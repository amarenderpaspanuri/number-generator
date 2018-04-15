package com.number.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import com.number.generator.type.PlayType_Latest;

public class NumberGenerator_Latest {

	public static PlayType_Latest playType = PlayType_Latest.OZ;
	
	public static void main(String[] args) {
		
		int linesRequired = 36;
		int initialNumbers = 2;
		
		//Select 2 numbers between 1 and 36
		List<ArrayList<Integer>> lines = generateInitialNumbers(linesRequired, initialNumbers);
		
		for(ArrayList<Integer> line : lines) {
			List<Integer> numbers = new ArrayList<Integer>();
			for(Integer number : line) {
				
				List<Integer> ruleNumbers = RuleNumberGenerator.getNumbers(number);
				if(ruleNumbers != null && !ruleNumbers.isEmpty()) {
					numbers.addAll(ruleNumbers);
				}
				
				
				//Multiples
				List<Integer> multipleNumbers = getMultiples(number);
				if(!multipleNumbers.isEmpty()) {
					addNumbers(numbers, multipleNumbers);
				}
				
				//Adds With
				Integer addsWithNumber = getAddsWith(number);
				List<Integer> addsWithNumbers = getAddsWithNumbers(addsWithNumber);
				if(!addsWithNumbers.isEmpty()) {
					addNumbers(numbers, addsWithNumbers);
				}
				
				
				//Ends With
				Integer endsWithNumber = getEndsWith(number);
				List<Integer> endsWithNumbers = getEndsWithNumbers(endsWithNumber);
				if(!endsWithNumbers.isEmpty()) {
					addNumbers(numbers, endsWithNumbers);
				}
			}
			
			Random random = new Random();
			while(line.size() < playType.getNumbersPerLine()) {
				int index = random.nextInt(numbers.size());
				Integer number = numbers.get(index);
				if(!line.contains(number)) {
					line.add(number);
				}
			}
		}
		for(ArrayList<Integer> line : lines) {
			System.out.println(line);
		}
	}
	
	public static void addNumbers(List<Integer> numbers, List<Integer> tempNumbers) {
		for(Integer number : tempNumbers) {
			if(!numbers.contains(number)) {
				numbers.add(number);
			}
		}
	}
	
	public static List<Integer> getMultiples(Integer number) {
		List<Integer> numbers = new ArrayList<Integer>();
		if(number > 7) {
			for(int i = 2; ; i++) {
				if(number * i > playType.getNumberLimit()) {
					break;
				} else {
					numbers.add(number*i);
				}
			}
		}
		return numbers;
	}
	
	public static List<Integer> getAddsWithNumbers(Integer number) {
		List<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 1; i <= playType.getNumberLimit(); i++) {
			if(number == getAddsWith(i) || number == getEndsWith(i)) {
				numbers.add(i);
			}
		}
		return numbers;
	}
	
	public static List<Integer> getEndsWithNumbers(Integer number) {
		List<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 1; i <= playType.getNumberLimit(); i++) {
			if(number == getAddsWith(i) || number == getEndsWith(i)) {
				numbers.add(i);
			}
		}
		return numbers;
	}
	
	public static Integer getAddsWith(Integer number) {
		Integer addsWithNumber = 0;
		String[] array = getString(number).split("");
		for(String item : array) {
			addsWithNumber += getInt(item);
		}
		return addsWithNumber;
	}
	
	public static int getEndsWith(Integer value) {
		Integer endsWithNumber;
		String[] array = getString(value).split("");
		if(array.length > 1) {
			endsWithNumber = getInt(array[array.length - 1]);
		} else {
			endsWithNumber = value;
		}
		return endsWithNumber;
	}
	
	public static String getString(Integer value) {
		return value.toString();
	}
	
	public static int getInt(String value) {
		return Integer.parseInt(value);
	}
	public static List<ArrayList<Integer>> generateInitialNumbers(int linesRequired, int initialNumbers) {
		List<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
		Random random = new Random();
		while(linesRequired != 0) {
			ArrayList<Integer> line = new ArrayList<Integer>();	
			for(int i = 1; i <= initialNumbers; ) {
				int number = random.nextInt(playType.getNumberLimit());
				if(number != 0 && !line.contains(number)) {
					line.add(number);
					i++;
				}
			}
						
			if(!listContainsList(lines, line)) {
				lines.add(line);
				linesRequired--;
			}
		}
		return lines;
	}
	
	public static boolean listContainsList(List<ArrayList<Integer>> rulesList, List<Integer> rule) {
		for(ArrayList<Integer> list : rulesList) {
			if(listEqualsList(list, rule)) {
				return true;
			}
		}
	    return false;
	}
	
	private static boolean listEqualsList(List<Integer> list1, List<Integer> list2) {
		return new HashSet<Integer>(list1).equals(new HashSet<Integer>(list2));
	}
}










