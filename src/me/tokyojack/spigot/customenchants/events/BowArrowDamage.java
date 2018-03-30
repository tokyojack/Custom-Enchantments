package me.tokyojack.spigot.customenchants.events;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.tokyojack.spigot.customenchants.Core;
import me.tokyojack.spigot.customenchants.enchants.bow.BowEnchant;
import me.tokyojack.spigot.customenchants.utils.RomanNumeral;
import me.tokyojack.spigot.customenchants.utils.ce.TargetType;

public class BowArrowDamage implements Listener {

	public BowArrowDamage(Core core) {
		// TODO Auto-generated constructor stub
	}

	@EventHandler(ignoreCancelled = true)
	public void dmg(EntityDamageByEntityEvent event) {
		if (!(event.getDamager() instanceof Arrow))
			return;

		Arrow arrow = (Arrow) event.getDamager();

		if (!(arrow.getShooter() instanceof Player))
			return;

		Player player = (Player) arrow.getShooter();
		ItemStack playerItem = player.getItemInHand();

		if (!playerItem.hasItemMeta())
			return;

		if (!playerItem.getItemMeta().hasLore())
			return;

		boolean isMob = (event.getEntity() instanceof Monster) || (event.getEntity() instanceof Animals);
		boolean isPlayer = event.getEntity() instanceof Player;


		Map<String, BowEnchant> bootEnchants = Core.getPlugin().getBowEnchants();

		for (String loreLine : playerItem.getItemMeta().getLore()) {
			String[] line_Split = ChatColor.stripColor(loreLine).split(" ");

			String enchantmentName = line_Split[0];
			int level = RomanNumeral.translateRomanNumeralsToInt(line_Split[1]);

			if (bootEnchants.containsKey(enchantmentName)) {

				BowEnchant ce = bootEnchants.get(enchantmentName);

				if (ce.getTargetType() == TargetType.PLAYER_AND_MOB) {
					ce.run(player, ((LivingEntity) event.getEntity()), arrow, level);
					continue;
				}

				if (ce.getTargetType() == TargetType.MOB) {
					if (!isMob)
						continue;

					ce.run(player, ((LivingEntity) event.getEntity()), arrow, level);
				}

				if (ce.getTargetType() == TargetType.PLAYER) {
					if (!isPlayer)
						continue;

					ce.run(player, ((LivingEntity) event.getEntity()), arrow, level);
				}
			}
		}
		
	}

}
