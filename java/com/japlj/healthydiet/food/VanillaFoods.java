package com.japlj.healthydiet.food;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

/*
 * バニラ食料に対して栄養素情報を設定する
 */
public final class VanillaFoods {
	private static void add(Item itemFood, float protein, float carbohydrate, float vitaMine, float satu) {
		FoodParameterManager.addParameterToFood(new ItemStack(itemFood, 1, 0), new FoodParameter(protein, carbohydrate, vitaMine, satu));
	}

	private static void add(ItemStack itemFood, float protein, float carbohydrate, float vitaMine, float satu) {
		FoodParameterManager.addParameterToFood(itemFood, new FoodParameter(protein, carbohydrate, vitaMine, satu));
	}

	public static void init() {
		/* TODO: コンフィグの難易度設定でパラメタのシビアさを変えられるようにする */
		/* TODO: バランス調整 */
		
		// 魚
		add(new ItemStack(Items.fish, 1, ItemFishFood.FishType.COD.getMetadata()), 3.0F, 0.0F, 0.0F, 3.0F);
		add(new ItemStack(Items.fish, 1, ItemFishFood.FishType.SALMON.getMetadata()), 3.0F, 0.0F, 0.0F, 3.0F);
		add(new ItemStack(Items.fish, 1, ItemFishFood.FishType.CLOWNFISH.getMetadata()), 1.5F, 0.0F, 0.0F, 1.5F);
		add(new ItemStack(Items.fish, 1, ItemFishFood.FishType.PUFFERFISH.getMetadata()), 1.5F, 0.0F, 0.0F, 1.5F);
		add(new ItemStack(Items.cooked_fish, 1, ItemFishFood.FishType.COD.getMetadata()), 18.0F, 0.0F, 0.0F, 6.0F);
		add(new ItemStack(Items.cooked_fish, 1, ItemFishFood.FishType.SALMON.getMetadata()), 18.0F, 0.0F, 0.0F, 6.0F);
		
		// 肉
		add(Items.beef, 7.0F, 0.0F, 0.0F, 5.0F);
		add(Items.porkchop, 7.0F, 0.0F, 0.0F, 5.0F);
		add(Items.chicken, 5.0F, 0.0F, 0.0F, 4.0F);
		add(Items.mutton, 5.0F, 0.0F, 0.0F, 4.5F);
		add(Items.rabbit, 4.0F, 0.0F, 0.0F, 3.5F);
		add(Items.cooked_beef, 32.0F, 0.0F, 0.0F, 10.0F);
		add(Items.cooked_porkchop, 32.0F, 0.0F, 0.0F, 10.0F);
		add(Items.cooked_chicken, 25.0F, 0.0F, 0.0F, 8.0F);
		add(Items.cooked_mutton, 24.0F, 0.0F, 0.0F, 8.0F);
		add(Items.cooked_rabbit, 19.5F, 0.0F, 0.0F, 6.5F);
		
		// 農産物等
		add(Items.apple, 0.0F, 0.0F, 14.5F, 4.5F);
		add(Items.carrot, 0.0F, 0.0F, 12.0F, 3.5F);
		add(Items.potato, 0.0F, 2.0F, 2.0F, 3.0F);
		add(Items.melon, 0.0F, 0.0F, 7.0F, 2.3F);
		add(Items.baked_potato, 0.0F, 14.0F, 7.0F, 7.0F);
		add(Items.poisonous_potato, 0.0F, 2.0F, 2.0F, 3.0F);
		
		// 料理
		add(Items.bread, 0.0F, 22.0F, 0.0F, 7.0F);
		add(Items.cookie, 0.0F, 5.0F, 1.0F, 2.0F);
		add(Items.mushroom_stew, 0.0F, 6.0F, 20.0F, 8.0F);
		add(Items.rabbit_stew, 19.5F, 14.0F, 17.0F, 15.0F);
		add(Items.pumpkin_pie, 17.0F, 4.0F, 12.0F, 10.0F);

		// TODO: ケーキの取り扱い
		// add(Items.cake, 5.0F, 2.0F, 0.0F, 2.0F);
		
		// 他
		add(new ItemStack(Items.golden_apple, 1, 0), 0.0F, 0.0F, 45.0F, 4.5F);
		add(new ItemStack(Items.golden_apple, 1, 1), 0.0F, 0.0F, 90.0F, 4.5F);
		add(Items.golden_carrot, 0.0F, 0.0F, 25.0F, 3.5F);
		add(Items.rotten_flesh, 16.0F, 0.0F, 0.0F, 5.5F);
		add(Items.spider_eye, 8.0F, 0.0F, 0.0F, 3.0F);
	}
}
