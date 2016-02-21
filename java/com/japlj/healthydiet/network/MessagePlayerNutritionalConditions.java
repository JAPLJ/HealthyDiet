package com.japlj.healthydiet.network;

import com.japlj.healthydiet.food.playerstats.PlayerNutritionalConditions;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessagePlayerNutritionalConditions implements IMessage {
	public NBTTagCompound nbt;

	public MessagePlayerNutritionalConditions() { }
	
	public MessagePlayerNutritionalConditions(EntityPlayer player) {
		nbt = new NBTTagCompound();
		PlayerNutritionalConditions.get(player).saveNBTData(nbt);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		nbt = ByteBufUtils.readTag(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, nbt);
	}
}
