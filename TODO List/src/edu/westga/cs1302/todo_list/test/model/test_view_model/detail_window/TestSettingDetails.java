package edu.westga.cs1302.todo_list.test.model.test_view_model.detail_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;
import edu.westga.cs1302.todo_list.viewmodel.DetailWindowViewModel;

/**Test setting the details in the DetailWindowViewModel
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class TestSettingDetails {
	
	@Test
	void testDetailWindowViewModelSetDetailWithSimpleTask() {
		DetailWindowViewModel vm = new DetailWindowViewModel();
		
		Task task = new Task("Title", "Des", 1, TaskPriority.LOW);
		
		vm.setDetailForView(task);
		String actual = vm.getDeatails().getValue();
		
		String expected = ("Title" + System.lineSeparator());
		expected += ("Description: Des" + System.lineSeparator());
		expected += ("Hours to complete: 1" + System.lineSeparator());
		expected += ("Priority: LOW" + System.lineSeparator());
		
		assertEquals(expected, actual, "checks that the details is set");	
	}
	
	@Test
	void testDetailWindowViewModelSetDetailTaskWithSubTask() {
		DetailWindowViewModel vm = new DetailWindowViewModel();
		
		Task task = new Task("Title", "Des", 1, TaskPriority.LOW);
		task.addSubTask(new Task("Title1", "Des1", 1, TaskPriority.LOW));
		
		
		vm.setDetailForView(task);
		String actual = vm.getDeatails().getValue();
		
		String expected = ("Title" + System.lineSeparator());
		expected += ("Description: Des" + System.lineSeparator());
		expected += ("Hours to complete: 1" + System.lineSeparator());
		expected += ("Priority: LOW" + System.lineSeparator());
		expected += ("***Subtasks***" + System.lineSeparator());
		expected += ("Title1" + System.lineSeparator());
		expected += ("Description: Des1" + System.lineSeparator());
		expected += ("Hours to complete: 1" + System.lineSeparator());
		expected += ("Priority: LOW" + System.lineSeparator());
		expected += (System.lineSeparator());
		
		assertEquals(expected, actual, "checks that the details is set");	
	}
	
	@Test
	void testDetailWindowViewModelSetDetailTaskWithMultipleSubTask() {
		DetailWindowViewModel vm = new DetailWindowViewModel();
		
		Task task = new Task("Title", "Des", 1, TaskPriority.LOW);
		task.addSubTask(new Task("Title1", "Des1", 1, TaskPriority.LOW));
		task.addSubTask(new Task("Title2", "Des2", 1, TaskPriority.LOW));
		
		
		vm.setDetailForView(task);
		String actual = vm.getDeatails().getValue();
		
		String expected = ("Title" + System.lineSeparator());
		expected += ("Description: Des" + System.lineSeparator());
		expected += ("Hours to complete: 1" + System.lineSeparator());
		expected += ("Priority: LOW" + System.lineSeparator());
		expected += ("***Subtasks***" + System.lineSeparator());
		expected += ("Title1" + System.lineSeparator());
		expected += ("Description: Des1" + System.lineSeparator());
		expected += ("Hours to complete: 1" + System.lineSeparator());
		expected += ("Priority: LOW" + System.lineSeparator());
		expected += (System.lineSeparator());
		expected += ("Title2" + System.lineSeparator());
		expected += ("Description: Des2" + System.lineSeparator());
		expected += ("Hours to complete: 1" + System.lineSeparator());
		expected += ("Priority: LOW" + System.lineSeparator());
		expected += (System.lineSeparator());
		
		
		assertEquals(expected, actual, "checks that the details is set");	
	}
	
	@Test
	void testDetailWindowViewModelSetDetailNullTask() {
		DetailWindowViewModel vm = new DetailWindowViewModel();
		
		assertThrows(ExceptionInInitializerError.class,()->{
			vm.setDetailForView(null);
		});
	}

}
