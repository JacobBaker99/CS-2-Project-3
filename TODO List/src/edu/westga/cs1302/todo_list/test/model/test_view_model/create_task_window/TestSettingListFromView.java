package edu.westga.cs1302.todo_list.test.model.test_view_model.create_task_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.viewmodel.CreateTaskViewModel;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

/**test setting the list being used in CreatTaskViewModel class
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class TestSettingListFromView {
	
	@Test
	public void testAddingANullList() {
		CreateTaskViewModel vm = new CreateTaskViewModel();
		assertThrows(ExceptionInInitializerError.class,()->{
			vm.setTaskListForView(null);
		});
	}
	
	@Test 
	public void testAddingAList() {
		CreateTaskViewModel vm = new CreateTaskViewModel();
		ObservableList<Task> theList = new SimpleListProperty<Task>();
		vm.setTaskListForView(theList);
		assertEquals(theList, vm.getTaskList());
	}

}
