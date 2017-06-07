package com.learningJava8.chap6;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Grouping {
	enum CaloricLevel{DIET,NORMAL,FAT}
	
	public static void main(String[] args) {
	    Map<Dish.Type,List<Dish>> dishesByType= Dish.menu.stream().collect(groupingBy(Dish::getType));    
	    System.out.println("Dishes grouped by type: " +dishesByType);    
	    
	    Map<Dish.Type, List<String>> dishNamesByType= Dish.menu.stream().collect(groupingBy(Dish::getType,mapping(Dish::getName, toList())));
	    System.out.println("Dish names grouped by type: "+dishNamesByType);
	    
	    Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel= 
	    		Dish.menu.stream().collect(groupingBy(dish -> {
	    	if(dish.getCalories() <= 400) return CaloricLevel.DIET;
	    	else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
	    	else return CaloricLevel.FAT;
	    }));
	    System.out.println("Dishes grouped by caloric level: " + groupDishesByCaloricLevel);
	    
	    Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel =
	    Dish.menu.stream().collect(groupingBy(Dish::getType,
	    		groupingBy((Dish dish) -> {
	    	if(dish.getCalories() <= 400) return CaloricLevel.DIET;
	    	else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
	    	else return CaloricLevel.FAT;
	    })));
	    System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel);
	    
	    Map<Dish.Type,Long> countDishesInGroups = Dish.menu.stream().collect(groupingBy(Dish::getType,counting()));
	    System.out.println("Count dishes in groups: " + countDishesInGroups);
	    
	    Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType = 
	    		Dish.menu.stream().collect(groupingBy(Dish::getType,reducing((Dish d1,Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));
	    System.out.println("Most caloric dishes by type: " + mostCaloricDishesByType);
	    
	    Map<Dish.Type, Dish> mostCaloricDishesByTypeWithoutOprionals =
	    		Dish.menu.stream().collect(groupingBy(Dish::getType,collectingAndThen(reducing((Dish d1,Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2),Optional::get)));
	    System.out.println("Most caloric dishes by type: " + mostCaloricDishesByTypeWithoutOprionals);
	    
	    Map<Dish.Type,Integer> sumCaloriesByType = Dish.menu.stream().collect(groupingBy(Dish::getType,summingInt(Dish::getCalories)));
	    System.out.println("Sum calories by type: " + sumCaloriesByType);
	    
	    Map<Dish.Type,Set<CaloricLevel>> caloricLevelsByType = 
	    Dish.menu.stream().collect(groupingBy(Dish::getType, mapping(
                dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                else return CaloricLevel.FAT; },
                toSet())));
	    System.out.println("Caloric levels by type: " + caloricLevelsByType);
	}
}
