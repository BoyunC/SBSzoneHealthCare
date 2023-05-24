package calendar;

import java.util.Calendar;

import appointment.Appointment;
import scanner.DataInput;

public class Day {
	private int month;
	private int date;
	private int weekday;
	private boolean isHoliday;
	static Appointment[] appointments;
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
		int i = 0;
		System.out.println(date + "일 예약 현황 : ");
		System.out.println();
		for(int j = 0 ; j < time.length / 2 ; j++) {
			for(int k = 0 ; k < 2 ; k++) { 
				String txt = "[" + (i+1) + "]" + time[i++] + ": ";
				if(appointments[i].getPatient() != null) //여기에 getpatient.getname
				System.out.print(txt + "\t");
			}
			System.out.println();
		}
		System.out.print("예약 시간 입력 : ");
		int selectTime = Integer.parseInt(DataInput.sc.nextLine()); 
		
		
	}
	
	public boolean isHoliday() {
		return isHoliday;
	}

	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
}
