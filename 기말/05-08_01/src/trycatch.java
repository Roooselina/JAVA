import java.util.Scanner;

public class trycatch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		try {
			int number = Integer.parseInt(sc.nextLine());
			System.out.println("입력한 정수: " + number);
		} catch (NumberFormatException e) {
			System.out.println("정수가 아닙니다.");
		} finally {
			sc.close();
		}

	}

}
