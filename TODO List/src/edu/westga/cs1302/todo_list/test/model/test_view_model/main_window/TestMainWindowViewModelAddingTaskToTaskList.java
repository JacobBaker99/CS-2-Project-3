package edu.westga.cs1302.todo_list.test.model.test_view_model.main_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.todo_list.model.TaskPriority;
import edu.westga.cs1302.todo_list.viewmodel.MainWindowViewModel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TestMainWindowViewModelAddingTaskToTaskList {

	@Test
	public void testAddingOneTaskToList() {
		MainWindowViewModel vm = new MainWindowViewModel();
		
		vm.setTaskTitle(new SimpleStringProperty("tit"));
		vm.setTaskDescription(new SimpleStringProperty("des"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		
		assertEquals("tit", vm.getTaskTitle().getValue(), "testing the vm title is updated");
		assertEquals("des", vm.getTaskDescription().getValue(), "testing the vm description is updated");
		assertEquals(1, vm.getTaskHour().getValue(), "testing the vm hour is updated");
		assertEquals(TaskPriority.LOW, vm.getTaskPriority().getValue(), "testing the vm priority is updated");

		assertEquals(1, vm.getTaskList().size(), "testing the size of the list");
		assertEquals("tit", vm.getTaskList().getValue().get(0).getTitle());
	}
	
	@Test
	public void testAddingMultipleTaskToList() {
		MainWindowViewModel vm = new MainWindowViewModel();
		
		vm.setTaskTitle(new SimpleStringProperty("tit"));
		vm.setTaskDescription(new SimpleStringProperty("des"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		
		assertEquals("tit", vm.getTaskTitle().getValue(), "testing the vm title is updated");
		assertEquals("des", vm.getTaskDescription().getValue(), "testing the vm description is updated");
		assertEquals(1, vm.getTaskHour().getValue(), "testing the vm hour is updated");
		assertEquals(TaskPriority.LOW, vm.getTaskPriority().getValue(), "testing the vm priority is updated");
		
		
		
		vm.setTaskTitle(new SimpleStringProperty("tit2"));
		vm.setTaskDescription(new SimpleStringProperty("des2"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		
		assertEquals("tit2", vm.getTaskTitle().getValue(), "testing the vm title is updated");
		assertEquals("des2", vm.getTaskDescription().getValue(), "testing the vm description is updated");
		assertEquals(1, vm.getTaskHour().getValue(), "testing the vm hour is updated");
		assertEquals(TaskPriority.LOW, vm.getTaskPriority().getValue(), "testing the vm priority is updated");
		
		
		
		vm.setTaskTitle(new SimpleStringProperty("tit3"));
		vm.setTaskDescription(new SimpleStringProperty("des3"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		
		assertEquals("tit3", vm.getTaskTitle().getValue(), "testing the vm title is updated");
		assertEquals("des3", vm.getTaskDescription().getValue(), "testing the vm description is updated");
		assertEquals(1, vm.getTaskHour().getValue(), "testing the vm hour is updated");
		assertEquals(TaskPriority.LOW, vm.getTaskPriority().getValue(), "testing the vm priority is updated");

		
		
		assertEquals(3, vm.getTaskList().size(), "testing the size of the list");
		assertEquals("tit", vm.getTaskList().getValue().get(0).getTitle());
		assertEquals("tit2", vm.getTaskList().getValue().get(1).getTitle());
		assertEquals("tit3", vm.getTaskList().getValue().get(2).getTitle());
	}
	
	@Test
	
	
}
