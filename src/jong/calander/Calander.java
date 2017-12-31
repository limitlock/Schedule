package jong.calander;

public class Calander {

	private static final int[] END_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_END_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getEndOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_END_DAYS[month - 1];
		} else {
			return END_DAYS[month - 1];
		}

	}

	public void printCalander(int year, int month, int weekday) {
		System.out.printf("  <<%4d년%3d월>> \n", year, month);
		System.out.println(" SU MO TU WD TH FR SA");
		System.out.println(" --------------------");

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

}
