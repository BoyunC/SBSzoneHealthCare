package paper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import diagnosis.Diagnosis;
import disease.Disease;

public class DischargeInstruction extends Paper {
	
	public static ArrayList<String> stringList= new ArrayList<String>();
	
	public static void setStringListDI(Diagnosis diagnosis) {

		stringList.add("===================================");
		stringList.add("			       진단서	  		       ");
		stringList.add("\n");
		stringList.add("\t\t성명 : " + diagnosis.getExam().getAppointment().getPatient().getName());
		stringList.add("\t\t주민등록번호: " + diagnosis.getExam().getAppointment().getPatient().getRegiNum());
		String temp = "\t\t진단명: ";
		for(Disease disease : diagnosis.getExam().getHavingDiseaseList()) {
			if(disease == null) {
				temp += "병 없음";
				break;
			}
			temp += disease.getName() + " ";
		}
		stringList.add(temp);
		stringList.add("\t\t진단일: " + diagnosis.getExam().getDate());
		stringList.add("\t\t진단의: " + diagnosis.getExam().getAppointment().getDoctor().getName());
		stringList.add("\n");
		stringList.add("\n");
		stringList.add("===================================");

	}
	public static void printDischargeInstruction(Diagnosis diagnosis) {
//		System.out.println("===================================");
//		System.out.println("			       진단서	  		       ");
//		System.out.println();
//		System.out.printf("\t\t성명 : %s", diagnosis.getExam().getAppointment().getPatient().getName());
//		System.out.printf("\t\t주민등록번호: %s", diagnosis.getExam().getAppointment().getPatient().getRegiNum());
//		System.out.printf("\t\t진단명: %s", diagnosis.getExam().getHavingDiseaseList());
//		System.out.printf("\t\t진단일: %s", diagnosis.getExam().getDate());
//		System.out.printf("\t\t진단의: %s", diagnosis.getExam().getAppointment().getDoctor().getName());
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("===================================");
		
		for(String str : stringList) {
			System.out.println(str);
		}
		
	}
	
	public static void fileDischargeInstruction(Diagnosis diagnosis) {
		String fileName = diagnosis.getExam().getAppointment().getPatient().getName()+ "_진단서.txt";
		
		try {
			String temp2 = "";
			for (String str : stringList) {
				// writer.write(str);
				temp2 += str + "\n";
			}
			FileWriter writer = new FileWriter(fileName);
			writer.write(temp2);					
			writer.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
