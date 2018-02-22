package com.number.generator.util;

import java.util.ArrayList;
import java.util.List;

import com.number.generator.dto.RandomNumber;

import static com.number.generator.util.CommonUtil.add_to_final_numbers;
import static com.number.generator.util.CommonUtil.get_list_copy;
import static com.number.generator.util.CommonUtil.get_random_numbers_from_list_by_size;
import static com.number.generator.util.CommonUtil.get_sorted_numbers;
import static com.number.generator.util.CommonUtil.log;
import static com.number.generator.constants.NumberConstants.MAIN_NUMBER_SIZE;
import static com.number.generator.constants.NumberConstants.MIN_COLUMN_NUMBERS;

public final class FlagUtil {

	public static List<RandomNumber> randomNumbers;
	
	private final static boolean printFlag = false;
	
	public static void generate_flag_numbers(){
		printNumbers(randomNumbers, "");
		generate_all_true_numbers();
		generate_is_equals_numbers();
		generate_is_multiple_numbers();
		generate_is_ends_with_numbers();
		generate_is_adds_with_numbers();
		generate_isDefault_isEquals_numbers();
		generate_isDefault_isMultiple_numbers();
		generate_isDefault_isAddsWIth_numbers();
		generate_isEquals_isMultiple_numbers();
		generate_isEquals_isAddsWith_numbers();
		generate_all_false_numbers();
	}
	
	private static void generate_all_true_numbers(){
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(randomNumber.isDefault() 
					&& randomNumber.isEquals() 
					&& randomNumber.isMultiple() 
					&& randomNumber.isEndsWith() 
					&& randomNumber.isAddsWith()) {
				selectedNumbers.add(randomNumber);
			}
		}
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "All true flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	private static void generate_is_equals_numbers(){
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(randomNumber.isEquals()) {
				selectedNumbers.add(randomNumber);
			}
		}
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "isEquals flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	private static void generate_is_multiple_numbers(){
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(randomNumber.isMultiple()) {
				selectedNumbers.add(randomNumber);
			}
		}
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "isMultiple flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	private static void generate_is_ends_with_numbers(){
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(randomNumber.isEndsWith()) {
				selectedNumbers.add(randomNumber);
			}
		}
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "isEndsWith flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	private static void generate_is_adds_with_numbers(){
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(randomNumber.isAddsWith()) {
				selectedNumbers.add(randomNumber);
			}
		}
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "isAddsWith flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	private static void generate_isDefault_isEquals_numbers() {
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(randomNumber.isDefault() && randomNumber.isEquals()) {
				selectedNumbers.add(randomNumber);
			}
		}
		
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "isDefault and isEquals flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	private static void generate_isDefault_isMultiple_numbers() {
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(randomNumber.isDefault() && randomNumber.isMultiple()) {
				selectedNumbers.add(randomNumber);
			}
		}
		
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "isDefault and isMultiple flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	private static void generate_isDefault_isAddsWIth_numbers() {
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(randomNumber.isDefault() && randomNumber.isAddsWith()) {
				selectedNumbers.add(randomNumber);
			}
		}
		
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "isDefault and isAddsWIth flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	private static void generate_isEquals_isMultiple_numbers() {
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(randomNumber.isEquals() && randomNumber.isMultiple()) {
				selectedNumbers.add(randomNumber);
			}
		}
		
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "isEquals and isMultiple flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	private static void generate_isEquals_isAddsWith_numbers() {
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(randomNumber.isEquals() && randomNumber.isAddsWith()) {
				selectedNumbers.add(randomNumber);
			}
		}
		
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "isEquals and isAddsWith flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	private static void generate_all_false_numbers() {
		List<RandomNumber> randomNumbersCopy = get_list_copy(randomNumbers);
		List<RandomNumber> selectedNumbers = new ArrayList<RandomNumber>();
		for(RandomNumber randomNumber : randomNumbersCopy) {
			if(!randomNumber.isDefault() 
					&& !randomNumber.isEquals() 
					&& !randomNumber.isMultiple() 
					&& !randomNumber.isEndsWith() 
					&& !randomNumber.isAddsWith()) {
				selectedNumbers.add(randomNumber);
			}
		}
		
		randomNumbersCopy.removeAll(selectedNumbers);
		if(selectedNumbers.size() < MAIN_NUMBER_SIZE) {
			int diff = MAIN_NUMBER_SIZE - selectedNumbers.size();
			selectedNumbers.addAll(get_random_numbers_from_list_by_size(randomNumbersCopy, diff));
		}
		printNumbers(selectedNumbers, "All false flags size: ");
		add_to_final_numbers(get_random_numbers_from_list_by_size(selectedNumbers, MAIN_NUMBER_SIZE));
	}
	
	public static void printNumbers(List<RandomNumber> selectedNumbers, String str) {
		log(str + selectedNumbers.size(), printFlag);
		for(RandomNumber randomNumber : selectedNumbers) {
			String message = "value: " + randomNumber.getValue() + 
					", isDefault: " + randomNumber.isDefault() + 
					", isEquals: " + randomNumber.isEquals() + 
					", isMultiple: " + randomNumber.isMultiple() + 
					", isEndsWith: " + randomNumber.isEndsWith() + 
					", isAddsWith: " + randomNumber.isAddsWith();
			log(message, printFlag);
		}
	}
}
