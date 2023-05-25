package diagnosis;

import appointment.Appointment;

public class DiagnosisFunction {
	
	public static void diagnosisPatient(Appointment appointment) {
		
		Exam exam = new Exam(appointment);
		Prescription prescription = new Prescription(appointment);
		
		ExamFunction.examPatient(exam);
		PrescriptionFunction.prescriptMedicine(prescription);
		
		appointment.getPatient().diagnosisList.add(new Diagnosis(exam, prescription));
		
		System.out.println("[system] 환자 진단이 완료되었습니다. ");
		System.out.println("[system] 이전 화면으로 돌아갑니다.");

	public void diagnosisPatient(Appointment appointment) {
		
		Exam exam = new Exam(appointment);
		
		ExamFunction.examPatient(exam);
	}

}
