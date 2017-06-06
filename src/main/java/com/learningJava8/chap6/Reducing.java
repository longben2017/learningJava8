package com.learningJava8.chap6;

import static java.util.stream.Collectors.*;

public class Reducing {
	public static void main(String[] args) {
		
		//calculateTotalCalories
		int totalCalories = Dish.menu.stream().collect(reducing(0,Dish::getCalories,(d1,d2) -> d1+d2));
		System.out.println(totalCalories);
		
		//calculateTotalCaloriesWithMethodReference
		int totalCalories2 = Dish.menu.stream().collect(reducing(0,Dish::getCalories,Integer::sum));
		System.out.println(totalCalories2);
		
		//calculateTotalCaloriesWithoutCollect
		int totalCalories3 = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
		System.out.println(totalCalories3);
		
		//calculateTotalCaloriesUsingSum
		int totalCalories4 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(totalCalories4);
	}
}
