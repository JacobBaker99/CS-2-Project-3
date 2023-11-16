package edu.westga.cs1302.todo_list.test.model.test_view_model.main_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import edu.westga.cs1302.todo_list.model.PriorityComparator;
import edu.westga.cs1302.todo_list.model.TaskPriority;
import edu.westga.cs1302.todo_list.model.TimeToCompleteComparator;
import edu.westga.cs1302.todo_list.viewmodel.MainWindowViewModel;

/**Testing MainWindowViewModel constructor initializing 
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class TestMainWindowViewModelConstuctor {

	@Test
	void testMainWindowViewModelConstructorValues() {
		MainWindowViewModel vm = new MainWindowViewModel();
		
//		assertEquals("", vm.getTaskTitle().getValue(), "Testing if the Title is assigned as empty");
//		assertEquals("", vm.getTaskDescription().getValue(), "Testing if the Description is assigned as empty");
//		
//		assertEquals(1, vm.getHoursList().get(0), "the list of hours index 0");
//		assertEquals(2, vm.getHoursList().get(1), "the list of hours index 1");
//		assertEquals(3, vm.getHoursList().get(2), "the list of hours index 2");
//		assertEquals(4, vm.getHoursList().get(3), "the list of hours index 3");
//		assertEquals(5, vm.getHoursList().get(4), "the list of hours index 4");
//		
//		assertEquals(1, vm.getTaskHour().getValue(), "the selected hour is assigned as 1");
//		
//		assertEquals(TaskPriority.HIGH, vm.getPriorityList().getValue().get(0), "the list of TaskPriority index 0");
//		assertEquals(TaskPriority.MEDIUM, vm.getPriorityList().getValue().get(1), "the list of TaskPriority index 1");
//		assertEquals(TaskPriority.LOW, vm.getPriorityList().getValue().get(2), "the list of TaskPriority index 2");
//		
//		assertEquals(TaskPriority.HIGH, vm.getTaskPriority().getValue(), "the selected priority is assigned to high");

		assertTrue(vm.getTaskList().isEmpty(), "testing if the list of task is empty");
		
		assertNull(vm.getSelectedTask().getValue(), "checks if the selected task is assigned as null");
		
		assertEquals(new PriorityComparator().toString(), vm.getSortingComparatorList().getValue().get(0).toString(), "checks the priority comparator list index 0");
		assertEquals(new TimeToCompleteComparator().toString(), vm.getSortingComparatorList().getValue().get(1).toString(), "checks the priority comparator list index 1");
		
		assertEquals(new PriorityComparator().toString(), vm.getTaskSortingComparator().getValue().toString(), "checks the selected comparator assignded to priority");
		
		assertEquals("", vm.getDeatails().getValue(), "checks that the details is empty");	
	}
}
