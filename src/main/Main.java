package main;

import java.util.Scanner;

import people.Patient;
import people.PatientFunction;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		Scanner sc = new Scanner(System.in);
		
//		// 임시 환자 데이터
//		new Patient("신짱구", "환자", "940819");
//		new Patient("신짱구", "환자", "930319");
//		new Patient("김철수", "환자", "921218");
//		new Patient("신짱구", "환자", "951201");
//		new Patient("신짱구", "환자", "960105");
//		new Patient("김철수", "환자", "971201");
//		new Patient("김철수", "환자", "981105");
		
		
		
		// 환자 검색 기능 사용 방법 
		System.out.print("검색할 이름 입력 : ");
		String name = sc.nextLine();
		
		Patient patient = PatientFunction.searchPatient(name);
		
		patient.printPatient();
	}
}
