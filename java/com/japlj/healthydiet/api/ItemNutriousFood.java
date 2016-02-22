package com.japlj.healthydiet.api;

import com.japlj.healthydiet.food.FoodParameter;

import net.minecraft.item.ItemFood;

/*
 * 栄養素情報が設定された食料
 */
public class ItemNutriousFood extends ItemFood {
	private final FoodParameter param;
	
	public ItemNutriousFood(float protein, float carbohydrate, float vitaMine, float satu, boolean feedWolves) {
		super(0, 0.0F, feedWolves);
		param = new FoodParameter(protein, carbohydrate, vitaMine, satu);
	}
	
	public FoodParameter getNutritionalValues() {
		return param;
	}
}
