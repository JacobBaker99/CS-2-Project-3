package edu.westga.cs1302.todo_list.test.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;

class TestAddSubTask {

	@Test
	void testAddNullTask() {
		Task task = new Task("a", "b", 1, TaskPriority.HIGH);
		assertThrows(IllegalArgumentException.class, ()->{task.addSubTask(null);});
	}

	@Test
	void testAddFirstSubTask() {
		Task task1 = new Task("a", "b", 1, TaskPriority.HIGH);
		Task task2 = new Task("c", "d", 2, TaskPriority.MEDIUM);

		task1.addSubTask(task2);
		
		assertSame(task2, task1.getTasks().get(0), "checking first subtask");
	}

	@Test
	void testAddSecondSubTask() {
		Task task1 = new Task("a", "b", 1, TaskPriority.HIGH);
		Task task2 = new Task("c", "d", 2, TaskPriority.MEDIUM);
		Task task3 = new Task("e", "f", 3, TaskPriority.LOW);

		task1.addSubTask(task2);
		task1.addSubTask(task3);
		
		assertSame(task2, task1.getTasks().get(0), "checking first subtask");
		assertSame(task3, task1.getTasks().get(1), "checking second subtask");
	}

}
