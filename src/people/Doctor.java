package people;

import java.util.ArrayList;

public class Doctor extends Person{
	
	private String office;
	private String major;
	private String licenseNum;
	
	public static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	
	public Doctor() { }

	public Doctor(String name, int age, String code, String office, String major, String licenseNum) {
		super(name, age, code);
		this.office = office;
		this.major = major;
		this.licenseNum = licenseNum;
	}

	public Doctor(String name, int age, String code, String pw, String office, String major, String licenseNum) {
		super(name, age, code, pw);
		this.office = office;
		this.major = major;
		this.licenseNum = licenseNum;
	}
	
	

}
