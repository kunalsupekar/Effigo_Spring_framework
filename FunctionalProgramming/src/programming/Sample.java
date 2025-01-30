package programming;

import java.util.function.Predicate;

public class Sample {
	
	public static void main(String [] args) {
		
		Predicate<Integer> isEvenPredicate= x->x%2==0;
		
//		if(isEvenPredicate.test(32)) {
//			System.out.println("true");
//		}else {
//			System.out.println("false");
//		}
		
		
		System.out.println(isEvenPredicate.test(321) ? "true":"false");
		
	}
}
