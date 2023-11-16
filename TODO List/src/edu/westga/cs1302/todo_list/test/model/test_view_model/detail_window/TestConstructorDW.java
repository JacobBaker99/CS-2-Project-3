package edu.westga.cs1302.todo_list.test.model.test_view_model.detail_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.westga.cs1302.todo_list.viewmodel.DetailWindowViewModel;

/**Test the constructor for DetailWindow
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class TestConstructorDW {
	
	@Test
	void testMainWindowViewModelConstructorValues() {
		DetailWindowViewModel vm = new DetailWindowViewModel();
		
		assertEquals("", vm.getDeatails().getValue(), "checks that the details is empty");	
	}

}
