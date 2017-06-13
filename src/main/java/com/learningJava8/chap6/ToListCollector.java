package com.learningJava8.chap6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToListCollector<T, A, R> implements Collector<T, List<T>, List<T>> {

	//T is the generality of the items to be collected in the stream.
	//It means that T is source.
	
	//A is the type of accumulator,the accumulator is used in the collection process for the accumulation of part of the object.
	//It means that A is intermediate object.
	
	//R is the type of object(usually but not necessarity a collection)the the collection opeartion gets.
	//It means that R is result.
	
	//Create a new container of results
	@Override
	public Supplier<List<T>> supplier() {
		return () -> new ArrayList<T>();
		//return ArrayList::new;
	}
	
	//Add elements to the results container
	@Override
	public BiConsumer<List<T>, T> accumulator() {
		return (List<T> list,T item) -> list.add(item);
		//return List::add;
	}

	//The final results of the container application conversion
	@Override
	public Function<List<T>, List<T>> finisher() {
		return i -> i ;
		//return Function.identity();
	}
	
	//Combine two result containers
	@Override
	public BinaryOperator<List<T>> combiner() {
		return (List<T> t1,List<T> t2) -> {
				t1.addAll(t2);
				return t1;			
			};
	}
	
	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		return null;
	}

	

	

	

	
}
