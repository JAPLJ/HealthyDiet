package com.japlj.healthydiet.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessagePlayerJoinInAnnouncement implements IMessage {
	private String uuid;
	
	public MessagePlayerJoinInAnnouncement() { }
	
	public MessagePlayerJoinInAnnouncement(EntityPlayer player) {
		uuid = player.getGameProfile().getId().toString();
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		uuid = ByteBufUtils.readUTF8String(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, uuid);
	}
	
	public String getUuid() {
		return uuid;
	}
}
