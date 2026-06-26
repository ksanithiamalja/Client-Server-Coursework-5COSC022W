package com.mycompany.csacoursework;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LinkedWorkspaceNotFoundExceptionMapper 
    implements ExceptionMapper<LinkedWorkspaceNotFoundException> {

    @Override
    public Response toResponse(LinkedWorkspaceNotFoundException exception) {
        return Response.status(422)
                .entity("{\"error\":\"" + exception.getMessage() + "\"}")
                .type("application/json")
                .build();
    }
}