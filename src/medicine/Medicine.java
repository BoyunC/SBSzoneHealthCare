package medicine;

import java.util.ArrayList;

import disease.Disease;

public class Medicine {

	private String id;
	private String name;
	private String efficacy;
	private String insuranceContent;
	private String classification;

	public static ArrayList<Medicine> medicineList = new ArrayList<>();

	// Constructor
	public Medicine() {
	}

	public Medicine(String id, String name, String efficacy, String classification) {
		super();
		this.id = id;
		this.name = name;
		this.efficacy = efficacy;
		this.classification = classification;

		medicineList.add(this);
	}

	// Method
	public void printMedicine(Medicine medicine) {

		System.out.println("약명 : " + medicine.getName());
		System.out.println("아이디 : " + medicine.getId());
		System.out.println("효능 : " + medicine.getEfficacy());
		System.out.println("분류 : " + medicine.getClassification());
		if (medicine.getInsuranceContent() != null) {
			System.out.println("보험 내용 : " + medicine.getInsuranceContent());
		}
	}

	// Getter & Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEfficacy() {
		return efficacy;
	}

	public void setEfficacy(String efficacy) {
		this.efficacy = efficacy;
	}

	public String getInsuranceContent() {
		return insuranceContent;
	}

	public void setInsuranceContent(String insuranceContent) {
		this.insuranceContent = insuranceContent;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}
