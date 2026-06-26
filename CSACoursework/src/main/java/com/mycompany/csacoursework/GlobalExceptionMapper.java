package com.mycompany.csacoursework;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper 
    implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        return Response.status(500)
                .entity("{\"error\":\"Internal server error\","
                      + "\"message\":\"" + exception.getMessage() + "\"}")
                .type("application/json")
                .build();
    }
}