package com.learningJava8.chap1;

import java.util.Arrays;
import java.util.List;

public class ComparatorApplesByLambda{
	public static void main(String[] args) {
		List<Apple> applesList = Arrays.asList(new Apple(80,"green"),
				   new Apple(160,"red"),
				   new Apple(50,"red"));
		
		applesList.sort((a1,a2)-> a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(applesList);
	}
}
