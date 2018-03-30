package me.tokyojack.spigot.customenchants.events;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.tokyojack.spigot.customenchants.Core;
import me.tokyojack.spigot.customenchants.enchants.tools.ToolEnchant;
import me.tokyojack.spigot.customenchants.utils.RomanNumeral;

public class PickaxeMine implements Listener {

	public PickaxeMine(Core core) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler(ignoreCancelled = true)
	public void onPickaxeMine(BlockBreakEvent event) {
		Player player = event.getPlayer();

		ItemStack playerItem = player.getItemInHand();

		if (playerItem == null)
			return;

		if (playerItem.getType() == Material.AIR)
			return;

		if (!playerItem.getType().name().endsWith("_PICKAXE"))
			return;

		if (!playerItem.hasItemMeta())
			return;

		if (!playerItem.getItemMeta().hasLore())
			return;
	
		Map<String, ToolEnchant> pickaxeEnchants = Core.getPlugin().getPickaxeEnchants();

		for (String loreLine : playerItem.getItemMeta().getLore()) {
			String[] line_Split = ChatColor.stripColor(loreLine).split(" ");

			String enchantmentName = line_Split[0];
			int level = RomanNumeral.translateRomanNumeralsToInt(line_Split[1]);

			if (pickaxeEnchants.containsKey(enchantmentName))
				pickaxeEnchants.get(enchantmentName).run(player, event.getBlock(), level);

		}
		
	}

}
