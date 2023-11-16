package edu.westga.cs1302.todo_list.viewmodel;

import edu.westga.cs1302.todo_list.model.Task;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;

/**The ViewModel for MainWidow
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class DetailWindowViewModel {
	private StringProperty deatails;
	
	/**The constructor to initialize the values and properties
	 * 
	 */
	public DetailWindowViewModel() {
		this.deatails = new SimpleStringProperty("");
	}

	/**Gets task details
	 * 
	 * @return task details
	 */
	public StringProperty getDeatails() {
		return this.deatails;
	}
	
	/**sets the task list in ViewModel
     * 
     * @param tasks the list of task being passed in
     * @return boolean to the MainWindow letting it know if it worked
     */
    public boolean setDetailForView(Task tasks) {
		if (tasks == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Unable to acess selected task");
			alert.showAndWait();
			return false;
		} else {
			this.deatails.set(tasks.getFullDetails());
			return true;
		}
	}
}