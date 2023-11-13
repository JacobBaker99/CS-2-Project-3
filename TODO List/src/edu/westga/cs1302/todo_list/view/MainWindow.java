package edu.westga.cs1302.todo_list.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import edu.westga.cs1302.todo_list.model.PriorityComparator;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;
import edu.westga.cs1302.todo_list.model.TimeToCompleteComparator;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2023
 */
public class MainWindow {
	@FXML
	private TextField title;
	@FXML
	private TextArea description;
	@FXML
	private ComboBox<Integer> hours;
	@FXML
	private ComboBox<TaskPriority> priority;
	@FXML
	private ListView<Task> taskListView;
	@FXML
	private TextArea details;
	@FXML
	private ComboBox<Comparator<Task>> taskOrder;

	private List<Task> taskListModel;

	/**
	 * Adds a task with the information specified in the various input fields.
	 * 
	 * @precondition none
	 * @postcondition task has been added to task list model&view
	 * 
	 * @param event we do not use this value
	 */
	@FXML
	void addTask(ActionEvent event) {
		try {
			Task task = new Task(this.title.getText(), this.description.getText(), this.hours.getValue(), this.priority.getValue());
			this.taskListModel.add(task);
			this.taskListView.getSelectionModel().select(task);
			this.updateDisplay();
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	/**
	 * Adds a task as subtask of the selected task with the information specified in
	 * the various input fields.
	 * 
	 * @precondition none
	 * @postcondition task has been added as a subtask
	 * 
	 * @param event we do not use this value
	 */
	@FXML
	void addSubTask(ActionEvent event) {
		Task selectedTask = this.taskListView.getSelectionModel().getSelectedItem();
		if (selectedTask != null) {
			try {
				Task task = new Task(this.title.getText(), this.description.getText(), this.hours.getValue(), this.priority.getValue());
				selectedTask.addSubTask(task);
				this.updateDisplay();
			} catch (IllegalArgumentException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		}
	}

	/**
	 * Displays currently selected task.
	 * 
	 * @precondition none
	 * @postcondition task full details are displayed in the details field of the
	 *                GUI
	 * 
	 * @param event we do not use this value
	 */
	@FXML
	void selectTask(MouseEvent event) {
		this.updateDisplay();
	}

	private void updateDisplay() {
		Task selectedItem = this.taskListView.getSelectionModel().getSelectedItem();
		this.refreshTaskListView();
		this.taskListView.getSelectionModel().select(selectedItem);
		this.displaySelectedTask();
	}
	
	private void refreshTaskListView() {
		Comparator<Task> sortOrder = this.taskOrder.getValue();
		if (sortOrder != null) {
			this.taskListModel.sort(sortOrder);
		}
		this.taskListView.getItems().clear();
		this.taskListView.getItems().addAll(this.taskListModel);
	}

	private void displaySelectedTask() {
		Task task = this.taskListView.getSelectionModel().getSelectedItem();
		if (task != null) {
			this.details.setText(task.getFullDetails());
		} else {
			this.details.setText("");
		}
	}

	/**
	 * Resort the list of tasks when a new sort order is selected.
	 * 
	 * @precondition none
	 * @postcondition tasks are sorted according to the new order
	 * 
	 * @param event we do not use this value
	 */
	@FXML
	void sortTasks(ActionEvent event) {
		this.updateDisplay();
	}

	@FXML
	void initialize() {
		assert this.title != null : "fx:id=\"title\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.description != null
				: "fx:id=\"description\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.hours != null : "fx:id=\"hours\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.priority != null : "fx:id=\"priority\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.taskListView != null
				: "fx:id=\"taskListView\" was not injected: check your FXML file 'MainWindow.fxml'.";

		this.taskListModel = new ArrayList<Task>();

		this.hours.getItems().add(1);
		this.hours.getItems().add(2);
		this.hours.getItems().add(3);
		this.hours.getItems().add(4);
		this.hours.getItems().add(5);
		this.hours.setValue(this.hours.getItems().get(0));

		this.priority.getItems().add(TaskPriority.HIGH);
		this.priority.getItems().add(TaskPriority.MEDIUM);
		this.priority.getItems().add(TaskPriority.LOW);
		this.priority.setValue(this.priority.getItems().get(0));

		this.taskOrder.getItems().add(new PriorityComparator());
		this.taskOrder.getItems().add(new TimeToCompleteComparator());
		this.taskOrder.setValue(this.taskOrder.getItems().get(0));

	}
}
