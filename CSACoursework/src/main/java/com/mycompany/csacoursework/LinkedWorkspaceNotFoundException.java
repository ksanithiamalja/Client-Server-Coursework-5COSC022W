package com.mycompany.csacoursework;

public class LinkedWorkspaceNotFoundException extends RuntimeException {
    private String workspaceId;
    
    public LinkedWorkspaceNotFoundException(String workspaceId) {
        super("Workspace not found: " + workspaceId);
        this.workspaceId = workspaceId;
    }
    
    public String getWorkspaceId() {
        return workspaceId;
    }
}