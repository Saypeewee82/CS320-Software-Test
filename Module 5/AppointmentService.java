// Peter Saye
// 9/28/2026
// CS 320 Module 5 Appointment Service


package appointment;

import java.util.HashMap;
import java.util.Date;


public class AppointmentService {

	private final HashMap<String, Appointment> appointments = new HashMap<>();
	
	// add a appointment if ID is unique
	public void addAppointment(Appointment appointment) {
		
		if (appointments.containsKey(appointment.getAppointmentId())) {
			throw new IllegalArgumentException("ID already exists.");
		}
		
		appointments.put(appointment.getAppointmentId(), appointment);
	}

    // delete appointment using the ID
    public void deleteAppointment(String appointmentId) {

        appointments.remove(appointmentId);
    }
    
    // update appointment date using ID
    public void updateAppointmentDate(String appointmentId, Date appointmentDate) {

        Appointment appointment = appointments.get(appointmentId);

        appointment.setAppointmentDate(appointmentDate);
    }

    // update appointment description using ID
    public void updateAppointmentDescription(String appointmentId, String description) {

        Appointment appointment = appointments.get(appointmentId);

        appointment.setDescription(description);
    }
	
}
