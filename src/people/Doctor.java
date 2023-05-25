package people;

import java.util.ArrayList;

public class Doctor extends Person {

	private String office;
	private String major;
	private String licenseNum;

	public static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();

	// Constructor
	public Doctor() {
	}

	public Doctor(String name, int age, String code, String office, String major, String licenseNum) {
		super(name, age, code);
		this.office = office;
		this.major = major;
		this.licenseNum = licenseNum;

		doctorList.add(this);
	}

	public Doctor(String name, int age, String code, String pw, String office, String major, String licenseNum) {
		super(name, age, code, pw);
		this.office = office;
		this.major = major;
		this.licenseNum = licenseNum;

		doctorList.add(this);
	}

	// Method
	// 의사 출력 : 아이디로 입력 받음
	public Doctor getDoctorFromId(String id) {

		for (Doctor doctor : doctorList) {
			if (doctor.getId().equals(id)) {
				return doctor;
			}
		}

		return null;
	}

	// Getter & Setter
	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public static ArrayList<Doctor> getDoctorList() {
		return doctorList;
	}

	public static void setDoctorList(ArrayList<Doctor> doctorList) {
		Doctor.doctorList = doctorList;
	}

}
