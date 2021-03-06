package com.japlj.healthydiet.food;

import com.japlj.healthydiet.ModConfig;

/* 食料の持つパラメタ (3種の栄養素と満腹度) */
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
		return Math.min(ModConfig.MAX_NUTRITION_VALUE, v1 + v2);
	}
	
	public void add(FoodParameter param) {
		proteinValue = addValue(proteinValue, param.proteinValue);
		carbohydrateValue = addValue(carbohydrateValue, param.carbohydrateValue);
		vitaMineValue = addValue(vitaMineValue, param.vitaMineValue);
		saturation = addValue(saturation, param.saturation);
	}
}
