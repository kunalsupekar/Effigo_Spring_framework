package testing.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {

	@AfterAll
	static void afterAll() {
		System.out.println("beforeeach");
	}
	
	@BeforeEach
	void testbefore() {
		System.out.println("beforeeach");
	}

	@Test
	void test() {
		System.out.println("test 1");
	}


	@Test
	void test2() {
		System.out.println("test 2");
	}

	@AfterEach
	void aftereachtest() {
		System.out.println("Aftereach");
	}
	
	@Test
	void test3() {
		System.out.println("test 3");
	}
	

	@BeforeAll
	 static void beforeall() {
		System.out.println("before all");
	}
}
