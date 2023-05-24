package medicine;

import java.util.ArrayList;

public class Medicine {

	private String id;
	private String name;
	private String efficacy;
	private String insuranceContent;
	private String classification;

	// Constructor
	public Medicine() {
	}

	public Medicine(String id, String name, String efficacy, String classification) {
		super();
		this.id = id;
		this.name = name;
		this.efficacy = efficacy;
		this.classification = classification;
	}

	// Method

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
