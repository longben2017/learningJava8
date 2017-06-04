package com.learningJava8.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.learningJava8.chap4.Dish;

public class Filtering {
	public static void main(String[] args) {
		//Filtering with predicate
		List<Dish> vegetarianMenu = 
				Dish.menu.stream()
				.filter(Dish::isVegetarian)
				.collect(Collectors.toList());
		vegetarianMenu.forEach(System.out::println);
		
		//Filtering unique elements
		List<Integer> numbers = Arrays.asList(1,2,1,4,3,2);
		numbers.stream()
			   .distinct()
			   .forEach(System.out::println);	  
		
		// Truncating a stream
		List<Dish> dishesLimit3 = 
				Dish.menu.stream()
				.filter(d -> d.getCalories() > 300)
				.limit(3)
				.collect(Collectors.toList());
		dishesLimit3.forEach(System.out::println);
		
		// Skipping elements
		List<Dish> dishesSkip2 = 
				Dish.menu.stream()
				.filter(d -> d.getCalories() > 300)
				.skip(2)
				.collect(Collectors.toList());
		dishesSkip2.forEach(System.out::println);
	}
}
