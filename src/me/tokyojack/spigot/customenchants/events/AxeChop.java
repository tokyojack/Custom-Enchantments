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

public class AxeChop implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onAxeChop(BlockBreakEvent event) {
		Player player = event.getPlayer();

		ItemStack playerItem = player.getItemInHand();

		if (playerItem == null)
			return;

		if (playerItem.getType() == Material.AIR)
			return;

		if (!playerItem.getType().name().endsWith("_AXE"))
			return;

		if (!playerItem.hasItemMeta())
			return;

		if (!playerItem.getItemMeta().hasLore())
			return;

		Map<String, ToolEnchant> axeEnchants = Core.getPlugin().getAxeEnchants();

		for (String loreLine : playerItem.getItemMeta().getLore()) {
			String[] line_Split = ChatColor.stripColor(loreLine).split(" ");

			String enchantmentName = line_Split[0];
			int level = RomanNumeral.translateRomanNumeralsToInt(line_Split[1]);

			if (axeEnchants.containsKey(enchantmentName))
				axeEnchants.get(enchantmentName).run(player, event.getBlock(), level);

		}
	}

}
