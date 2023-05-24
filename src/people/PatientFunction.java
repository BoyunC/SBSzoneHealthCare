package people;

import java.util.ArrayList;
import java.util.Scanner;

public class PatientFunction {
	
	Patient patient;

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
		Scanner sc = new Scanner(System.in);
		int pickPatient = Integer.parseInt(sc.nextLine()) - 1;
		
		return searchPatientList.get(pickPatient);
	}


}
