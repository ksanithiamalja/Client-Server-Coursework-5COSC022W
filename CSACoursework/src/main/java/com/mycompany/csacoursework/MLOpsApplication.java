package com.mycompany.csacoursework;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api/v1")
public class MLOpsApplication extends Application {
    // JAX-RS will automatically find all resource classes
}