package main;

import people.Doctor;
import people.Nurse;
import scanner.DataInput;

public class MainFunction {

	// 로그인 : 의사 1 반환 간호사 2 반환 그 외 -1 반환 
	public static int login() {
		System.out.println("**************LOGIN*************");
		System.out.print("ID : ");
		String id = DataInput.sc.nextLine();
		System.out.print("Password : ");
		String pw = DataInput.sc.nextLine();

		// 의사인 경우
		if (id.charAt(0) == 'd') {

			for (Doctor doctor : Doctor.doctorList) {

				// if : 아이디 존재 여부
				if (doctor.getId().equals(id)) {
					// if : 비밀번호 일치 여부
					if (doctor.getPw().equals(pw)) {
						System.out.println("[system] 로그인 성공 ");
						return 1;
					} else {
						System.out.println("[system] 비밀번호가 틀렸습니다. ");
						return -1; 
					}
				}
			}
		} else if (id.charAt(0)=='n') {   // 간호사인 경우 
			for (Nurse nurse : Nurse.nurseList) {
				
				// if : 아이디 존재 여부
				if (nurse.getId().equals(id)) {
					// if : 비밀번호 일치 여부
					if (nurse.getPw().equals(pw)) {
						System.out.println("[system] 로그인에 성공했습니다. ");
						return 2;
					} else {
						System.out.println("[system] 비밀번호가 틀렸습니다. ");
						return -1; 
					}
				}
			}
		} 

		System.out.println("[system] 아이디가 존재하지 않습니다.");

		return -1;
	}

	
	// 메뉴 출력 => 권한 분류
	public static void printMenu(int flag) {
		System.out.println("**************MENU*************");
		
		if (flag == 1) {
			System.out.println("[1] 스케쥴 관리");
			System.out.println("[2] 환자 관리");
			System.out.println("[3] 원무 처리");
		} else if (flag == 2) {
			System.out.println("[1] 스케쥴 관리");
			System.out.println("[2] 원무 처리");
		}
	}
	
	// 예약 메뉴 출력 
	public static void printDetailMenu(String menu) { 
		if(menu.equals("1")) {
			System.out.println("**********APPOINTMENT*********");
			System.out.println("[1] 진료예약 ");
			System.out.println("[2] 예약수정 ");
			System.out.println("[3] 예약취소 ");
			System.out.println("[4] 당일예약현황 ");
			System.out.println("[b] 이전으로 ");
		} else if (menu.equals("2")) {
			System.out.println("*************PATIENT***********");
			System.out.println("[1] 환자등록/조회 ");
			System.out.println("[2] 환자진단 ");
			System.out.println("[3] 환자진단내역조회 ");
			System.out.println("[4] 약 검색");
			System.out.println("[5] 병 검색 ");
			System.out.println("[b] 이전으로 ");
		} else if (menu.equals("3")) {
			System.out.println("********ADMINISTRATION********");
			System.out.println("[1] 진료비수납 ");
			System.out.println("[2] 관련서류출력 ");
			System.out.println("[b] 이전으로 ");
		}
	}
}
