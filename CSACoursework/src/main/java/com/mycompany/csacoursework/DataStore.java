package com.mycompany.csacoursework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataStore {

    // Workspace storage
    private static Map<String, MLWorkspace> workspaces = new HashMap<>();
    
    // Model storage
    private static Map<String, MachineLearningModel> models = new HashMap<>();
    
    // Metrics storage - one list of metrics per model
    // Key = modelId, Value = list of metrics for that model
    private static Map<String, List<EvaluationMetric>> metrics = new HashMap<>();

    static {
        // Sample workspaces
        MLWorkspace ws1 = new MLWorkspace("WSVISION-01", "Computer Vision Lab", 500);
        MLWorkspace ws2 = new MLWorkspace("WSNLP-01", "NLP Research Team", 300);
        workspaces.put(ws1.getId(), ws1);
        workspaces.put(ws2.getId(), ws2);

        // Sample models
        MachineLearningModel m1 = new MachineLearningModel(
            "MOD-001", "TensorFlow", "DEPLOYED", 0.95, "WSVISION-01");
        MachineLearningModel m2 = new MachineLearningModel(
            "MOD-002", "PyTorch", "TRAINING", 0.87, "WSNLP-01");
        MachineLearningModel m3 = new MachineLearningModel(
            "MOD-003", "Scikit-Learn", "DEPRECATED", 0.76, "WSVISION-01");

        models.put(m1.getId(), m1);
        models.put(m2.getId(), m2);
        models.put(m3.getId(), m3);

        // Link models to workspaces
        ws1.getModelIds().add("MOD-001");
        ws1.getModelIds().add("MOD-003");
        ws2.getModelIds().add("MOD-002");

        // Sample metrics for MOD-001
        metrics.put("MOD-001", new ArrayList<>());
        metrics.put("MOD-002", new ArrayList<>());
        metrics.put("MOD-003", new ArrayList<>());
        
        metrics.get("MOD-001").add(new EvaluationMetric("MOD-001", 0.91));
        metrics.get("MOD-001").add(new EvaluationMetric("MOD-001", 0.95));
    }

    // ---- Workspace methods ----
    public static List<MLWorkspace> getAllWorkspaces() {
        return new ArrayList<>(workspaces.values());
    }
    public static MLWorkspace getWorkspace(String id) {
        return workspaces.get(id);
    }
    public static void addWorkspace(MLWorkspace workspace) {
        workspaces.put(workspace.getId(), workspace);
    }
    public static void deleteWorkspace(String id) {
        workspaces.remove(id);
    }
    public static boolean workspaceExists(String id) {
        return workspaces.containsKey(id);
    }

    // ---- Model methods ----
    public static List<MachineLearningModel> getAllModels() {
        return new ArrayList<>(models.values());
    }
    public static List<MachineLearningModel> getModelsByStatus(String status) {
        return models.values().stream()
                .filter(m -> m.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
    public static MachineLearningModel getModel(String id) {
        return models.get(id);
    }
    public static void addModel(MachineLearningModel model) {
        models.put(model.getId(), model);
        // Create empty metrics list for new model
        metrics.put(model.getId(), new ArrayList<>());
    }
    public static boolean modelExists(String id) {
        return models.containsKey(id);
    }

    // ---- Metric methods ----
    public static List<EvaluationMetric> getMetricsForModel(String modelId) {
        return metrics.getOrDefault(modelId, new ArrayList<>());
    }
    public static void addMetric(String modelId, EvaluationMetric metric) {
        metrics.get(modelId).add(metric);
    }
}