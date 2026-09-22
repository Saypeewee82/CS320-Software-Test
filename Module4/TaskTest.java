// Peter Saye
// 9/21/2026
// CS 320 Module 4 Task Service


package test;

import static org.junit.jupiter.api.Assertions.*;

import task.Task;

import org.junit.jupiter.api.Test;

class TaskTest {

	// test for creating a task
	@Test
	void testTask() {
		
		Task task = new Task("2784946", "Peter", "He is the greatest of all time");
		
		assertEquals("2784946", task.getTaskID());
		assertEquals("Peter", task.getName());
		assertEquals("He is the greatest of all time", task.getDescription());
	}
	
	// test for allowing long values
	@Test
	void testLongestValues() {
		
		Task task = new Task("1234567890",
				"12345678901234567890",
				"12345678901234567890123456789012345678901234567890");
		assertEquals(10, task.getTaskID().length());
		assertEquals(20, task.getName().length());
		assertEquals(50, task.getDescription().length());
		
		}
	
	// test for invalid task ID's
	@Test
	void testInvalidID() {

		assertThrows(IllegalArgumentException.class, 
				() -> new Task(null, "Peter", "He is the greatest of all time"));
		assertThrows(IllegalArgumentException.class, 
				() -> new Task("12345678900", "Peter", "He is the greatest of all time"));
	}
	
	// test for invalid Name
	@Test
	void testInvalidName() {
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Task("2784946", null, "He is the greatest of all time"));
		assertThrows(IllegalArgumentException.class, 
				() -> new Task("2784946", "123456789012345678900", "He is the greatest of all time"));
	}

	// test for invalid Description
	@Test
	void testInvalidDescription() {
		
		assertThrows(IllegalArgumentException.class, 
				() -> new Task("2784946", "Peter", null));
		assertThrows(IllegalArgumentException.class, 
				() -> new Task("2784946", "Peter", "123456789012345678901234567890123456789012345678900"));
	}
	
	// test for making sure invalid updates do not erase old data
	@Test
	void testInvalidUpdates() {
		
		Task task = new Task("2784946", "Peter", "He is the greatest of all time");
		
		assertThrows(IllegalArgumentException.class,
				() -> task.setName(null));

		assertThrows(IllegalArgumentException.class,
				() -> task.setName("123456789012345678900"));

		assertThrows(IllegalArgumentException.class,
				() -> task.setDescription(null));

		assertThrows(IllegalArgumentException.class,
				() -> task.setDescription(
						"123456789012345678901234567890123456789012345678900"));

		assertEquals("Peter", task.getName());

		assertEquals("He is the greatest of all time",
				task.getDescription());
		
	}
	
	

}
