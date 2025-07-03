import java.util.ArrayList;

class SimplePair <T>{
	ArrayList<T> list;
	
	SimplePair(T text, T text2){
		super();
		list = new ArrayList<>();
		list.add(text);
		list.add(text2);
	}
	
	public T getFirst() {
		return list.get(0);
	}
	
	public T getSecond() {
		return list.get(1);
	}
}

public class SimplePairTest {

	public static void main(String[] args) {
		SimplePair<String> pair = new SimplePair<String>("apple", "tomato");
		System.out.println(pair.getFirst());
		System.out.println(pair.getSecond());

	}

}
