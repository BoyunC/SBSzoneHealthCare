package people;

import java.util.ArrayList;

public class Nurse extends Person {

	private String licenseNum;

	public static ArrayList<Nurse> nurseList = new ArrayList<Nurse>();

	// Constructor
	public Nurse() {
	}

	public Nurse(String name, int age, String code, String licenseNum) {
		super(name, age, code);
		this.licenseNum = licenseNum;
	}

	public Nurse(String name, int age, String code, String pw, String licenseNum) {
		super(name, age, code, pw);
		this.licenseNum = licenseNum;
	}

	// Method

	public Nurse getNurse(String id) {
		for (Nurse nurse : nurseList) {
			if (nurse.getId().equals(id)) {
				return nurse;
			}
		}

		return null;
	}

	// Getter & Setter
	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public static ArrayList<Nurse> getNurseList() {
		return nurseList;
	}

	public static void setNurseList(ArrayList<Nurse> nurseList) {
		Nurse.nurseList = nurseList;
	}

}
