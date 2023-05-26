package diagnosis;

import java.util.Date;

public class Diagnosis {

	private Exam exam;
	private Prescription prescription;
	private int charge;
	private Date date; 

	// Constructor
	public Diagnosis() {
	}

	public Diagnosis(Exam exam, Prescription prescription) {
		super();
		this.exam = exam;
		this.prescription = prescription;
		this.charge = prescription.getHavingMedicineList().size() * 2500; 
		this.date = new Date();
	}
	
	// Method
	public void printDiagonis() {
		
	}

	
	// Getter & Setter 
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	 
}
