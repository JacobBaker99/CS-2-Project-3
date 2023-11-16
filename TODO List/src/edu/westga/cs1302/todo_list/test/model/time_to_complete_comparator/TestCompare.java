package edu.westga.cs1302.todo_list.test.model.time_to_complete_comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.todo_list.model.TimeToCompleteComparator;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;

class TestCompare {

	@Test
	void testNullFirstTask() {
		TimeToCompleteComparator comparator = new TimeToCompleteComparator();
		Task task2 = new Task("a", "b", 1, TaskPriority.LOW);
		
		assertThrows(IllegalArgumentException.class, ()->{comparator.compare(null, task2);});
	}

	@Test
	void testNullSecondTask() {
		TimeToCompleteComparator comparator = new TimeToCompleteComparator();
		Task task1 = new Task("a", "b", 1, TaskPriority.LOW);
		
		assertThrows(IllegalArgumentException.class, ()->{comparator.compare(task1, null);});
	}

	@Test
	void testBothTasksSameHoursToComplete() {
		TimeToCompleteComparator comparator = new TimeToCompleteComparator();
		Task task1 = new Task("a", "b", 1, TaskPriority.LOW);
		Task task2 = new Task("a", "b", 1, TaskPriority.LOW);
		
		int result = comparator.compare(task1, task2);
		
		assertEquals(0, result, "checking result");
	}

	@Test
	void testTask1HigherHoursToComplete() {
		TimeToCompleteComparator comparator = new TimeToCompleteComparator();
		Task task1 = new Task("a", "b", 2, TaskPriority.LOW);
		Task task2 = new Task("a", "b", 1, TaskPriority.LOW);
		
		int result = comparator.compare(task1, task2);
		
		assertEquals(1, result, "checking result");
	}

	@Test
	void testTask1LowerHoursToComplete() {
		TimeToCompleteComparator comparator = new TimeToCompleteComparator();
		Task task1 = new Task("a", "b", 1, TaskPriority.LOW);
		Task task2 = new Task("a", "b", 2, TaskPriority.LOW);
		
		int result = comparator.compare(task1, task2);
		
		assertEquals(-1, result, "checking result");
	}

}
