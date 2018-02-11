package com.number.generator;

import static com.number.generator.constants.NumberConstants.MAX_MAIN_NUMBERS;
import static com.number.generator.util.ColumnUtil.generate_column_numbers;
import static com.number.generator.util.CommonUtil.printNumbers;
import static com.number.generator.util.DateUtil.add_dates_weightage;
import static com.number.generator.util.DozenUtil.generate_dozen_numbers;
import static com.number.generator.util.WeightageUtil.add_my_weightage;
import static com.number.generator.util.WeightageUtil.add_system_weightage;
import static com.number.generator.util.WeightageUtil.generate_weightage_numbers;
import static com.number.generator.util.FlagUtil.generate_flag_numbers;
import static com.number.generator.constants.NumberConstants.USE_DATES;
import static com.number.generator.constants.NumberConstants.SUPPLEMENT_REQUIRED;
import static com.number.generator.util.SupplementaryUtil.generate_supplementary_number;
import static com.number.generator.constants.NumberConstants.GENERATE_WEIGHTAGE_NUMBERS;
import static com.number.generator.constants.NumberConstants.GENERATE_COLUMN_NUMBERS;
import static com.number.generator.constants.NumberConstants.GENERATE_DOZEN_NUMBERS;
import static com.number.generator.constants.NumberConstants.GENERATE_FLAG_NUMBERS;
import static com.number.generator.constants.NumberConstants.ADD_SYSTEM_WEIGHTAGE;
import static com.number.generator.constants.NumberConstants.ADD_MY_WEIGHTAGE;
import java.util.ArrayList;
import java.util.List;

import com.number.generator.dto.RandomNumber;
import com.number.generator.util.ColumnUtil;
import com.number.generator.util.CommonUtil;
import com.number.generator.util.DateUtil;
import com.number.generator.util.DozenUtil;
import com.number.generator.util.FlagUtil;
import com.number.generator.util.SupplementaryUtil;
import com.number.generator.util.WeightageUtil;

public class NumberGenerator {

	private static ArrayList<RandomNumber> randomNumbers;
	private static List<ArrayList<RandomNumber>> finalNumbers;

	public static void main(String[] args) {
		initialize();
		
		//assign numbers to util classes
		add_intial_numbers();
				
		//add system/my/date weightages
		add_weightages();
		
		generateNumbers();
		
		if(SUPPLEMENT_REQUIRED) {
			generate_supplementary_number();
		}
		
		printNumbers();
	}
	
	private static void initialize() {
		finalNumbers = new ArrayList<ArrayList<RandomNumber>>();
		CommonUtil.finalNumbers = finalNumbers;
		
		randomNumbers = new ArrayList<RandomNumber>();
		WeightageUtil.randomNumbers = randomNumbers;
		DateUtil.randomNumbers = randomNumbers;
		ColumnUtil.randomNumbers = randomNumbers;
		DozenUtil.randomNumbers = randomNumbers;
		FlagUtil.randomNumbers = randomNumbers;
		SupplementaryUtil.finalNumbers = finalNumbers;
	}
	
	private static void add_intial_numbers() {
		for(int i=1; i <= MAX_MAIN_NUMBERS; i++) {
			RandomNumber randomNumber = new RandomNumber();
			randomNumber.setValue(i);
			randomNumbers.add(randomNumber);
		}
	}
	
	private static void add_weightages() {
		if(ADD_SYSTEM_WEIGHTAGE) {
			add_system_weightage();
		}
		
		if(ADD_MY_WEIGHTAGE) {
			add_my_weightage();
		}
		
		if(USE_DATES) {
			add_dates_weightage();
		}
	}

	private static void generateNumbers() {
		//rules
		
		// Weightage - 14
		if(GENERATE_WEIGHTAGE_NUMBERS) {
			generate_weightage_numbers();
		}
		
		
		//columns - 6
		if(GENERATE_COLUMN_NUMBERS) {
			generate_column_numbers();
		}
		
		
		//3. dozens - 6
		if(GENERATE_DOZEN_NUMBERS) {
			generate_dozen_numbers();
		}
		
		//4. isDefault/ isEquals / isEndsWith/ isAddsWith/ isMultiple - 11
		if(GENERATE_FLAG_NUMBERS) {
			generate_flag_numbers();
		}
	}
}
