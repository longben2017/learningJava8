package com.learningJava8.chap5;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildStreams {
	public static void main(String[] args) throws Exception{
		//Stream of
		System.out.println("-------Stream of-----------");
		Stream<String> stream = Stream.of("Java8","Lambda","in","Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		//Stream empty
		//Stream<String> emptyStream = Stream.empty();
		
		System.out.println("--------Arrays stream----------");
		int[] numbers = {1,5,3,10,7,14};
		System.out.println(Arrays.stream(numbers).sum());
		
		
		System.out.println("--------Stream iterate----------");
		Stream.iterate(1, n -> n + 2)
			  .limit(3)
			  .forEach(System.out::println);
		
		System.out.println("---------fibonnaci with iterate---------");
		Stream.iterate(new int[]{1,2},t -> new int[]{t[1],t[0]+t[1]})
			  .limit(5)
			  .forEach(t -> System.out.println("("+t[0]+","+t[1]+")"));
		
		System.out.println("---------");
		Stream.iterate(new int[]{1,2},t -> new int[]{t[1],t[0]+t[1]})
			  .limit(5)
			  .map(t -> t[0])
			  .forEach(System.out::println);
		
		//Stream.generate : Infinitely created something,so don't forget to use limit method to limit it
		System.out.println("--------random stream of doubles with Stream.generate-----------");
		Stream.generate(Math::random)
			  .limit(3)
			  .forEach(System.out::println);
		
		System.out.println("---------stream of 1 with Stream.generate---------------------");
		IntStream.generate(() -> 1)
			  .limit(5)
			  .forEach(System.out::println);
		
		System.out.println("-------IntStream match IntSupplier---------");
		IntStream.generate(new IntSupplier() {
			@Override
			public int getAsInt() {
				return 2;
			}
		})
		.limit(5)
		.forEach(System.out::println);
		
		System.out.println("----fibonnaci with IntStream.generate----");
		IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;
			@Override
			public int getAsInt() {
				int nextValue = this.previous + this.current;
				this.previous = current;
				this.current = nextValue;
				return previous;
			}
		};
		IntStream.generate(fib).limit(5).forEach(System.out::println);

		System.out.println("----flatMap-----");
        long uniqueWords = Files.lines(Paths.get("src/main/resources/chap5/data.txt"))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
        System.out.println("There are " + uniqueWords + " unique words in data.txt");
	}
}
