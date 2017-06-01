package com.learningJava8.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {
	public static void main(String[] args) {
		getDishInJava7(Dish.menu).forEach(System.out::println);
		
		getDishInJava8(Dish.menu).forEach(System.out::println);
	}
	
	public static List<String> getDishInJava7(List<Dish> dishesList)
	{
		List<Dish> lowCaloricList = new ArrayList<Dish>();
		
		for(Dish dish : dishesList)
		{
			if(dish.getCalories() < 400)
			{
				lowCaloricList.add(dish);
			}
		}
		
		Collections.sort(lowCaloricList,new Comparator<Dish>() {
			public int compare(Dish d1,Dish d2){
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		
		List<String> lowCaloricNameList = new ArrayList<String>();
		for(Dish d : lowCaloricList)
		{
			lowCaloricNameList.add(d.getName());
		}
		
		
		return lowCaloricNameList;
	}
	
	public static List<String> getDishInJava8(List<Dish> dishesList)
	{
		return dishesList.stream()
				.filter(d -> d.getCalories() < 400)
				.sorted(Comparator.comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(Collectors.toList());
	}
}
