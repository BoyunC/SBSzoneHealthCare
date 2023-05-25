package diagnosis;

import java.util.Date;

import medicine.MedicineFunction;
import scanner.DataInput;

public class PrescriptionFunction {
	
	public static void prescriptMedicine (Prescription prescription) {
		System.out.println("--------------처방------------");
		
		// 병 검색 메소드
		while (true) {
			System.out.print("약명 입력 : ");
			String nameMedicine = DataInput.sc.nextLine();
			if (nameMedicine.equals("Q") || nameMedicine.equals("q"))
				break;
			prescription.havingMedicineList.add(MedicineFunction.searchMedicine(nameMedicine));
		}

		date = new Date();
	}

}
