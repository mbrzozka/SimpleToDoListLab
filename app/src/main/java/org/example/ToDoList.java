package org.example;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private final List<Task> tasks;

    public ToDoList(){
        tasks = new ArrayList<>();
    }

    public boolean addTask(String description){
        // If description is null or empty, return false, otherwise add task and return true
        if(description == null || description.trim().isEmpty()){
            return false;
        }
        tasks.add(new Task(description.trim()));
        return true;
    }

    public boolean markTaskComplete(int index){
        // If task number is out of bounds, return false, otherwise mark task complete and return true
        if(index < 0 || index >= tasks.size()){
            return false;
        }
        tasks.get(index).markComplete();
        return true;
    }

    public List<Task> getIncompleteTasks(){
        List<Task> result = new ArrayList<>();
        // Loop through tasks and add not complete tasks to result
        for(Task t : tasks){
            if(!t.isComplete()){
                result.add(t);
            }
        }
        return result;
    }

    public List<Task> getCompleteTasks(){
        List<Task> result = new ArrayList<>();
        // Loop through tasks and add complete tasks to result
        for(Task t : tasks){
            if(t.isComplete()){
                result.add(t);
            }
        }
        return result;
    }

    public void clear(){
        tasks.clear();
    }

    public int size(){
        return tasks.size();
    }

    public List<Task> getAllTasks(){
        // Return list of all tasks
        return tasks;
    }
}