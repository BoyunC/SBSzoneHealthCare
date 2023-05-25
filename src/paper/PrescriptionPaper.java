package paper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import diagnosis.Diagnosis;
import disease.Disease;
import medicine.Medicine;


public class PrescriptionPaper extends Paper {
	
	public ArrayList<String> stringList = new ArrayList<String>();
	
	public void setStringList(Diagnosis diagnosis) {
		stringList.add("===================================");
		stringList.add("			       처방전	  		       ");
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
		String temp1 = "\t\t처방약 : ";
		for(Medicine medicine : diagnosis.getPrescription().getHavingMedicineList()){
			if(medicine == null) {
				temp1 += "약 없음 ";
				break;
			}
			temp1 += medicine.getName() + " ";
		}
		stringList.add(temp1);
		stringList.add("\n");
		stringList.add("\n");
		stringList.add("===================================");
	}
	
	
	public void printPrescription() {
//		System.out.println("===================================");
//		System.out.println("			       처방전	  		       ");
//		System.out.println();
//		System.out.printf("\t\t성명 : %s", diagnosis.getExam().getAppointment().getPatient().getName());
//		System.out.printf("\t\t주민등록번호: %s", diagnosis.getExam().getAppointment().getPatient().getRegiNum());
//		System.out.print("\t\t진단명: ");
//		for(Disease disease : diagnosis.getExam().getHavingDiseaseList()) {
//			if(disease == null) {
//				System.out.println("병 없음");
//				break;
//			}
//			System.out.println(disease.getName() + " ");
//		}
//		System.out.printf("\t\t진단일: %s", diagnosis.getExam().getDate());
//		System.out.printf("\t\t진단의: %s", diagnosis.getExam().getAppointment().getDoctor().getName());
//		System.out.print("\t\t처방약 뭐로할거야");
//		for(Medicine medicine : diagnosis.getPrescription().getHavingMedicineList()){
//			if(medicine == null) {
//				System.out.println("약 없음");
//				break;
//			}
//			System.out.print(medicine.getName() + " ");
//		}
//				
//		System.out.println();
//		System.out.println();
//		System.out.println("===================================");
		
		for(String str : stringList) {
			System.out.println(str);
		}
		
		
	}
	
	public void filePrescription(Diagnosis diagnosis) {
		String fileName = diagnosis.getExam().getAppointment().getPatient().getName();
							
		try {
			FileWriter writer = new FileWriter(fileName);
			//String temp2 = null;
			for(String str : stringList) {
				writer.write(str);
				//temp2 += str + "\n";
			}
			//writer.write(temp2);						
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		
	}
	
}
