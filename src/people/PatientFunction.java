package people;

import java.util.ArrayList;

import medicine.Medicine;
import medicine.MedicineFunction;
import scanner.DataInput;

public class PatientFunction {
	Patient patient;

	// 환자 등록 기능
	public static void registratePatient() {
		System.out.print("[system] 이름 : ");
		String name = DataInput.sc.nextLine();

		System.out.print("[system] 주민등록번호 : ");
		String regiNum = DataInput.sc.nextLine();

		System.out.print("[system] 패스워드(미입력시 0000으로 초기화) : ");
		String pw = DataInput.sc.nextLine();

		System.out.print("[system] 특이사항 : ");
		String description = DataInput.sc.nextLine();

		System.out.print("[system] 복용중인 약 여부[y/n]  : ");
		String hasMedicineList = DataInput.sc.nextLine();
		ArrayList<Medicine> takingMedicineList = new ArrayList<Medicine>();

		if (hasMedicineList.equals("y") || hasMedicineList.equals("Y")) {

			while (true) {
				System.out.print("[system] 복용중인 약 검색 (중단 Q) : ");
				String medicineName = DataInput.sc.nextLine();

				if (medicineName.equals("Q") || medicineName.equals("q")) {
					break;
				}
				
				takingMedicineList.add(MedicineFunction.searchMedicine(medicineName));
			} // while
		} // if

		if (pw == null) {
			System.out.println(takingMedicineList.toString());
			new Patient(name, "환자", regiNum, description, takingMedicineList);
		} else {
			new Patient(name, "환자", pw, regiNum, description, takingMedicineList);
		}

	}

	// 환자 검색 기능
	public static Patient searchPatient(String name) {

		ArrayList<Patient> searchPatientList = new ArrayList<Patient>();
		int cnt = 1;

		// 동명이인 추출
		for (int i = 0; i < Patient.patientList.size(); i++) {
			if (Patient.patientList.get(i).getName().contains(name)) {
				searchPatientList.add(Patient.patientList.get(i));
				System.out.println((cnt++) + ". " + Patient.patientList.get(i).getName() + "("
						+ Patient.patientList.get(i).getRegiNum() + ")");
			}
		}

		// 환자 존재하지 않는 경우
		if (searchPatientList.isEmpty()) {
			System.out.println("[system] 해당하는 이름의 환자가 존재하지 않습니다.");
			return null;
		}

		System.out.print("[system] 환자 선택 : ");
		int pickPatient = Integer.parseInt(DataInput.sc.nextLine()) - 1;

		return searchPatientList.get(pickPatient);
	}

}
