package com.number.generator;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import com.number.generator.comparator.NumberComparator;
import com.number.generator.type.PlayType_Latest;

public class NumberGenerator_Latest {

	public static PlayType_Latest playType = PlayType_Latest.PB;
	
	private static List<Integer> includeList;
	
	private static List<Integer> excludeList = new ArrayList<Integer>();

	// O 
	private static List<Integer> oIncludeList = Arrays.asList(
			new Integer[]{15, 3, 4, 5, 7, 8, 9, 11, 13, 16, 18, 19, 23, 25, 27, 29, 31, 34, 36, 37, 38, 39, 41, 43, 45}); 
	                   
	private static List<Integer> oExcludeList = Arrays.asList(
			new Integer[]{1, 2, 3, 6, 10, 12, 13, 14, 16, 18, 20, 21, 22, 24, 28, 31, 34, 36, 37, 38, 40, 41, 43, 44});
	
	// P
	private static List<Integer> pIncludeList = Arrays.asList(
			new Integer[]{15, 1, 3, 4, 5, 6, 7, 9, 12, 13, 14, 16, 19, 20, 24, 25, 26, 32, 33, 34, 35});
	private static List<Integer> pExcludeList = Arrays.asList(
			new Integer[]{1, 2, 3, 6, 10, 12, 13, 14, 16, 18, 20, 21, 22, 24, 28, 31, 34});
	
	// S
	private static List<Integer> sIncludeList = Arrays.asList(
			new Integer[]{2, 33, 35, 29, 7, 17, 23, 8});
	private static List<Integer> sExcludeList = Arrays.asList(
			new Integer[]{1, 2, 3, 6, 10, 12, 13, 14, 16, 18, 20, 21, 22, 24, 28, 31, 34, 36, 37, 39, 40, 41, 43});
	
	// SFL
	private static List<Integer> sflIncludeList = Arrays.asList(
			new Integer[]{2, 33, 35, 29, 7, 17, 23, 8});
	private static List<Integer> sflExcludeList = Arrays.asList(
			new Integer[]{1, 2, 3, 6, 10, 12, 13, 14, 16, 18, 20, 21, 22, 24, 28, 31, 34, 36, 37});
	
	public static void main(String[] args) {
		
		initPlayType();

		//Select 2 numbers between 1 and number limit
		List<ArrayList<Integer>> lines = generateInitialNumbers();
		
		for(ArrayList<Integer> line : lines) {
			List<Integer> numbers = new ArrayList<Integer>();
			for(Integer number : line) {
				
				//Rules
				List<Integer> ruleNumbers = RuleNumberGenerator.getNumbers(number);
				if(ruleNumbers != null && !ruleNumbers.isEmpty()) {
					addNumbers(line, numbers, ruleNumbers);
				}
				
				//Multiples
				List<Integer> multipleNumbers = getMultiples(number);
				if(!multipleNumbers.isEmpty()) {
					addNumbers(line, numbers, multipleNumbers);
				}
				
				//Adds With
				Integer addsWithNumber = getAddsWith(number);
				List<Integer> addsWithNumbers = getAddsWithNumbers(addsWithNumber);
				if(!addsWithNumbers.isEmpty()) {
					addNumbers(line, numbers, addsWithNumbers);
				}
				
				//Ends With
				Integer endsWithNumber = getEndsWith(number);
				List<Integer> endsWithNumbers = getEndsWithNumbers(endsWithNumber);
				if(!endsWithNumbers.isEmpty()) {
					addNumbers(line, numbers, endsWithNumbers);
				}
			}

			//Include Numbers
			if(!includeList.isEmpty()) {
				addNumbers(line, numbers, includeList);
			}

			//Random
			List<Integer> randomNumbers = getRandomNumbers(numbers, playType.getRandomNumberCount());
			if(!randomNumbers.isEmpty()) {
				//addNumbers(line, numbers, randomNumbers);
			}

			Collections.shuffle(numbers);

			List<Integer> lineCopy = getListCopy(line);
			Random random = new Random();
			while(line.size() < playType.getNumbersPerLine()) {
				int index = random.nextInt(numbers.size());
				Integer number = numbers.get(index);
				if(!line.contains(number)) {
					line.add(number);
				}

				if(getNumberSequenceCount(line) > playType.getAllowedNumberSequenceCount()) {
					line.clear();
					line.addAll(lineCopy);
				}
			}
		}
		for(ArrayList<Integer> line : lines) {
			System.out.println(line);
		}
	}
	
	public static void addNumbers(ArrayList<Integer> line, List<Integer> numbers, List<Integer> tempNumbers) {
		for(Integer number : tempNumbers) {
			if(!numbers.contains(number) && !line.contains(number)) {
				numbers.add(number);
			}
		}
	}
	
