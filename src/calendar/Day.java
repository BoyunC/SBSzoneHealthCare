package calendar;

import java.util.ArrayList;
import java.util.Calendar;

import appointment.Appointment;
import people.Doctor;
import people.DoctorFunction;
import people.Patient;
import people.PatientFunction;
import scanner.DataInput;

public class Day {
	private int month;
	private int date;
	private int weekday;
	
	private boolean isHoliday;
	private String reason;
	
	Appointment[] appointments;

	static String[] time = new String[] {
		"09:00", "09:30", "10:00", "10:30", 
		"11:00", "11:30", "13:00", "13:30", 
		"14:00", "14:30", "15:00", "15:30", 
		"16:00", "16:30", "17:00", "17:30", 
	};
	
	public Day() {}
	
	public Day(int month, int date, int weekday, boolean isHoliday) {
		super();
		this.month = month;
		this.date = date;
		this.weekday = weekday;
		this.isHoliday = isHoliday;
		setAppointment();
	}
	
	public void cancelAppointment() {
		System.out.print("환자 성명 : ");
		String name = DataInput.sc.nextLine();
		Patient tempPatient = Patient.getPatient(name);
		Appointment tempAppointment = searchAppointment(tempPatient);
		
		tempAppointment.setDoctor(null);
		tempAppointment.setPatient(null);
		tempAppointment.setSymtom(null);
		System.out.println("예약 취소가 완료되었습니다.");
	}
	
	public void updateAppointment() {
		//지금 구조는 같은 날짜 안에서만 수정이 가능함.
		//근데 날짜를 바꿔줘야 하니까 상위에서 환자 정보 -> 예약내역 조회 -> 수정할 예약 선택 ->
		//기존 예약 / 변경할 예약 선택해서 기존 삭제 -> 새로 예약 등록?
		String name = DataInput.sc.nextLine();
		
	}

	public void showAppointments() { 
		int i = 0;
		System.out.println(date + "일 예약 현황 : ");
		System.out.println();
		for(int j = 0 ; j < time.length / 2 ; j++) {
			for(int k = 0 ; k < 2 ; k++) { 
				String txt = "[" + (i+1) + "]" + time[i] + ": ";
				if(appointments[i].getPatient() != null) {
					txt += appointments[i].getPatient().getName(); 
				} else {
					txt += "\t";
				}
				i++;
				System.out.print(txt + "\t");
			}
			System.out.println();
		}
	}
	public void setAppointment() {
		Calendar gc = Calendar.getInstance();
		gc.set(Calendar.MONTH, this.month -1);
		gc.set(Calendar.DATE, this.date);
		
		appointments = new Appointment[16];
		for(int i = 0 ; i < appointments.length ; i++) {
			appointments[i] = new Appointment(gc, time[i]);
		}
	}
	
	public void makeAppointment() {
		showAppointments();
		
		System.out.print("예약 시간 입력 : ");
		int selectTime = Integer.parseInt(DataInput.sc.nextLine()); 
		
		//환자 정보 입력
		//만약에 환자가 존재하지 않으면 환자 등록으로? 
		System.out.print("환자 이름 입력 : ");
		String name = DataInput.sc.nextLine();
		Patient tempPatient = PatientFunction.searchPatient(name);
		if(tempPatient == null) {
			PatientFunction.registratePatient();
			tempPatient = PatientFunction.searchPatient(name);
		}
		appointments[selectTime - 1].setPatient(tempPatient);
		
		//증상 입력
		System.out.print("증상 입력 : ");
		String symtom = DataInput.sc.nextLine();
		appointments[selectTime - 1].setSymtom(symtom);
		
		//의사 정보 입력
		System.out.println("담당 의사 선택 : ");
		name = DataInput.sc.nextLine();
		Doctor tempDoctor = DoctorFunction.searchDoctor(name);
		if(tempDoctor == null) {
			DoctorFunction.registrateDoctor();
			tempDoctor = DoctorFunction.searchDoctor(name);
		}
		appointments[selectTime - 1].setDoctor(tempDoctor);
		System.out.println("ddd");
		//환자 예약 내역에 예약 추가
	
		tempPatient.getAppointmentList().add(appointments[selectTime - 1]);
		//예약 내역 출력
		System.out.println("예약 완료 : ");
		System.out.println(month + "월 " + date + "일 " + appointments[selectTime - 1].getTime());
		System.out.println("환자 : " + appointments[selectTime-1].getPatient().getName()
				+ " " + appointments[selectTime-1].getPatient().getRegiNum());
				
		}
	
	public Appointment searchAppointment(Patient p) {
		//만약에 월별 리스트를 안만들거면 요일 입력받아서 시간 보여주고 선택할 수 있게?
		//아니면 요일 -> 환자 이름 검색 -> 해당 내역 찾아서 리턴 -> 수정/삭제
		ArrayList<Appointment> searchAppointmentList = new ArrayList<Appointment>();
		int cnt = 1;
		
		for(int i = 0 ; i < appointments.length ; i++) {
			if(appointments[i].getPatient().getName().equals(p.getName())) {
				searchAppointmentList.add(appointments[i]);
				System.out.println("[" + (cnt++) + "] " 
						+ appointments[i].getDate().get(Calendar.MONTH) + "월 "
						+ appointments[i].getDate().get(Calendar.DATE) + "일 "
						+ appointments[i].getTime());
			}
		}
		System.out.print("수정 또는 취소할 예약 번호 입력 : ");
		int selectAppointment = Integer.parseInt(DataInput.sc.nextLine());
		
		return appointments[selectAppointment - 1];
	}
	
	public boolean isHoliday() {
		return isHoliday;
	}

	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	
	public Appointment[] getAppointments() {
		return appointments;
	}

	public void setAppointments(Appointment[] appointments) {
		this.appointments = appointments;
	}
	
	
}
