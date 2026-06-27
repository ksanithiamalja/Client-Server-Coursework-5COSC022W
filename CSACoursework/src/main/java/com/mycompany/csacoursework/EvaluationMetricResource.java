package com.mycompany.csacoursework;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EvaluationMetricResource {

    private String modelId;

    public EvaluationMetricResource(String modelId) {
        this.modelId = modelId;
    }

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

    @POST
    public Response addMetric(EvaluationMetric metric) {
        MachineLearningModel model = DataStore.getModel(modelId);
        if (model == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Model not found\"}")
                    .build();
        }
        if (model.getStatus().equals("DEPRECATED")) {
            throw new ModelDeprecatedException(modelId);
        }
        metric.setId(UUID.randomUUID().toString());
        metric.setModelId(modelId);
        metric.setTimestamp(System.currentTimeMillis());
        DataStore.addMetric(modelId, metric);
        model.setLatestAccuracy(metric.getAccuracyScore());
        return Response.status(Response.Status.CREATED)
                .entity(metric)
                .build();
    }
}