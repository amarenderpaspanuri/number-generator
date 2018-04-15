package com.number.generator.type;

public enum PlayType_Latest {
    OZ("oz",   45, 7, 0,  false, false),
    PB("pb",   40, 7, 20, true,  false),
    SL("sl",   45, 6, 0,  false, false),
    ML("ml",   45, 6, 0,  false, false),
    WL("wl",   45, 6, 0,  false, false),
    SFL("sfl", 37, 8, 0,  false, false);
    
	private String value;
	private int numberLimit;
	private int numbersPerLine;
	private int supplementaryNumberLimit;
	private boolean supplemantaryRequired;
	private boolean duplicatesAllowed;
	
	PlayType_Latest(String value, int numberLimit, int numbersPerLine,
    		int supplementaryNumberLimit, boolean supplemantaryRequired, 
    		boolean duplicatesAllowed) {
    	this.value = value;
    	this.numberLimit = numberLimit;
    	this.numbersPerLine = numbersPerLine;
    	this.supplementaryNumberLimit = supplementaryNumberLimit;
    	this.supplemantaryRequired = supplemantaryRequired;
    	this.duplicatesAllowed = duplicatesAllowed;
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
}
