package com.mycompany.csacoursework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {
    
    // This is like a database table for workspaces
    // Key = workspace ID, Value = MLWorkspace object
    private static Map<String, MLWorkspace> workspaces = new HashMap<>();
    
    // Add some sample data when the app starts
    static {
        MLWorkspace ws1 = new MLWorkspace("WSVISION-01", "Computer Vision Lab", 500);
        MLWorkspace ws2 = new MLWorkspace("WSNLP-01", "NLP Research Team", 300);
        workspaces.put(ws1.getId(), ws1);
        workspaces.put(ws2.getId(), ws2);
    }
    
    // Get all workspaces
    public static List<MLWorkspace> getAllWorkspaces() {
        return new ArrayList<>(workspaces.values());
    }
    
    // Get one workspace by ID
    public static MLWorkspace getWorkspace(String id) {
        return workspaces.get(id);
    }
    
    // Add a new workspace
    public static void addWorkspace(MLWorkspace workspace) {
        workspaces.put(workspace.getId(), workspace);
    }
    
    // Delete a workspace
    public static void deleteWorkspace(String id) {
        workspaces.remove(id);
    }
    
    // Check if workspace exists
    public static boolean workspaceExists(String id) {
        return workspaces.containsKey(id);
    }
}
