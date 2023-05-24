package diagnosis;

import java.util.Date;

import appointment.Appointment;
import disease.Disease;
import people.Doctor;

public class Exam {

	private String opinion;
	private Date date;
	
	private Doctor doctor;
	private Disease disease;
	private Appointment appointment;
	
	// Constructor
	public Exam() {}

	public Exam(Doctor doctor, Appointment appointment) {
		super();
		this.doctor = doctor;
		this.appointment = appointment;
	}

	
	// Method
	
	// Getter & Setter
	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
}
