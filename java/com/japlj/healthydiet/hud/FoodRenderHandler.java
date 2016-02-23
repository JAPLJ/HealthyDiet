package com.japlj.healthydiet.hud;

import com.japlj.healthydiet.ModConfig;
import com.japlj.healthydiet.food.FoodParameter;
import com.japlj.healthydiet.food.playerstats.PlayerNutritionalConditions;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FoodRenderHandler {
	private final int COL_ERROR = 0xdc143c;
	private final int COL_INFO = 0xf5f5f5;
	
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
		
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		
		ScaledResolution scale = event.resolution;
		
		/* カスタムデータから栄養素と満腹度を取得 */
		PlayerNutritionalConditions extProps = PlayerNutritionalConditions.get(player);
		FoodParameter stats;
		if (extProps == null) {
			stats = null;
		} else {
			stats = extProps.getFoodParameter();
		}
		
		/* デバッグ情報の描画 */
		if (ModConfig.SHOW_DEBUG_INFO) {
			drawDebugInfo(mc, player, scale, stats);
		}
		
		/* 既存の満腹度表示はキャンセル */
		event.setCanceled(true);
	}
	
	private void drawDebugInfo(Minecraft mc, EntityPlayer player, ScaledResolution scale, FoodParameter stats) {
		int font_height = mc.fontRendererObj.FONT_HEIGHT;
		int left = 0;
		int top = scale.getScaledHeight() - font_height;
		
		if (stats == null) {
			mc.ingameGUI.drawString(mc.fontRendererObj, "*Nutritional Info NOT Found*", left, top, COL_ERROR);
		} else {
			mc.ingameGUI.drawString(mc.fontRendererObj, "Saturation  : " + stats.saturation, left, top, COL_INFO);
			mc.ingameGUI.drawString(mc.fontRendererObj, "VitaMine    : " + stats.vitaMineValue, left, top - font_height, COL_INFO);
			mc.ingameGUI.drawString(mc.fontRendererObj, "Carbohydrate: " + stats.carbohydrateValue, left, top - font_height * 2, COL_INFO);
			mc.ingameGUI.drawString(mc.fontRendererObj, "Protein     : " + stats.proteinValue, left, top - font_height * 3, COL_INFO);
		}
	}
}
