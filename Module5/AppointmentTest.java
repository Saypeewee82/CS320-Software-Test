// Peter Saye
// 9/28/2026
// CS 320 Module 5 Appointment Service


package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import org.junit.jupiter.api.Test;

import appointment.Appointment;

class AppointmentTest {

    // test valid appointment
    @Test
    void testAppointment() {

        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment = new Appointment(
                "2784946", appointmentDate, "Doctor's appointment");

        assertEquals("2784946", appointment.getAppointmentId());

        assertEquals(appointmentDate, appointment.getAppointmentDate());

        assertEquals("Doctor's appointment", appointment.getDescription());
    }

    // test null appointment ID
    @Test
    void testAppointmentIdNull() {

        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);

        assertThrows(IllegalArgumentException.class, 
        		() -> new Appointment(null, appointmentDate, "Doctor's appointment"));
    }

    // test appointment ID longer than 10 characters
    @Test
    void testAppointmentIdTooLong() {

        Date appointmentDate =
                new Date(System.currentTimeMillis() + 86400000);

        assertThrows(IllegalArgumentException.class, 
        		() -> new Appointment("12345678901", appointmentDate, "Doctor's appointment"));
    }

    // test null appointment date
    @Test
    void testAppointmentDateNull() {

        assertThrows(IllegalArgumentException.class, 
        		() -> new Appointment("2784946", null, "Doctor's appointment"));
    }

    // test appointment date in the past
    @Test
    void testAppointmentDatePast() {

        Date appointmentDate = new Date(System.currentTimeMillis() - 86400000);

        assertThrows(IllegalArgumentException.class, 
        		() -> new Appointment("2784946", appointmentDate, "Doctor's appointment"));
    }

    // test null description
    @Test
    void testDescriptionNull() {

        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);

        assertThrows(IllegalArgumentException.class, 
        		() -> new Appointment("2784946", appointmentDate, null));
    }

    // test description longer than 50 characters
    @Test
    void testDescriptionTooLong() {

        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);

        assertThrows(IllegalArgumentException.class, 
        		() -> new Appointment("2784946", appointmentDate, 
                "Peter has a doctor's appointment that is over fifty characters long"));
    }

    // test updating appointment date
    @Test
    void testSetAppointmentDate() {

        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment = new Appointment(
                "2784946", appointmentDate, "Doctor's appointment");

        Date newAppointmentDate = new Date(System.currentTimeMillis() + 172800000);

        appointment.setAppointmentDate(newAppointmentDate);

        assertEquals(newAppointmentDate, appointment.getAppointmentDate());
    }

    // test invalid updated appointment date
    @Test
    void testSetAppointmentDatePast() {

        Date appointmentDate =
                new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment = new Appointment(
                "2784946", appointmentDate, "Doctor's appointment");

        Date pastDate = new Date(System.currentTimeMillis() - 86400000);

        assertThrows(IllegalArgumentException.class, 
        		() -> appointment.setAppointmentDate(pastDate));
    }

    // test updating description
    @Test
    void testSetDescription() {

        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment = new Appointment(
                "2784946", appointmentDate, "Doctor's appointment");

        appointment.setDescription("Dentist appointment");

        assertEquals("Dentist appointment", appointment.getDescription());
    }

    // test invalid updated description
    @Test
    void testSetDescriptionNull() {

        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment = new Appointment(
                "2784946", appointmentDate, "Dentist appointment");

        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
    }
}