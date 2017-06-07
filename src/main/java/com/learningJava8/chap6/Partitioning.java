package com.learningJava8.chap6;

import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.learningJava8.chap6.Dish.Type;

public class Partitioning {
	public static void main(String[] args) {
		Map<Boolean,List<Dish>> partitionByVegeterian = Dish.menu.stream().collect(partitioningBy(Dish::isVigetrian));
		System.out.println("Dishes partitioned by vegetarian: " + partitionByVegeterian);
		
		List<Dish> vegetarianDishes = partitionByVegeterian.get(true);
									//Dish.menu.stream().filter(Dish::isVigetrian).collect(toList());
		System.out.println("VegetarianDishes: " + vegetarianDishes);
		
		Map<Boolean, Map<Type, List<Dish>>> vegetarianDishesByType =
		Dish.menu.stream().collect(partitioningBy(Dish::isVigetrian,groupingBy(Dish::getType)));
		System.out.println("Vegetarian Dishes by type: " + vegetarianDishesByType);
		
		Map<Boolean,Dish> mostCaloricPartitionedByVegetarian =
		Dish.menu.stream().collect(partitioningBy(Dish::isVigetrian,collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),Optional::get)));
		System.out.println("Most caloric dishes by vegetarian: " + mostCaloricPartitionedByVegetarian);
		
		Map<Boolean,Long> dishesCountByVegetarian = Dish.menu.stream().collect(partitioningBy(Dish::isVigetrian,counting()));
		System.out.println("Dishes count by vegetarian:" + dishesCountByVegetarian);
	}
}
