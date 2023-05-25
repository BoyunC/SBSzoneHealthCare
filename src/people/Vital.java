package people;

import java.util.Date;

public class Vital {
	private double temperature;
	private double weight;
	private double height;
	private String bloodPressure;
	private String bloodSuger;
	private Date date;

	// Constructor
	public Vital() {
	}

	public Vital(double temperature, double weight, double height, String bloodPressure, String bloodSuger) {
		super();
		this.temperature = temperature;
		this.weight = weight;
		this.height = height;
		this.bloodPressure = bloodPressure;
		this.bloodSuger = bloodSuger;
		this.date = new Date();
	}

	// Method

	// Getter & Setter
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBloodSuger() {
		return bloodSuger;
	}

	public void setBloodSuger(String bloodSuger) {
		this.bloodSuger = bloodSuger;
	}

}
