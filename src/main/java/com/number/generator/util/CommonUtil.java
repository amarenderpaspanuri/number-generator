package com.number.generator.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.lang3.StringUtils;

import com.number.generator.comparator.ValueComparator;
import com.number.generator.dto.RandomNumber;
import static com.number.generator.constants.NumberConstants.SUPPLEMENT_REQUIRED;
import static com.number.generator.util.CommonUtil.log;
import static com.number.generator.constants.NumberConstants.MAIN_NUMBER_SIZE;

public final class CommonUtil {

	public static List<ArrayList<RandomNumber>> finalNumbers;
	
	public static String getString(Integer value) {
		return value.toString();
	}
	
	public static int getInt(String value) {
		return Integer.parseInt(value);
	}
	
	public static Integer getNumberWithinMaxRange(Integer number, Integer maxRange) {
		log("getNumberWithinMaxRange() method Start: " + number, false);
		if(number > maxRange) {
			return addDigits(number);
		} else {
			return number;
		}
	}
	
	public static Integer addDigits(Integer number) {
		log("addDigits() method Start: " + number, false);
		String[] array = getString(number).split("");
		int sum = 0;
		for(String item : array) {
			sum += getInt(item);
		}
		log("addDigits() method End: " + sum, false);
		return sum;
	}
	
	public static int getLastDigit(Integer value) {
		log("getLastDigit() method Start: " + value, false);
		int result;
		String[] array = getString(value).split("");
		if(array.length > 1) {
			result = getInt(array[array.length - 1]);
		} else {
			result = value;
		}
		
		log("getLastDigit() method End: " + result, false);
		return result;
	}
	
	public static List<RandomNumber> get_list_copy(List<RandomNumber> list) {
		return new CopyOnWriteArrayList<RandomNumber>(list);
	}
	
	public static List<RandomNumber> get_sub_list(List<RandomNumber> list, int startIndex, int endIndex) {
		List<RandomNumber> result = new ArrayList<RandomNumber>();
		for(int i = startIndex; i < endIndex; i++){
			result.add(list.get(i));
		}
		return result;
	}
	
	public static List<RandomNumber> get_random_numbers_from_list_by_size(List<RandomNumber> list, int size) {
		List<RandomNumber> result = new ArrayList<RandomNumber>();
	    Random rand = new Random();
	    
		int count = 1;
		while (count <= size) {
			int randomIndex = rand.nextInt(list.size());
			RandomNumber randomNumber = list.get(randomIndex);
			if (!listContainsNumber(result, randomNumber)) {
				result.add(randomNumber);
				count++;
			}
		}
	     return result;
	}
	
	public static RandomNumber updateNumber(RandomNumber number, boolean updateWeightage, boolean isEquals,
			boolean isMultiple, boolean isEndsWith, boolean isAddsWith) {

		if (updateWeightage) {
			number.setWeightage(number.getWeightage() + 1);
		}
		if (isMultiple) {
			number.setMultiple(isMultiple);
		}
		if (isEndsWith) {
			number.setEndsWith(isEndsWith);
		}
		if (isEquals) {
			number.setEquals(isEquals);
		}
		if (isAddsWith) {
			number.setAddsWith(isAddsWith);
		}

		log("In updateNumber() method: " + number.getValue(), false);
		return number;
	}
	
	public static void add_to_final_numbers(List<RandomNumber> newNumbers) {
		boolean exists = true;
		if (finalNumbers.isEmpty()) {
			exists = false;
		} else {
			for (ArrayList<RandomNumber> existingList : finalNumbers) {
				exists = listEqualsList(getIntegerList(existingList), getIntegerList(newNumbers));
				if (!exists) {
					break;
				}
			}
		}

		if (!exists) {
			finalNumbers.add((ArrayList<RandomNumber>)newNumbers);
		}
	}
	
	private static List<Integer> getIntegerList(List<RandomNumber> numbers) {
		List<Integer> integerList = new ArrayList<Integer>();
		for(RandomNumber number : numbers) {
			integerList.add(number.getValue());
		}
	    return integerList;
	}
	
	private static boolean listContainsNumber(List<RandomNumber> list, RandomNumber newNumber) {
		for(RandomNumber existingNumber : list) {
			if(existingNumber.getValue() == newNumber.getValue()) {
				return true;
			}
		}
	    return false;
	}
	
	private static boolean listEqualsList(List<Integer> list1, List<Integer> list2) {
	    return new HashSet<Integer>(list1).equals(new HashSet<Integer>(list2));
	}
	
	public static List<RandomNumber> get_sorted_numbers(List<RandomNumber> numbers, Comparator<RandomNumber> cmp) {
		List<RandomNumber> randomNumbersCopy = get_list_copy(numbers);
		Collections.sort(randomNumbersCopy, cmp);
		return randomNumbersCopy;
	}
	
	public static void printNumbers(List<RandomNumber> randomNumbers, boolean flag) {
		for(RandomNumber randomNumber : randomNumbers) {
			printNumber(randomNumber, flag);
		}
	}
	
	public static void printNumber(RandomNumber randomNumber, boolean flag) {
		String message = "value: " + randomNumber.getValue() + 
				", isDefault: " + randomNumber.isDefault() + 
				", isEquals: " + randomNumber.isEquals() + 
				", isMultiple: " + randomNumber.isMultiple() + 
				", isEndsWith: " + randomNumber.isEndsWith() + 
				", isAddsWith: " + randomNumber.isAddsWith() +
				", isAverage: " + randomNumber.isAverage();
		log(message, flag);
	}
	
	public static void printNumbers() {
		log("Total size: " + finalNumbers.size(), true);
		for (ArrayList<RandomNumber> numbers : finalNumbers) {
			
			RandomNumber supplemantaryNumber = null;
			if(SUPPLEMENT_REQUIRED && numbers.size() > MAIN_NUMBER_SIZE) {
				supplemantaryNumber = numbers.get(numbers.size() - 1);
				numbers.remove(numbers.size() - 1);
			}
			
			String numbersStr = null;
			if(supplemantaryNumber != null) {
				numbersStr = StringUtils.join(numbers, " | ") + " | --> " + supplemantaryNumber;
			} else {
				numbersStr = StringUtils.join(numbers, " | ");
			}
			log(numbersStr, true);
			//log("", true);
		}
	}
	
	public static void log(String message, boolean flag) {
		if(flag) {
			System.out.println(message);
		}
	}
}
