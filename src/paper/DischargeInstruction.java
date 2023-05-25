package paper;

import diagnosis.Diagnosis;
import people.Doctor;
import people.Patient;

public class DischargeInstruction extends Paper {
	private Patient patient;
	private Doctor doctor;
	
	public void printDischargeInstruction(Diagnosis diagnosis) {
		System.out.println("===================================");
		System.out.println("			       진단서	  		       ");
		System.out.println();
		System.out.printf("\t\t성명 : %s", patient.getName());
		System.out.printf("\t\t주민등록번호: %s", patient.getRegiNum());
		System.out.printf("\t\t진단명: %s");
		System.out.printf("\t\t진단일: %s");
		System.out.printf("\t\t진단의: %s", doctor.getName());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("===================================");
	}
	
	public void fileDischargeInstruction() {
		
	}
}
