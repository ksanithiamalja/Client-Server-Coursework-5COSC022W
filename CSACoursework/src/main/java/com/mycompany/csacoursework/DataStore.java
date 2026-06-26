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

    // Pre-fill sample data
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
    }
    public static boolean modelExists(String id) {
        return models.containsKey(id);
    }
}