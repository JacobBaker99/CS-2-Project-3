package edu.westga.cs1302.todo_list.test.model.test_view_model.main_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import edu.westga.cs1302.todo_list.model.PriorityComparator;
import edu.westga.cs1302.todo_list.model.TimeToCompleteComparator;
import edu.westga.cs1302.todo_list.viewmodel.MainWindowViewModel;

/**Testing MainWindowViewModel constructor initializing 
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class TestConstructorMW {

	@Test
	void testMainWindowViewModelConstructorValues() {
		MainWindowViewModel vm = new MainWindowViewModel();

		assertTrue(vm.getTaskList().isEmpty(), "testing if the list of task is empty");
		
		assertNull(vm.getSelectedTask().getValue(), "checks if the selected task is assigned as null");
		
		assertEquals(new PriorityComparator().toString(), vm.getSortingComparatorList().getValue().get(0).toString(), "checks the priority comparator list index 0");
		assertEquals(new TimeToCompleteComparator().toString(), vm.getSortingComparatorList().getValue().get(1).toString(), "checks the priority comparator list index 1");
		
		assertEquals(new PriorityComparator().toString(), vm.getTaskSortingComparator().getValue().toString(), "checks the selected comparator assignded to priority");	
	}
}
