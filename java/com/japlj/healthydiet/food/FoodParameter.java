package com.japlj.healthydiet.food;

public class FoodParameter {
	public float proteinValue;
	public float carbohydrateValue;
	public float vitaMineValue;
	public float saturation;
	
	public FoodParameter(float protein, float carbo, float vitamine, float satu) {
		this.proteinValue = protein;
		this.carbohydrateValue = carbo;
		this.vitaMineValue = vitamine;
		this.saturation = satu;
	}
	
	private float addValue(float v1, float v2) {
		return Math.min(100.0F, v1 + v2);
	}
	
	public void add(FoodParameter param) {
		proteinValue = addValue(proteinValue, param.proteinValue);
		carbohydrateValue = addValue(carbohydrateValue, param.carbohydrateValue);
		vitaMineValue = addValue(vitaMineValue, param.vitaMineValue);
		saturation = addValue(saturation, param.saturation);
	}
}
