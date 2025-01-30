package programming;

import java.util.Arrays;
import java.util.List;

public class FP01Structured {
	public static void main(String [] args) {
		
		 List<String> cities = Arrays.asList(
		            "New", "London", "Tok", "Paris", "Mumbai",
		            "Sydney", "Toronto", "Berlin", "Dubai", "Singapore"
		        );
		
		 cities.stream()
		 		.filter(c-> c.contains("on"))
		 		.forEach(System.out::println);
		 
		 System.out.println();
		 
		 cities.stream()
	 		.filter(c-> c.length()>=4)
	 		.forEach(System.out::println);
		 
		 System.out.println();
		 
	        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 10, 20, 30);
	        
	        numbers.stream()
	        .map(c-> c*c)
	 		.forEach(System.out::println);
	}
	
	
}
