package edu.westga.cs1302.todo_list.test.model.priority_comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.todo_list.model.PriorityComparator;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;

class TestCompare {

	@Test
	void testNullFirstTask() {
		PriorityComparator comparator = new PriorityComparator();
		Task task2 = new Task("a", "b", 1, TaskPriority.LOW);
		
		assertThrows(IllegalArgumentException.class, ()->{comparator.compare(null, task2);});
	}

	@Test
	void testNullSecondTask() {
		PriorityComparator comparator = new PriorityComparator();
		Task task1 = new Task("a", "b", 1, TaskPriority.LOW);
		
		assertThrows(IllegalArgumentException.class, ()->{comparator.compare(task1, null);});
	}

	@Test
	void testBothTasksSamePriority() {
		PriorityComparator comparator = new PriorityComparator();
		Task task1 = new Task("a", "b", 1, TaskPriority.LOW);
		Task task2 = new Task("a", "b", 1, TaskPriority.LOW);
		
		int result = comparator.compare(task1, task2);
		
		assertEquals(0, result, "checking result");
	}

	@Test
	void testTask1HigherPriority() {
		PriorityComparator comparator = new PriorityComparator();
		Task task1 = new Task("a", "b", 1, TaskPriority.HIGH);
		Task task2 = new Task("a", "b", 1, TaskPriority.LOW);
		
		int result = comparator.compare(task1, task2);
		
		assertEquals(-1, result, "checking result");
	}

	@Test
	void testTask1LowerPriority() {
		PriorityComparator comparator = new PriorityComparator();
		Task task1 = new Task("a", "b", 1, TaskPriority.MEDIUM);
		Task task2 = new Task("a", "b", 1, TaskPriority.HIGH);
		
		int result = comparator.compare(task1, task2);
		
		assertEquals(1, result, "checking result");
	}

}
