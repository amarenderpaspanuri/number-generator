package com.number.generator.util;

import static com.number.generator.constants.NumberConstants.MAX_MAIN_NUMBERS;
import static com.number.generator.constants.NumberConstants.USE_FLAG;
import static com.number.generator.util.CommonUtil.addDigits;
import static com.number.generator.util.CommonUtil.getInt;
import static com.number.generator.util.CommonUtil.getLastDigit;
import static com.number.generator.util.CommonUtil.getString;
import static com.number.generator.util.CommonUtil.log;
import static com.number.generator.util.CommonUtil.updateNumber;
import static com.number.generator.constants.NumberConstants.DATES;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.number.generator.dto.RandomNumber;

public final class DateUtil {

	public static List<RandomNumber> randomNumbers;
	
	private final static boolean printFlag = false;
	
	public static void add_dates_weightage() {
		for (String date : DATES) {
			String[] array = date.split("-");
			int day = getInt(array[0]);
			int month = getInt(array[1]);
			int year = getInt(array[2]);

			// day
			updateWeightage(day);

			// month
			updateWeightage(month);

			// day + month
			updateWeightage(day + month);

			// year
			updateWeightage(year);

			// day + month + year
			updateWeightage(day + month + year);

			LocalDate today = LocalDate.now();
			LocalDate birthday = LocalDate.of(year, month, day);
			Period period = Period.between(birthday, today);

			day = period.getDays();
			month = period.getMonths();
			year = period.getYears();

			// day
			updateWeightage(day);

			// month
			updateWeightage(month);

			// day + month
			updateWeightage(day + month);

			// year
			updateWeightage(year);

			// day + month + year
			updateWeightage(day + month + year);
		}
	}

	private static void updateWeightage(int value) {
		log("updateWeightage() method Start: " + value, printFlag);
		int tempNumber;
		List<Integer> list = new ArrayList<Integer>();
		if (value <= 9) {
			list.add(value);
		} else if (value <= MAX_MAIN_NUMBERS) {
			list.add(value);
			list.add(getLastDigit(value));
			tempNumber = addDigits(value);
			list.add(tempNumber);
			if (tempNumber != getLastDigit(tempNumber)) {
				list.add(getLastDigit(tempNumber));
			}
		} else {
			if (value <= 99) {
				tempNumber = addDigits(value);
				list.add(tempNumber);
				if (tempNumber != getLastDigit(tempNumber)) {
					list.add(getLastDigit(tempNumber));
				}
			} else if (value <= 999) {
				tempNumber = addDigits(value);
				list.add(tempNumber);
				if (tempNumber != getLastDigit(tempNumber)) {
					list.add(getLastDigit(tempNumber));
				}
			} else if (value <= 9999) {
				tempNumber = addDigits(value);
				list.add(tempNumber);
				if (tempNumber != getLastDigit(tempNumber)) {
					list.add(getLastDigit(tempNumber));
				}
			}
		}

		for (int number : list) {
			isEquals(number);
			isMultiple(number);
			isEndsWith(number);
			isAddsWith(number);
		}
	}

	private static void isEquals(Integer value) {
		log("In isEquals() method: " + value, printFlag);
		for (RandomNumber randomNumber : randomNumbers) {
			if ((randomNumber.getValue() == value)) {
				updateNumber(randomNumber, false, USE_FLAG, false, false, false);
			}
		}
	}

	private static void isMultiple(Integer value) {
		log("In isMultiple() method: " + value, printFlag);
		if (value > 1) {
			for (RandomNumber randomNumber : randomNumbers) {
				if ((randomNumber.getValue() % value) == 0 && (randomNumber.getValue() != value)) {
					updateNumber(randomNumber, false, false, USE_FLAG, false, false);
				}
			}
		}
	}

	private static void isEndsWith(Integer value) {
		log("isEndsWith() method Start: " + value, printFlag);
		for (RandomNumber randomNumber : randomNumbers) {
			String[] array = getString(randomNumber.getValue()).split("");
			if (array[array.length - 1].equals(getString(value))) {
				updateNumber(randomNumber, false, false, false, USE_FLAG, false);
			}
		}
	}

	private static void isAddsWith(Integer value) {
		log("In addDigitsWith() method: " + value, printFlag);
		for (RandomNumber randomNumber : randomNumbers) {
			if (randomNumber.getValue() > 9 && value == addDigits(randomNumber.getValue())) {
				updateNumber(randomNumber, false, false, false, false, USE_FLAG);
			}
		}
	}
}
