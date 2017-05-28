package com.learningJava8.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
	List<Apple> applesList = Arrays.asList(new Apple(80,"green"),
										   new Apple(160,"red"),
										   new Apple(50,"red"));
	
	
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
	
	//Now you can run it by this way.
	List<Apple> greenApples = filterApplesByColor(applesList, "green");
	List<Apple> redApples = filterApplesByColor(applesList, "red");
	
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
	
	//4.But the above two methods lead to too much code.You will try to combine these two methods.
	//It needs a sign to distinguish which method is called.
	public static List<Apple> filterApples(List<Apple> applesList,String color,int weight,boolean flag){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : applesList){
			if(flag && apple.getColor().equals(color) || 
					!flag && apple.getWeight() > weight ){
				result.add(apple);
			}
		}
		return result;
	}
	
	//When you want to filter green apples,you will set true.Or you want to filter heavy apples,you will set false.
	//But the client code is bad.No one knows true or false except you.
	//If someone adds another condition,it's not work.
	List<Apple> greenApples2 = filterApples(applesList, "green", 0, true);
	List<Apple> heavyApples = filterApples(applesList, "", 150, false);
	
	
	
	
	
}
