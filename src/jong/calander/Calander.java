package jong.calander;

import java.util.Scanner;

public class Calander {

	private static final int[] EndOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int getEndofMonth(int month) {

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

		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();

		System.out.println("당신이 입력한 " + month + "월의 마지막 날짜는 " + getEndofMonth(month) + "입니다");

		scanner.close();
	}

}
