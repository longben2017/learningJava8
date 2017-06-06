package com.learningJava8.chap6;

import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;

public class Summarizing {
	public static void main(String[] args) {
        long dishesCount = Dish.menu.stream().count();
        //long dishesCount2 = Dish.menu.stream().collect(counting());
        System.out.println("how many dishes are there in the menu :"+ dishesCount);
        
        Dish mostCaloricDish = Dish.menu.stream().collect(reducing((d1,d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
        System.out.println("The most caloric dish is: "+mostCaloricDish);
        
        //findMostCaloricDishUsingComparator
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloricDish2 = Dish.menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println("The most caloric dish is: "+mostCaloricDish2.get());
        
        int totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("Total calories in menu: "+totalCalories);
        
        double averageCalories =  Dish.menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println("Average calories in menu: "+averageCalories);
        
        IntSummaryStatistics intSummaryStatistics = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("Menu statistics: "+ intSummaryStatistics);
        
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining());
        System.out.println("Short menu: " + shortMenu);
        
        String shortMenu2 = Dish.menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println("Short menu comma separated: " +shortMenu2);
	}
}
