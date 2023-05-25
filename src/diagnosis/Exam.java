package diagnosis;

import java.util.ArrayList;
import java.util.Date;

import appointment.Appointment;
import disease.Disease;
import disease.DiseaseFunction;
import medicine.Medicine;
import people.Doctor;
import scanner.DataInput;

public class Exam {

	private String detailSymptom;
	private String diagnosis;
	private String opinion;
	private Date date;

	private Appointment appointment;

	private ArrayList<Disease> havingDiseaseList = new ArrayList<>();

	// Constructor
	public Exam() {
	}

	public Exam(Appointment appointment) {
		super();
		this.appointment = appointment;
	}

	// Method
	public void printExam() {
		
		System.out.println("자세한 증상 : " + detailSymptom);
		
		System.out.print("진단 명 : ");

		for (Disease disease : havingDiseaseList) {
			System.out.print(disease.getName() + "(" + disease.getId() + ") ");
		}
		System.out.println();
		
		if(opinion != null) {
			System.out.println("의사 소견 : " + opinion);
		}
	}

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

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public String getDetailSymptom() {
		return detailSymptom;
	}

	public void setDetailSymptom(String detailSymptom) {
		this.detailSymptom = detailSymptom;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public ArrayList<Disease> getHavingDiseaseList() {
		return havingDiseaseList;
	}

	public void setHavingDiseaseList(ArrayList<Disease> havingDiseaseList) {
		this.havingDiseaseList = havingDiseaseList;
	}
	
	public void addHavingDiseaseList(Disease disease) {
		havingDiseaseList.add(disease);
	}
	
	
}
