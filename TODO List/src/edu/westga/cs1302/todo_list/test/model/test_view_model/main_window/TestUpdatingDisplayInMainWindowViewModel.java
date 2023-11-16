package edu.westga.cs1302.todo_list.test.model.test_view_model.main_window;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;
import edu.westga.cs1302.todo_list.model.TimeToCompleteComparator;
import edu.westga.cs1302.todo_list.viewmodel.MainWindowViewModel;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**Test updating the list and sorting in the MainWindowViewModel
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
class TestUpdatingDisplayInMainWindowViewModel {

	
//All Priority Sorted Below
	@Test
	void testUpdaingDisplayPrioritySortingFirstHighInputThenLowInput() {
		MainWindowViewModel vm = new MainWindowViewModel();
		
		ArrayList<Task> theListToUpdate = new ArrayList<Task>();
		Task task1 = new Task("tit", "des" , 1, TaskPriority.HIGH);
		task1.addSubTask(new Task("subtit", "subdes", 1, TaskPriority.LOW));
		
		
		Task task2 = new Task("tit", "des" , 1, TaskPriority.LOW);
		task1.addSubTask(new Task("subtit", "subdes", 1, TaskPriority.LOW));
		
		theListToUpdate.add(task1);
		theListToUpdate.add(task2);
		
		SimpleListProperty<Task> theListToUpdate1 = new SimpleListProperty<Task>();
		theListToUpdate1.setAll(theListToUpdate);
		
		vm.setTaskList(theListToUpdate1);
		
		
		
		//Above for sub task
		assertEquals("Priority", vm.getTaskSortingComparator().getValue().toString(), "checks to make sure PriorityCiomparator is selected");
		//AddingTask && AddingSubTask && ClickingListView && calling updateDiplay~ all updates display
		vm.updateDisplay();
		
		assertEquals("tit", vm.getTaskList().getValue().get(0).getTitle(), "checks that the first priority in lis is the high");
		assertEquals("tit2", vm.getTaskList().getValue().get(1).getTitle(), "checks that the second priority in lis is the low");
	}
	
//	@Test
//	void testUpdaingDisplayPrioritySortingFirstLowInputThenHighInput() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit"));
//		vm.setTaskDescription(new SimpleStringProperty("des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		// above For Sub Task
//
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit2"));
//		vm.setTaskDescription(new SimpleStringProperty("des2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2b"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2b"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2c"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2c"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		//Above for sub task
//		assertEquals("Priority", vm.getTaskSortingComparator().getValue().toString(), "checks to make sure PriorityCiomparator is selected");
//		//AddingTask && AddingSubTask && ClickingListView && calling updateDiplay~ all updates display
//		vm.updateDisplay();
//		
//		assertEquals("tit", vm.getTaskList().getValue().get(1).getTitle(), "checks that the first priority in lis is the high");
//		assertEquals("tit2", vm.getTaskList().getValue().get(0).getTitle(), "checks that the second priority in lis is the low");
//	}
//	
//	@Test
//	void testUpdaingDisplayPrioritySortingTaskBothLowFirstSubHighInputThenSubLowInput() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit"));
//		vm.setTaskDescription(new SimpleStringProperty("des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		// above For Sub Task
//
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit2"));
//		vm.setTaskDescription(new SimpleStringProperty("des2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2b"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2b"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2c"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2c"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		//Above for sub task
//		assertEquals("Priority", vm.getTaskSortingComparator().getValue().toString(), "checks to make sure PriorityCiomparator is selected");
//		//AddingTask && AddingSubTask && ClickingListView && calling updateDiplay~ all updates display
//		vm.updateDisplay();
//		
//		assertEquals("tit", vm.getTaskList().getValue().get(0).getTitle(), "checks that the first priority in lis is the high");
//		assertEquals("tit2", vm.getTaskList().getValue().get(1).getTitle(), "checks that the second priority in lis is the low");
//	}
//	
//	@Test
//	void testUpdaingDisplayPrioritySortingBothTaskLowFirstSubLowInputThenSubHighInput() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit"));
//		vm.setTaskDescription(new SimpleStringProperty("des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		// above For Sub Task
//
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit2"));
//		vm.setTaskDescription(new SimpleStringProperty("des2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2b"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2b"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2c"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2c"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		//Above for sub task
//		assertEquals("Priority", vm.getTaskSortingComparator().getValue().toString(), "checks to make sure PriorityCiomparator is selected");
//		//AddingTask && AddingSubTask && ClickingListView && calling updateDiplay~ all updates display
//		vm.updateDisplay();
//		
//		assertEquals("tit", vm.getTaskList().getValue().get(1).getTitle(), "checks that the first priority in lis is the high");
//		assertEquals("tit2", vm.getTaskList().getValue().get(0).getTitle(), "checks that the second priority in lis is the low");
//	}
//	
//	@Test
//	void testUpdaingDisplayPriorityWithLargeVariety() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit"));
//		vm.setTaskDescription(new SimpleStringProperty("des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		// above For Sub Task
//
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit2"));
//		vm.setTaskDescription(new SimpleStringProperty("des2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.MEDIUM));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2b"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2b"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2c"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2c"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		//Above for sub task
//		
//		vm.setTaskTitle(new SimpleStringProperty("tit3"));
//		vm.setTaskDescription(new SimpleStringProperty("des3"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit3"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes3"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb3"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb3"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc3"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc3"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		
//		vm.setTaskTitle(new SimpleStringProperty("tit4"));
//		vm.setTaskDescription(new SimpleStringProperty("des4"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit4"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes4"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb4"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb4"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc4"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc4"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		
//		vm.setTaskTitle(new SimpleStringProperty("tit5"));
//		vm.setTaskDescription(new SimpleStringProperty("des5"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.MEDIUM));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit5"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes5"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb5"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb5"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc5"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc5"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//	
//		vm.setTaskTitle(new SimpleStringProperty("tit6"));
//		vm.setTaskDescription(new SimpleStringProperty("des6"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit6"));
//		vm.setTaskDescription(new SimpleStringProperty("sub6des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subti6tb"));
//		vm.setTaskDescription(new SimpleStringProperty("s6ubdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subt6itc"));
//		vm.setTaskDescription(new SimpleStringProperty("subde6sc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//
//		vm.setTaskTitle(new SimpleStringProperty("tit7"));
//		vm.setTaskDescription(new SimpleStringProperty("des7"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit7"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes7"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit7b"));
//		vm.setTaskDescription(new SimpleStringProperty("s7ubdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("sub7titc"));
//		vm.setTaskDescription(new SimpleStringProperty("subd7esc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//
//		vm.setTaskTitle(new SimpleStringProperty("tit8"));
//		vm.setTaskDescription(new SimpleStringProperty("des8"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.MEDIUM));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subt8it"));
//		vm.setTaskDescription(new SimpleStringProperty("8subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subt8itb"));
//		vm.setTaskDescription(new SimpleStringProperty("subd8esb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subti8tc"));
//		vm.setTaskDescription(new SimpleStringProperty("su8bdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//
//		vm.setTaskTitle(new SimpleStringProperty("tit9"));
//		vm.setTaskDescription(new SimpleStringProperty("des9"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.MEDIUM));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subti9"));
//		vm.setTaskDescription(new SimpleStringProperty("su9bdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subti9tb"));
//		vm.setTaskDescription(new SimpleStringProperty("subd9esb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subti9tc"));
//		vm.setTaskDescription(new SimpleStringProperty("subd9esc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		
//		vm.setTaskTitle(new SimpleStringProperty("tit0"));
//		vm.setTaskDescription(new SimpleStringProperty("des0"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("sub0tit"));
//		vm.setTaskDescription(new SimpleStringProperty("su0bdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit0b"));
//		vm.setTaskDescription(new SimpleStringProperty("su0bdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subt0itc"));
//		vm.setTaskDescription(new SimpleStringProperty("su0bdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		
//		assertEquals("Priority", vm.getTaskSortingComparator().getValue().toString(), "checks to make sure PriorityCiomparator is selected");
//		//AddingTask && AddingSubTask && ClickingListView && calling updateDiplay~ all updates display
//		vm.updateDisplay();
//
//		assertEquals("tit", vm.getTaskList().getValue().get(0).getTitle(), "checks that the first priority in lis is the high");
//		assertEquals("tit7", vm.getTaskList().getValue().get(1).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit2", vm.getTaskList().getValue().get(2).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit5", vm.getTaskList().getValue().get(3).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit8", vm.getTaskList().getValue().get(4).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit9", vm.getTaskList().getValue().get(5).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit3", vm.getTaskList().getValue().get(6).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit4", vm.getTaskList().getValue().get(7).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit6", vm.getTaskList().getValue().get(8).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit0", vm.getTaskList().getValue().get(9).getTitle(), "checks that the second priority in lis is the low");
//	}
//	
////All Priority Sorted above
//	
////All Time Sorted Below
//	
//	@Test
//	void testUpdaingDisplayTimeSortingFirstHighInputThenLowInput() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit"));
//		vm.setTaskDescription(new SimpleStringProperty("des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(5));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		// above For Sub Task
//
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit2"));
//		vm.setTaskDescription(new SimpleStringProperty("des2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2b"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2b"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2c"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2c"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		//Above for sub task
//		vm.setTaskSortingComparator(new SimpleObjectProperty<Comparator<Task>>(new TimeToCompleteComparator()));
//		assertEquals("Time to Complete", vm.getTaskSortingComparator().getValue().toString(), "checks to make sure PriorityCiomparator is selected");
//		//AddingTask && AddingSubTask && ClickingListView && calling updateDiplay~ all updates display
//		vm.updateDisplay();
//		
//		assertEquals("tit2", vm.getTaskList().getValue().get(0).getTitle(), "checks that the first priority in lis is the high");
//		assertEquals("tit", vm.getTaskList().getValue().get(1).getTitle(), "checks that the second priority in lis is the low");
//	}
//	
//	@Test
//	void testUpdaingDisplayTimeSortingFirstLowInputThenHighInput() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit"));
//		vm.setTaskDescription(new SimpleStringProperty("des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		// above For Sub Task
//
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit2"));
//		vm.setTaskDescription(new SimpleStringProperty("des2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(5));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2b"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2b"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2c"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2c"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		//Above for sub task
//		vm.setTaskSortingComparator(new SimpleObjectProperty<Comparator<Task>>(new TimeToCompleteComparator()));
//		assertEquals("Time to Complete", vm.getTaskSortingComparator().getValue().toString(), "checks to make sure PriorityCiomparator is selected");
//		//AddingTask && AddingSubTask && ClickingListView && calling updateDiplay~ all updates display
//		vm.updateDisplay();
//		
//		assertEquals("tit2", vm.getTaskList().getValue().get(1).getTitle(), "checks that the first priority in lis is the high");
//		assertEquals("tit", vm.getTaskList().getValue().get(0).getTitle(), "checks that the second priority in lis is the low");
//	}
//	
//	@Test
//	void testUpdaingDisplayTimeSortingTaskBothLowFirstSubHighInputThenSubLowInput() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit"));
//		vm.setTaskDescription(new SimpleStringProperty("des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(5));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		// above For Sub Task
//
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit2"));
//		vm.setTaskDescription(new SimpleStringProperty("des2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(3));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2b"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2b"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2c"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2c"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		//Above for sub task
//		vm.setTaskSortingComparator(new SimpleObjectProperty<Comparator<Task>>(new TimeToCompleteComparator()));
//
//		assertEquals("Time to Complete", vm.getTaskSortingComparator().getValue().toString(), "checks to make sure PriorityCiomparator is selected");
//		//AddingTask && AddingSubTask && ClickingListView && calling updateDiplay~ all updates display
//		vm.updateDisplay();
//		
//		assertEquals("tit", vm.getTaskList().getValue().get(0).getTitle(), "checks that the first priority in lis is the high");
//		assertEquals("tit2", vm.getTaskList().getValue().get(1).getTitle(), "checks that the second priority in lis is the low");
//	}
//	
//	@Test
//	void testUpdaingDisplayTimeSortingBothTaskLowFirstSubLowInputThenSubHighInput() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit"));
//		vm.setTaskDescription(new SimpleStringProperty("des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		// above For Sub Task
//
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit2"));
//		vm.setTaskDescription(new SimpleStringProperty("des2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(5));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2b"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2b"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2c"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2c"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		//Above for sub task
//		vm.setTaskSortingComparator(new SimpleObjectProperty<Comparator<Task>>(new TimeToCompleteComparator()));
//		assertEquals("Time to Complete", vm.getTaskSortingComparator().getValue().toString(), "checks to make sure PriorityCiomparator is selected");
//		//AddingTask && AddingSubTask && ClickingListView && calling updateDiplay~ all updates display
//		vm.updateDisplay();
//		
//		assertEquals("tit", vm.getTaskList().getValue().get(1).getTitle(), "checks that the first priority in lis is the high");
//		assertEquals("tit2", vm.getTaskList().getValue().get(0).getTitle(), "checks that the second priority in lis is the low");
//	}
//	
//	@Test
//	void testUpdaingDisplayTimeWithLargeVariety() {
//		MainWindowViewModel vm = new MainWindowViewModel();
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit"));
//		vm.setTaskDescription(new SimpleStringProperty("des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(3));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		// above For Sub Task
//
//		// below For Main Task
//		vm.setTaskTitle(new SimpleStringProperty("tit2"));
//		vm.setTaskDescription(new SimpleStringProperty("des2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.MEDIUM));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2b"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2b"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit2c"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes2c"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(1));
//		vm.addSubTask();
//		//Above for sub task
//		
//		vm.setTaskTitle(new SimpleStringProperty("tit3"));
//		vm.setTaskDescription(new SimpleStringProperty("des3"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(5));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit3"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes3"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb3"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb3"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc3"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc3"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		
//		vm.setTaskTitle(new SimpleStringProperty("tit4"));
//		vm.setTaskDescription(new SimpleStringProperty("des4"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit2"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes4"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb4"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb4"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc4"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc4"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		
//		vm.setTaskTitle(new SimpleStringProperty("tit5"));
//		vm.setTaskDescription(new SimpleStringProperty("des5"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(4));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.MEDIUM));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit5"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes5"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitb5"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesb5"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtitc5"));
//		vm.setTaskDescription(new SimpleStringProperty("subdesc5"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//	
//		vm.setTaskTitle(new SimpleStringProperty("tit6"));
//		vm.setTaskDescription(new SimpleStringProperty("des6"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit6"));
//		vm.setTaskDescription(new SimpleStringProperty("sub6des"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(2));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subti6tb"));
//		vm.setTaskDescription(new SimpleStringProperty("s6ubdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subt6itc"));
//		vm.setTaskDescription(new SimpleStringProperty("subde6sc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//
//		vm.setTaskTitle(new SimpleStringProperty("tit7"));
//		vm.setTaskDescription(new SimpleStringProperty("des7"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.HIGH));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subtit7"));
//		vm.setTaskDescription(new SimpleStringProperty("subdes7"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit7b"));
//		vm.setTaskDescription(new SimpleStringProperty("s7ubdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("sub7titc"));
//		vm.setTaskDescription(new SimpleStringProperty("subd7esc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//
//		vm.setTaskTitle(new SimpleStringProperty("tit8"));
//		vm.setTaskDescription(new SimpleStringProperty("des8"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(4));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.MEDIUM));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subt8it"));
//		vm.setTaskDescription(new SimpleStringProperty("8subdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subt8itb"));
//		vm.setTaskDescription(new SimpleStringProperty("subd8esb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subti8tc"));
//		vm.setTaskDescription(new SimpleStringProperty("su8bdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//
//		vm.setTaskTitle(new SimpleStringProperty("tit9"));
//		vm.setTaskDescription(new SimpleStringProperty("des9"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.MEDIUM));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("subti9"));
//		vm.setTaskDescription(new SimpleStringProperty("su9bdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(4));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subti9tb"));
//		vm.setTaskDescription(new SimpleStringProperty("subd9esb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subti9tc"));
//		vm.setTaskDescription(new SimpleStringProperty("subd9esc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		
//		vm.setTaskTitle(new SimpleStringProperty("tit0"));
//		vm.setTaskDescription(new SimpleStringProperty("des0"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(3));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.addTask();
//		// above For Main Task
//		// below For Sub Task
//		vm.setTaskTitle(new SimpleStringProperty("sub0tit"));
//		vm.setTaskDescription(new SimpleStringProperty("su0bdes"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subtit0b"));
//		vm.setTaskDescription(new SimpleStringProperty("su0bdesb"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskTitle(new SimpleStringProperty("subt0itc"));
//		vm.setTaskDescription(new SimpleStringProperty("su0bdesc"));
//		vm.setTaskHour(new SimpleObjectProperty<Integer>(1));
//		vm.setTaskPriority(new SimpleObjectProperty<TaskPriority>(TaskPriority.LOW));
//		vm.setSelectedTask(vm.getTaskList().getValue().get(0));
//		vm.addSubTask();
//		vm.setTaskSortingComparator(new SimpleObjectProperty<Comparator<Task>>(new TimeToCompleteComparator()));
//
//		assertEquals("Time to Complete", vm.getTaskSortingComparator().getValue().toString(), "checks to make sure PriorityCiomparator is selected");
//		//AddingTask && AddingSubTask && ClickingListView && calling updateDiplay~ all updates display
//		vm.updateDisplay();
//
//		assertEquals("tit7", vm.getTaskList().getValue().get(0).getTitle(), "checks that the first priority in lis is the high");
//		assertEquals("tit2", vm.getTaskList().getValue().get(1).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit9", vm.getTaskList().getValue().get(2).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit4", vm.getTaskList().getValue().get(3).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit6", vm.getTaskList().getValue().get(4).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit", vm.getTaskList().getValue().get(5).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit0", vm.getTaskList().getValue().get(6).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit5", vm.getTaskList().getValue().get(7).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit8", vm.getTaskList().getValue().get(8).getTitle(), "checks that the second priority in lis is the low");
//		assertEquals("tit3", vm.getTaskList().getValue().get(9).getTitle(), "checks that the second priority in lis is the low");
//	}
////All Time Sorted Above	
}
