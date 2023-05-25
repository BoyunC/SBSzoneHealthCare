package appointment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import calendar.Calendars;
import people.Doctor;
import people.DoctorFunction;
import people.Patient;
import people.PatientFunction;
import scanner.DataInput;

public class AppointmentManager {
	public static void updateAppointment() {
		System.out.print("환자 성명 : ");
		String name = DataInput.sc.nextLine();
		Patient tempPatient = PatientFunction.searchPatient(name);
		
		List<Appointment> tempList = tempPatient.getAppointmentList();
		showAppointmentList(tempList);
		System.out.print("변경할 예약 선택 : ");
		int selectAppoint = Integer.parseInt(DataInput.sc.nextLine()) -1;
		
		//예약을 받아와서 수정을 해야하는데 바꿀게 날짜, 시간
		Appointment tempAppoint = tempList.get(selectAppoint);
		//기존 날짜
		int date = tempAppoint.getDate().get(Calendar.DATE);
		
		Calendars.getCalendar();
		System.out.print("변경할 날짜 선택 :");
		int newDate = Integer.parseInt(DataInput.sc.nextLine()) - 1;
		
		Calendars.days.get(newDate).showAppointments();
		System.out.print("변경할 시간 선택 : ");
		int selectAppoint2 = Integer.parseInt(DataInput.sc.nextLine()) - 1;
		Appointment newAppoint = Calendars.days.get(newDate).getAppointments()[selectAppoint2];
		
		newAppoint.setPatient(tempAppoint.getPatient());
		newAppoint.setDoctor(tempAppoint.getDoctor());
		newAppoint.setSymtom(tempAppoint.getSymtom());
		
		tempPatient.appointmentList.remove(selectAppoint);
		tempPatient.appointmentList.add(newAppoint);
		
		tempAppoint.setDoctor(null);
		tempAppoint.setPatient(null);
		tempAppoint.setSymtom(null);
		
		System.out.println("예약 변경 완료");
		System.out.println(newAppoint.getDate().get(Calendar.DATE) + "일 " + newAppoint.getTime());
		
	}
	
	public static void cancelAppointment() {
		System.out.print("환자 성명 : ");
		String name = DataInput.sc.nextLine();
		Patient tempPatient = PatientFunction.searchPatient(name);
		
		List<Appointment> tempList = tempPatient.getAppointmentList();
		showAppointmentList(tempList);
		System.out.print("취소할 예약 선택 : ");
		int selectAppoint = Integer.parseInt(DataInput.sc.nextLine()) -1;
		
		Appointment tempAppoint = tempList.get(selectAppoint);
		
		int date = tempAppoint.getDate().get(Calendar.DATE);

		for(Appointment a : Calendars.days.get(date).getAppointments()) {
			if(tempAppoint.getTime().equals(a.getTime())) {
				tempAppoint.setDoctor(null);
				tempAppoint.setPatient(null);
				tempAppoint.setSymtom(null);
			}
		}
		tempList.remove(selectAppoint);
		System.out.println("예약 취소 완료");
	}
	
	public static void showAppointmentList(List<Appointment> list) {
		int i = 1;
		for(Appointment a : list) {
			System.out.println("[" + i++ + "]" 
					+ a.getDate().get(Calendar.MONTH) + "월 "
					+ a.getDate().get(Calendar.DATE) + "일 "
					+ a.getTime()
					);
		}
	}
	
	public static void showTodayAppointList() { 
		int i = 1;
		System.out.println(Calendar.getInstance().get(Calendar.DATE));
		for(Appointment a : Calendars.days.get(Calendar.getInstance().get(Calendar.DATE) - 1).getAppointments()) {
			if(a.getPatient() != null) {
				System.out.println("[" + i++ + "]" 
						+ a.getTime() + " "
						+ a.getPatient().getName() + " 님"
						);
			}
		}
	}
}


