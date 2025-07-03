import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformanceComparison {
	private static final int ELEMENTS_COUNT = 100000;
	private static final int OPERATIONS_COUNT = 10000;

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();
		Random random = new Random();
		
		// ArrayList add operation
		long startTime = System.nanoTime();
		for (int i=0; i<OPERATIONS_COUNT;i++)
			arrayList.add(0, random.nextInt(ELEMENTS_COUNT));		
		
		long endTime = System.nanoTime();
		System.out.println("ArrayList add: " + (endTime - startTime) / 1e6 + " ms");

		startTime = System.nanoTime();
		for (int i=0; i<OPERATIONS_COUNT;i++)
			linkedList.add(0, random.nextInt(ELEMENTS_COUNT));		
		
		endTime = System.nanoTime();
		System.out.println("linkedList add: " + (endTime - startTime) / 1e6 + " ms");

		
	}

}
