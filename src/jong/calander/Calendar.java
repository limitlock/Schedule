package jong.calander;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] END_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_END_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private HashMap<Date, PlanItem> planMap;

	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
	}

	public void registerPlan(String strDate, String plan) throws ParseException {
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);

	}

	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);

	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getEndOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_END_DAYS[month];
		} else {
			return END_DAYS[month];
		}

	}

	public void printCalander(int year, int month) {
		System.out.printf("  <<%4d년%3d월>> \n", year, month);
		System.out.println(" SU MO TU WD TH FR SA");
		System.out.println(" --------------------");

		// get weekday auto
		int weekday = getWeekDay(year, month, 1);

		// print blank
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int endDay = getEndOfMonth(year, month);
		int count = 7 - weekday;
		int div_condition = (count < 7) ? count : 0;

		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		for (int i = count + 1; i <= endDay; i++) {

			System.out.printf("%3d", i);
			if (i % 7 == div_condition) {
				System.out.println();
			}

		}
		System.out.println();
		System.out.println();

	}

	// 1970년 1월 1일 목요일을 기준으로 요일을 구한다.
	private int getWeekDay(int year, int month, int day) {
		// TODO 자동 생성된 메소드 스텁
		int f_year = 1970;
		final int F_WEEKDAY = 4;

		int count = 0;
		for (int i = f_year; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getEndOfMonth(year, i);
			count += delta;
		}

		count += day - 1;

		int weekday = (count + F_WEEKDAY) % 7;
		return weekday;
	}

}
