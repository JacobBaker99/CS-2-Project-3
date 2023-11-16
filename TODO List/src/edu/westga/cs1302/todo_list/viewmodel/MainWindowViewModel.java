package edu.westga.cs1302.todo_list.viewmodel;

import java.util.ArrayList;
import java.util.Comparator;
import edu.westga.cs1302.todo_list.model.PriorityComparator;
import edu.westga.cs1302.todo_list.model.Task;
import edu.westga.cs1302.todo_list.model.TimeToCompleteComparator;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;

/**
 * The ViewModel for MainWidow
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class MainWindowViewModel {
	private ListProperty<Task> taskList;
	private ObjectProperty<Task> selectedTask;
	private ListProperty<Comparator<Task>> sortingComparatorList;
	private ObjectProperty<Comparator<Task>> taskSortingComparator;

	/**
	 * The constructor to initialize the values and properties
	 * 
	 */
	public MainWindowViewModel() {
		this.taskList = new SimpleListProperty<Task>(FXCollections.observableArrayList(new ArrayList<Task>()));
		this.selectedTask = new SimpleObjectProperty<Task>();
		this.sortingComparatorList = new SimpleListProperty<Comparator<Task>>(
				FXCollections.observableArrayList(new ArrayList<Comparator<Task>>()));
		this.sortingComparatorList.add(new PriorityComparator());
		this.sortingComparatorList.add(new TimeToCompleteComparator());
		this.taskSortingComparator = new SimpleObjectProperty<Comparator<Task>>(
				this.sortingComparatorList.getValue().get(0));
	}

	/**
	 * This will sort the list and assign the detail of the selected task if not
	 * null
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
	}

	/**
	 * This allows the codebehind to pass a clicked value through to the view model
	 * 
	 * @param taskSelected is the task that was clicked on by the user
	 */
	public void setSelectedTask(Task taskSelected) {
		this.selectedTask = new SimpleObjectProperty<Task>(taskSelected);
		this.updateDisplay();
	}

	/**
	 * Gets list of task
	 * 
	 * @return list of task
	 */
	public ListProperty<Task> getTaskList() {
		return this.taskList;
	}

	/**
	 * Gets task selected
	 * 
	 * @return task slected
	 */
	public ObjectProperty<Task> getSelectedTask() {
		return this.selectedTask;
	}

	/**
	 * Gets list of comparators
	 * 
	 * @return list of comparators
	 */
	public ListProperty<Comparator<Task>> getSortingComparatorList() {
		return this.sortingComparatorList;
	}

	/**
	 * Gets current comparator
	 * 
	 * @return current comparator
	 */
	public ObjectProperty<Comparator<Task>> getTaskSortingComparator() {
		return this.taskSortingComparator;
	}

	/**
	 * Sets Task list of all the task
	 * 
	 * @param taskList the list of last being set
	 */
	public void setTaskList(ListProperty<Task> taskList) {
		this.taskList = taskList;
	}

	/**
	 * Sets selected task
	 * 
	 * @param selectedTask the task being set
	 */
	public void setSelectedTask(ObjectProperty<Task> selectedTask) {
		this.selectedTask = selectedTask;
	}

	/**
	 * Sets Task sorting comparator
	 * 
	 * @param taskSortingComparator sorting comparator being set
	 */
	public void setTaskSortingComparator(ObjectProperty<Comparator<Task>> taskSortingComparator) {
		this.taskSortingComparator = taskSortingComparator;
	}
}