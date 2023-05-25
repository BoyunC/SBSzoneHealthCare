package main;

import appointment.Appointment;
import diagnosis.Diagnosis;
import calendar.CalendarManager;
import calendar.Calendars;
import diagnosis.DiagnosisFunction;
import disease.Disease;
import disease.DiseaseFunction;
import medicine.Medicine;
import medicine.MedicineFunction;
import people.Doctor;
import people.Nurse;
import people.Patient;

import people.PatientFunction;
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
		} else if (id.charAt(0) == 'n') { // 간호사인 경우
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

	// 상세 메뉴 출력
	public static String printDetailMenu(String menu) {
		if (menu.equals("1")) {
			System.out.println("**********APPOINTMENT*********");
			System.out.println("[1] 진료예약 ");
			System.out.println("[2] 예약수정 ");
			System.out.println("[3] 예약취소 ");
			System.out.println("[4] 당일예약현황 ");
			System.out.println("[b] 이전으로 ");
		} else if (menu.equals("2")) {
			System.out.println("*************PATIENT***********");
			System.out.println("[1] 환자등록 ");
			System.out.println("[2] 환자조회 ");
			System.out.println("[3] 환자진단 ");
			System.out.println("[4] 환자진단내역조회 ");
			System.out.println("[5] 약 검색");
			System.out.println("[6] 병 검색 ");
			System.out.println("[b] 이전으로 ");
		} else if (menu.equals("3")) {
			System.out.println("********ADMINISTRATION********");
			System.out.println("[1] 진료비수납 ");
			System.out.println("[2] 관련서류출력 ");
			System.out.println("[b] 이전으로 ");
		}

		System.out.print("[system] 메뉴 선택(종료 Q) : ");
		String detailMenu = DataInput.sc.nextLine();

		return detailMenu;
	}

	// 스케쥴 관리 메뉴 연결
	public static void menuAppointment(String menu) {
		switch (menu) {
		case "1":
			System.out.println("========진료 예약========");
			CalendarManager.start();

			break;
		case "2":
			System.out.println("========예약 수정========");
			
			break;
		case "3":
			System.out.println("========예약 취소========");

			break;
		case "4":
			System.out.println("======당일 예약 현황======");
			
			break;

		default:
			break;
		}
	}

	// 환자 관리 메뉴 연결
	public static void menuPatient(String menu) {
		switch (menu) {
		case "1":
			System.out.println("========환자 등록========");
			PatientFunction.registratePatient();
			System.out.println("[system] 이전 화면으로 돌아갑니다.");
			break;
		case "2":
			System.out.println("========환자 조회========");
			System.out.print("[system] 검색할 환자 명 : ");
			String name = DataInput.sc.nextLine();

			Patient patient = PatientFunction.searchPatient(name);
			if (patient != null) {
				patient.printPatient();
			}

			System.out.println("[system] 이전 화면으로 돌아갑니다.");
			break;
		case "3":
			System.out.println("========환자 진단========");

			// DiagnosisFunction.
			// 오늘 예약 리스트 받아와서 해당 예약 리스트 선택하는 기능 구현
			// 가짜 데이터
			DiagnosisFunction.diagnosisPatient(FakeData.appoint);
			break;
		case "4":
			System.out.println("========환자 진단 내역========");
			System.out.print("[system] 검색할 환자 명 : ");
			String nameP = DataInput.sc.nextLine();
			Patient patient4 = PatientFunction.searchPatient(nameP);
			if (patient4 == null) {
				break;
			}
			int cnt = 1;
			for (Diagnosis diagnosis : patient4.diagnosisList) {
				System.out.println("[" + (cnt++) + "] 번째 진단");
				diagnosis.getExam().printExam();
				diagnosis.getPrescription().printPrescription();
			}
			break;
		case "5":
			System.out.println("========약 검색========");
			System.out.print("[system] 검색할 약 명 : ");
			String nameM = DataInput.sc.nextLine();
			Medicine medicine = MedicineFunction.searchMedicine(nameM);
			medicine.printMedicine(medicine);
			break;
		case "6":
			System.out.println("========병 검색========");
			System.out.print("[system] 검색할 병 명 : ");
			String nameD = DataInput.sc.nextLine();
			Disease disease = DiseaseFunction.searchDisease(nameD);
			disease.printDisease(disease);
			break;
		default:
			break;
		}
	}

	// 원무 처리 메뉴 연결
	public static void menuAdministration(String menu) {
		switch (menu) {
		case "1":

			break;
		case "2":

			break;

		default:
			break;
		}

	}

}
