// Peter Saye
// 9/28/2026
// CS 320 Module 5 Appointment Service


package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.AppointmentService;

class AppointmentServiceTest {

    // test adding an appointment and duplicate ID
    @Test
    void testAddingAppointment() {

        AppointmentService appointmentService = new AppointmentService();

        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment = new Appointment("2784946", appointmentDate, "Doctor's appointment");

        appointmentService.addAppointment(appointment);

        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(
        		new Appointment("2784946", appointmentDate, "Doctor's appointment")));
    }

    // test deleting an appointment
    @Test
    void testDeletingAppointment() {

        AppointmentService service = new AppointmentService();

        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);

        service.addAppointment(new Appointment(
        		"2784946", appointmentDate, "Doctors appointment"));

        service.deleteAppointment("2784946");

        // same ID can be added after deleting
        assertDoesNotThrow( () -> service.addAppointment(new Appointment(
        		"2784946", appointmentDate, "Doctor's appointment")));
    }

    // test updating an appointment
    @Test
    void testUpdatingAppointment() {

        AppointmentService service = new AppointmentService();

        Date appointmentDate =
                new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment = new Appointment(
        		"2784946", appointmentDate, "Doctor's appointment");

        service.addAppointment(appointment);

        Date newAppointmentDate = new Date(System.currentTimeMillis() + 172800000);

        service.updateAppointmentDate(
                "2784946", newAppointmentDate);

        service.updateAppointmentDescription(
                "2784946", "Doctor's appointment");

        assertEquals(newAppointmentDate, appointment.getAppointmentDate());

        assertEquals("Doctor's appointment", appointment.getDescription());

        assertEquals("2784946", appointment.getAppointmentId());
    }
}