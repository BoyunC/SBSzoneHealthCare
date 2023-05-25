package diagnosis;

import java.util.Date;

import appointment.Appointment;
import disease.DiseaseFunction;
import scanner.DataInput;

public class ExamFunction {
	

	public static void examPatient(Exam exam) {
		System.out.println("--------------진단------------");
		System.out.print("[system] 자세한 증상 : ");
		exam.setDetailSymptom(DataInput.sc.nextLine());
		
		// 병 검색 메소드
		while (true) {
			System.out.print("[system] 병명 입력 : ");
			String nameDisease = DataInput.sc.nextLine();
			
			if (nameDisease.equals("Q") || nameDisease.equals("q"))
				break;
			
			exam.addHavingDiseaseList(DiseaseFunction.searchDisease(nameDisease));
		}

		// 의사 소견 : 선택사항 
		System.out.print("[system] 의사 소견을 입력하시겠습니까? [y/n]");
		
		if (DataInput.sc.nextLine().equals("Y") || DataInput.sc.nextLine().equals("y")) {
			System.out.print("[system] 의사 소견 : ");
			exam.setOpinion(DataInput.sc.nextLine());
		}

		exam.setDate(new Date());
	}
}
