package edu.westga.cs1302.todo_list.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
import edu.westga.cs1302.todo_list.viewmodel.MainWindowViewModel;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2023
 */
public class MainWindow {
	@FXML private TextField title;
	@FXML private TextArea description;
	@FXML private ComboBox<Integer> hours;
	@FXML private ComboBox<TaskPriority> priority;
	@FXML private ListView<Task> taskListView;
	@FXML private TextArea details;
	@FXML private ComboBox<Comparator<Task>> taskOrder;
	@FXML private Button addSubTask;
	@FXML private Button addTask;
	private MainWindowViewModel vm;

	/**The constructor of MainWindow
	 * 
	 */
	public MainWindow() {
		this.vm = new MainWindowViewModel();
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
		this.bindingViewModel();
		this.addTask.setOnAction((event)-> {
			this.vm.addTask();
		});
		this.addSubTask.setOnAction((event)-> {
			this.vm.addSubTask();
		});
		this.taskListView.setOnMouseClicked((event)-> {
			this.vm.setSelectedTask(this.taskListView.getSelectionModel().getSelectedItem());
		});
	}
	
	/**Binds the view model with the view
	 * 
	 */
	public void bindingViewModel() {
		this.hours.itemsProperty().bind(this.vm.getHoursList());
		this.hours.setValue(this.vm.getHoursList().getValue().get(0));
		this.priority.itemsProperty().bind(this.vm.getPriorityList());
		this.priority.setValue(this.vm.getPriorityList().getValue().get(0));
		this.taskOrder.itemsProperty().bind(this.vm.getSortingComparatorList());
		this.taskOrder.setValue(this.vm.getSortingComparatorList().getValue().get(0));
		this.taskListView.itemsProperty().bindBidirectional(this.vm.getTaskList());
		this.details.textProperty().bindBidirectional(this.vm.getDeatails());
		this.title.textProperty().bindBidirectional(this.vm.getTaskTitle());
		this.description.textProperty().bindBidirectional(this.vm.getTaskDescription());
		this.vm.getTaskHour().bind(this.hours.getSelectionModel().selectedItemProperty());
		this.vm.getTaskPriority().bind(this.priority.getSelectionModel().selectedItemProperty());
		this.vm.getTaskSortingComparator().bind(this.taskOrder.getSelectionModel().selectedItemProperty());
		
		
		//this.taskListView.onMouseClickedProperty().bind(this.vm.getSelectedTask());
		//this.taskListView.itemsProperty().bindBidirectional(this.vm.getSelectedTask().setValue(this.taskListView.getSelectionModel()e));
		//this.vm.
		//this.taskListView.selectionModelProperty().bindBidirectional(this.vm.getSelectedTask()););
		//this.vm.getSelectedTask().bind(this.taskListView.getSelectionModel().selectedItemProperty());
	}
}
