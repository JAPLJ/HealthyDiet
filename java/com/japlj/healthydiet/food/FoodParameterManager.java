package com.japlj.healthydiet.food;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

/* 
 * バニラ食料など、本来栄養素情報を持たない食料に対し
 * 追加で付与された栄養素情報を管理
 */
public final class FoodParameterManager {
	private static HashMap<ItemStack, FoodParameter> foodParams = new HashMap<ItemStack, FoodParameter>();
	
	private FoodParameterManager() { }
	
	/*
	 * 食料 itemFood に対し栄養素情報 param を追加付与する
	 */
	public static void addParameterToFood(ItemStack itemFood, FoodParameter param) {
		if (itemFood.stackSize != 1) {
			throw new IllegalArgumentException("stackSize must be 1");
		}
		
		if (foodParams.containsKey(itemFood)) {
			throw new IllegalArgumentException("item '" + itemFood.getUnlocalizedName() + "' already has nutritional information");
		}
		
		foodParams.put(itemFood, param);
	}
	
	/*
	 * 食料 itemFood に追加で栄養素情報が設定されているか
	 */
	public static boolean hasNutritionalInfo(ItemStack itemFood) {
		ItemStack single = itemFood.copy();
		single.stackSize = 1;
		return foodParams.containsKey(single);
	}
	
	/*
	 * 食料 itemFood に追加で設定された栄養素情報を取得
	 */
	public static FoodParameter getNutritionalValues(ItemStack itemFood) {
		ItemStack single = itemFood.copy();
		single.stackSize = 1;
		return foodParams.get(single);
	}
}
