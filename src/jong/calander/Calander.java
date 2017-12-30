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

		System.out.print("반복횟수를 입력하세요 : ");
		int repeat = scanner.nextInt();

		for (int i = 0; i < repeat; i++) {
			System.out.println("달을 입력하세요 : ");
			System.out.println(PROMPT);
			int month = scanner.nextInt();
			System.out.println("당신이 입력한 " + month + "월의 마지막 날짜는 " + cal.getEndofMonth(month) + "입니다");
			
		}

	

	
		scanner.close();
	}

}
