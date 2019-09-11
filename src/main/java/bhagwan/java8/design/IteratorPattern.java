package bhagwan.java8.design;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IteratorPattern {

	public static int imperativeFactorialNumber(int n) {
		int tot = 1;
		for (int i = 1; i <= n; i++) {
			tot *= i;
		}
		return tot;
	}

	
	public static int factorialJava8(int num) {

		return IntStream.rangeClosed(1, num)
					.reduce(1, (tot, n) -> tot * n);
	}

	public static void main(String[] args) {
		System.out.println(imperativeFactorialNumber(5));
		System.out.println(factorialJava8(5));
		
		//internal iterator example 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
 
		numbers.forEach(System.out::println);
		
	}
}
