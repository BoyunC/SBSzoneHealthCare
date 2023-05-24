package disease;

public class Disease {
	private String id;
	private String name;
	private String insuranceContent;
	private String classification;
	
	// Constructor
	public Disease() { }

	public Disease(String id, String name, String classification) {
		super();
		this.id = id;
		this.name = name;
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