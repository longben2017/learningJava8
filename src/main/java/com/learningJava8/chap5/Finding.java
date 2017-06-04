package com.learningJava8.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.learningJava8.chap4.Dish;

public class Finding {
	public static void main(String[] args) {
		//find element
		Dish.menu.stream()
				 .filter(Dish::isVegetarian)
				 .findAny()
				 .ifPresent(d -> System.out.println(d.getName()));
		
		//find first element
		List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
		Optional<Integer> firstSquareDivisibleByThree = 
				someNumbers.stream()
						   .map(x -> x * x)
						   .filter(x -> x % 3 == 0)
						   .findFirst();
		System.out.println(firstSquareDivisibleByThree.get());
	}
}
