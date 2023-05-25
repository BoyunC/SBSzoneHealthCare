package diagnosis;

import appointment.Appointment;

public class DiagnosisFunction {
	
	public void diagnosisPatient(Appointment appointment) {
		
		Exam exam = new Exam(appointment);
		
		ExamFunction.examPatient(exam);
	}

}
