package main;

import java.util.Calendar;

import appointment.Appointment;
import disease.Disease;
import medicine.Medicine;
import people.Doctor;
import people.Patient;

// 임의 데이터 입력 
public class FakeData {
	public static Appointment appoint = new Appointment(Calendar.getInstance(), "10:00");
	public FakeData() {
		
		// 액터 (의사, 간호사, 환자)
		new Patient("신짱구", "환자", "940819-1234567", "복통, 설사", null);
		new Patient("김짱구", "환자", "930319-1234567", "기침", null);
		new Patient("이짱구", "환자", "921001-1234567", "간지러움", null);
		
		// 예약
		//Appointment appoint = new Appointment(Calendar.getInstance(), "10:00");
		appoint.setPatient(new Patient("신짱구", "환자", "001205-1234567", "두통, 감기", null));
		appoint.setDoctor(new Doctor("이슬이", 28, "의사", "진료실1", "내과", "1235a"));

		
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
