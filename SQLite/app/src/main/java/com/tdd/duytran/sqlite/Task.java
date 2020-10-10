package com.tdd.duytran.sqlite;

public class Task {
    private int id;
    private String taskContent;

    public Task(int id, String taskContent) {
        this.id = id;
        this.taskContent = taskContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }
}
