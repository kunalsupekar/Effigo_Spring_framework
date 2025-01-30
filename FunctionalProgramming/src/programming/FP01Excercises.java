package programming;

import java.util.List;

public class FP01Excercises {
	public static void main(String [] args) {
		
		printAllNumbers(List.of(11,22,1,2,1,2,1,21,2,1,2,112,1,14));
		
	}
	
	private static void print(int number) {
	System.out.println(number);
	}

	
	private static boolean isEven(int number) {
		return number%2==0;
		}
	private static void printAllNumbers(List<Integer> nuIntegers) {
//		for(var n:nuIntegers) {
//			System.out.println(n);
//		}
		
//		nuIntegers.stream().forEach(FP01Structured::print);
//		nuIntegers.stream().forEach(System.out::println);
		
		
		nuIntegers.stream()
//		.filter(FP01Structured::isEven)
		.filter(num -> num%2==0)
		.forEach(System.out::println);
		
	}

}
