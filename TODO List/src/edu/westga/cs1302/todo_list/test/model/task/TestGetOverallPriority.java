package edu.westga.cs1302.todo_list.test.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;

class TestGetOverallPriority {

	@Test
	void testNoSubTasks() {
		Task task = new Task("a", "b", 1, TaskPriority.LOW);
		
		TaskPriority result = task.getOverallPriority();
		
		assertEquals(TaskPriority.LOW, result, "checking overall priority");
	}

	@Test
	void testOneSubTask() {
		Task task1 = new Task("a", "b", 1, TaskPriority.LOW);
		Task task2 = new Task("c", "d", 2, TaskPriority.MEDIUM);
		task1.addSubTask(task2);
		
		TaskPriority result = task1.getOverallPriority();
		
		assertEquals(TaskPriority.MEDIUM, result, "checking overall priority");
	}

	@Test
	void testMultipleSubTasksLastIsHighest() {
		Task task1 = new Task("a", "b", 1, TaskPriority.LOW);
		Task task2 = new Task("c", "d", 2, TaskPriority.MEDIUM);
		Task task3 = new Task("e", "f", 3, TaskPriority.HIGH);
		task1.addSubTask(task2);
		task1.addSubTask(task3);
		
		TaskPriority result = task1.getOverallPriority();
		
		assertEquals(TaskPriority.HIGH, result, "checking overall priority");
	}

	@Test
	void testMultipleSubTasksFirstIsHighest() {
		Task task1 = new Task("a", "b", 1, TaskPriority.LOW);
		Task task2 = new Task("c", "d", 2, TaskPriority.HIGH);
		Task task3 = new Task("e", "f", 3, TaskPriority.MEDIUM);
		task1.addSubTask(task2);
		task1.addSubTask(task3);
		
		TaskPriority result = task1.getOverallPriority();
		
		assertEquals(TaskPriority.HIGH, result, "checking overall priority");
	}

}
