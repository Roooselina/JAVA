import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coutnry {

	public static void main(String[] args) {
		Map<String, String> countryCapitalMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);

		countryCapitalMap.put("USA", "Washington");
		countryCapitalMap.put("Japan", "Tokyo");
		countryCapitalMap.put("China", "Beijing");
		countryCapitalMap.put("UK", "London");
		countryCapitalMap.put("Korea", "Seoul");

		for (int i = 0; i < 2; i++) {
			System.out.print("국가 이름을 입력하시오: ");
			String county = sc.next();
			if (countryCapitalMap.containsKey(county))
				System.out.println(county + "의 수도 " + countryCapitalMap.get(county)+"\n");
			else
				System.out.println("해당 국가 데이터 존재하지 않음\n");
		}
	}
}
