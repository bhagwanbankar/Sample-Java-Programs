package bhagwan.java8.design;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Stratergy {

	private static int totalNumbers(List<Integer> numbers) {
		int tot=0;
		for(int n : numbers) {
			tot+=n;
		}
		
		return tot;
	}
	
	//java 8 way
	//second parameter is strategy here
	private static int totalNumberUsingLambda(List<Integer> numbers, Predicate<Integer> predicate) {
		
		return numbers.stream()
				.filter(predicate)
				.mapToInt(m->m).sum();
	}
	
	
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println(totalNumbers(numbers));
		
		//java lamda ways
		System.out.println("Total of all numbers::"+totalNumberUsingLambda(numbers, s -> true));
		System.out.println("Total of even numbers::"+totalNumberUsingLambda(numbers, s -> s % 2 == 0));
		System.out.println("Total of odd numbers::"+totalNumberUsingLambda(numbers, s -> s % 2 !=0));
	}

}
