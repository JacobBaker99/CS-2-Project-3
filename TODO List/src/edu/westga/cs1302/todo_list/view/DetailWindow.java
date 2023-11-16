package edu.westga.cs1302.todo_list.view;

import java.net.URL;
import java.util.ResourceBundle;
import edu.westga.cs1302.todo_list.viewmodel.DetailWindowViewModel;
import edu.westga.cs1302.todo_list.model.Task;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Codebehind for the DetailWindow of the Application.
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class DetailWindow {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private Button close;
	@FXML
	private TextArea details;

	private DetailWindowViewModel vm;

	@FXML
	void initialize() {
		this.assertInitially();
		this.vm = new DetailWindowViewModel();
		this.bindingDetailsWindow();
		this.close.setOnAction((event) -> {
			((Node) (event.getSource())).getScene().getWindow().hide();
		});
	}

	/**
	 * Asserts that the properties all have the proper assigned values
	 * 
	 */
	public void assertInitially() {
		assert this.close != null : "fx:id=\"close\" was not injected: check your FXML file 'DetailWindow.fxml'.";
		assert this.details != null : "fx:id=\"details\" was not injected: check your FXML file 'DetailWindow.fxml'.";
	}

	/**
	 * Binds the ViewModel with the View
	 * 
	 */
	public void bindingDetailsWindow() {
		this.details.textProperty().bind(this.vm.getDeatails());
	}

	/**
	 * sets the task list in ViewModel
	 * 
	 * @param task the list of task being passed in
	 * @return boolean to the MainWindow letting it know if it worked
	 */
	public boolean setSelectedDetail(Task task) throws NullPointerException, IllegalArgumentException {
		return this.vm.setDetailForView(task);
	}
}