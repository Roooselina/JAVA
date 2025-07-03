
interface Calculator{
	int calculate(int x, int y);
}



public class Main{

	public static void main(String[] args) {
		Calculator addition = new Calculator() {

			@Override
			public int calculate(int x, int y) {
				return x+y;
			}
		};
		int result = addition.calculate(5, 3);
		System.out.println("결과 : "+result);

	}
}
