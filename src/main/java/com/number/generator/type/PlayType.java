package com.number.generator.type;

public enum PlayType {
    OZ("oz",   45, 7, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 0,  false, false, 0.7f, 1.4f, 3, 5, 3, 4),
    PB("pb",   40, 7, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 20, true,  false, 0.7f, 1.4f, 3, 5, 3, 4),
    SL("sl",   45, 6, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 0,  false, false, 0.7f, 1.4f, 3, 4, 3, 4),
    ML("ml",   45, 6, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 0,  false, false, 0.7f, 1.4f, 3, 4, 3, 4),
    WL("wl",   45, 6, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 0,  false, false, 0.7f, 1.4f, 3, 4, 3, 4),
    SFL("sfl", 37, 8, Constants.LINES_REQUIRED, Constants.NUMBER_OF_REPETITIONS, 0,  false, false, 0.7f, 1.4f, 3, 6, 4, 4);
    
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
	
	private int minSingleRuleCount;
	private int maxSingleRuleCount;
	
	private int minMultiRuleCount;
	private int maxMultiRuleCount;
	
    PlayType(String value, int numberLimit, int numbersPerLine, int requiredLines, int repetitions,
    		int supplementaryNumberLimit, boolean supplemantaryRequired, boolean duplicatesAllowed, 
    		float minNumberOccuranceFactor, float maxNumberOccuranceFactor, 
    		int minSingleRuleCount, int maxSingleRuleCount,
    		int minMultiRuleCount, int maxMultiRuleCount) {
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
    	this.minSingleRuleCount = minSingleRuleCount;
    	this.maxSingleRuleCount = maxSingleRuleCount;
    	this.minMultiRuleCount = minMultiRuleCount;
    	this.maxMultiRuleCount = maxMultiRuleCount;
    }
    
    public static class Constants {
        public static final int LINES_REQUIRED = 50;
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

	public int getMinSingleRuleCount() {
		return minSingleRuleCount;
	}

	public void setMinSingleRuleCount(int minSingleRuleCount) {
		this.minSingleRuleCount = minSingleRuleCount;
	}

	public int getMaxSingleRuleCount() {
		return maxSingleRuleCount;
	}

	public void setMaxSingleRuleCount(int maxSingleRuleCount) {
		this.maxSingleRuleCount = maxSingleRuleCount;
	}

	public int getMinMultiRuleCount() {
		return minMultiRuleCount;
	}

	public void setMinMultiRuleCount(int minMultiRuleCount) {
		this.minMultiRuleCount = minMultiRuleCount;
	}

	public int getMaxMultiRuleCount() {
		return maxMultiRuleCount;
	}

	public void setMaxMultiRuleCount(int maxMultiRuleCount) {
		this.maxMultiRuleCount = maxMultiRuleCount;
	}
}
