package com.application.parseappchallenge;

import java.util.Date;

public class RequestModel {
    private String id;
    private String title;
    private String description;
    private String creator;
    private Date createdAt;

    public RequestModel() {
    }

    public RequestModel(String id, String title, String description, String creator, Date createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreator() {
        return creator;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
