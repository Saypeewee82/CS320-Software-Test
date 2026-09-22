// Peter Saye
// 9/21/2026
// CS 320 Module 4 Task Service


package task;

import java.util.HashMap;

public class TaskService {
	
	private final HashMap<String, Task> tasks = new HashMap<>();
	
	// add a task if ID is unique
	public void addTask(Task task) {
		
		if (tasks.containsKey(task.getTaskID())) {
			throw new IllegalArgumentException("ID already exists.");
		}
		
		tasks.put(task.getTaskID(), task);
	}

	// delete task using the ID
	public void deleteTask(String taskID) {

		tasks.remove(taskID);
	}
	
	// update task name using ID
	public void updateTaskName(String taskID, String name) {
		Task task = tasks.get(taskID);
		
		task.setName(name);
	}
	
	// update task description using ID
	public void updateTaskDescription(String taskID, String description) {
		Task task = tasks.get(taskID);

		task.setDescription(description);
	}

}
