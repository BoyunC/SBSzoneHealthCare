package paper;

import java.util.Date;

import diagnosis.Diagnosis;
import hospital.Hospital;

public class Paper {
	private Date printDate;
	private Date examDate; 
	private int numOfPaper;
	private Hospital hospital;
	private Diagnosis diagnosis;
	
	
	//Constructor
	public Paper() {}
	
	public Paper(Date printDate, Date examDate, int numOfPaper, Diagnosis diagnosis, Hospital hospital) {
		super();
		this.printDate = printDate;
		this.examDate = examDate;
		this.numOfPaper = numOfPaper;
		this.diagnosis = diagnosis;
		this.hospital = hospital;
	}

	
	//Getter Setter
	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public int getNumOfPaper() {
		return numOfPaper;
	}

	public void setNumOfPaper(int numOfPaper) {
		this.numOfPaper = numOfPaper;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	
	
	
}
