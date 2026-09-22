// Peter Saye
// 9/21/2026
// CS 320 Module 4 Task Service

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

class TaskServiceTest {

	// test adding a task and duplicate ID
	@Test
	void testAddingTask() {

		TaskService taskservice = new TaskService();

		Task task = new Task("2784946", "Peter",
				"He is the greatest of all time");

		taskservice.addTask(task);

		assertThrows(IllegalArgumentException.class,
				() -> taskservice.addTask(new Task("2784946", "Peter",
						"He is the greatest of all time")));

	}

	// test deleting a task
	@Test
	void testDeletingTask() {

		TaskService service = new TaskService();

		service.addTask(new Task("2784946", "Peter",
				"He is the greatest of all time"));

		service.deleteTask("2784946");

		// same ID can be added after deleting
		assertDoesNotThrow(
				() -> service.addTask(new Task("2784946", "Peter",
						"He is the greatest of all time")));

	}

	// test updating a task
	@Test
	void testUpdatingTask() {

		TaskService service = new TaskService();

		Task task = new Task("2784946", "Peter",
				"He is the greatest of all time");

		service.addTask(task);

		service.updateTaskName("2784946", "Christina");

		service.updateTaskDescription("2784946",
				"She is the greatest of all time");

		assertEquals("Christina", task.getName());

		assertEquals("She is the greatest of all time",
				task.getDescription());

		assertEquals("2784946", task.getTaskID());

	}

}