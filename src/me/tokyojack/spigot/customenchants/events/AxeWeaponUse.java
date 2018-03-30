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
import me.tokyojack.spigot.customenchants.enchants.weapon.WeaponEnchant;
import me.tokyojack.spigot.customenchants.utils.RomanNumeral;
import me.tokyojack.spigot.customenchants.utils.ce.TargetType;

public class AxeWeaponUse implements Listener {

	public AxeWeaponUse(Core core) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler(ignoreCancelled = true)
	public void dmg(EntityDamageByEntityEvent event) {
		if (!(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity))
			return;

		Player player = (Player) event.getDamager();

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

		boolean isMob = (event.getEntity() instanceof Monster) || (event.getEntity() instanceof Animals);
		boolean isPlayer = event.getEntity() instanceof Player;

		Map<String, WeaponEnchant> axeEnchants = Core.getPlugin().getAxeWeaponEnchants();

		for (String loreLine : playerItem.getItemMeta().getLore()) {
			String[] line_Split = ChatColor.stripColor(loreLine).split(" ");

			String enchantmentName = line_Split[0];
			int level = RomanNumeral.translateRomanNumeralsToInt(line_Split[1]);

			if (axeEnchants.containsKey(enchantmentName)) {

				WeaponEnchant ce = axeEnchants.get(enchantmentName);

				if (ce.getTargetType() == TargetType.PLAYER_AND_MOB) {
					ce.run(player, ((LivingEntity) event.getEntity()), level);
					continue;
				}

				if (ce.getTargetType() == TargetType.MOB) {
					if (!isMob)
						continue;

					ce.run(player, ((LivingEntity) event.getEntity()), level);
				}

				if (ce.getTargetType() == TargetType.PLAYER) {
					if (!isPlayer)
						continue;

					ce.run(player, ((LivingEntity) event.getEntity()), level);
				}
			}
		}
	}
}
