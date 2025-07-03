import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class main {

	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>();
		s1.add("A");
		s1.add("B");
		s1.add("C");

		Set<String> s2 = new HashSet<String>();
		s2.add("A");
		s2.add("D");
		
		Set<String> s3 = new HashSet<String>();
		for (String s: s1)
			s3.add(s);
		
;		s3.addAll(s2);
		System.out.println("합집합: "+s3);
		System.out.println("\n");

		s1.retainAll(s2);
		System.out.println("교집합: "+s1);
		System.out.println("\n");

	}

}
