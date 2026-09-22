// Peter Saye
// 9/21/2026
// CS 320 Module 4 Task Service


package task;

public class Task {
	
	// variables
	private final String taskID;
	private String name;
	private String description;
	
	//constructor that checks for null and lengths
	public Task(String taskID, String name, String description) {
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID.");
		}
		
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name.");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description.");
		}
		
		// assignments
		this.taskID = taskID;
		this.name = name;
		this.description = description;
		
	}

	
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name.");
		}
		
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description.");
		}
		
		this.description = description;
	}

	public String getTaskID() {
		return taskID;
	}

}
