package disease;

import java.util.ArrayList;

import people.Doctor;
import scanner.DataInput;

public class DiseaseFunction {
	
	public static Disease searchDisease(String name) {
		
		ArrayList<Disease> searchDiseaseList = new ArrayList<Disease>();
		int cnt = 1;

		// 테스트 필요 
		for (int i = 0; i < Disease.diseaseList.size(); i++) {
			if (Disease.diseaseList.get(i).getName().contains(name)) {
				searchDiseaseList.add(Disease.diseaseList.get(i));
				System.out.println((cnt++) + ". " + Disease.diseaseList.get(i).getName() + "("
						+ Disease.diseaseList.get(i).getId() + ")");
			}
		}

		// 병이 존재하지 않는 경우
		if (searchDiseaseList.isEmpty()) {
			System.out.println("[system] 해당하는 병명이 존재하지 않습니다.");
			return null;
		}

		System.out.print("[system] 질병 선택 : ");
		int pickPatient = Integer.parseInt(DataInput.sc.nextLine()) - 1;

		return searchDiseaseList.get(pickPatient);

	}

}
