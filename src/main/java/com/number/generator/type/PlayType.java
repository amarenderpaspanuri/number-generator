package com.number.generator.type;

public enum PlayType {
    OZ("oz",   45, 7, Constants.DEFAULT_LINES, Constants.DEFAULT_REPETITIONS, 0,  false, false, 0.7f, 1.4f, 3, 5, 3, 5, 6,
    		"1-13-16-27-42-20",
    		"1-16, 14-37, 1-36, 11-13, 13-21",
    		"16-17-21, 5-25-34, 28-32-40, 7-10-28, 17-22-26"),
    PB("pb",   40, 7, Constants.DEFAULT_LINES, Constants.DEFAULT_REPETITIONS, 20, true,  false, 0.7f, 1.4f, 3, 5, 3, 5, 6,
    		"",
    		"",
    		""),
    SL("sl",   45, 6, Constants.DEFAULT_LINES, Constants.DEFAULT_REPETITIONS, 0,  false, false, 0.7f, 1.4f, 3, 5, 3, 5, 6,
    		"",
    		"",
    		""),
    ML("ml",   45, 6, Constants.DEFAULT_LINES, Constants.DEFAULT_REPETITIONS, 0,  false, false, 0.7f, 1.4f, 3, 5, 3, 5, 6,
    		"",
    		"",
    		""),
    WL("wl",   45, 6, Constants.DEFAULT_LINES, Constants.DEFAULT_REPETITIONS, 0,  false, false, 0.7f, 1.4f, 3, 5, 3, 5, 6,
    		"",
    		"",
    		""),
    SFL("sfl", 37, 8, Constants.DEFAULT_LINES, Constants.DEFAULT_REPETITIONS, 0,  false, false, 0.7f, 1.4f, 3, 6, 4, 6, 6,
    		"",
    		"",
    		"");
    
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

	private int minTotalRuleCount;
	
	private String singles;
	private String doubles;
	private String triples;
	
    PlayType(String value, int numberLimit, int numbersPerLine, int requiredLines, int repetitions,
    		int supplementaryNumberLimit, boolean supplemantaryRequired, boolean duplicatesAllowed, 
    		float minNumberOccuranceFactor, float maxNumberOccuranceFactor, 
    		int minSingleRuleCount, int maxSingleRuleCount,
    		int minMultiRuleCount, int maxMultiRuleCount,
			 int minTotalRuleCount,
			 String singles, String doubles, String triples) {
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
		this.minTotalRuleCount = minTotalRuleCount;
		
		this.singles = singles;
		this.doubles = doubles;
		this.triples = triples;
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

	public int getMinTotalRuleCount() {
		return minTotalRuleCount;
	}

	public void setMinTotalRuleCount(int minTotalRuleCount) {
		this.minTotalRuleCount = minTotalRuleCount;
	}
	
	public static class Constants {
        public static final int DEFAULT_LINES = 0;
        public static final int DEFAULT_REPETITIONS = 1;
    }

	public String getSingles() {
		return singles;
	}

	public void setSingles(String singles) {
		this.singles = singles;
	}

	public String getDoubles() {
		return doubles;
	}

	public void setDoubles(String doubles) {
		this.doubles = doubles;
	}

	public String getTriples() {
		return triples;
	}

	public void setTriples(String triples) {
		this.triples = triples;
	}
}
