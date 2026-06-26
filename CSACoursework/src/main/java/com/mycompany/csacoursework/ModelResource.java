package com.mycompany.csacoursework;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/models")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ModelResource {

    // GET /api/v1/models - get all models
    // GET /api/v1/models?status=DEPLOYED - get filtered models
    @GET
    public List<MachineLearningModel> getModels(
            @QueryParam("status") String status) {
        if (status != null) {
            return DataStore.getModelsByStatus(status);
        }
        return DataStore.getAllModels();
    }

    // GET /api/v1/models/{id} - get one model
    @GET
    @Path("/{modelId}")
    public Response getModel(@PathParam("modelId") String modelId) {
        MachineLearningModel model = DataStore.getModel(modelId);
        if (model == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Model not found\"}")
                    .build();
        }
        return Response.ok(model).build();
    }

    // POST /api/v1/models - create new model
@POST
public Response createModel(MachineLearningModel model) {
    if (!DataStore.workspaceExists(model.getWorkspaceId())) {
        throw new LinkedWorkspaceNotFoundException(model.getWorkspaceId());
    }
    model.setId("MOD-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase());
    DataStore.addModel(model);
    DataStore.getWorkspace(model.getWorkspaceId())
            .getModelIds().add(model.getId());
    return Response.status(Response.Status.CREATED)
            .entity(model)
            .build();
}
    // Sub-resource locator
// GET/POST /api/v1/models/{modelId}/metrics
@Path("/{modelId}/metrics")
public EvaluationMetricResource getMetricResource(
        @PathParam("modelId") String modelId) {
    return new EvaluationMetricResource(modelId);
}
}