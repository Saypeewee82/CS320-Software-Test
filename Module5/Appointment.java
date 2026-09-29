// Peter Saye
// 9/28/2026
// CS 320 Module 5 Appointment Service


package appointment;

import java.util.Date;

public class Appointment {

	// variables
	private final String appointmentId;
	private Date appointmentDate;
	private String description;
	
	//constructor that checks for null and lengths
	public Appointment (String appointmentId, Date appointmentDate, String description) {
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID.");
		}
		
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid date.");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description.");
		}
		
		// assignments
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}

	// getters and setters
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid date.");
		}
		
		this.appointmentDate = appointmentDate;
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

	public String getAppointmentId() {
		return appointmentId;
	}
	
	
}
