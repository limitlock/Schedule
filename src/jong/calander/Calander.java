package jong.calander;

import java.util.Scanner;

public class Calander {

	private static final int[] EndOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getEndofMonth(int month) {

		return EndOfMonth[month - 1];

	}

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		/*
		 * System.out.println("일 월  화  수  목  금  토");
		 * System.out.println("1   2   3   4    5   6   7");
		 * System.out.println("8   9  10  11  12  13  14");
		 * System.out.println("15 16 17  18  19  20  21");
		 * System.out.println("22 23 24  25  26  27  28");
		 */
		String PROMPT = "cal>";
		Scanner scanner = new Scanner(System.in);
		Calander cal = new Calander();

		int month = 1;

		while (true) {
			System.out.println("달을 입력하세요 : ");
			System.out.println(PROMPT);
			month = scanner.nextInt();
			// 종료조건
			if (month < 1) {
				break;
			}
			// 입력조건
			if (month > 12) {
				System.out.println("입력한 달이 존재하는 범위에 있지 않습니다. (1~12)");
				continue;
			}
			System.out.println("당신이 입력한 " + month + "월의 마지막 날짜는 " + cal.getEndofMonth(month) + "입니다");
		}
		System.out.println("종료");
		scanner.close();
	}

}
