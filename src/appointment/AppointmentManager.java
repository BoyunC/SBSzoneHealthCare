package appointment;

import people.Patient;
import scanner.DataInput;

public class AppointmentManager {

	public static void main(String[] args) {
		
		int select = 0;
		
		System.out.println("=======================");
		System.out.println("=                     =");
		System.out.println("= SBSzone Health Care =");
		System.out.println("=                     =");
		System.out.println("=======================");
		
		
		
		while(true) {
			System.out.println("1. 예약 등록");
			System.out.println("2. 예약 수정");
			System.out.println("3. 예약 삭제");
			System.out.println("4. 당일 예약 현황");
			System.out.println("5. 이전으로");
			
			switch (select) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				return;
				
			}
		}
	}
	
	
//	//예약 등록
//	public Patient[] searchPatient() {
//		System.out.print("환자 성명 : ");
//		String name = DataInput.sc.nextLine();
//		
//	}
}
