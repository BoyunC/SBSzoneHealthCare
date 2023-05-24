package people;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Patient extends Person{
	private String regiNum;
	private int visitCnt; 
	private Date firstVisitDate;
	private Date lastVistiDate;
	private String description;
	private ArrayList<Vital> vital;
	
	public static ArrayList<Patient> patientList = new ArrayList<Patient>();
	
	private Date date =  new Date();
	
	// Constructor
	public Patient() {
		visitCnt = 1;
		firstVisitDate =  new Date();
		lastVistiDate =  new Date();
		vital = new ArrayList<Vital>();
		
	}
	
	// C : 이름, 코드, 주민등록번호
	public Patient(String name, String code, String regiNum) {
		super(name, code);
		this.regiNum = regiNum;
	
		// 나이 설정 안됨 => 나이 계산기 
		this.setAge(1900 + date.getYear() - (Integer.parseInt("19" + regiNum.charAt(0)+regiNum.charAt(1))));
		
		patientList.add(this);
		printResult();
		
		visitCnt = 1;
		firstVisitDate =  new Date();
		lastVistiDate =  new Date();
		vital = new ArrayList<Vital>();
	}

	// C : 이름, 코드, 비밀번호, 주민등록번호 
	public Patient(String name, String code, String pw, String regiNum) {
		super(name, code, pw);
		this.regiNum = regiNum;
		
		patientList.add(this);
		printResult();
		
		visitCnt = 1;
		firstVisitDate =  new Date();
		lastVistiDate =  new Date();
		vital = new ArrayList<Vital>();
	}

	// Method 
	
	// 
	public void printPatient() {
		System.out.println("성명 : " + this.getName());
		System.out.println("나이 : " + this.getAge());
		System.out.println("주민등록번호 : " + this.getRegiNum());
		System.out.println("방문 횟수 : " + this.getVisitCnt());
		System.out.println("첫 내원일 : " + this.getFirstVisitDate());
		System.out.println("마지막 내원일 : " + this.getLastVistiDate());
		System.out.println("특이사항 : " + this.getDescription());
		
		//System.out.println("환자 성명 : " + patient()); 복용약
	}
	
	// 회원 검색 
	static public Patient getPatient(String name) {
		for(Patient patient : patientList) {
			if (patient.getName().equals(name)) {
				return patient;
			}
		}
		
		return null;  // 존재하지 않는 경우 => null 반환 
	}
	
	// 
	private void printResult() {
		System.out.println("회원 등록이 완료되었습니다.");
	}
	
	//
	public void printAll() {
		System.out.println(this.getId() + " "
				 + this.getPw() + " "
				 + this.getName() + " "
				 + this.getAge() + " "
				 + this.getCode() + " "
				 + this.regiNum);
		
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
		return vital;
	}

	public void setVital(ArrayList<Vital> vital) {
		this.vital = vital;
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
