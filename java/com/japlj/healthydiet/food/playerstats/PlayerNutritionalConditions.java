package com.japlj.healthydiet.food.playerstats;

import com.japlj.healthydiet.ModConfig;
import com.japlj.healthydiet.food.FoodParameter;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerNutritionalConditions implements IExtendedEntityProperties {
	public final static String EXT_PROP_NAME = "playerNutritionalConditions";
	
	private FoodParameter param = new FoodParameter(50.0F, 50.0F, 50.0F, 50.0F);
	private final static String PROTEIN_VALUE_NAME = "proteinValue";
	private final static String CARBOHYDRATE_VALUE_NAME = "carbohydrateValue";
	private final static String VITA_MINE_VALUE_NAME = "vitaMineValue";
	private final static String FOOD_SATURATION_NAME = "foodSaturation";
	
	public static void register(EntityPlayer player) {
		player.registerExtendedProperties(EXT_PROP_NAME, new PlayerNutritionalConditions());
	}
	
	public static PlayerNutritionalConditions get(EntityPlayer player) {
		return (PlayerNutritionalConditions)player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound nbtOut) {
		NBTTagCompound nbt = new NBTTagCompound();
		
		nbt.setFloat(PROTEIN_VALUE_NAME, param.proteinValue);
		nbt.setFloat(CARBOHYDRATE_VALUE_NAME, param.carbohydrateValue);
		nbt.setFloat(VITA_MINE_VALUE_NAME, param.vitaMineValue);
		nbt.setFloat(FOOD_SATURATION_NAME, param.saturation);
		
		nbtOut.setTag(EXT_PROP_NAME, nbt);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound nbtIn) {
		NBTTagCompound nbt = (NBTTagCompound)nbtIn.getTag(EXT_PROP_NAME);
		
		this.param.proteinValue = nbt.getFloat(PROTEIN_VALUE_NAME);
		this.param.carbohydrateValue = nbt.getFloat(CARBOHYDRATE_VALUE_NAME);
		this.param.vitaMineValue = nbt.getFloat(VITA_MINE_VALUE_NAME);
		this.param.saturation = nbt.getFloat(FOOD_SATURATION_NAME);
	}
	
	@Override
	public void init(Entity entitiy, World world) { }
	
	public FoodParameter getFoodParameter() {
		return param;
	}
	
	public boolean isEdible(FoodParameter foodParam) {
		return param.saturation + foodParam.saturation <= ModConfig.MAX_NUTRITION_VALUE;
	}
}
