package people;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import appointment.Appointment;
import diagnosis.Diagnosis;
import medicine.Medicine;
import reception.Payment;

public class Patient extends Person {
	private String regiNum;
	private int visitCnt;
	private Date firstVisitDate;
	private Date lastVistiDate;
	private String description;
	public ArrayList<Vital> vitalList;
	public ArrayList<Medicine> takingMedicineList;
	public ArrayList<Appointment> appointmentList;
	public ArrayList<Payment> paymentList;
	public ArrayList<Diagnosis> diagnosisList;

	public static ArrayList<Patient> patientList = new ArrayList<Patient>();

	private Date date = new Date();

	// Constructor
	public Patient() {
	}

	// C : 이름, 코드, 주민등록번호, 특이사항, 복용약 리스트
	public Patient(String name, String code, String regiNum, String description,
			ArrayList<Medicine> takingMedicineList) {
		super(name, code);
		this.regiNum = regiNum;

		// 나이 설정 제대로 안됨 => 나이 계산기 이후 제작
		this.setAge(1900 + date.getYear() - (Integer.parseInt("19" + regiNum.charAt(0) + regiNum.charAt(1))));

		this.visitCnt = 1;
		this.firstVisitDate = new Date();
		this.lastVistiDate = new Date();
		this.description = description;
		this.takingMedicineList = takingMedicineList;
		vitalList = new ArrayList<Vital>();

		patientList.add(this);
		printResult();
	}

	// C : 이름, 코드, 비밀번호, 주민등록번호, 특이사항, 복용약 리스트
	public Patient(String name, String code, String pw, String regiNum, String description,
			ArrayList<Medicine> takingMedicineList) {
		super(name, code, pw);
		this.regiNum = regiNum;

		visitCnt = 1;
		firstVisitDate = new Date();
		lastVistiDate = new Date();
		this.description = description;
		this.takingMedicineList = takingMedicineList;
		vitalList = new ArrayList<Vital>();

		patientList.add(this);
		printResult();
	}

	// Method

	// 환자 출력
	public void printPatient() {
		System.out.println("성명 : " + this.getName());
		System.out.println("나이 : " + this.getAge());
		System.out.println("주민등록번호 : " + this.getRegiNum());
		System.out.println("방문 횟수 : " + this.getVisitCnt());
		System.out.println("첫 내원일 : " + this.getFirstVisitDate());
		System.out.println("마지막 내원일 : " + this.getLastVistiDate());
		System.out.println("특이사항 : " + this.getDescription());

		System.out.print("복용중인 약 : ");
		for (Medicine medicine : takingMedicineList) {
			System.out.println(medicine.getName() + "(" + medicine.getId() + ")  ");
		}

		// 가장 최근 vital 출력
		System.out.print("체온 : " + vitalList.get(vitalList.size() - 1).getTemperature());
		System.out.print("체중 : " + vitalList.get(vitalList.size() - 1).getWeight());
		System.out.print("신장 : " + vitalList.get(vitalList.size() - 1).getHeight());
		System.out.print("혈압 : " + vitalList.get(vitalList.size() - 1).getBloodPressure());
		System.out.print("혈당 : " + vitalList.get(vitalList.size() - 1).getBloodSuger());

		// System.out.println("환자 성명 : " + patient()); 복용약
	}

	public ArrayList<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(ArrayList<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	// 회원 검색
	static public Patient getPatient(String name) {
		for (Patient patient : patientList) {
			if (patient.getName().equals(name)) {
				return patient;
			}
		}

		return null; // 존재하지 않는 경우 => null 반환
	}

	//
	private void printResult() {
		System.out.println("회원 등록이 완료되었습니다.");
	}

	//
	public void printAll() {
		System.out.println(this.getId() + " " + this.getPw() + " " + this.getName() + " " + this.getAge() + " "
				+ this.getCode() + " " + this.regiNum);

	}

	// Getter & Setter

	public String getRegiNum() {
		return regiNum;
	}

	public void setRegiNum(String regiNum) {
		this.regiNum = regiNum;
	}

	public int getVisitCnt() {
		return visitCnt;
	}

	public void setVisitCnt(int visitCnt) {
		this.visitCnt = visitCnt;
	}

	public Date getFirstVisitDate() {
		return firstVisitDate;
	}

	public void setFirstVisitDate(Date firstVisitDate) {
		this.firstVisitDate = firstVisitDate;
	}

	public Date getLastVistiDate() {
		return lastVistiDate;
	}

	public void setLastVistiDate(Date lastVistiDate) {
		this.lastVistiDate = lastVistiDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Vital> getVital() {
		return vitalList;
	}

	public void setVital(ArrayList<Vital> vitalList) {
		this.vitalList = vitalList;
	}

	public static ArrayList<Patient> getPatientList() {
		return patientList;
	}

	public static void setPatientList(ArrayList<Patient> patientList) {
		Patient.patientList = patientList;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
