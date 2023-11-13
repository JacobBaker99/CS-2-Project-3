package edu.westga.cs1302.todo_list.test.model.priority_comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.todo_list.model.PriorityComparator;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;

class TestComparePriority {

	@Test
	void testNullFirstTask() {
		PriorityComparator comparator = new PriorityComparator();
		
		assertThrows(IllegalArgumentException.class, ()->{comparator.comparePriority(null, TaskPriority.LOW);});
	}

	@Test
	void testNullSecondTask() {
		PriorityComparator comparator = new PriorityComparator();
		
		assertThrows(IllegalArgumentException.class, ()->{comparator.comparePriority(TaskPriority.LOW, null);});
	}

	@Test
	void testBothTasksSamePriority() {
		PriorityComparator comparator = new PriorityComparator();
		
		int result = comparator.comparePriority(TaskPriority.LOW, TaskPriority.LOW);
		
		assertEquals(0, result, "checking result");
	}

	@Test
	void testTask1HigherPriority() {
		PriorityComparator comparator = new PriorityComparator();

		int result = comparator.comparePriority(TaskPriority.HIGH, TaskPriority.LOW);
		
		assertEquals(-1, result, "checking result");
	}

	@Test
	void testTask1LowerPriority() {
		PriorityComparator comparator = new PriorityComparator();

		int result = comparator.comparePriority(TaskPriority.MEDIUM, TaskPriority.HIGH);
		
		assertEquals(1, result, "checking result");
	}

}
