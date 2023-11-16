package edu.westga.cs1302.todo_list.test.model.test_view_model.detail_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;
import edu.westga.cs1302.todo_list.viewmodel.DetailWindowViewModel;

public class TestSettingDetailForView {

	@Test
	void testDetailWindowViewModelDetailWithSimpleTask() {
		DetailWindowViewModel vm = new DetailWindowViewModel();
		Task task = new Task("Test", "Des", 2, TaskPriority.HIGH);
		vm.setDetailForView(task);
		String actual = vm.getDeatails().getValue();
		String expected = ("Test" + System.lineSeparator());
		expected += ("Description: Des" + System.lineSeparator());
		expected += ("Hours to complete: 2" + System.lineSeparator());
		expected += ("Priority: HIGH" + System.lineSeparator());
		assertEquals(expected, actual, "Teting if getting detail actually works");
	}
	
	@Test
	void testDetailWindowViewModelDetailWithTaskWithOneSubTask() {
		DetailWindowViewModel vm = new DetailWindowViewModel();
		Task task = new Task("Test", "Des", 2, TaskPriority.HIGH);
		task.addSubTask(new Task("SubTest", "SubDes", 2, TaskPriority.HIGH));
		vm.setDetailForView(task);
		String actual = vm.getDeatails().getValue();
		String expected = ("Test" + System.lineSeparator());
		expected += ("Description: Des" + System.lineSeparator());
		expected += ("Hours to complete: 2" + System.lineSeparator());
		expected += ("Priority: HIGH" + System.lineSeparator());
		expected += ("***Subtasks***" + System.lineSeparator());
		expected += ("SubTest" + System.lineSeparator());
		expected += ("Description: SubDes" + System.lineSeparator());
		expected += ("Hours to complete: 2" + System.lineSeparator());
		expected += ("Priority: HIGH" + System.lineSeparator());
		expected += (System.lineSeparator());
		assertEquals(expected, actual, "Teting if getting detail actually works");
	}
	
	@Test
	void testDetailWindowViewModelDetailWithTaskWithMultipleSubTask() {
		DetailWindowViewModel vm = new DetailWindowViewModel();
		Task task = new Task("Test", "Des", 2, TaskPriority.HIGH);
		task.addSubTask(new Task("SubTest", "SubDes", 2, TaskPriority.HIGH));
		task.addSubTask(new Task("SubTest2", "SubDes2", 3, TaskPriority.LOW));
		vm.setDetailForView(task);
		String actual = vm.getDeatails().getValue();
		String expected = ("Test" + System.lineSeparator());
		expected += ("Description: Des" + System.lineSeparator());
		expected += ("Hours to complete: 2" + System.lineSeparator());
		expected += ("Priority: HIGH" + System.lineSeparator());
		expected += ("***Subtasks***" + System.lineSeparator());
		expected += ("SubTest" + System.lineSeparator());
		expected += ("Description: SubDes" + System.lineSeparator());
		expected += ("Hours to complete: 2" + System.lineSeparator());
		expected += ("Priority: HIGH" + System.lineSeparator());
		expected += (System.lineSeparator());
		expected += ("SubTest2" + System.lineSeparator());
		expected += ("Description: SubDes2" + System.lineSeparator());
		expected += ("Hours to complete: 3" + System.lineSeparator());
		expected += ("Priority: LOW" + System.lineSeparator());
		expected += (System.lineSeparator());
		assertEquals(expected, actual, "Teting if getting detail actually works");
	}
	
	@Test
	void testDetailWindowViewModelDetailNullTask() {
		DetailWindowViewModel vm = new DetailWindowViewModel();
		assertThrows(ExceptionInInitializerError.class,()->{
			vm.setDetailForView(null);
		});
	}
	
}
