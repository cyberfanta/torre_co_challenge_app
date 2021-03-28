package com.cyberfanta.torre_co_challenge_app.models.job;

public class Value{
	private int minValue;
	private String type;
	private int maxValue;
	private String unitText;

	public void setMinValue(int minValue){
		this.minValue = minValue;
	}

	public int getMinValue(){
		return minValue;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setMaxValue(int maxValue){
		this.maxValue = maxValue;
	}

	public int getMaxValue(){
		return maxValue;
	}

	public void setUnitText(String unitText){
		this.unitText = unitText;
	}

	public String getUnitText(){
		return unitText;
	}

	@Override
 	public String toString(){
		return 
			"Value{" + 
			"minValue = '" + minValue + '\'' + 
			",@type = '" + type + '\'' + 
			",maxValue = '" + maxValue + '\'' + 
			",unitText = '" + unitText + '\'' + 
			"}";
		}
}
