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

		System.out.print("자세한 증상 : ");
		detailSymptom = DataInput.sc.nextLine();

		System.out.println("---진단---");
		// 병 검색 메소드
		while (true) {
			System.out.print("병명 입력 : ");
			String nameDisease = DataInput.sc.nextLine();
			if (nameDisease.equals("Q") || nameDisease.equals("q"))
				break;
			havingDiseaseList.add(DiseaseFunction.searchDisease(nameDisease));
		}

		System.out.print("의사 소견을 입력하시겠습니까? (Y/N)");
		if (DataInput.sc.nextLine().equals("Y") || DataInput.sc.nextLine().equals("y")) {
			System.out.print("진단 : ");
			opinion = DataInput.sc.nextLine();
		}

		date = new Date();
	}

	// Method
	public void printExam() {
		
		System.out.println("자세한 증상 " + detailSymptom);
		
		System.out.print("진단 명 : ");

		for (Disease disease : havingDiseaseList) {
			System.out.print(disease.getName() + "(" + disease.getId() + ") ");
		}
		
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
}
