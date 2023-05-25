package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import appointment.Appointment;
import scanner.DataInput;

public class Calendars {
	static List<Day> days;
	
	public Calendars() {
		days = new ArrayList<Day>();
		
		// 여기서 반복문 이용해서 12
	}
	
	public void setMonth(int month) {
		
		System.out.println(month); //입력받은 월 토대로 달력 세팅
		Calendar gc = Calendar.getInstance(); 
		gc.set(Calendar.MONTH, month-1);
		gc.set(Calendar.DATE, 1);
		
		System.out.println(gc.getTime());
		
		int start = gc.get(Calendar.DAY_OF_WEEK) -1; //1일 요일 구하는 기준점
		int start2 = start; //요일 전체 구하는 인덱스
		
		int n = gc.getActualMaximum(Calendar.DATE); //한달에 며칠 있는 지 
		int end = start + n;
		char[] week = {'일','월','화','수','목','금','토'};
		int[][] monthArr = new int[n/7+2][7];
		
		for(int i =0 ; i < week.length ; i++) {  //요일 출력
			System.out.printf("%c\t", week[i]);
		}
		System.out.println();
		
		int day = 1;
		boolean isHoliday = false;

		for(int i = 0 ; i <= n / 7 + 1 ; i++) {
			for(int j = 0 ; j < 7 ; j++) {
				if(start2 >= end) break; 
				if(i == 0 && j < start) {
					monthArr[i][j] = 0;
					continue;
				}
				monthArr[i][start2++%7] = day++;
			}
		}
		
		start2 = start; //Day 리스트에 요일 구해서 넣을 용
		
		day = 1; //Day 리스트에 며칠인지 넣을 용
		
		for(int i = 0 ; i < monthArr.length ; i++) {
			for(int j = 0 ; j < monthArr[i].length ; j++) {
				if(monthArr[i][j] != 0) {
					if(start2 % 7 == 0 || start2 % 7 == 6) {
						isHoliday = true;
					} else {
						isHoliday = false;
					}
				
					days.add(new Day(month, day++, start2++%7, isHoliday));			
				}
			}
		}
		
		getCalendar(n, monthArr);
	}
	
	static public void getCalendar(int n , int[][] monthArr) {
		int day = 1;
		
		for(int i = 0 ; i <= n / 7 + 1 ; i++) { // 완성된 달력 출력 -> isHoliday 확인해서 휴일이면 [x]로 표시
			for(int j = 0 ; j < 7 ; j++) {
				if(monthArr[i][j] == 0) {
					System.out.print(" ");
				} else {
					if(days.get(day++ - 1).isHoliday()) { 
						System.out.print("[x]");
					} else {
						System.out.print(monthArr[i][j]);
					}
				}
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	static Appointment[] getAppointments() {
		System.out.print("예약 리스트 확인할 날짜 입력 : ");
		int date = Integer.parseInt(DataInput.sc.nextLine()) - 1;
		
		return days.get(date).appointments;
	}
	
	static public void setHoliday() {
		System.out.print("일정 등록 일 입력 : ");
		int date = Integer.parseInt(DataInput.sc.nextLine()) - 1;
		System.out.println("일정 등록 사유 입력 : ");
		days.get(date).setReason(DataInput.sc.nextLine());
		days.get(date).setHoliday(true);
		
		System.out.println("일정이 등록되었습니다.");
		
	}
	static public void updateHoliday() {
		System.out.println("일정 수정 일 입력 : ");
		int date = Integer.parseInt(DataInput.sc.nextLine()) - 1;
		
	}
	
	static public void removeHoliday() {
		System.out.println("일정 삭제 일 입력 : ");
		int date = Integer.parseInt(DataInput.sc.nextLine()) - 1;
		if(!days.get(date).isHoliday()) {
			System.out.println("삭제할 일정이 없습니다.");
			removeHoliday();
		} else {
			days.get(date).setHoliday(false);
			days.get(date).setReason("");
			System.out.println("일정이 삭제되었습니다.");
		}
	}
	
	public void updateAppointment() {
		System.out.println("");
	}
	
	static public List<Day> getDays() {
		return days;
	}

	static public void setDays(List<Day> dayList) {
		days = dayList;
	}
}
