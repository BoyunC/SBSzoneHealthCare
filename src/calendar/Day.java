package calendar;

public class Day {
	private boolean isHoliday;
//	static Appointment[] appointments;
	
	
	public Day() {}
	
	public Day(boolean isHoliday) {
		super();
		this.isHoliday = isHoliday;
	}

	public boolean isHoliday() {
		return isHoliday;
	}

	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
}
