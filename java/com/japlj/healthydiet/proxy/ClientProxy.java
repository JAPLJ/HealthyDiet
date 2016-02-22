package com.japlj.healthydiet.proxy;

import com.japlj.healthydiet.hud.FoodRenderHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/* クライアントサイドでのみ行われる処理 */
public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}
	
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		
		FoodRenderHandler.init();
	}
	
	@Override
	public EntityPlayer getEntityPlayerInstance() {
		return Minecraft.getMinecraft().thePlayer;
	}
}
