package com.japlj.healthydiet.network;

import com.japlj.healthydiet.HealthyDiet;
import com.japlj.healthydiet.food.playerstats.PlayerNutritionalConditions;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessagePlayerNutritionalConditionsHandler implements IMessageHandler<MessagePlayerNutritionalConditions, IMessage> {
	@Override
	public IMessage onMessage(MessagePlayerNutritionalConditions message, MessageContext ctx) {
		PlayerNutritionalConditions.get(HealthyDiet.proxy.getEntityPlayerInstance()).loadNBTData(message.nbt);
		return null;
	}
}
