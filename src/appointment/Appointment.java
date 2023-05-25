package appointment;

import java.util.Calendar;
import java.util.Date;

import people.Doctor;
import people.Patient;

public class Appointment {
	private	Calendar date;
	private String time;
	private String symtom;
	private Doctor doctor;
	private Patient patient;
	
	
	public Appointment() {}

	public Appointment(Calendar date, String time) {
		super();
		this.date = date;
		this.time = time;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSymtom() {
		return symtom;
	}

	public void setSymtom(String symtom) {
		this.symtom = symtom;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
