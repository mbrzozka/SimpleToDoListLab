package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ToDoListTest {

  // Test the addTask method with valid and invalid input
  @Test
  public void testAddTask(){
    ToDoList list = new ToDoList();
    assertTrue(list.addTask("Study"));
    assertFalse(list.addTask(""));
    assertFalse(list.addTask("   "));
    assertFalse(list.addTask(null));
  }

  // Test the markTaskComplete method with valid and invalid input
  public void testMarkTaskComplete(){
    ToDoList list = new ToDoList();
    list.addTask("Study");
    assertTrue(list.markTaskComplete(0));
    assertFalse(list.markTaskComplete(5));
  }

  // Test the getIncompleteTasks method to make sure it only returns incomplete tasks
  @Test
  public void testGetIncompleteTasks(){
    ToDoList list = new ToDoList();
    list.addTask("Study");
    list.addTask("Gym");
    list.markTaskComplete(0);
    assertEquals(1, list.getIncompleteTasks().size());
  }

  // Test the clear method to make sure it removes all tasks
  @Test
  public void testClear(){
    ToDoList list = new ToDoList();
    list.addTask("Study");
    list.clear();
    assertEquals(0, list.size());
  }
}