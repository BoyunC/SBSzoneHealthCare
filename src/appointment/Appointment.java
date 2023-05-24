package appointment;

import java.util.Date;

import people.Doctor;
import people.Patient;

public class Appointment {
	private Date date;
	private int time;
	private String symtom;
	private Doctor doctor;
	private Patient patient;
	
	public Appointment() {}

	public Appointment(Date date, int time, String symtom, Doctor doctor, Patient patient) {
		super();
		this.date = date;
		this.time = time;
		this.symtom = symtom;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
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
