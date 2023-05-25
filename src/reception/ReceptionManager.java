package reception;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import appointment.Appointment;
import calendar.Calendars;
import calendar.Day;
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
	DischargeInstruction dci;
	PrescriptionPaper psp;
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
		//당일 예약자 리스트 받아오기
		todayAppointments = Calendars.days.get(Calendar.getInstance().get(Calendar.DATE)).getAppointments();
//		todayAppointments = Calendars.getAppointments();
		LinkedList<Appointment> list = new LinkedList<Appointment>();
		for(Appointment a : todayAppointments) {
			cnt++;
			list.add(a);
			System.out.println(cnt + "." + a.getPatient().getName() + "(" + a.getPatient().getRegiNum() + ")");
		}
		
		
		System.out.print("수납할 환자: ");
		int pickPayment = Integer.parseInt(DataInput.sc.nextLine()) - 1;
		System.out.println("=========================================");
		System.out.println("이름: " + list.get(pickPayment).getPatient().getName() + "\n주민등록번호: " + list.get(pickPayment).getPatient().getRegiNum()
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
		
		// 수납환자  빼기
		Patient patient = list.poll().getPatient();

		//patient.paymentList.add(new Payment(5000, new Date(), "카드"));
		patient.paymentList.add(new Payment(patient.diagnosisList.get(patient.diagnosisList.size()-1).getCharge(), new Date(), "카드"));
		
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
			for(int i=0;i<patient.diagnosisList.size();i++) {
				cnt++;
				System.out.println(cnt + "." + patient.diagnosisList.get(i));
			}
			System.out.print("출력 진단 내역 선택: ");
			int pickprintPaper = Integer.parseInt(DataInput.sc.nextLine()) - 1;
			dci.setStringListDI(patient.diagnosisList.get(pickprintPaper));
			dci.printDischargeInstruction(patient.diagnosisList.get(pickprintPaper));
			dci.fileDischargeInstruction(patient.diagnosisList.get(pickprintPaper));
			break;
		case "2":
			// 처방전
			for(int i=0;i<patient.diagnosisList.size();i++) {
				cnt++;
				System.out.println(cnt + "." + patient.diagnosisList.get(i).getPrescription());
			}
			System.out.print("출력 진단 내역 선택: ");
			int pickPrescription = Integer.parseInt(DataInput.sc.nextLine()) - 1;
			psp.setStringList(patient.diagnosisList.get(pickPrescription));
			//psp.printPrescription(patient.diagnosisList.get(pickPrescription));
			break;
		case "3":
			// 보험서류
			for(int i=0;i<patient.diagnosisList.size();i++) {
				cnt++;
				System.out.println(cnt + "." + patient.diagnosisList.get(i));
			}
			
			break;

		}
		
		
	}
}
