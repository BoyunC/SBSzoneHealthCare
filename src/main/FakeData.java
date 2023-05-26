package main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import appointment.Appointment;
import calendar.Calendars;
import calendar.Day;
import disease.Disease;
import medicine.Medicine;
import people.Doctor;
import people.Nurse;
import people.Patient;

// 임의 데이터 입력 
public class FakeData {
	public static Appointment appoint = new Appointment(Calendar.getInstance(), "10:00");
	public FakeData() {
		
		// 액터 (의사, 간호사, 환자)
		
		// 의사
		Doctor d1 = new Doctor("김영희", 30, "의사", "진료실1", "소아과", "a1774152d21");				//dr_0001, 0000
		Doctor d2 = new Doctor("이수영", 50, "의사", "1234", "진료실2",  "내과",  "a1157114d18");	//dr_0002, 1234
		new Doctor("박혜성", 45, "의사", "진료실3", "이비인후과", "a1247152d84");			//dr_0003, 0000
		new Doctor("김수영", 47, "의사", "진료실4", "피부과", "a1734524d14");
		new Doctor("서강준", 32, "의사", "진료실5", "안과", "a1652152d81");
		
		// 간호사 
		new Nurse("김철수", 30, "간호사",  "c654412s1");				//nu_0001, 0000
		new Nurse("신짱구", 50, "간호사", "1234",  "c21234s1");		//nu_0002, 1234
		new Nurse("이유리", 45, "간호사",  "c23f23s1");					//nu_0003, 0000
		new Nurse("이훈이", 47, "간호사",  "c234234s1");
		new Nurse("맹구", 32, "간호사",  "c005164s1");
		
		// 환자 
		Patient p1 = new Patient("이선빈", "환자", "940819-1234567", "복통, 설사", null);
		Patient p2 =new Patient("강지영", "환자", "930319-1234567", "기침", null);
		Patient p3 =new Patient("진세연", "환자", "921001-1234567", "간지러움", null);
		new Patient("박선빈", "환자", "971021-1234567", "간지러움", null);
		new Patient("오세연", "환자", "980525-1234567", "간지러움", null);
		new Patient("강세연", "환자", "930423-1234567", "간지러움", null);
		
		// 예약
		//Appointment appoint = new Appointment(Calendar.getInstance(), "10:00");
		appoint.setPatient(new Patient("신짱구", "환자", "001205-1234567", "두통, 감기", null));
		appoint.setDoctor(new Doctor("이슬이", 28, "의사", "진료실1", "내과", "1235a"));
		
		
//		Calendar cal = new GregorianCalendar();
//		cal = Calendar.getInstance();
//		System.out.println(cal);
//		
//		new Appointment(cal, "9:00");
//		new Appointment(cal, "10:00");
//		new Appointment(cal, "11:30");
//		
//		// 오늘 days 객체 하나 생성
//		Day day = new Day(4, 26);
//		
//		Appointment[] appointments = {
//				new Appointment(cal, "9:00", "기침", d1, p1), null, new Appointment(cal, "10:00", "재채기, 콧물", d1, p2), null,
//				null, new Appointment(cal, "11:30", "열감, 두통", d2, p3), null , null,
//				null, null, null, null,
//				null, null, null, null
//		};
//		
//		day.setAppointments(appointments);
//		
//		Calendars.days.add(day);

		
		// 약 
		new Medicine("m_0001", "타이레놀", "두통, 해열, 진통", "m-a");
		new Medicine("m_0002", "타이레놀이알서방정", "두통, 해열, 극심한 진통", "m-a1");
		new Medicine("m_0003", "타이레놀콜드", "두통, 해열, 진통, 감기, 콧물", "m-a2");
		new Medicine("m_0004", "타이레놀우먼", "두통, 해열, 진통, 생리통", "m-a3");
		new Medicine("m_0005", "타이레놀키즈", "두통, 해열, 진통", "m-a4");

	
		// 병
		new Disease("d_0001", "독감", "d-a01");
		new Disease("d_0002", "감기", "d-a01");
		new Disease("d_0003", "몸살감기", "d-a01");
		new Disease("d_0004", "폐렴", "d-a01");
		new Disease("d_0005", "약한감기", "d-a01");

	}
	
	
}
