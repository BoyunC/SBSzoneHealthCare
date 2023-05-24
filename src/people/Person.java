package people;

import java.util.ArrayList;

public class Person {
	// 자동 생성
	private String id;

	// 자동 생성 또는 입력 가능 값
	private String pw;
	private int age;

	// 필수 입력값
	private String name;
	private String code;

	// Constructor
	public Person() {
	}

	// C : 필수 입력 값 (이름, 코드)
	public Person(String name, String code) {
		super();

		setIDnCode(code);
		this.name = name;
		this.pw = "0000";
	}

	// C : 이름, 나이, 코드
	public Person(String name, int age, String code) {
		super();

		setIDnCode(code);
		this.name = name;
		this.age = age;
		this.pw = "0000";
	}

	// C : 이름, 코드, 비밀번호
	public Person(String name, String code, String pw) {
		super();

		setIDnCode(code);
		this.pw = pw;
		this.name = name;
	}

	// C : 이름, 나이, 코드, 비밀번호
	public Person(String name, int age, String code, String pw) {
		super();

		setIDnCode(code);
		this.pw = pw;
		this.age = age;
		this.name = name;
	}

	// Method
	// 아이디 자리수 설정 기능
	private String setDigit(ArrayList list) {

		if (list.size() < 10) {
			return "000" + (list.size() + 1);
		} else if (list.size() < 100) {
			return "00" + (list.size() + 1);
		} else if (list.size() < 1000) {
			return "0" + (list.size() + 1);
		}

		return list.size() + 1 + "";
	}

	// 코드 및 아이디 설정 기능
	private void setIDnCode(String code) {

		// 코드 및 아이디 설정
		if (code.equals("의사")) {
			this.code = "doctor";
			this.id = "dr_" + setDigit(Doctor.doctorList);
		} else if (code.equals("간호사")) {
			this.code = "nurse";
			this.id = "nu_" + setDigit(Nurse.nurseList);
		} else if (code.equals("환자")) {
			this.code = "patient";
			this.id = "pa_" + setDigit(Patient.patientList);
		}
	}

	// Getter & Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
