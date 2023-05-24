package calendar;

import scanner.DataInput;

public class CalendarManager {
	//1. 월 입력받아 달력 출력하기
	public static void main(String[] args) {
	
		
		System.out.println("=======================");
		System.out.println("=                     =");
		System.out.println("= SBSzone Health Care =");
		System.out.println("=                     =");
		System.out.println("=======================");
		
		System.out.print("예약 월 입력 : ");
		int selectMonth = Integer.parseInt(DataInput.sc.nextLine());
		
		Calendars calendar = new Calendars();
		calendar.setMonth(selectMonth);
		
		System.out.print("예약 일 입력 : ");
		int selectDate = Integer.parseInt(DataInput.sc.nextLine());
		
		//예약 현황 보여줘야 함. 인덱스, 시간, 예약자명 30분 단위로
		Calendars.days.get(selectDate - 1).makeAppointment();
		
	}

}
