package org.example;

import java.util.Scanner;

public class App {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    ToDoList list = new ToDoList();
    boolean running = true;
    System.out.println("Welcome to your To-Do List!");
    // Display menu and handle user input until user exits
    while(running){
      System.out.println("\nMenu:");
      System.out.println("1. Add task");
      System.out.println("2. Mark task complete");
      System.out.println("3. View incomplete tasks");
      System.out.println("4. View complete tasks");
      System.out.println("5. View all tasks");
      System.out.println("6. Clear all tasks");
      System.out.println("7. Exit");
      System.out.print("Choose an option: ");
      if(!scanner.hasNextInt()){
        System.out.println("Please enter a number.");
        scanner.next();
        continue;
      }
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch(choice){
        case 1:
          System.out.print("Enter task description: ");
          String desc = scanner.nextLine();
          if(desc.trim().isEmpty()){
            System.out.println("Error: Task description cannot be blank.");
            break;
          }
          // If addTask returns false, it means the description was invalid
          if(!list.addTask(desc)){
            System.out.println("Error: Invalid task description.");
          }
          else{
            System.out.println("Task added.");
          }
          break;
        case 2:
          System.out.print("Enter task number: ");
          // If the input is not an integer, it's invalid
          if(!scanner.hasNextInt()){
            System.out.println("Invalid number.");
            scanner.next();
            break;
          }
          int index = scanner.nextInt();
          scanner.nextLine();
          // If markTaskComplete returns false, it means the index was invalid
          if(!list.markTaskComplete(index)){
            System.out.println("Invalid index.");
          }
          else{
            System.out.println("Task marked complete.");
          }
          break;
        case 3:
          System.out.println("Incomplete tasks:");
          // Loop through incomplete tasks and print them
          for(Task t : list.getIncompleteTasks()){
            System.out.println(t);
          }
          break;
        case 4:
          System.out.println("Complete tasks:");
          // Loop through complete tasks and print them
          for(Task t : list.getCompleteTasks()){
            System.out.println(t);
          }
          break;
        case 5:
          System.out.println("All tasks:");
          int i = 0;
          // Loop through all tasks and print them with their index
          for (Task t : list.getAllTasks()) {
            System.out.println(i + ": " + t);
            i++;
          }
          break;
        case 6:
          list.clear();
          System.out.println("All tasks cleared.");
          break;
        case 7:
          running = false;
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid choice.");
      }
    }
    scanner.close();
  }
}