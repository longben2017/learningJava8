package com.learningJava8.chap1;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {
	//1.Someone want to filter green apples in a list.
	public static List<Apple> filterGreenApples(List<Apple> applesList){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : applesList){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}
	
	//2.Someone want to filter red(or any other color) apples in a list.
	//This time,you will make the color as a parameter.
	public static List<Apple> filterApplesByColor(List<Apple> applesList,String color){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : applesList){
			if(color.equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}
	
	//3.Someone want to filter heavy or light apples in a list.
	//So you need to create a new method to make the weight become a parameter.
	public static List<Apple> filterApplesByWeight(List<Apple> applesList,int weight){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : applesList){
			if(apple.getWeight() > weight){
				result.add(apple);
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
}
