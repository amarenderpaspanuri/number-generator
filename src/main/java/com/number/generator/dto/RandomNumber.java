package com.number.generator.dto;

import static com.number.generator.util.CommonUtil.getString;

public class RandomNumber implements Comparable<RandomNumber> {
	
	int value;
	int weightage;
	boolean isDefault;
	boolean isEquals;
	boolean isMultiple;
	boolean isEndsWith;
	boolean isAddsWith;
	boolean isAverage;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getWeightage() {
		return weightage;
	}
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	public boolean isMultiple() {
		return isMultiple;
	}
	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}
	public boolean isEndsWith() {
		return isEndsWith;
	}
	public void setEndsWith(boolean isEndsWith) {
		this.isEndsWith = isEndsWith;
	}
	public boolean isEquals() {
		return isEquals;
	}
	public void setEquals(boolean isEquals) {
		this.isEquals = isEquals;
	}
	public boolean isAddsWith() {
		return isAddsWith;
	}
	public void setAddsWith(boolean isAddsWith) {
		this.isAddsWith = isAddsWith;
	}
	public boolean isAverage() {
		return isAverage;
	}
	public void setAverage(boolean isAverage) {
		this.isAverage = isAverage;
	}
	
	public int compareTo(RandomNumber randomNumber) {

		int value = randomNumber.getValue();

		//ascending order
		return this.value - value;

		//descending order
		//return compareQuantity - this.quantity;

	}
	
	@Override
	public String toString() {
		return getString(value);
	}
}
