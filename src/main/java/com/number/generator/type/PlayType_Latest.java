package com.number.generator.type;

public enum PlayType_Latest {
    OZ("oz",   45, 7, 1, 0, 3),
    PB("pb",   35, 8, 3, 1, 3),
    SL("sl",   45, 6, 2, 0, 3),
    ML("ml",   45, 6, 2, 1, 3),
    WL("wl",   45, 6, 2, 1, 3),
    SFL("sfl", 37, 8, 3, 2, 3);
    
	private String value;
	private int numberLimit;
	private int numbersPerLine;
	private int initialNumbersCount;
	private int allowedNumberSequenceCount;
	private int randomNumberCount;
	
	PlayType_Latest(String value, int numberLimit, int numbersPerLine, int initialNumbersCount, int allowedNumberSequenceCount, int randomNumberCount) {
    	this.value = value;
    	this.numberLimit = numberLimit;
    	this.numbersPerLine = numbersPerLine;
    	this.initialNumbersCount = initialNumbersCount;
    	this.allowedNumberSequenceCount = allowedNumberSequenceCount;
    	this.randomNumberCount = randomNumberCount;
	}
    
    public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getNumberLimit() {
		return numberLimit;
	}

	public void setNumberLimit(int numberLimit) {
		this.numberLimit = numberLimit;
	}

	public int getNumbersPerLine() {
		return numbersPerLine;
	}

	public void setNumbersPerLine(int numbersPerLine) {
		this.numbersPerLine = numbersPerLine;
	}

	public int getRandomNumberCount() {
		return randomNumberCount;
	}

	public void setRandomNumberCount(int randomNumberCount) {
		this.randomNumberCount = randomNumberCount;
	}

	public int getInitialNumbersCount() {
		return initialNumbersCount;
	}

	public void setInitialNumbersCount(int initialNumbersCount) {
		this.initialNumbersCount = initialNumbersCount;
	}

	public int getAllowedNumberSequenceCount() {
		return allowedNumberSequenceCount;
	}

	public void setAllowedNumberSequenceCount(int allowedNumberSequenceCount) {
		this.allowedNumberSequenceCount = allowedNumberSequenceCount;
	}
}
