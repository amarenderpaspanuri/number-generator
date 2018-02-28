package com.number.generator.type;

public enum PlayType {
    OZ("oz",   45, 7, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 0,  false, false, 0.7f, 1.6f, 1.1),
    PB("pb",   40, 7, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 20, true,  false, 0.7f, 1.6f, 1.3),
    SL("sl",   45, 6, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 0,  false, false, 0.7f, 1.6f, 1.3),
    ML("ml",   45, 6, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 0,  false, false, 0.7f, 1.6f, 1.3),
    WL("wl",   45, 6, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 0,  false, false, 0.7f, 1.6f, 1.3),
    SFL("sfl", 37, 8, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 0,  false, false, 0.7f, 1.6f, 1.3);
    
	private String value;
	private int numberLimit;
	private int numbersPerLine;
	private int requiredLines;
	private int repetitions;
	private int supplementaryNumberLimit;
	private boolean supplemantaryRequired;
	private boolean duplicatesAllowed;
	private float minNumberOccuranceFactor;
	private float maxNumberOccuranceFactor;
	private double rulesFactor;
	
    PlayType(String value, int numberLimit, int numbersPerLine, int requiredLines, int repetitions,
    		int supplementaryNumberLimit, boolean supplemantaryRequired, boolean duplicatesAllowed, 
    		float minNumberOccuranceFactor, float maxNumberOccuranceFactor, double rulesFactor) {
    	this.value = value;
    	this.numberLimit = numberLimit;
    	this.numbersPerLine = numbersPerLine;
    	this.requiredLines = requiredLines;
    	this.repetitions = repetitions;
    	this.supplementaryNumberLimit = supplementaryNumberLimit;
    	this.supplemantaryRequired = supplemantaryRequired;
    	this.duplicatesAllowed = duplicatesAllowed;
    	this.minNumberOccuranceFactor = minNumberOccuranceFactor;
    	this.maxNumberOccuranceFactor = maxNumberOccuranceFactor;
    	this.rulesFactor = rulesFactor;
    }
    
    private static class Constants {
        public static final int LINES_REQUIRED = 0;
        public static final int NUMBER_OF_REPETITIONS = 1;
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

	public int getRequiredLines() {
		return requiredLines;
	}

	public void setRequiredLines(int requiredLines) {
		this.requiredLines = requiredLines;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public int getSupplementaryNumberLimit() {
		return supplementaryNumberLimit;
	}

	public void setSupplementaryNumberLimit(int supplementaryNumberLimit) {
		this.supplementaryNumberLimit = supplementaryNumberLimit;
	}

	public boolean isSupplemantaryRequired() {
		return supplemantaryRequired;
	}

	public void setSupplemantaryRequired(boolean supplemantaryRequired) {
		this.supplemantaryRequired = supplemantaryRequired;
	}

	public boolean isDuplicatesAllowed() {
		return duplicatesAllowed;
	}

	public void setDuplicatesAllowed(boolean duplicatesAllowed) {
		this.duplicatesAllowed = duplicatesAllowed;
	}

	public float getMinNumberOccuranceFactor() {
		return minNumberOccuranceFactor;
	}

	public void setMinNumberOccuranceFactor(float minNumberOccuranceFactor) {
		this.minNumberOccuranceFactor = minNumberOccuranceFactor;
	}

	public float getMaxNumberOccuranceFactor() {
		return maxNumberOccuranceFactor;
	}

	public void setMaxNumberOccuranceFactor(float maxNumberOccuranceFactor) {
		this.maxNumberOccuranceFactor = maxNumberOccuranceFactor;
	}

	public double getRulesFactor() {
		return rulesFactor;
	}

	public void setRulesFactor(double rulesFactor) {
		this.rulesFactor = rulesFactor;
	}
}
