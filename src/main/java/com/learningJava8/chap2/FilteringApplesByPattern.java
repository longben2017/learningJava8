package com.learningJava8.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Strategy pattern
public class FilteringApplesByPattern {
	List<Apple> applesList = Arrays.asList(new Apple(80,"green"),
			   							   new Apple(160,"red"),
			   							   new Apple(50,"red"));
	
	public class AppleHeavyWeightPredicate implements IApplePredicate{
		@Override
		public boolean test(Apple apple) {
			return apple.getWeight() > 150;
		}
	}
	
	public class AppleGreedColorPredicate implements IApplePredicate{
		@Override
		public boolean test(Apple apple) {
			return "green".equals(apple.getColor());
		}
	}
	
	public class AppleRedAndHeavyPredicate implements IApplePredicate{
		@Override
		public boolean test(Apple apple) {
			return "red".equals(apple.getColor())
					&& apple.getWeight() > 150;
		}
	}
	
	public static List<Apple> filterApples(List<Apple> applesList,IApplePredicate p){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : applesList){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}
	
	//call this mothod
	List<Apple> greenApples1 = filterApples(applesList, new AppleGreedColorPredicate());
	List<Apple> heavyApples2 = filterApples(applesList, new AppleHeavyWeightPredicate());
	List<Apple> redAndHeavyApples = filterApples(applesList, new AppleRedAndHeavyPredicate());
}
