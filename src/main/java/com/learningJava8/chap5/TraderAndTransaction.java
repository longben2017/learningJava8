package com.learningJava8.chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TraderAndTransaction {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul","Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian,2011,300),
				new Transaction(raoul,2012,1000),
				new Transaction(raoul,2011,400),
				new Transaction(mario,2012,710),
				new Transaction(mario,2012,700),
				new Transaction(alan,2012,950)
		);
		
		//To find all transactions that occurred in 2011 
		//and sort by transaction amount(from low to high).
		transactions.stream()
					.filter(t -> t.getYear() == 2011)
					.sorted(Comparator.comparing(Transaction::getValue))
					.forEach(System.out::println);
		System.out.println("------------------");
		
		//What are the different cities in which traders work?
		transactions.stream()
					.map(t -> (t.getTrader().getCity()))
					.distinct()
					.forEach(System.out::println);
		System.out.println("------------------");
		
		//To find all traders from Cambridge and sort By name.
		transactions.stream()
					.map(Transaction::getTrader)
					.filter(t -> "Cambridge".equals(t.getCity()))
					.distinct()
					.sorted(Comparator.comparing(Trader::getName))
					.forEach(System.out::println);
		System.out.println("------------------");
		
		//Returns the name strings of all traders,sorted alphabetically
		System.out.println(transactions.stream()
					.map(t -> t.getTrader().getName())
					.distinct()
					.sorted()
					.reduce("", (n1,n2) -> n1 + n2));
		System.out.println("------------------");
		
		//Whether there are traders working in Milan?
		boolean milanBased = 
		transactions.stream()
					.anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
		System.out.println(milanBased);
		System.out.println("------------------");
		
		//Print all the trades of traders living in Cambridge
		transactions.stream()
					.filter(t -> "Cambridge".equals(t.getTrader().getCity()))
					.map(Transaction::getValue)
					.forEach(System.out::println);
		System.out.println("------------------");
		
		//What is the maximum amount of transactions in all transactions?
		System.out.println(transactions.stream()
					.map(Transaction::getValue)
					.reduce(Integer::max)
					.get());
		System.out.println("------------------");
		
		//To find the transaction with the smallest transaction value.
		System.out.println(transactions.stream()
					.reduce((t1,t2) -> t1.getValue() < t2.getValue() ? t1 : t2).get());
	}
	
}
