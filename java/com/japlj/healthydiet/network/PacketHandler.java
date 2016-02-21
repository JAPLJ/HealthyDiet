package com.japlj.healthydiet.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("healthydiet");
	
	public static void init() {
		INSTANCE.registerMessage(MessagePlayerNutritionalConditionsHandler.class, MessagePlayerNutritionalConditions.class, 0, Side.CLIENT);
		INSTANCE.registerMessage(MessagePlayerJoinInAnnouncementHandler.class, MessagePlayerJoinInAnnouncement.class, 1, Side.SERVER);
	}
}
