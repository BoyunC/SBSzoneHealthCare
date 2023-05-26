package reception;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import appointment.Appointment;
import appointment.AppointmentManager;
import calendar.Calendars;
import calendar.Day;
import diagnosis.Diagnosis;
import disease.Disease;
import paper.DischargeInstruction;
import paper.Paper;
import paper.PrescriptionPaper;
import people.Patient;
import people.PatientFunction;
import scanner.DataInput;

public class ReceptionManager {
	ArrayList<Patient> patientList;
	PatientFunction patientFunction;
	Calendars calendars;
	Appointment[] todayAppointments;
	List<Appointment> todayAppointmentList;
	DischargeInstruction dci;
	PrescriptionPaper psp;
	int cnt = 0;

	public ReceptionManager() {
	}

	public void paymentFunction() {
		// 당일 예약자 리스트 받아오기

		// todayAppointments =
		// Calendars.days.get(Calendar.getInstance().get(Calendar.DATE)).getAppointments();
		// todayAppointments = Calendars.getAppointments();
		todayAppointmentList = AppointmentManager.getTodayAppointList();

		LinkedList<Appointment> list = new LinkedList<Appointment>();

		for (Appointment a : todayAppointmentList) {
			cnt++;
			list.add(a);
			System.out.println("[" + cnt + "] " + a.getPatient().getName() + "(" + a.getPatient().getRegiNum() + ")");
		}

		System.out.print("수납할 환자: ");
		int pickPayment = Integer.parseInt(DataInput.sc.nextLine()) - 1;

		// 수납환자 빼기
		// Patient patient = list.poll().getPatient();
		Patient patient = list.get(pickPayment).getPatient();

		System.out.println("=========================================");
		System.out.println("이름: " + patient.getName() + "\n주민등록번호: " + patient.getRegiNum());
		System.out.print("진단명 : ");
		for (Disease disease : patient.diagnosisList.get(patient.diagnosisList.size() - 1).getExam()
				.getHavingDiseaseList()) {
			System.out.print(disease.getName() + " ");
		}
		System.out.println();
		System.out.println("수납금액 : " + patient.diagnosisList.get(patient.diagnosisList.size() - 1).getCharge());

		System.out.println("=========================================");
		System.out.println("1.현금 2.카드 ");
		System.out.print("수납방식: ");
		int payMethod = Integer.parseInt(DataInput.sc.nextLine());

		if (payMethod == 1) {
			System.out.println("현금으로 결제가 완료되었습니다.");
		} else {
			System.out.println("카드로 결제가 완료되었습니다.");
		}

		// patient.paymentList.add(new Payment(5000, new Date(), "카드"));

		// Payment payment = new Payment(5000, new Date(), "카드");
		// patient.paymentList.add(payment);
		if (patient.diagnosisList.size() != 0) {
			patient.paymentList.add(new Payment(patient.diagnosisList.get(patient.diagnosisList.size() - 1).getCharge(),
					new Date(), "카드"));
		} else {
			System.out.println("이 환자는 아직 진료를 완료하지 않았습니다.");
		}

		for (Payment payment2 : patient.paymentList) {
			if (payment2 == null) {
				System.out.println("이 환자는 아직 수납내역이 없습니다.");
			}
			System.out.println(payment2.getTotal());
		}

	}

	public void printPaymentList() {
		System.out.print("환자 성명: ");
		String name = DataInput.sc.nextLine();
		Patient patient = PatientFunction.searchPatient(name);

		for (Payment payment : patient.paymentList) {
			if (payment != null) {
				System.out.println("날짜 : " + payment.getDate());
				System.out.println("금액 : " + payment.getTotal());
			}
		}
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
			for (int i = 0; i < patient.diagnosisList.size(); i++) {
				cnt++;
				System.out.println(cnt + "." + patient.diagnosisList.get(i).getDate());
			}
			System.out.print("출력 진단 내역 선택: ");
			int pickprintPaper = Integer.parseInt(DataInput.sc.nextLine()) - 1;

			if (patient.diagnosisList.get(pickprintPaper).getExam().getOpinion() == null) {
				System.out.println("[system] 의사의 소견이 입력되지 않아 출력이 진단서 출력이 불가능합니다. ");
				// 추가 기능 : 의사 소견 입력 기능
			} else {

				
				if (patient.diagnosisList.get(pickprintPaper) != null) {
					DischargeInstruction.setStringListDI(patient.diagnosisList.get(pickprintPaper));
					DischargeInstruction.printDischargeInstruction(patient.diagnosisList.get(pickprintPaper));
					DischargeInstruction.fileDischargeInstruction(patient.diagnosisList.get(pickprintPaper));
				}
			}

			break;
		case "2":
			// 처방전
			for (int i = 0; i < patient.diagnosisList.size(); i++) {
				cnt++;
				System.out.println(cnt + "." + patient.diagnosisList.get(i).getPrescription());
			}
			System.out.print("출력 진단 내역 선택: ");
			int pickPrescription = Integer.parseInt(DataInput.sc.nextLine()) - 1;
			
			if (patient.diagnosisList.get(pickPrescription) == null) {
				System.out.println("[system] 진료가 진행되지 않아 처방전 출력이 불가능합니다. ");
				// 추가 기능 : 의사 소견 입력 기능
			} else {
				PrescriptionPaper.setStringList(patient.diagnosisList.get(pickPrescription));
				PrescriptionPaper.printPrescription();
				PrescriptionPaper.filePrescription(patient.diagnosisList.get(pickPrescription));
			}
			break;
		case "3":
			// 보험서류
			for (int i = 0; i < patient.diagnosisList.size(); i++) {
				cnt++;
				System.out.println(cnt + "." + patient.diagnosisList.get(i));
			}
			System.out.print("출력 진단 내역 선택: ");
			int pickInsurance = Integer.parseInt(DataInput.sc.nextLine()) - 1;
			
			if (patient.diagnosisList.get(pickInsurance) == null) {
				System.out.println("[system] 진료가 진행되지 않아 보험서류 출력이 불가능합니다. ");
				// 추가 기능 : 의사 소견 입력 기능
			} else {
				PrescriptionPaper.setStringList(patient.diagnosisList.get(pickInsurance));
				PrescriptionPaper.printPrescription();
				PrescriptionPaper.filePrescription(patient.diagnosisList.get(pickInsurance));
			}

			break;

		}

	}
}
