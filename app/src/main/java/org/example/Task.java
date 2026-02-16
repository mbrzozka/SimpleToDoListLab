package org.example;

public class Task {
    private final String description;
    private boolean isComplete;

    public Task(String description){
        this.description = description;
        this.isComplete = false;
    }

    public String getDescription(){
        return description;
    }

    public boolean isComplete(){
        return isComplete;
    }

    public void markComplete(){
        this.isComplete = true;
    }
    
    public String toString(){
        String status = isComplete ? "[x] " : "[ ] ";
        return status + description;
    }
}