package com.japlj.healthydiet.api;

import com.japlj.healthydiet.food.FoodParameter;
import com.japlj.healthydiet.food.FoodParameterManager;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public final class NutritionUtils {
	private NutritionUtils() { }
	
	/*
	 * アイテム item に栄養素情報が設定されているか
	 */
	public static boolean hasNutritionalInfo(ItemStack items) {
		if (!(items.getItem() instanceof ItemFood)) {
			return false;
		}
		
		if (items.getItem() instanceof ItemNutriousFood) {
			return true;
		}
		
		return FoodParameterManager.hasNutritionalInfo(items);
	}
	
	/*
	 * アイテム item に設定された栄養素情報を取得
	 */
	public static FoodParameter getNutritionalValues(ItemStack items) {
		if (items.getItem() instanceof ItemNutriousFood) {
			return ((ItemNutriousFood)items.getItem()).getNutritionalValues();
		}
		return FoodParameterManager.getNutritionalValues(items);
	}
}
