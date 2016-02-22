package com.japlj.healthydiet.proxy;

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
		PacketHandler.init();
	}
	
	public void init(FMLInitializationEvent e) {
		/* Register event handlers for extended player properties */
		MinecraftForge.EVENT_BUS.register(new NutritionalConditionsEventHandler());
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
	
	public EntityPlayer getEntityPlayerInstance() {
		return null;
	}
}
