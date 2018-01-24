package com.number.generator.util;

import static com.number.generator.constants.NumberConstants.MAIN_NUMBER_SIZE;
import static com.number.generator.constants.NumberConstants.MAX_MAIN_NUMBERS;
import static com.number.generator.constants.NumberConstants.MIN_WEIGHTAGE_NUMBERS;
import static com.number.generator.constants.NumberConstants.MY_WEIGHTAGE;
import static com.number.generator.constants.NumberConstants.SYSTEM_WEIGHTAGE;
import static com.number.generator.util.CommonUtil.add_to_final_numbers;
import static com.number.generator.util.CommonUtil.get_list_copy;
import static com.number.generator.util.CommonUtil.get_random_numbers_from_list_by_size;
import static com.number.generator.util.CommonUtil.get_sorted_numbers;
import static com.number.generator.util.CommonUtil.get_sub_list;
import static com.number.generator.util.CommonUtil.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.number.generator.comparator.WeightageComparator;
import com.number.generator.dto.RandomNumber;

public final class WeightageUtil {

	public static List<RandomNumber> randomNumbers;
	
	private static final boolean printFlag = false;
	
	public static void add_system_weightage() {
		for(Map.Entry<Integer, Integer> entry : SYSTEM_WEIGHTAGE.entrySet()) {
			if(entry.getKey() <= MAX_MAIN_NUMBERS ) {
				RandomNumber randomNumber = randomNumbers.get(entry.getKey() - 1);
				randomNumber.setWeightage(entry.getValue());
			}
		}
	}

	public static void add_my_weightage() {
		for(Map.Entry<Integer, Integer> entry : MY_WEIGHTAGE.entrySet()) {
			if(entry.getKey() <= MAX_MAIN_NUMBERS ) {
				RandomNumber randomNumber = randomNumbers.get(entry.getKey() - 1);
				randomNumber.setWeightage(randomNumber.getWeightage() + entry.getValue());
				if(entry.getValue() != 0) {
					randomNumber.setDefault(true);
				}
			}
		}
	}
	
	public static void generate_weightage_numbers() {
		generate_sorted_weightage_numbers();
		generate_sorted_shuffled_weightage_numbers();
	}
	
	private static void generate_sorted_weightage_numbers() {
		List<RandomNumber> randomNumbersCopy = get_sorted_numbers(get_list_copy(randomNumbers), new WeightageComparator());
		
		int times = MAX_MAIN_NUMBERS / MAIN_NUMBER_SIZE;
		int reminder = MAX_MAIN_NUMBERS % MAIN_NUMBER_SIZE;
		
		int startIndex = 0; 
		int endIndex = MAIN_NUMBER_SIZE;
		while(endIndex < MAX_MAIN_NUMBERS) {
			add_to_final_numbers(get_sub_list(randomNumbersCopy, startIndex, endIndex));
			startIndex = endIndex;
			endIndex = startIndex + MAIN_NUMBER_SIZE;
		}
		
		int size = MAIN_NUMBER_SIZE - reminder;
		List<RandomNumber> remainderItems = get_sub_list(randomNumbersCopy, startIndex, startIndex + reminder);
		List<RandomNumber> extraItems = get_random_numbers_from_list_by_size(get_sub_list(randomNumbersCopy, 0, startIndex), size);
		remainderItems.addAll(extraItems);
		add_to_final_numbers(remainderItems);
	}
	
	private static void generate_sorted_shuffled_weightage_numbers() {
		List<RandomNumber> randomNumbersCopy = get_sorted_numbers(get_list_copy(randomNumbers), new WeightageComparator());
		
		List<ArrayList<RandomNumber>> listOfList = new ArrayList<ArrayList<RandomNumber>>();
		int startIndex = 0; 
		int endIndex = MAIN_NUMBER_SIZE;
		while(true) {
			listOfList.add((ArrayList<RandomNumber>)get_sub_list(randomNumbersCopy, startIndex, endIndex));
			startIndex = endIndex;
			endIndex = startIndex + MAIN_NUMBER_SIZE;
			if(endIndex > MAX_MAIN_NUMBERS) {
				listOfList.add((ArrayList<RandomNumber>)get_sub_list(randomNumbersCopy, startIndex, MAX_MAIN_NUMBERS));
				break;
			}
		}
		
		for(int i=0; i < listOfList.size(); i++) {
			List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
			ArrayList<RandomNumber> list = listOfList.get(i);
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(list, MIN_WEIGHTAGE_NUMBERS));
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(listOfList.get(get_random_index(listOfList.size(), i)), 
					MAIN_NUMBER_SIZE - MIN_WEIGHTAGE_NUMBERS));
			add_to_final_numbers(selectedNumbers);
		}
	}

	public static int get_random_index(int size, int currentIndex) {
		Random rand = new Random();
		
		int newIndex = -1;
		
		while(newIndex == -1 || newIndex == currentIndex) {
			newIndex = rand.nextInt(size);
		}
		
		log("Random Index: " + newIndex, printFlag);
		return newIndex;
	}
	
	/*public static List<RandomNumber> generateNumbers(List<RandomNumber> list) {
		List<RandomNumber> result = new ArrayList<RandomNumber>();
	    Random rand = new Random();
	    
		while (result.size() < MAIN_NUMBER_SIZE) {
			int randomIndex = rand.nextInt(list.size());
			RandomNumber randomNumber = list.get(randomIndex);
			if (!result.contains(randomNumber)) {
				result.add(randomNumber);
			}
		}
	    log(result.toString(), true);
	    return result;
	}*/
}
