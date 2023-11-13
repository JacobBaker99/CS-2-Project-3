package edu.westga.cs1302.todo_list.test.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;

class TestConstructor {

	@Test
	void testNullTitle() {
		assertThrows(IllegalArgumentException.class, ()->{new Task(null, "description", 1, TaskPriority.HIGH);});
	}

	@Test
	void testEmptyTitle() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("", "description", 1, TaskPriority.HIGH);});
	}

	@Test
	void testNullDescription() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("title", null, 1, TaskPriority.HIGH);});
	}

	@Test
	void testEmptyDescription() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("title", "", 1, TaskPriority.HIGH);});
	}

	@Test
	void testHoursToCompleteTooLow() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("title", "description", 0, TaskPriority.HIGH);});
	}

	@Test
	void testNullPriority() {
		assertThrows(IllegalArgumentException.class, ()->{new Task("title", "description", 1, null);});
	}
	
	@Test
	void testValidSimpleTask() {
		Task result = new Task("title", "description", 1, TaskPriority.HIGH);
		
		assertEquals("title", result.getTitle(), "Checking the title");
		assertEquals("description", result.getDescription(), "Checking the description");
		assertEquals(1, result.getHoursToComplete(), "Checking the hours to complete");
		assertEquals(TaskPriority.HIGH, result.getPriority(), "Checking the priority");
		
		assertEquals("title", result.toString(), "checking toString (simple details)");
		
		String expectedFullDetails = "title" + System.lineSeparator();
		expectedFullDetails += "Description: description" + System.lineSeparator();
		expectedFullDetails += "Hours to complete: 1" + System.lineSeparator();
		expectedFullDetails += "Priority: " + TaskPriority.HIGH + System.lineSeparator();
		assertEquals(expectedFullDetails, result.getFullDetails(), "checking full details");
	}
}
