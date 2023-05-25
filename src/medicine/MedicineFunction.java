package medicine;

import java.util.ArrayList;

import scanner.DataInput;

public class MedicineFunction {
	
public static Medicine searchMedicine(String name) {
		
		ArrayList<Medicine> searchMedicineList = new ArrayList<Medicine>();
		int cnt = 1;

		// 테스트 필요 
		for (int i = 0; i < Medicine.medicineList.size(); i++) {
			if (Medicine.medicineList.get(i).getName().contains(name)) {
				searchMedicineList.add(Medicine.medicineList.get(i));
				System.out.println((cnt++) + ". " + Medicine.medicineList.get(i).getName() + "("
						+ Medicine.medicineList.get(i).getId() + ")");
			}
		}

		// 약이 존재하지 않는 경우
		if (searchMedicineList.isEmpty()) {
			System.out.println("[system] 해당하는 약이 존재하지 않습니다.");
			return null;
		}

		System.out.print("[system] 약 선택 : ");
		int pickPatient = Integer.parseInt(DataInput.sc.nextLine()) - 1;

		return searchMedicineList.get(pickPatient);

	}

}
