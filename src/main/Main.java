package main;

import java.util.Scanner;

import people.Doctor;
import people.Nurse;
import people.Patient;
import people.PatientFunction;
import scanner.DataInput;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		Scanner sc = new Scanner(System.in);

		System.out.println("********************************");
		System.out.println("*                                                        *");
		System.out.println("*               SBSzone Health Care          *");
		System.out.println("*                                                        *");

		new Doctor("신짱구", 50, "의사", "진료실1", "소아과", "11234");
		new Nurse("김철수", 55, "간호사", "1234", "12354");

		int flag = 0;
		while (true) {

			// 로그인
			if (flag <= 0) {
				flag = MainFunction.login();
				
				if (flag == -1)
					continue;
			}

			// 메뉴 출력
			MainFunction.printMenu(flag);

			detailMenuLoop: while (true) {
				// 메뉴 선택
				System.out.print("[system] 메뉴 선택(종료 Q) : ");
				String menu = DataInput.sc.nextLine();

				switch (menu) {
				case "1":
					MainFunction.printDetailMenu(menu);
					break;
				case "2":
					if (flag == 1)
						MainFunction.printDetailMenu(menu);
					else
						MainFunction.printDetailMenu(menu + 1);
					break;
				case "3":
					if (flag == 1)
						MainFunction.printDetailMenu(menu);
					else
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
