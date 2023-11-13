package edu.westga.cs1302.todo_list.model;

import java.util.Comparator;

/** Compares two tasks based on priority.
 * 
 * @author CS 1302
 * @version Fall 2023
 */
public class PriorityComparator implements Comparator<Task> {

	/** Compare two tasks based on priority
	 * 
	 * @precondition firstTask != null and SecondTask != null
	 * @postcondition none
	 * 
	 * @param firstTask the first task being compared
	 * @param secondTask the second task being compared
	 * 
	 * @return 1 if secondTask is higher priority
	 * 		   0  if both tasks have same priority
	 * 		   -1  if firstTask is higher priority
	 * 
	 */
	@Override
	public int compare(Task firstTask, Task secondTask) {
		if (firstTask == null || secondTask == null) {
			throw new IllegalArgumentException("Should not compare null Task objects");
		}
		
		TaskPriority firstPrio = firstTask.getOverallPriority();
		TaskPriority secondPrio = secondTask.getOverallPriority();
		return this.comparePriority(firstPrio, secondPrio);
	}

	/** Compares two task priorities
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param firstPrio the first priority being compared
	 * @param secondPrio the second priority being compared
	 * 
	 * @return 1 if firstPrio is higher
	 * 		   0 if both priorities are the same
	 * 		   -1 if secondPrio is higher
	 */
	public int comparePriority(TaskPriority firstPrio, TaskPriority secondPrio) {
		if (firstPrio == null || secondPrio == null) {
			throw new IllegalArgumentException("Should not compare null TaskPriority objects");
		}
		if (firstPrio == secondPrio) {
			return 0;
		} else if (firstPrio == TaskPriority.HIGH) {
			return -1;
		} else if (firstPrio == TaskPriority.MEDIUM && secondPrio == TaskPriority.LOW) {
			return -1;
		} else {
			return 1;
		}
	}
	
	/** Returns a label for the type of comparison.
	 * 
	 * @precondition none
	 * @postondition none
	 * 
	 * @return a label for the type of comparison.
	 */
	@Override
	public String toString() {
		return "Priority";
	}

}
