package edu.westga.cs1302.todo_list.viewmodel;

import java.util.ArrayList;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**The ViewModel for MainWidow
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class CreateTaskViewModel {
	private StringProperty taskTitle;
	private StringProperty taskDescription;
	private ListProperty<Integer> hoursList;
	private ObjectProperty<Integer> taskHour;
	private ListProperty<TaskPriority> priorityList;
	private ObjectProperty<TaskPriority> taskPriority;
	private ListProperty<Task> taskList;
	private ObjectProperty<Task> selectedTask;
	
	/**The constructor to initialize the values and properties
	 * 
	 */
	public CreateTaskViewModel() {
		this.taskTitle = new SimpleStringProperty("");
		this.taskDescription = new SimpleStringProperty("");
		this.hoursList = new SimpleListProperty<Integer>(FXCollections.observableArrayList(new ArrayList<Integer>()));
		this.hoursList.addAll(1, 2, 3, 4, 5);
		this.taskHour = new SimpleObjectProperty<Integer>(this.hoursList.get(0));
		this.priorityList = new SimpleListProperty<TaskPriority>(FXCollections.observableArrayList(new ArrayList<TaskPriority>()));
		this.priorityList.addAll(TaskPriority.HIGH, TaskPriority.MEDIUM, TaskPriority.LOW);
		this.taskPriority = new SimpleObjectProperty<TaskPriority>(this.priorityList.get(0));
		this.taskList = new SimpleListProperty<Task>(FXCollections.observableArrayList(new ArrayList<Task>()));
		this.selectedTask = new SimpleObjectProperty<Task>();
	}

	/**Adds task to the list of task using the title description hour and priority given by code behind
	 * 
	 */
	public void addTask() {
		try {
			Task newTask = new Task(this.taskTitle.getValue(), this.taskDescription.getValue(), this.taskHour.getValue(), this.taskPriority.getValue());
			this.taskList.add(newTask);
		} catch (NullPointerException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (ExceptionInInitializerError e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	/**Adds a sub task to the selected task passes in from the code behind alone with the title description hour and priority given by code behind
	 * 
	 */
	public void addSubTask() {
		try {
			Task newSubTask = new Task(this.taskTitle.getValue(), this.taskDescription.getValue(), this.taskHour.getValue(), this.taskPriority.getValue());
			this.selectedTask.getValue().addSubTask(newSubTask);
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (ExceptionInInitializerError e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	/**Gets task title
	 * 
	 * @return task title
	 */
	public StringProperty getTaskTitle() {
		return this.taskTitle;
	}

	/**Gets task description
	 * 
	 * @return task description
	 */
	public StringProperty getTaskDescription() {
		return this.taskDescription;
	}

	/**Gets list of hours
	 * 
	 * @return list of hours
	 */
	public ListProperty<Integer> getHoursList() {
		return this.hoursList;
	}

	/**Gets task hour
	 * 
	 * @return task hour
	 */
	public ObjectProperty<Integer> getTaskHour() {
		return this.taskHour;
	}

	/**Gets list of priorities
	 * 
	 * @return list of priorities
	 */
	public ListProperty<TaskPriority> getPriorityList() {
		return this.priorityList;
	}

	/**Gets task priority
	 * 
	 * @return task priority
	 */
	public ObjectProperty<TaskPriority> getTaskPriority() {
		return this.taskPriority;
	}

	/**Gets list of  task
	 * 
	 * @return list of task
	 */
	public ListProperty<Task> getTaskList() {
		return this.taskList;
	}

	/**Gets task selected
	 * 
	 * @return task slected
	 */
	public ObjectProperty<Task> getSelectedTask() {
		return this.selectedTask;
	}
	
	/**
	 * Below is for testing purposes
	 */
	
	/**Sets Task titles strictly for testing
	 * 
	 * @param taskTitle the tile being set
	 */
	public void setTaskTitle(StringProperty taskTitle) {
		this.taskTitle = taskTitle;
	}

	/**Sets task description strictly for testing
	 * 
	 * @param taskDescription the description being set
	 */
	public void setTaskDescription(StringProperty taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**Sets Task Hour strictly for testing
	 * 
	 * @param taskHour the hour being set
	 */
	public void setTaskHour(ObjectProperty<Integer> taskHour) {
		this.taskHour = taskHour;
	}

	/**Sets Task priority strictly for testing
	 * 
	 * @param taskPriority the priority being set
	 */
	public void setTaskPriority(ObjectProperty<TaskPriority> taskPriority) {
		this.taskPriority = taskPriority;
	}

	/**Sets Task list strictly for testing
	 * 
	 * @param taskList the list of last being set
	 */
	public void setTaskList(ListProperty<Task> taskList) {
		this.taskList.set(taskList);
	}

	/**Sets Task strictly for testing
	 * 
	 * @param selectedTask the task being set
	 */
	public void setSelectedTask(ObjectProperty<Task> selectedTask) {
		this.selectedTask = selectedTask;
	}	
	
	/**sets the task list in ViewModel
     * 
     * @param tasks the list of task being passed in
     * @return boolean to the MainWindow letting it know if it worked
     */
    public boolean setTaskListForView(ObservableList<Task> tasks) {
		if (tasks == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Unable to acess task list");
			alert.showAndWait();
			return false;
		} else {
			ListProperty<Task> newTaskList = new SimpleListProperty<Task>();
			newTaskList.set(tasks);
			this.setTaskList(newTaskList);
			return true;
		}
	}
}