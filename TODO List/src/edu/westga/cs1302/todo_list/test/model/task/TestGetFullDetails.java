package edu.westga.cs1302.todo_list.test.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;

class TestGetFullDetails {

	@Test
	void testNoSubTasks() {
		Task task = new Task("a", "b", 1, TaskPriority.HIGH);
		
		String result = task.getFullDetails();
		
		String expected = "a" + System.lineSeparator();
		expected += "Description: b" + System.lineSeparator();
		expected += "Hours to complete: 1" + System.lineSeparator();
		expected += "Priority: HIGH" + System.lineSeparator();
		
		assertEquals(expected, result, "checking details");
	}

	@Test
	void testOneSubTask() {
		Task task1 = new Task("a", "b", 1, TaskPriority.HIGH);
		Task task2 = new Task("c", "d", 2, TaskPriority.MEDIUM);
		task1.addSubTask(task2);
		
		String result = task1.getFullDetails();
		
		String expected = "a" + System.lineSeparator();
		expected += "Description: b" + System.lineSeparator();
		expected += "Hours to complete: 1" + System.lineSeparator();
		expected += "Priority: HIGH" + System.lineSeparator();
		expected += "***Subtasks***" + System.lineSeparator();
		expected += "c" + System.lineSeparator();
		expected += "Description: d" + System.lineSeparator();
		expected += "Hours to complete: 2" + System.lineSeparator();
		expected += "Priority: MEDIUM" + System.lineSeparator();
		expected += System.lineSeparator();
		
		assertEquals(expected, result, "checking details");
	}

	@Test
	void testMultipleSubTasks() {
		Task task1 = new Task("a", "b", 1, TaskPriority.HIGH);
		Task task2 = new Task("c", "d", 2, TaskPriority.MEDIUM);
		Task task3 = new Task("e", "f", 3, TaskPriority.LOW);
		task1.addSubTask(task2);
		task1.addSubTask(task3);
		
		String result = task1.getFullDetails();
		
		String expected = "a" + System.lineSeparator();
		expected += "Description: b" + System.lineSeparator();
		expected += "Hours to complete: 1" + System.lineSeparator();
		expected += "Priority: HIGH" + System.lineSeparator();
		expected += "***Subtasks***" + System.lineSeparator();
		expected += "c" + System.lineSeparator();
		expected += "Description: d" + System.lineSeparator();
		expected += "Hours to complete: 2" + System.lineSeparator();
		expected += "Priority: MEDIUM" + System.lineSeparator();
		expected += System.lineSeparator();
		expected += "e" + System.lineSeparator();
		expected += "Description: f" + System.lineSeparator();
		expected += "Hours to complete: 3" + System.lineSeparator();
		expected += "Priority: LOW" + System.lineSeparator();
		expected += System.lineSeparator();
		
		assertEquals(expected, result, "checking details");
	}

}
