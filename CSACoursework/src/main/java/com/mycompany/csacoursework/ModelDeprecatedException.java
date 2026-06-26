package com.mycompany.csacoursework;

public class ModelDeprecatedException extends RuntimeException {
    private String modelId;
    
    public ModelDeprecatedException(String modelId) {
        super("Model " + modelId + " is DEPRECATED and cannot accept new metrics");
        this.modelId = modelId;
    }
    
    public String getModelId() {
        return modelId;
    }
}