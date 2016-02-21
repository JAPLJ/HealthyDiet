package com.japlj.healthydiet.food.playerstats;

import com.japlj.healthydiet.network.MessagePlayerJoinInAnnouncement;
import com.japlj.healthydiet.network.MessagePlayerNutritionalConditions;
import com.japlj.healthydiet.network.PacketHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class NutritionalConditionsEventHandler {
	@SubscribeEvent
	public void onEntityConstructing(EntityEvent.EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			PlayerNutritionalConditions.register((EntityPlayer)event.entity);
		}
	}
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (event.world.isRemote && event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			PacketHandler.INSTANCE.sendToServer(new MessagePlayerJoinInAnnouncement(player));
		}
	}
	
	@SubscribeEvent
	public void onClonePlayer(net.minecraftforge.event.entity.player.PlayerEvent.Clone event) {
		if (event.wasDeath) {
			IExtendedEntityProperties oldprop = event.original.getExtendedProperties(PlayerNutritionalConditions.EXT_PROP_NAME);
			IExtendedEntityProperties newprop = event.entityPlayer.getExtendedProperties(PlayerNutritionalConditions.EXT_PROP_NAME);
			
			NBTTagCompound data = new NBTTagCompound();
			oldprop.saveNBTData(data);
			newprop.loadNBTData(data);
		}
	}
	
	@SubscribeEvent
	public void respawnEvent(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.player.worldObj.isRemote) {
			PacketHandler.INSTANCE.sendTo(new MessagePlayerNutritionalConditions(event.player), (EntityPlayerMP)event.player);
		}
	}
}
