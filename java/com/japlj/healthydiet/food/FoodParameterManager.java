package com.japlj.healthydiet.food;

import java.util.HashMap;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

/* 
 * バニラ食料など、本来栄養素情報を持たない食料に対し
 * 追加で付与された栄養素情報を管理
 */
public final class FoodParameterManager {
	private static class ItemFoodKey {
		public final ItemFood food;
		public final int damage;
		
		public ItemFoodKey(ItemFood food, int damage) {
			this.food = food;
			this.damage = damage;
		}
		
		public static ItemFoodKey fromItemStack(ItemStack items) {
			return new ItemFoodKey((ItemFood)items.getItem(), items.getMetadata());
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof ItemFoodKey)) {
				return false;
			}
			ItemFoodKey key = (ItemFoodKey)obj;
			return food.equals(key.food) && damage == key.damage;
		}
		
		@Override
		public int hashCode() {
			return food.hashCode() ^ damage;
		}
	}
	
	private static HashMap<ItemFoodKey, FoodParameter> foodParams = new HashMap<ItemFoodKey, FoodParameter>();
	
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
		
		foodParams.put(ItemFoodKey.fromItemStack(itemFood), param);
	}
	
	/*
	 * 食料 itemFood に追加で栄養素情報が設定されているか
	 */
	public static boolean hasNutritionalInfo(ItemStack itemFood) {
		return foodParams.containsKey(ItemFoodKey.fromItemStack(itemFood));
	}
	
	/*
	 * 食料 itemFood に追加で設定された栄養素情報を取得
	 */
	public static FoodParameter getNutritionalValues(ItemStack itemFood) {
		return foodParams.get(ItemFoodKey.fromItemStack(itemFood));
	}
}
