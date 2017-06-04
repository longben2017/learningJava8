package com.learningJava8.chap5;

import java.util.List;

import com.learningJava8.chap4.Dish;

public class Matching {
	public static void main(String[] args) {
		List<Dish> menu = Dish.menu;
		
		//Check if the predicate matches at least one element. 
		if(menu.stream().anyMatch(Dish::isVegetarian)){
			System.out.println("The menu is somewhat vegetarian friendly!");
		}
		
		//Check if the predicate matches all the elements.
		if(menu.stream().allMatch(d -> d.getCalories() < 1000)){
			System.out.println("The dishes in the menu are health!");
		}
		
		//noneMatch:opposite the allMatch
		if(menu.stream().noneMatch(d -> d.getCalories() >= 1000)){
			System.out.println("The dishes in the menu are health!");
		}
	}
}
