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

/**The ViewModel for MainWidow
 * 
 * @author Jacob Baker
 * @version Fall 2023
 */
public class MiainWindowViewModel {
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
	public MiainWindowViewModel() {
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
		this.taskSortingComparator = new SimpleObjectProperty<Comparator<Task>>(this.sortingComparatorList.get(0));
		this.deatails = new SimpleStringProperty("");
	}
}
