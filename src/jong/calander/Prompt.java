package jong.calander;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
		
	}

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

	public void runPrompot() throws ParseException {
		printMenu();

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			if (cmd.equals("1")) {
				cmdRegister(scanner, cal);
			} else if (cmd.equals("2")) {
				cmdSearch(scanner, cal);
			} else if (cmd.equals("3")) {
				cmdCalendar(scanner, cal);
			} else if (cmd.equals("h")) {
				cmdHelp();
			} else if (cmd.equals("q")) {
				break;
			}
		}
		System.out.println("일정관리 프로그램을 종료합니다.");
		scanner.close();

	}

	private void cmdHelp() {
		// TODO 자동 생성된 메소드 스텁

	}

	private void cmdCalendar(Scanner s, Calendar c) {
		// TODO 자동 생성된 메소드 스텁

		int month = 1;
		int year = 2017;

		System.out.println("년도을 입력하세요.");
		System.out.print("YEAR> ");
		year = s.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = s.nextInt();

		// 입력조건 
		if (month < 1 || month > 12) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		c.printCalander(year, month);

	}

	private void cmdSearch(Scanner s, Calendar c) {
		// TODO 자동 생성된 메소드 스텁

		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = s.next();
		String plan = "";
		try {
			plan = c.searchPlan(date);
		} catch (ParseException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
			System.err.println("일정 검색 중 오류가 발생했습니다.");
		}
		System.out.println(plan);

	}

	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
		// TODO 자동 생성된 메소드 스텁
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = s.next();
		String text = "";
		s.nextLine(); // ignore one newline
		System.out.println("일정을 입력해 주세요.");
		text = s.nextLine();

		c.registerPlan(date, text);

	}

	public static void main(String[] args) throws ParseException {

		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompot();

	}

}
