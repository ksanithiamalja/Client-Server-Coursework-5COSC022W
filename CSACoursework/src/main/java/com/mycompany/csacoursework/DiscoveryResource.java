package com.mycompany.csacoursework;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class DiscoveryResource {

    @GET
    public Map<String, Object> discover() {
        Map<String, Object> response = new HashMap<>();
        response.put("version", "1.0");
        response.put("description", "MLOps Pipeline Management API");
        response.put("contact", "admin@mlops.com");
        
        Map<String, String> resources = new HashMap<>();
        resources.put("workspaces", "/api/v1/workspaces");
        resources.put("models", "/api/v1/models");
        
        response.put("resources", resources);
        return response;
    }
}