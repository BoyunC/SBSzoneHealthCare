package reception;

import java.util.ArrayList;

import calendar.Calendars;
import people.Patient;
import people.PatientFunction;
import scanner.DataInput;

public class ReceptionManager {
	PatientFunction patientFunction;
	ArrayList<Patient> patientList;
	Calendars calendars;
	int cnt = 0;
	
	public ReceptionManager() {
		patientList = new ArrayList<Patient>();
		
		// 임시 환자 데이터
		patientList.add(new Patient("신짱구", "환자", "940819", "환자ㅏ어저구저쩌구", null));
		patientList.add(new Patient("신짱구", "환자", "970717", "환자ㅏ어저구저쩌구", null));
		patientList.add(new Patient("신짱아", "환자", "930319", "환자ㅏ어저구저쩌구", null));
		patientList.add(new Patient("봉미선", "환자", "921218", "환자ㅏ어저구저쩌구", null));
		patientList.add(new Patient("흰둥이", "환자", "951201", "환자ㅏ어저구저쩌구", null));
		patientList.add(new Patient("신형만", "환자", "960105", "환자ㅏ어저구저쩌구", null));
		patientList.add(new Patient("김철수", "환자", "971201", "환자ㅏ어저구저쩌구", null));
		patientList.add(new Patient("김맹구", "환자", "981105", "환자ㅏ어저구저쩌구", null));
			

	}
	
	public void paymentFunction() {
		//당일 예약자 리스트 받아오기인데 일단은 임시 환자 데이터를 받아오겠습니다.
		
		
		
		
//		for(Patient patient : patientList) {
//			cnt++;
//			System.out.println(cnt + "." + patient.getName() + " " + patient.getRegiNum());
//		}
		
		System.out.print("수납할 환자: ");
		int pickPayment = Integer.parseInt(DataInput.sc.nextLine()) - 1;
		System.out.println("=========================================");
		System.out.println("이름: " + patientList.get(pickPayment).getName() + "\n주민등록번호: " + patientList.get(pickPayment).getRegiNum()
				+ "\n진단명: " + "\n수납금액: ");
		System.out.println("=========================================");
		System.out.println("1.현금 2.카드 ");
		System.out.print("수납방식: ");
		int payMethod = Integer.parseInt(DataInput.sc.nextLine());
		
		if(payMethod == 1) {
			System.out.println("현금으로 결제가 완료되었습니다.");
		}else {
			System.out.println("카드로 결제가 완료되었습니다.");
		}
		
		// queue 
		// 뺀걸 payment 리스트에 넣으려면 어떻게 해야 할까?
		
	}
	
	public void printPaper() {
		System.out.print("환자 성명: ");
		String name = DataInput.sc.nextLine();
		Patient patient = PatientFunction.searchPatient(name);
				
		System.out.println(patient.getName() + "(" + patient.getRegiNum() + ")" + " 환자 서류");
		System.out.println("1.진단서\n2.처방전\n3.보험서류");
		System.out.print("출력 선택: ");
		String paper = DataInput.sc.nextLine();
		
		switch (paper) {
		case "1":
			// 해당 환자의 진단내역 리스트 불러오고 그중 하나 선택해서 출력
			
			break;
		case "2":

			break;
		case "3":

			break;

		}
		
		
	}
}
