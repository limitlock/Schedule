package jong.calander;

import java.util.Scanner;

public class Prompt {
	/**
	 * 
	 * @param week
	 *            요일명
	 * @return 0은 일요일 ~ 6은 토요일
	 */
	public int parseDay(String week) {
		if (week.equals("su"))
			return 0;
		else if (week.equals("mo"))
			return 1;
		else if (week.equals("tu"))
			return 2;
		else if (week.equals("we"))
			return 3;
		else if (week.equals("th"))
			return 4;
		else if (week.equals("fr"))
			return 5;
		else if (week.equals("sa"))
			return 6;
		else
			return 0;
	}

	public void runPrompot() {
		Scanner scanner = new Scanner(System.in);
		Calander cal = new Calander();

		int month = 1;
		int year = 2017;
		int weekday = 0;

		while (true) {
			System.out.println("년도을 입력하세요.(exit : -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			// 종료조건
			if (year == -1) {
				break;
			}

			System.out.println("달을 입력하세요.");
			System.out.print("MONTH> ");
			month = scanner.nextInt();

			System.out.println("첫째 날을 입력하세요(su, mo, tu, we, th, fr, sa).");
			System.out.print("FIRST_DAY> ");
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);

			// 입력조건
			if (month < 1 || month > 12) {
				System.out.println("잘못된 입력입니다. \n" + "당신이 입력한 값은 " + month + "입니다.\n");
				continue;
			}
			// System.out.println("당신이 입력한 " + month + "월의 마지막 날짜는 " +
			// cal.getEndofMonth(month) + "입니다\n");
			cal.printCalander(year, month, weekday);
		}
		System.out.println("종료");
		scanner.close();

	}

	public static void main(String[] args) {

		// 셀 실행

		Prompt p = new Prompt();
		p.runPrompot();

	}

}
