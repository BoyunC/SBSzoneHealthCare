package calendar;

import java.util.ArrayList;
import java.util.Calendar;

import appointment.Appointment;
import people.Patient;
import scanner.DataInput;

public class Day {
	private int month;
	private int date;
	private int weekday;
	private boolean isHoliday;
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
	
	public void getAppointments() { 
		int i = 0;
		System.out.println(date + "일 예약 현황 : ");
		System.out.println();
		for(int j = 0 ; j < time.length / 2 ; j++) {
			for(int k = 0 ; k < 2 ; k++) { 
				String txt = "[" + (i+1) + "]" + time[i] + ": ";
				if(appointments[i++].getPatient() != null) {
					txt += appointments[i].getPatient().getName(); 
				} else {
					txt += "\t";
				}
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
		getAppointments();
		
		System.out.print("예약 시간 입력 : ");
		int selectTime = Integer.parseInt(DataInput.sc.nextLine()); 
		//의사정보, 환자 정보, 증상
		
		System.out.print("증상 입력 : ");
		String symtom = DataInput.sc.nextLine();
		appointments[selectTime - 1].setSymtom(symtom);
		System.out.println("예약 완료 : " + appointments[selectTime -1].getSymtom());
	}
	
	public Appointment searchAppointment(Patient p) {
		//만약에 월별 리스트를 만들거면 
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
}
