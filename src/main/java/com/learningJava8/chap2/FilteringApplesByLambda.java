package com.learningJava8.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApplesByLambda {
	
	
	public static List<Apple> filterApples(List<Apple> applesList,IApplePredicate p){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : applesList){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}
	
	//abstarct List type
	public static <T> List<T> filter(List<T> list,IPredicate<T> p){
		List<T> result = new ArrayList<T>();
		for(T t : list){
			if(p.test(t)){
				result.add(t);
			}
		}
		return result;
	}
		
	public static void main(String[] args) {
		List<Apple> applesList = Arrays.asList(new Apple(80,"green"),
				   new Apple(160,"red"),
				   new Apple(50,"red"));
		
		List<Apple> result = filterApples(applesList,(Apple apple)-> "red".equals(apple.getColor()));
		System.out.println(result);
		System.out.println("----------");
		
		List<Integer> evenNumbers = filter(Arrays.asList(new Integer[]{1,2,3}),(Integer i) -> i % 2 ==0);
		System.out.println(evenNumbers);
	}
}
