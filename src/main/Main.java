package main;

import java.util.Scanner;

import people.Doctor;
import people.Nurse;
import people.Patient;
import people.PatientFunction;
import scanner.DataInput;

public class Main {

	public static void main(String[] args) {
		new FakeData();
		Scanner sc = new Scanner(System.in);

		System.out.println("********************************");
		System.out.println("*                                                        *");
		System.out.println("*               SBSzone Health Care          *");
		System.out.println("*                                                        *");

		new Doctor("신짱구", 50, "의사", "진료실1", "소아과", "11234"); // id:dr_0001 pw:0000
		new Nurse("김철수", 55, "간호사", "1234", "12354"); // id:nu_0001 pw:1234

		int flag = 0;
		while (true) {

			// 로그인
			if (flag <= 0) {
				flag = MainFunction.login();

				if (flag == -1)
					continue;
			}
			System.out.println("here");
			// 메뉴 출력
			MainFunction.printMenu(flag);

			String menu = null;
			detailMenuLoop: 
			while (true) {
				// 상세 메뉴 선택
				if (menu == null) {
					System.out.print("[system] 메뉴 선택(종료 Q) : ");
					menu = DataInput.sc.nextLine();
				}

				String detailMenu;
				switch (menu) {
				case "1":
					detailMenu = MainFunction.printDetailMenu(menu);
					MainFunction.menuAppointment(detailMenu);
					break;

				case "2":
					if (flag == 1) {
						detailMenu = MainFunction.printDetailMenu(menu);
						MainFunction.menuPatient(detailMenu);
					} // 권한 구분(간호사 접근 불가)
					else {
						detailMenu = MainFunction.printDetailMenu(menu + 1);
						MainFunction.menuAdministration(detailMenu);
					}
					break;

				case "3":
					if (flag == 1) {
						detailMenu = MainFunction.printDetailMenu(menu);
						MainFunction.menuAdministration(detailMenu);
					} else
						System.out.println("[system] 해당 메뉴가 존재하지 않습니다.");
					break;

				case "b":
				case "B":
					System.out.println("[system] 이전 화면으로 돌아갑니다. ");
					break detailMenuLoop;

				case "Q":
				case "q":
					System.out.println("[system] 프로그램이 종료됩니다. ");
					// 전체 프로그램 종료할지 확인
					break detailMenuLoop;


				default:
					System.out.println("[system] 해당 메뉴가 존재하지 않습니다.");
					break;
				}
			}
		}
	}

}
