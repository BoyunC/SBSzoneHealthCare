package people;

import java.util.ArrayList;

import medicine.Medicine;
import scanner.DataInput;

public class DoctorFunction {

	// 의사 등록 기능
	public static void registrateDoctor() {
		System.out.println("========의사 등록========");
		System.out.print("이름 : ");
		String name = DataInput.sc.nextLine();

		System.out.print("나이 : ");
		int age = Integer.parseInt(DataInput.sc.nextLine());

		System.out.print("패스워드(미입력시 0000으로 초기화) : ");
		String pw = DataInput.sc.nextLine();

		System.out.print("근무지 : ");
		String office = DataInput.sc.nextLine();

		System.out.print("전공 : ");
		String major = DataInput.sc.nextLine();

		System.out.print("의사 면허 번호 : ");
		String licenseNum = DataInput.sc.nextLine();

		if (pw == null) {
			new Doctor(name, age, "의사", office, major, licenseNum);
		} else {
			new Doctor(name, age, "의사", pw, office, major, licenseNum);
		}

		System.out.println("[system] 의사 등록이 완료되었습니다.");
		System.out.println("[system] 아이디 : " + Doctor.doctorList.get(Doctor.doctorList.size() - 1).getId());
	}

	// 의사 검색 기능 : 이름으로
	// 단순하게 아이디로 의사 가져오는 메소드는 Doctor -> getDoctor()
	public static Doctor searchDoctor(String name) {

		ArrayList<Doctor> searchDoctorList = new ArrayList<Doctor>();
		int cnt = 1;

		// 동명이인 추출
		for (int i = 0; i < Doctor.doctorList.size(); i++) {
			if (Doctor.doctorList.get(i).getName().equals(name)) {
				searchDoctorList.add(Doctor.doctorList.get(i));
				System.out.println((cnt++) + ". " + Doctor.doctorList.get(i).getName() + "("
						+ Doctor.doctorList.get(i).getLicenseNum() + ")");
			}
		}

		// 의사 존재하지 않는 경우
		if (searchDoctorList.isEmpty()) {
			System.out.println("해당하는 이름의 의사가 존재하지 않습니다.");
			return null;
		}

		System.out.print("의사 선택 : ");
		int pickPatient = Integer.parseInt(DataInput.sc.nextLine()) - 1;

		return searchDoctorList.get(pickPatient);
	}

}
