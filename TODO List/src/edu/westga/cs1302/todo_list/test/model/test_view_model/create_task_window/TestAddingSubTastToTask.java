package edu.westga.cs1302.todo_list.test.model.test_view_model.create_task_window;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;
import edu.westga.cs1302.todo_list.viewmodel.CreateTaskViewModel;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**Test adding sub task to the task in MainWindowViewModel
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
class TestAddingSubTastToTask {
	
	@Test
	public void addingSubTaskToNoTaskSelected() {
		CreateTaskViewModel vm = new CreateTaskViewModel();
		// below For Main Task
		vm.setTaskTitle(new SimpleStringProperty("tit"));
		vm.setTaskDescription(new SimpleStringProperty("des"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		// above For Main Task
		// below For Sub Task
		vm.setTaskTitle(new SimpleStringProperty("subtit"));
		vm.setTaskDescription(new SimpleStringProperty("subdes"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		// above For Sub Task
		
		assertThrows(NullPointerException.class, ()->{vm.addSubTask();});
	}
	
	@Test
	void testAddingOneSubTaskToOneTask() {
		CreateTaskViewModel vm = new CreateTaskViewModel();
		// below For Main Task
		vm.setTaskTitle(new SimpleStringProperty("tit"));
		vm.setTaskDescription(new SimpleStringProperty("des"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		// above For Main Task
		// below For Sub Task
		vm.setTaskTitle(new SimpleStringProperty("subtit"));
		vm.setTaskDescription(new SimpleStringProperty("subdes"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(0)));
		vm.addSubTask();
		// above For Sub Task

		String actual = vm.getTaskList().get(0).getFullDetails();

		String expected = "tit" + System.lineSeparator();
		expected = expected + "Description: des" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + "***Subtasks***" + System.lineSeparator();
		expected = expected + "subtit" + System.lineSeparator();
		expected = expected + "Description: subdes" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + System.lineSeparator();

		assertEquals(expected, actual, "Test adding a subtask and then getting the discription of the task");
	}
	
	@Test
	void testAddingOneSubTaskToMultipleTask() {
		CreateTaskViewModel vm = new CreateTaskViewModel();
		// below For Main Task
		vm.setTaskTitle(new SimpleStringProperty("tit"));
		vm.setTaskDescription(new SimpleStringProperty("des"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		// above For Main Task
		// below For Sub Task
		vm.setTaskTitle(new SimpleStringProperty("subtit"));
		vm.setTaskDescription(new SimpleStringProperty("subdes"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(0)));
		vm.addSubTask();
		// above For Sub Task
		
		// below For Main Task
		vm.setTaskTitle(new SimpleStringProperty("tit2"));
		vm.setTaskDescription(new SimpleStringProperty("des2"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		// above For Main Task
		// below For Sub Task
		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(1)));
		vm.addSubTask();

		assertEquals(2, vm.getTaskList().getSize(), "testing the size of list");

		String actual = vm.getTaskList().get(0).getFullDetails();

		String expected = "tit" + System.lineSeparator();
		expected = expected + "Description: des" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + "***Subtasks***" + System.lineSeparator();
		expected = expected + "subtit" + System.lineSeparator();
		expected = expected + "Description: subdes" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + System.lineSeparator();

		assertEquals(expected, actual, "Test adding a subtask and then getting the discription of the task");
	
		String actual2 = vm.getTaskList().get(1).getFullDetails();

		String expected2 = "tit2" + System.lineSeparator();
		expected2 = expected2 + "Description: des2" + System.lineSeparator();
		expected2 = expected2 + "Hours to complete: 1" + System.lineSeparator();
		expected2 = expected2 + "Priority: LOW" + System.lineSeparator();
		expected2 = expected2 + "***Subtasks***" + System.lineSeparator();
		expected2 = expected2 + "subtit2" + System.lineSeparator();
		expected2 = expected2 + "Description: subdes2" + System.lineSeparator();
		expected2 = expected2 + "Hours to complete: 1" + System.lineSeparator();
		expected2 = expected2 + "Priority: LOW" + System.lineSeparator();
		expected2 = expected2 + System.lineSeparator();

		assertEquals(expected2, actual2, "Test adding a subtask and then getting the discription of the task");
	}
	
	@Test
	void testAddingMultipleSubTaskToOneTask() {
		CreateTaskViewModel vm = new CreateTaskViewModel();
		// below For Main Task
		vm.setTaskTitle(new SimpleStringProperty("tit"));
		vm.setTaskDescription(new SimpleStringProperty("des"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		// above For Main Task
		// below For Sub Task
		vm.setTaskTitle(new SimpleStringProperty("subtit"));
		vm.setTaskDescription(new SimpleStringProperty("subdes"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(0)));
		vm.addSubTask();
		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(0)));
		vm.addSubTask();
		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(0)));
		vm.addSubTask();
		// above For Sub Task
		
		assertEquals(1, vm.getTaskList().getSize(), "testing the size of list");

		String actual = vm.getTaskList().get(0).getFullDetails();

		String expected = "tit" + System.lineSeparator();
		expected = expected + "Description: des" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + "***Subtasks***" + System.lineSeparator();
		expected = expected + "subtit" + System.lineSeparator();
		expected = expected + "Description: subdes" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + System.lineSeparator();
		
		expected = expected + "subtitb" + System.lineSeparator();
		expected = expected + "Description: subdesb" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + System.lineSeparator();
		
		expected = expected + "subtitc" + System.lineSeparator();
		expected = expected + "Description: subdesc" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + System.lineSeparator();

		assertEquals(expected, actual, "Test adding a subtask and then getting the discription of the task");
	}
	
	@Test
	void testAddingMultipleSubTaskToMultipleTask() {
		CreateTaskViewModel vm = new CreateTaskViewModel();
		// below For Main Task
		vm.setTaskTitle(new SimpleStringProperty("tit"));
		vm.setTaskDescription(new SimpleStringProperty("des"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		// above For Main Task
		// below For Sub Task
		vm.setTaskTitle(new SimpleStringProperty("subtit"));
		vm.setTaskDescription(new SimpleStringProperty("subdes"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(null);
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(0)));
		vm.addSubTask();
		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(0)));
		vm.addSubTask();
		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(0)));
		vm.addSubTask();
		// above For Sub Task

		// below For Main Task
		vm.setTaskTitle(new SimpleStringProperty("tit2"));
		vm.setTaskDescription(new SimpleStringProperty("des2"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.addTask();
		// above For Main Task
		// below For Sub Task
		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(1)));
		vm.addSubTask();
		vm.setTaskTitle(new SimpleStringProperty("subtit2b"));
		vm.setTaskDescription(new SimpleStringProperty("subdes2b"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(1)));
		vm.addSubTask();
		vm.setTaskTitle(new SimpleStringProperty("subtit2c"));
		vm.setTaskDescription(new SimpleStringProperty("subdes2c"));
		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
		vm.setSelectedTask(new SimpleObjectProperty<Task>(vm.getTaskList().getValue().get(1)));
		vm.addSubTask();
		//Above for sub task

		assertEquals(2, vm.getTaskList().getSize(), "testing the size of list");

		String actual = vm.getTaskList().get(0).getFullDetails();

		String expected = "tit" + System.lineSeparator();
		expected = expected + "Description: des" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + "***Subtasks***" + System.lineSeparator();
		expected = expected + "subtit" + System.lineSeparator();
		expected = expected + "Description: subdes" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + System.lineSeparator();
		
		expected = expected + "subtitb" + System.lineSeparator();
		expected = expected + "Description: subdesb" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + System.lineSeparator();
		
		expected = expected + "subtitc" + System.lineSeparator();
		expected = expected + "Description: subdesc" + System.lineSeparator();
		expected = expected + "Hours to complete: 1" + System.lineSeparator();
		expected = expected + "Priority: LOW" + System.lineSeparator();
		expected = expected + System.lineSeparator();

		assertEquals(expected, actual, "Test adding a subtask and then getting the discription of the task");
		
		String actual2 = vm.getTaskList().get(1).getFullDetails();

		String expected2 = "tit2" + System.lineSeparator();
		expected2 = expected2 + "Description: des2" + System.lineSeparator();
		expected2 = expected2 + "Hours to complete: 1" + System.lineSeparator();
		expected2 = expected2 + "Priority: LOW" + System.lineSeparator();
		expected2 = expected2 + "***Subtasks***" + System.lineSeparator();
		expected2 = expected2 + "subtit2" + System.lineSeparator();
		expected2 = expected2 + "Description: subdes2" + System.lineSeparator();
		expected2 = expected2 + "Hours to complete: 1" + System.lineSeparator();
		expected2 = expected2 + "Priority: LOW" + System.lineSeparator();
		expected2 = expected2 + System.lineSeparator();

		expected2 = expected2 + "subtit2b" + System.lineSeparator();
		expected2 = expected2 + "Description: subdes2b" + System.lineSeparator();
		expected2 = expected2 + "Hours to complete: 1" + System.lineSeparator();
		expected2 = expected2 + "Priority: LOW" + System.lineSeparator();
		expected2 = expected2 + System.lineSeparator();
		
		expected2 = expected2 + "subtit2c" + System.lineSeparator();
		expected2 = expected2 + "Description: subdes2c" + System.lineSeparator();
		expected2 = expected2 + "Hours to complete: 1" + System.lineSeparator();
		expected2 = expected2 + "Priority: LOW" + System.lineSeparator();
		expected2 = expected2 + System.lineSeparator();

		assertEquals(expected2, actual2, "Test adding a subtask and then getting the discription of the task");
	}	
}
