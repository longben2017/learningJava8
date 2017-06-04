package com.learningJava8.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.learningJava8.chap4.Dish;

public class Mapping {
	public static void main(String[] args) {
		//map
		List<String> dishNames = Dish.menu.stream()
				.map(Dish::getName)
				.collect(Collectors.toList());
		System.out.println(dishNames);
		
		//map
		List<String> words = Arrays.asList("hello","world");
		List<Integer> wordlengths = words.stream()
				.map(String::length)
				.collect(Collectors.toList());
		System.out.println(wordlengths);
		
		//flat map
		words.stream()
			 .flatMap(line -> Arrays.stream(line.split("")))
			 .distinct()
			 .forEach(System.out::println);
	}
}
