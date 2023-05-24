package reception;

import java.util.ArrayList;

import people.Patient;
import people.PatientFunction;
import scanner.DataInput;

public class ReceptionManager {
	PatientFunction patientFunction;
	ArrayList<Patient> patientList;
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
		for(Patient patient : patientList) {
			cnt++;
			System.out.println(cnt + "." + patient.getName() + " " + patient.getRegiNum());
		}
		
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
		
	}
	
	public void printPaper() {
		System.out.print("환자 성명: ");
		String name = DataInput.sc.nextLine();
		Patient.getPatient(name);
		PatientFunction.searchPatient(name);
		
		
		
		
	}
}
