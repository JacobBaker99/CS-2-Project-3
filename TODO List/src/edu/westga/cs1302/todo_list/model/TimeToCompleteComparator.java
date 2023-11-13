package edu.westga.cs1302.todo_list.model;

import java.util.Comparator;

/** Compares two tasks based on time to complete.
 * 
 * @author CS 1302
 * @version Fall 2023
 */
public class TimeToCompleteComparator  implements Comparator<Task> {
	
	/** Compare two tasks based on time to complete
	 * 
	 * @precondition firstTask != null and SecondTask != null
	 * @postcondition none
	 * 
	 * @param firstTask the first task being compared
	 * @param secondTask the second task being compared
	 * 
	 * @return -1 if secondTask takes longer to complete
	 * 		   0  if both tasks have same priority
	 * 		   1  if firstTask takes longer to complete
	 * 
	 */
	@Override
	public int compare(Task firstTask, Task secondTask) {
		if (firstTask == null || secondTask == null) {
			throw new IllegalArgumentException("Should not compare null Task objects");
		}
		return firstTask.getHoursToComplete() - secondTask.getHoursToComplete();
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
		return "Time to Complete";
	}
}
