package people;

import java.util.ArrayList;

import medicine.Medicine;
import scanner.DataInput;

public class PatientFunction {
	Patient patient;

	// 환자 등록 기능
	public static void registratePatient() {
		System.out.println("========환자 등록========");
		System.out.print("이름 : ");
		String name = DataInput.sc.nextLine();

		System.out.print("주민등록번호 : ");
		String regiNum = DataInput.sc.nextLine();

		System.out.print("패스워드(미입력시 0000으로 초기화) : ");
		String pw = DataInput.sc.nextLine();

		System.out.print("특이사항 : ");
		String description = DataInput.sc.nextLine();

		System.out.print("복용중인 약 여부  : ");
		String hasMedicineList = DataInput.sc.nextLine();
		ArrayList<Medicine> takingMedicineList = new ArrayList<Medicine>();

		if (hasMedicineList.equals("y") || hasMedicineList.equals("Y")) {

			while (true) {
				System.out.println("복용중인 약 검색 : ");
				String medicineName = DataInput.sc.nextLine();

				// 약 검색 메소드 추가

				if (medicineName.equals("Q") || medicineName.equals("q")) {
					break;
				}
			} // while
		} // if

		if (pw == null) {
			new Patient(name, regiNum, "환자", description, takingMedicineList);
		} else {
			new Patient(name, regiNum, pw, "환자", description, takingMedicineList);
		}

		System.out.println("system : 환자 등록이 완료되었습니다.");
	}

	// 환자 검색 기능
	public static Patient searchPatient(String name) {

		ArrayList<Patient> searchPatientList = new ArrayList<Patient>();
		int cnt = 1;

		// 동명이인 추출
		for (int i = 0; i < Patient.patientList.size(); i++) {
			if (Patient.patientList.get(i).getName().equals(name)) {
				searchPatientList.add(Patient.patientList.get(i));
				System.out.println((cnt++) + ". " + Patient.patientList.get(i).getName() + "("
						+ Patient.patientList.get(i).getRegiNum() + ")");
			}
		}

		// 환자 존재하지 않는 경우
		if (searchPatientList.isEmpty()) {
			System.out.println("해당하는 이름의 환자가 존재하지 않습니다.");
			return null;
		}

		System.out.print("환자 선택 : ");
		int pickPatient = Integer.parseInt(DataInput.sc.nextLine()) - 1;

		return searchPatientList.get(pickPatient);
	}

}
