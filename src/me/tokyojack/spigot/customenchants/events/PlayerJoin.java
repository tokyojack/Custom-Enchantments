package me.tokyojack.spigot.customenchants.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.tokyojack.spigot.customenchants.Core;
import me.tokyojack.spigot.customenchants.utils.ItemBuilder;

public class PlayerJoin implements Listener {

	//NOTE: This is just for me to test the CE	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().getInventory().addItem(new ItemBuilder(Material.DIAMOND_SWORD).addLoreLine("Poison I").toItemStack());
		event.getPlayer().getInventory().addItem(new ItemBuilder(Material.DIAMOND_CHESTPLATE).addLoreLine("Fire I").toItemStack());
		event.getPlayer().getInventory().addItem(new ItemBuilder(Material.DIAMOND_PICKAXE).addLoreLine("Haste I").toItemStack());
		event.getPlayer().getInventory().addItem(new ItemBuilder(Material.BOW).addLoreLine("Smite V").toItemStack());
		event.getPlayer().getInventory().addItem(new ItemBuilder(Material.DIAMOND_HOE).addLoreLine("Explosion I").toItemStack());
	}
	
}
