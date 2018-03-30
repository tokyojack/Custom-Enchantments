package me.tokyojack.spigot.customenchants.enchants.bow.bow;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import me.tokyojack.spigot.customenchants.enchants.bow.BowEnchant;
import me.tokyojack.spigot.customenchants.utils.ce.Rarity;

public class Smite extends BowEnchant {

	public Smite() {
		super("as", 5, Rarity.COMMON);
	}

	@Override
	public void run(Player shooter, LivingEntity taker, Arrow arrow, int currentLevel) {
		if (!testChance(currentLevel))
			return;

		for (int i = 0; i < currentLevel; i++) {
			taker.getWorld().strikeLightning(taker.getLocation());
		}
	}

	@Override
	public boolean testChance(int currentLevel) {
		return true;
	}

}
