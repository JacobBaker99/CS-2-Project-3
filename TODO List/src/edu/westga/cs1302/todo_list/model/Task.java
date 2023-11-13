package edu.westga.cs1302.todo_list.model;

import java.util.ArrayList;
import java.util.List;

/** Stores basic information for a task.
 * 
 * @author CS 1302
 * @version Fall 2023
 */
public class Task {
	private String description;
	private String title;
	private int hoursToComplete;
	private TaskPriority priority;
	private List<Task> subTasks;
	
	/** Create a new Task
	 * 
	 * @precondition title != null && !title.isEmpty() &&
	 * 				 description != null && !description.isEmpty() &&
	 * 				 hoursToComplete > 0 &&
	 * 				 priority != null
	 * 
	 * @param title title of the new task
	 * @param description description of the new task
	 * @param hoursToComplete hours to complete the new task
	 * @param priority priority of the new task
	 */
	public Task(String title, String description, int hoursToComplete, TaskPriority priority) {
		if (title == null) {
			throw new IllegalArgumentException("must provide a title, but title was null");
		}
		if (title.isEmpty()) {
			throw new IllegalArgumentException("must provide a title, but title was empty");
		}
		if (description == null) {
			throw new IllegalArgumentException("must provide a description, but description was null");
		}
		if (description.isEmpty()) {
			throw new IllegalArgumentException("must provide a description, but description was empty");
		}
		if (hoursToComplete <= 0) {
			throw new IllegalArgumentException("must have a positive number of hours to complete the task");
		}
		if (priority == null) {
			throw new IllegalArgumentException("must provide a priority");
		}
		this.title = title;
		this.description = description;
		this.hoursToComplete = hoursToComplete;
		this.priority = priority;
		this.subTasks = new ArrayList<Task>();
	}
	
	/** Return the title of the task
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the title of the task
	 */
	public String getTitle() {
		return this.title;
	}
	
	/** Return the description of the task
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the description of the task
	 */
	public String getDescription() {
		return this.description;
	}
	
	/** Return the priority of the task
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the priority of the task
	 */
	public TaskPriority getPriority() {
		return this.priority;
	}
	
	/** Return the hours to complete of the task
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the hours to complete of the task
	 */
	public int getHoursToComplete() {
		return this.hoursToComplete;
	}
	
	/** Returns the list of subtasks
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list of subtasks
	 */
	public List<Task> getTasks() {
		return this.subTasks;
	}
	
	/** Generates a string representation of the basic object state
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return string representation of the basic object state
	 * 
	 */
	public String toString() {
		return this.title;
	}
	
	/** Add a new subtask to the task
	 * 
	 * @precondition subTask != null
	 * @postcondition subTask has been added to the task
	 * 
	 * @param subTask the task to add as a subtask
	 * 
	 * @throws IllegalArgumentException if the precondition is violated
	 * 
	 */
	public void addSubTask(Task subTask) throws IllegalArgumentException {
		if (subTask == null) {
			throw new IllegalArgumentException("sub task must not be null");
		}
		this.subTasks.add(subTask);
	}
	
	/** Generates a string representation of the full object state
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return string representation of the full object state
	 * 
	 */
	public String getFullDetails() {
		String fullDetails = this.title + System.lineSeparator();
		fullDetails += "Description: " + this.description + System.lineSeparator();
		fullDetails += "Hours to complete: " + this.hoursToComplete + System.lineSeparator();
		fullDetails += "Priority: " + this.priority + System.lineSeparator();
		if (!this.subTasks.isEmpty()) {
			fullDetails += "***Subtasks***" + System.lineSeparator();
			for (Task currentTask : this.subTasks) {
				fullDetails += currentTask.getFullDetails() + System.lineSeparator();
			}
		}
		return fullDetails;
	}

	/** Get the highest priority considering both the task and its subtasks
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the highest priority 
	 */
	public TaskPriority getOverallPriority() {
		TaskPriority highest = this.priority;
		for (Task currentTask : this.subTasks) {
			TaskPriority currentTaskPriority = currentTask.getOverallPriority();
			if ((new PriorityComparator()).comparePriority(currentTaskPriority, highest) < 0) {
				highest = currentTaskPriority;
			}
		}
		return highest;
	}
}
