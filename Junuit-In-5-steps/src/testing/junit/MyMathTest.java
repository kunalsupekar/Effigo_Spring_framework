package testing.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath math=new MyMath();
	@Test
	void test() {
	
		int result=math.calculateSum( new int[] {1,2,3,1,3});
		int expectedResult=17;
		assertEquals(expectedResult,result);
	}

	
	@Test
	void test1() {
		
		int[] numbers= {};
		MyMath math=new MyMath();
		int result=math.calculateSum(numbers);
		int expectedResult=0;
		assertEquals(expectedResult,result);
		//System.out.println(result);
	}

}
