package com.mycompany.csacoursework;

public class WorkspaceNotEmptyException extends RuntimeException {
    private String workspaceId;
    
    public WorkspaceNotEmptyException(String workspaceId) {
        super("Workspace " + workspaceId + " still has models assigned to it");
        this.workspaceId = workspaceId;
    }
    
    public String getWorkspaceId() {
        return workspaceId;
    }
}