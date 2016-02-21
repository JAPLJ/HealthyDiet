package com.japlj.healthydiet.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessagePlayerJoinInAnnouncementHandler implements IMessageHandler<MessagePlayerJoinInAnnouncement, MessagePlayerNutritionalConditions> {
	@Override
	public MessagePlayerNutritionalConditions onMessage(MessagePlayerJoinInAnnouncement message, MessageContext ctx) {
		String uuid = message.getUuid();
		EntityPlayer player = ctx.getServerHandler().playerEntity;
		
		if (player.getGameProfile().getId().toString().equals(uuid)) {
			return new MessagePlayerNutritionalConditions(player);
		}
		return null;
	}
}
