package com.learningJava8.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.learningJava8.chap2.Apple;

public class CompoundLambda {
	public static void main(String[] args) {
		List<Apple> applesList = Arrays.asList(new Apple(80,"red"),
											   new Apple(80,"green"),	
											   new Apple(160,"red"),
											   new Apple(50,"red"));
		 
		//Comparator compound
		applesList.sort(Comparator.comparing(Apple::getWeight));
		System.out.println(applesList);
		
		applesList.sort(Comparator.comparing(Apple::getWeight).reversed());
		System.out.println(applesList);
		
		applesList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		System.out.println(applesList);
		
		//Predicate compound(negate、and、or)
		Predicate<Apple> redApplePredicate = (Apple apple)-> "red".equals(apple.getColor());
		Predicate<Apple> notRedApplePredicate= redApplePredicate.negate();
		Predicate<Apple> redAndHeavyPredicate = redApplePredicate.and((Apple apple) -> apple.getWeight() > 150);
		Predicate<Apple> redAndHeavyAppleOrGreenPredicate = redApplePredicate.and(a -> a.getWeight() > 150).or(a -> "green".equals(a.getColor()));
		List<Apple> redAppleResult = filter(applesList, redApplePredicate);
		System.out.println("There is a red apple list:"+redAppleResult);
		List<Apple> notRedAppleResult = filter(applesList, notRedApplePredicate);
		System.out.println("There is a not red apple list:"+notRedAppleResult);
		List<Apple> redAndHeavyResult = filter(applesList, redAndHeavyPredicate);
		System.out.println("There is a red and heavy apple list:"+redAndHeavyResult);
		List<Apple> redAndHeavyAppleOrGreenResult = filter(applesList, redAndHeavyAppleOrGreenPredicate);
		System.out.println("There is a (red and heavy) or green apple list:"+redAndHeavyAppleOrGreenResult);
		
		//Function compound(andThen、compose)
		Function<Integer, Integer> f = x -> x+1;
		Function<Integer, Integer> g = x -> x*2;
		Function<Integer, Integer> h1 = f.andThen(g);
		Function<Integer, Integer> h2 = f.compose(g);
		System.out.println(h1.apply(1));
		System.out.println(h2.apply(1));
	}
	
	public static <T> List<T> filter(List<T> list,Predicate<T> p){
		List<T> result = new ArrayList<T>();
		for(T t : list){
			if(p.test(t)){
				result.add(t);
			}
		}
		return result;
	}
}
