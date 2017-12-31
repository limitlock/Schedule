package jong.calander;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompot() {
		Scanner scanner = new Scanner(System.in);
		Calander cal = new Calander();

		int month = -1;
		int year = -1;

		while (true) {
			System.out.println("년도을 입력하세요.");
			System.out.print("YEAR> ");
			year = scanner.nextInt();

			System.out.println("달을 입력하세요.");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			// 종료조건
			if (month == -1) {
				break;
			}
			// 입력조건
			if (month < 1 || month > 12) {
				System.out.println("입력한 달이 존재하는 범위에 있지 않습니다. \n" + "당신이 입력한 값은 " + month + "입니다.\n");
				continue;
			}
			// System.out.println("당신이 입력한 " + month + "월의 마지막 날짜는 " +
			// cal.getEndofMonth(month) + "입니다\n");
			cal.printCalander(year, month);
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
