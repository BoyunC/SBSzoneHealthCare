package people;

import java.util.ArrayList;
import scanner.DataInput;

public class NurseFunction {

	// 간호사 등록 기능
	public static void registrateNurse() {
		System.out.println("========간호사 등록========");
		System.out.print("이름 : ");
		String name = DataInput.sc.nextLine();

		System.out.print("나이 : ");
		int age = Integer.parseInt(DataInput.sc.nextLine());

		System.out.print("패스워드(미입력시 0000으로 초기화) : ");
		String pw = DataInput.sc.nextLine();

		System.out.print("간호사 면허 번호 : ");
		String licenseNum = DataInput.sc.nextLine();

		if (pw == null) {
			new Nurse(name, age, "간호사", licenseNum);
		} else {
			new Nurse(name, age, "간호사", pw, licenseNum);
		}

		System.out.println("[system] 간호사 등록이 완료되었습니다.");
		System.out.println("[system] 아이디 : " + Nurse.nurseList.get(Nurse.nurseList.size()-1).getId());
	}

	// 간호사 검색 기능 : 이름으로
	// 단순하게 아이디로 간호사 가져오는 메소드는 Nurse -> getNurse()
	public static Nurse searchDoctor(String name) {

		ArrayList<Nurse> searchNurseList = new ArrayList<Nurse>();
		int cnt = 1;

		// 동명이인 추출
		for (int i = 0; i < Nurse.nurseList.size(); i++) {
			if (Nurse.nurseList.get(i).getName().equals(name)) {
				searchNurseList.add(Nurse.nurseList.get(i));
				System.out.println((cnt++) + ". " + Nurse.nurseList.get(i).getName() + "("
						+ Nurse.nurseList.get(i).getLicenseNum() + ")");
			}
		}

		// 간호사 존재하지 않는 경우
		if (searchNurseList.isEmpty()) {
			System.out.println("해당하는 이름의 간호사가 존재하지 않습니다.");
			return null;
		}

		System.out.print("간호사 선택 : ");
		int pickPatient = Integer.parseInt(DataInput.sc.nextLine()) - 1;

		return searchNurseList.get(pickPatient);
	}
}
