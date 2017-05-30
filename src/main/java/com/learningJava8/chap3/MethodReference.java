package com.learningJava8.chap3;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.learningJava8.chap2.Apple;


public class MethodReference {
	public static void main(String[] args) {
		/****************Construct method reference*******************/
		//There is a Apple constructor with no arguments
		Supplier<Apple> supplier = Apple::new;
		Apple apple1 = supplier.get();
		System.out.println(apple1);
		
		//There is a Apple constructor with one argument
		Function<String, Apple> function = Apple::new;
		Apple apple2 = function.apply("green");
		System.out.println(apple2);
		
		//There is a Apple constructor with two arguments
		BiFunction<Integer,String,Apple> biFunction = Apple::new;
		Apple apple3 = biFunction.apply(150, "green");
		System.out.println(apple3);
	}
}


