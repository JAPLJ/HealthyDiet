package com.japlj.healthydiet.food;

import com.japlj.healthydiet.HealthyDiet;
import com.japlj.healthydiet.api.NutritionUtils;
import com.japlj.healthydiet.food.playerstats.PlayerNutritionalConditions;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import squeek.applecore.api.food.FoodEvent;

public class FoodEventHandler {
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new FoodEventHandler());
	}
	
	@SubscribeEvent
	public void onFoodEaten(FoodEvent.FoodEaten event) {
		PlayerNutritionalConditions playerNutrition = PlayerNutritionalConditions.get(event.player);

		if (!NutritionUtils.hasNutritionalInfo(event.food)) {
			/* TODO: 栄養素情報のない食料を食べたときの処理をコンフィグで設定できるように */
			HealthyDiet.logger.warn("A food without nutritional values was eaten. Ignored.");
			return;
		}
		
		FoodParameter foodNutrition = NutritionUtils.getNutritionalValues(event.food);
		
		/* 
		 * 満腹度チェックはアイテム使用開始時に行われているはずなので、
		 * ここで失敗する場合は何かがおかしい
		 */
		if (!playerNutrition.isEdible(foodNutrition)) {
			HealthyDiet.logger.error("This food is currently not edible!");
			return;
		}
		
		playerNutrition.getFoodParameter().add(foodNutrition);
	}
}
