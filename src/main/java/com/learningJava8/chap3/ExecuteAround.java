package com.learningJava8.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
	//There is a task.We need to read a txt file.Let's see how java8 simplely.
	
	//before java8,you can only read one line
	public static String processFile() throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/chap3/data.txt"))){
			return br.readLine();
		}
	}
	
	/***********java8*************/
	public interface BufferedReaderProcessor{
		String process(BufferedReader br) throws IOException;
	}
	
	public static String processFile(BufferedReaderProcessor p) throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/chap3/data.txt"))){
			//handle Object BufferedReader
			return p.process(br);
		}
	}
	
	//main
	public static void main(String[] args) throws IOException {
		String resultString = processFile();
		System.out.println(resultString);
		
		String oneline = processFile((BufferedReader br) -> br.readLine());
		System.out.println(oneline);
		
		String twoline = processFile((BufferedReader br) -> br.readLine() + br.readLine());
		System.out.println(twoline);
		
	}
}
