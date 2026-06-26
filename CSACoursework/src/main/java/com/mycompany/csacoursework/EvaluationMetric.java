package com.mycompany.csacoursework;

import java.util.UUID;

public class EvaluationMetric {
    private String id;
    private long timestamp;
    private double accuracyScore;
    private String modelId;

    public EvaluationMetric() {}

    public EvaluationMetric(String modelId, double accuracyScore) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
        this.accuracyScore = accuracyScore;
        this.modelId = modelId;
    }

    public String getId() { return id; }
    public long getTimestamp() { return timestamp; }
    public double getAccuracyScore() { return accuracyScore; }
    public String getModelId() { return modelId; }

    public void setId(String id) { this.id = id; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    public void setAccuracyScore(double accuracyScore) { this.accuracyScore = accuracyScore; }
    public void setModelId(String modelId) { this.modelId = modelId; }
}