	public static void initPlayType() {
		if(playType == PlayType_Latest.OZ) {
			includeList = oIncludeList;
		} else if(playType == PlayType_Latest.PB) {
			includeList = pIncludeList;
		} else if(playType == PlayType_Latest.SL) {
			includeList = sIncludeList;
		} else if(playType == PlayType_Latest.SFL) {
			includeList = sflIncludeList;
		}
		prepareExcludeList();
	}
	
	private static void prepareExcludeList() {
		for(int i = 1; i <= playType.getNumberLimit(); i++) {
			if(!includeList.contains(i)) {
				excludeList.add(i);
			}
		}
	}
	
	public static List<Integer> getMultiples(Integer number) {
		List<Integer> numbers = new ArrayList<Integer>();
		if(number > 3) {
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

	public static List<Integer> getRandomNumbers(List<Integer> numbers, Integer count) {
		List<Integer> list = new ArrayList<Integer>();

		Random random = new Random();
		while(list.size() < count) {
			int number = random.nextInt(playType.getNumberLimit() + 1);
			if(number !=0 && !numbers.contains(number)) {
				list.add(number);
			}
		}
		return list;
	}

	public static Integer getAddsWith(Integer number) {
		Integer addsWithNumber = 0;
		String[] array = getString(number).split("");
		for(String item : array) {
			addsWithNumber += getInt(item);
		}
		if(addsWithNumber > 9) {
			addsWithNumber = getAddsWith(addsWithNumber);
		}
		return addsWithNumber;
	}
	
	public static int getEndsWith(Integer number) {
		Integer endsWithNumber;
		String[] array = getString(number).split("");
		if(array.length > 1) {
			endsWithNumber = getInt(array[array.length - 1]);
		} else {
			endsWithNumber = number;
		}
		return endsWithNumber;
	}
	
	public static String getString(Integer value) {
		return value.toString();
	}
	
	public static int getInt(String value) {
		return Integer.parseInt(value);
	}

	public static List<ArrayList<Integer>> generateInitialNumbers() {

		List<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
		for(int i = 1; i<= playType.getNumberLimit(); i++) {
			if(!excludeList.contains(i)) {
				ArrayList<Integer> line = new ArrayList<Integer>();
				line.add(i);
				lines.add(line);
			}
		}

		if(playType.getInitialNumbersCount() > 1){
			Random random = new Random();
			for(int j = 0; j < lines.size(); ) {
				ArrayList<Integer> line = lines.get(j);
				int number = 0;
				for(int i = 1; i < playType.getInitialNumbersCount(); ) {
					ArrayList<Integer> lineCopy = getArrayListCopy(line);
					number = random.nextInt(playType.getNumberLimit());
					if(!excludeList.contains(number)) {
						if(number != 0 && !lineCopy.contains(number)) {
							lineCopy.add(number);
							if(getNumberSequenceCount(lineCopy) == 0 && !listContainsList(lines, lineCopy)) {
								line.add(number);
								j++;
								i++;
							}
						}
					}
				}
			}
		}
		
		/*while(playType.getNumberLimit() != 0) {
			ArrayList<Integer> line = new ArrayList<Integer>();	
			for(int i = 1; i <= playType.getInitialNumbersCount(); ) {
				int number = random.nextInt(playType.getNumberLimit());
				if(number != 0 && !line.contains(number)) {
					line.add(number);
					i++;
				}
			}
						
			if(getNumberSequenceCount(line) == 0 && !listContainsList(lines, line)) {
				lines.add(line);
				linesRequired--;
			}
		}*/
		return lines;
	}
	
	public static int getNumberSequenceCount(ArrayList<Integer> line) {
		List<Integer> sortedLineCopy = getSortedLine(line, new NumberComparator());
		int count = 0;
		for(int i = 0; i < sortedLineCopy.size(); i++) {
			if((i + 1 < sortedLineCopy.size()) && (sortedLineCopy.get(i) + 1) == sortedLineCopy.get(i + 1)) {
				count++;
			}
		}
		return count;
	}

	public static List<Integer> getSortedLine(List<Integer> numbers, Comparator<Integer> cmp) {
		List<Integer> listCopy = getListCopy(numbers);
		Collections.sort(listCopy, cmp);
		return listCopy;
	}

	public static List<Integer> getListCopy(List<Integer> list) {
		return new CopyOnWriteArrayList<Integer>(list);
	}

	public static ArrayList<Integer> getArrayListCopy(List<Integer> list) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(Integer number : list) {
			temp.add(number);
		}
		return temp;
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










