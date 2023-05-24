package calendar;

import java.util.List;

public class Calendar {
	static List<Day> days;

	public Calendar() {}
	

	static public List<Day> getDays() {
		return days;
	}

	static public void setDays(List<Day> dayList) {
		days = dayList;
	}
}
