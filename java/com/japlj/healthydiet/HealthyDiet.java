package com.japlj.healthydiet;

import org.apache.logging.log4j.Logger;

import com.japlj.healthydiet.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HealthyDiet.MODID,
	 version = HealthyDiet.VERSION)
public class HealthyDiet {
	@Mod.Instance("HealthyDiet")
	public static final String MODID = "healthydiet";
	public static final String VERSION = "0.0.1";

	@SidedProxy(clientSide="com.japlj.healthydiet.proxy.ClientProxy", 
				serverSide="com.japlj.healthydiet.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	public static Logger logger;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}
