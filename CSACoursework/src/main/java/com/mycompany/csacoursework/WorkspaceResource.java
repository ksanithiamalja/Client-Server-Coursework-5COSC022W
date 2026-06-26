package com.mycompany.csacoursework;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/workspaces")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkspaceResource {

    // GET /api/v1/workspaces - get all workspaces
    @GET
    public List<MLWorkspace> getAllWorkspaces() {
        return DataStore.getAllWorkspaces();
    }

    // GET /api/v1/workspaces/{id} - get one workspace
    @GET
    @Path("/{workspaceId}")
    public Response getWorkspace(@PathParam("workspaceId") String workspaceId) {
        MLWorkspace workspace = DataStore.getWorkspace(workspaceId);
        if (workspace == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Workspace not found\"}")
                    .build();
        }
        return Response.ok(workspace).build();
    }

    // POST /api/v1/workspaces - create new workspace
    @POST
    public Response createWorkspace(MLWorkspace workspace) {
        if (DataStore.workspaceExists(workspace.getId())) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("{\"error\":\"Workspace already exists\"}")
                    .build();
        }
        DataStore.addWorkspace(workspace);
        return Response.status(Response.Status.CREATED)
                .entity(workspace)
                .build();
    }

    // DELETE /api/v1/workspaces/{id} - delete workspace
@DELETE
@Path("/{workspaceId}")
public Response deleteWorkspace(@PathParam("workspaceId") String workspaceId) {
    MLWorkspace workspace = DataStore.getWorkspace(workspaceId);
    if (workspace == null) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"error\":\"Workspace not found\"}")
                .build();
    }
    if (!workspace.getModelIds().isEmpty()) {
        throw new WorkspaceNotEmptyException(workspaceId);
    }
    DataStore.deleteWorkspace(workspaceId);
    return Response.ok("{\"message\":\"Workspace deleted successfully\"}").build();
}  
}