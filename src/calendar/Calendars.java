package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Calendars {
	static List<Day> days;
	
	public Calendars() {
		days = new ArrayList<Day>();
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
 
	static public List<Day> getDays() {
		return days;
	}

	static public void setDays(List<Day> dayList) {
		days = dayList;
	}
}
