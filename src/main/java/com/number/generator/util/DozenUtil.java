package com.number.generator.util;

import static com.number.generator.constants.NumberConstants.DOZEN_SIZE;
import static com.number.generator.constants.NumberConstants.MAIN_NUMBER_SIZE;
import static com.number.generator.constants.NumberConstants.MIN_DOZEN_NUMBERS;
import static com.number.generator.util.CommonUtil.add_to_final_numbers;
import static com.number.generator.util.CommonUtil.get_list_copy;
import static com.number.generator.util.CommonUtil.get_random_numbers_from_list_by_size;
import static com.number.generator.util.CommonUtil.get_sorted_numbers;
import static com.number.generator.util.CommonUtil.get_sub_list;

import java.util.List;

import com.number.generator.comparator.WeightageComparator;
import com.number.generator.dto.RandomNumber;

public final class DozenUtil {

	public static List<RandomNumber> randomNumbers;
	
	/* 6 numbers*/
	public static void generate_dozen_numbers(){
		generate_numbers(randomNumbers);
		
		List<RandomNumber> randomNumbersCopy = get_sorted_numbers(get_list_copy(randomNumbers), new WeightageComparator());
		generate_numbers(randomNumbersCopy);
	}
	
	private static void generate_numbers(List<RandomNumber> numbers){
		List<RandomNumber> firstDozenNumbers = get_sub_list(numbers, 0, DOZEN_SIZE);
		List<RandomNumber> secondDozenNumbers = get_sub_list(numbers, DOZEN_SIZE, 2 * DOZEN_SIZE);
		List<RandomNumber> thirdDozenNumbers = get_sub_list(numbers, 2 * DOZEN_SIZE, 3 * DOZEN_SIZE);
		
		int diff = MAIN_NUMBER_SIZE - MIN_DOZEN_NUMBERS;
		List<RandomNumber> list = get_random_numbers_from_list_by_size(firstDozenNumbers, MIN_DOZEN_NUMBERS);
		list.addAll(get_random_numbers_from_list_by_size(secondDozenNumbers, diff/2));
		list.addAll(get_random_numbers_from_list_by_size(thirdDozenNumbers, diff/2));
		add_to_final_numbers(list);
		
		list = get_random_numbers_from_list_by_size(secondDozenNumbers, MIN_DOZEN_NUMBERS);
		list.addAll(get_random_numbers_from_list_by_size(firstDozenNumbers, diff/2));
		list.addAll(get_random_numbers_from_list_by_size(thirdDozenNumbers, diff/2));
		add_to_final_numbers(list);
		
		list = get_random_numbers_from_list_by_size(thirdDozenNumbers, MIN_DOZEN_NUMBERS);
		list.addAll(get_random_numbers_from_list_by_size(firstDozenNumbers, diff/2));
		list.addAll(get_random_numbers_from_list_by_size(secondDozenNumbers, diff/2));
		add_to_final_numbers(list);
	}
}
