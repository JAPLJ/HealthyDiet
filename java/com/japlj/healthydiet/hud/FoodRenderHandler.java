package com.japlj.healthydiet.hud;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FoodRenderHandler {
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new FoodRenderHandler());
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onPreRender(RenderGameOverlayEvent.Pre event) {
		if (event.isCanceled()) {
			return;
		}
		
		if (event.type != RenderGameOverlayEvent.ElementType.FOOD) {
			return;
		}
	}
}
