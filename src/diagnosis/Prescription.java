package diagnosis;

import java.util.ArrayList;
import java.util.Date;

import appointment.Appointment;
import medicine.Medicine;
import medicine.MedicineFunction;
import scanner.DataInput;

public class Prescription {

	private Date date;

	private Appointment appointment;

	private ArrayList<Medicine> havingMedicineList = new ArrayList<>();

	// Constructor
	public Prescription() {
	}

	public Prescription(Appointment appointment) {
		super();
		this.appointment = appointment;

		System.out.println("---처방---");
		// 병 검색 메소드
		while (true) {
			System.out.print("약명 입력 : ");
			String nameMedicine = DataInput.sc.nextLine();
			if (nameMedicine.equals("Q") || nameMedicine.equals("q"))
				break;
			havingMedicineList.add(MedicineFunction.searchMedicine(nameMedicine));
		}

		date = new Date();
	}

	// Method
	public void printPrescription() {
		System.out.print("처방 약 : ");
		
		for(Medicine medicine : havingMedicineList) {
			System.out.print(medicine.getName() + "(" + medicine.getId() + ") ");
		}
	}

	
	// Getter & Setter
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public ArrayList<Medicine> getHavingMedicineList() {
		return havingMedicineList;
	}

	public void setHavingMedicineList(ArrayList<Medicine> havingMedicineList) {
		this.havingMedicineList = havingMedicineList;
	}
	
	//public void set

}
