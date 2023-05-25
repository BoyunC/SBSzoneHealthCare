package paper;

import diagnosis.Diagnosis;

public class PaperMain {

	public static void main(String[] args) {
		PrescriptionPaper pp = new PrescriptionPaper();
		Diagnosis dd = new Diagnosis();
		
		pp.setStringList(dd);
		pp.printPrescription();
		

	}

}
