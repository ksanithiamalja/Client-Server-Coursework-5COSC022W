package com.mycompany.csacoursework;

import java.util.ArrayList;
import java.util.List;

public class MLWorkspace {
    private String id;
    private String teamName;
    private int storageQuotaGb;
    private List<String> modelIds = new ArrayList<>();

    // Constructor
    public MLWorkspace() {}

    public MLWorkspace(String id, String teamName, int storageQuotaGb) {
        this.id = id;
        this.teamName = teamName;
        this.storageQuotaGb = storageQuotaGb;
    }

    // Getters
    public String getId() { return id; }
    public String getTeamName() { return teamName; }
    public int getStorageQuotaGb() { return storageQuotaGb; }
    public List<String> getModelIds() { return modelIds; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public void setStorageQuotaGb(int storageQuotaGb) { this.storageQuotaGb = storageQuotaGb; }
    public void setModelIds(List<String> modelIds) { this.modelIds = modelIds; }
}