package edu.westga.cs1302.todo_list.viewmodel;

import java.util.ArrayList;
import java.util.Comparator;
import edu.westga.cs1302.todo_list.model.PriorityComparator;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TaskPriority;
import edu.westga.cs1302.todo_list.model.TimeToCompleteComparator;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;

/**The ViewModel for MainWidow
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class MainWindowViewModel {
	private StringProperty taskTitle;
	private StringProperty taskDescription;
	private ListProperty<Integer> hoursList;
	private ObjectProperty<Integer> taskHour;
	private ListProperty<TaskPriority> priorityList;
	private ObjectProperty<TaskPriority> taskPriority;
	private ListProperty<Task> taskList;
	private ObjectProperty<Task> selectedTask;
	private ListProperty<Comparator<Task>> sortingComparatorList;
	private ObjectProperty<Comparator<Task>> taskSortingComparator;
	private StringProperty deatails;
	
	/**The constructor to initialize the values and properties
	 * 
	 */
	public MainWindowViewModel() {
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
		this.sortingComparatorList = new SimpleListProperty<Comparator<Task>>(FXCollections.observableArrayList(new ArrayList<Comparator<Task>>()));
		this.sortingComparatorList.add(new PriorityComparator());
		this.sortingComparatorList.add(new TimeToCompleteComparator());
		this.taskSortingComparator = new SimpleObjectProperty<Comparator<Task>>(this.sortingComparatorList.getValue().get(0));
		this.deatails = new SimpleStringProperty("");
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
		}
		this.updateDisplay();
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
		}
		this.updateDisplay();
	}
	
	/**This will sort the list and assign the detail of the selected task if not null
	 * 
	 */
	public void updateDisplay() {
		try {
			this.taskList.getValue().sort(this.taskSortingComparator.getValue());
		} catch (NullPointerException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		} catch (IllegalArgumentException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		if (this.selectedTask.getValue() != null) {
			this.deatails.set(this.selectedTask.getValue().getFullDetails());
		}
	}
	
	/**This allows the codebehind to pass a clicked value through to the view model
	 * 
	 * @param taskSelected is the task that was clicked on by the user
	 */
	public void setSelectedTask(Task taskSelected) {
		this.selectedTask = new SimpleObjectProperty<Task>(taskSelected);
		this.updateDisplay();
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

	/**Gets list of comparators
	 * 
	 * @return list of comparators
	 */
	public ListProperty<Comparator<Task>> getSortingComparatorList() {
		return this.sortingComparatorList;
	}

	/**Gets current comparator
	 * 
	 * @return current comparator
	 */
	public ObjectProperty<Comparator<Task>> getTaskSortingComparator() {
		return this.taskSortingComparator;
	}

	/**Gets task details
	 * 
	 * @return task details
	 */
	public StringProperty getDeatails() {
		return this.deatails;
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
		this.taskList = taskList;
	}

	/**Sets Task strictly for testing
	 * 
	 * @param selectedTask the task being set
	 */
	public void setSelectedTask(ObjectProperty<Task> selectedTask) {
		this.selectedTask = selectedTask;
	}

	/**Sets Task sorting comparator strictly for testing
	 * 
	 * @param taskSortingComparator sorting comparator being set
	 */
	public void setTaskSortingComparator(ObjectProperty<Comparator<Task>> taskSortingComparator) {
		this.taskSortingComparator = taskSortingComparator;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Above is for testing purposes
	 */
}