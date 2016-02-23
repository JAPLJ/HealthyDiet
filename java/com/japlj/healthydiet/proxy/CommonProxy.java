package com.japlj.healthydiet.proxy;

import com.japlj.healthydiet.HealthyDiet;
import com.japlj.healthydiet.food.VanillaFoods;
import com.japlj.healthydiet.food.playerstats.NutritionalConditionsEventHandler;
import com.japlj.healthydiet.network.PacketHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/* クライアント・サーバ双方で行われる処理 */
public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		HealthyDiet.logger = e.getModLog();
		PacketHandler.init();
	}
	
	public void init(FMLInitializationEvent e) {
		/* イベントハンドラの登録・初期化 */
		MinecraftForge.EVENT_BUS.register(new NutritionalConditionsEventHandler());
		
		/* バニラ食料の栄養素情報設定 */
		VanillaFoods.init();
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	public EntityPlayer getEntityPlayerInstance() {
		return null;
	}
}
