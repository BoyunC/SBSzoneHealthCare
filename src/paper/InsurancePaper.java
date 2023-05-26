package paper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import diagnosis.Diagnosis;
import disease.Disease;
import medicine.Medicine;
import people.Doctor;
import people.Patient;

public class InsurancePaper extends Paper {
	private Patient patient;
	private Doctor doctor;

	public static ArrayList<String> stringList = new ArrayList<String>();

	public static void setStringList(Diagnosis diagnosis) {
		stringList.add("===================================");
		stringList.add("			       보험서류	  		       ");
		stringList.add("\n");
		stringList.add("\t\t성명 : " + diagnosis.getExam().getAppointment().getPatient().getName());
		stringList.add("\t\t주민등록번호: " + diagnosis.getExam().getAppointment().getPatient().getRegiNum());
		String temp = "\t\t진단명: ";
		for (Disease disease : diagnosis.getExam().getHavingDiseaseList()) {
			if (disease == null) {
				temp += "병 없음";
				break;
			}
			temp += disease.getName() + " ";
		}
		stringList.add(temp);
		stringList.add("\t\t진단일: " + diagnosis.getExam().getDate());
		stringList.add("\t\t진단의: " + diagnosis.getExam().getAppointment().getDoctor().getName());
		String temp1 = "\t\t처방약 : ";
		for (Medicine medicine : diagnosis.getPrescription().getHavingMedicineList()) {
			if (medicine == null) {
				temp1 += "약 없음 ";
				break;
			}
			temp1 += medicine.getName() + " ";
		}
		stringList.add(temp1);
		stringList.add("\t위 사항이 사실임을 증명합니다.");
		stringList.add("\n");
		stringList.add("\n");
		stringList.add("===================================");
	}

	public static void printInsurancePaper(Diagnosis diagnosis) {
		for (String str : stringList) {
			System.out.println(str);
		}
	}

	public static void fileInsurancePaper(Diagnosis diagnosis) {
		String fileName = diagnosis.getExam().getAppointment().getPatient().getName() + "_보험서류.txt";

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
