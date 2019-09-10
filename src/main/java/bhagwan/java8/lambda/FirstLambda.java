package bhagwan.java8.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class FirstLambda {

	public void printNumbers(Function<Integer, Integer> func) {
		System.out.println(func.apply(10));
	}

	private boolean isPrime(Integer num) {

		Optional<Integer> divisible = 
				Stream.iterate(2, n -> n + 1)
				.filter(n -> n >= Math.sqrt(num))
				.filter(n -> (num % n) == 0)
				.findAny();

		if (divisible.isPresent())
			return false;

		return true;
	}

	public void verifyFunctionInterface() {
		FirstLambda firstLamda = new FirstLambda();
		firstLamda.printNumbers((a) -> a * 2);
	}

	@Test
	public void testUsingStreams() {
		int maxSize = 4;
		FirstLambda firstLamda = new FirstLambda();
		Stream<Integer> stream = Stream.iterate(1, n -> n + 1);

		Integer sum = stream.limit(maxSize)
				.filter(p -> firstLamda.isPrime(p))
				.mapToInt(p -> p).sum();

		assertEquals(5, sum);

	}

}
