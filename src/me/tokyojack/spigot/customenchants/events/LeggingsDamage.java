package me.tokyojack.spigot.customenchants.events;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Animals;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.tokyojack.spigot.customenchants.Core;
import me.tokyojack.spigot.customenchants.enchants.armour.ArmourEnchant;
import me.tokyojack.spigot.customenchants.utils.RomanNumeral;
import me.tokyojack.spigot.customenchants.utils.ce.TargetType;

public class LeggingsDamage implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onChestplateDamage(EntityDamageByEntityEvent event) {

		if (!(event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity))
			return;

		Player taker = (Player) event.getEntity();
		
		ItemStack playerItem = taker.getEquipment().getLeggings();

		if(playerItem == null)
			return;
		
		if(playerItem.getType() == Material.AIR)
			return;
		
		if(!playerItem.hasItemMeta())
			return;
		
		if(!playerItem.getItemMeta().hasLore())
			return;

		boolean isMob = (event.getDamager() instanceof Monster) || (event.getDamager() instanceof Animals);
		boolean isPlayer = event.getDamager() instanceof Player;

		Map<String, ArmourEnchant> leggingsEnchantment = Core.getPlugin().getLeggingsEnchants();

		for (String loreLine : playerItem.getItemMeta().getLore()) {
			String[] line_Split = ChatColor.stripColor(loreLine).split(" ");

			String enchantmentName = line_Split[0];
			int level = RomanNumeral.translateRomanNumeralsToInt(line_Split[1]);

			if (leggingsEnchantment.containsKey(enchantmentName)) {

				ArmourEnchant ce = leggingsEnchantment.get(enchantmentName);

				if (ce.getTargetType() == TargetType.PLAYER_AND_MOB) {
					ce.run(taker, ((LivingEntity) event.getDamager()), level);
					continue;
				}

				if (ce.getTargetType() == TargetType.MOB) {
					if (!isMob)
						continue;

					ce.run(taker, ((LivingEntity) event.getDamager()), level);
				}

				if (ce.getTargetType() == TargetType.PLAYER) {
					if (!isPlayer)
						continue;

					ce.run(taker, ((LivingEntity) event.getDamager()), level);
				}
			}
		}

	}
}
