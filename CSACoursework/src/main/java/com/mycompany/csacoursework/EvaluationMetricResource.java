package com.mycompany.csacoursework;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvaluationMetricResource {

    // The model this resource belongs to
    private String modelId;

    // Constructor - receives modelId from ModelResource
    public EvaluationMetricResource(String modelId) {
        this.modelId = modelId;
    }

    // GET /api/v1/models/{modelId}/metrics
    // Get all metrics for this model
    @GET
    public Response getMetrics() {
        MachineLearningModel model = DataStore.getModel(modelId);
        if (model == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Model not found\"}")
                    .build();
        }
        List<EvaluationMetric> metricList = DataStore.getMetricsForModel(modelId);
        return Response.ok(metricList).build();
    }

    // POST /api/v1/models/{modelId}/metrics
    // Add a new metric for this model
    @POST
    public Response addMetric(EvaluationMetric metric) {
        MachineLearningModel model = DataStore.getModel(modelId);
        
        // Check model exists
        if (model == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Model not found\"}")
                    .build();
        }
        
        // Check model is not DEPRECATED
        if (model.getStatus().equals("DEPRECATED")) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("{\"error\":\"Cannot add metrics to a DEPRECATED model\"}")
                    .build();
        }

        // Set metric details
        metric.setModelId(modelId);
        metric.setTimestamp(System.currentTimeMillis());

        // Save metric
        DataStore.addMetric(modelId, metric);

        // Update model's latestAccuracy with this new score
        model.setLatestAccuracy(metric.getAccuracyScore());

        return Response.status(Response.Status.CREATED)
                .entity(metric)
                .build();
    }
}