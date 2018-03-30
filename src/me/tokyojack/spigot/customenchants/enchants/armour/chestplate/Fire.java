package me.tokyojack.spigot.customenchants.enchants.armour.chestplate;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import me.tokyojack.spigot.customenchants.enchants.armour.ArmourEnchant;
import me.tokyojack.spigot.customenchants.enchants.armour.ArmourType;
import me.tokyojack.spigot.customenchants.utils.ce.Rarity;

public class Fire extends ArmourEnchant {

	public Fire() {
		super("fires people", 5, Rarity.COMMON, ArmourType.CHESTPLATE);
	}

	@Override
	public boolean testChance(int currentLevel) {
		return true;
	}

	@Override
	public void run(Player taker, LivingEntity damager, int currentLevel) {
		if (!testChance(currentLevel))
			return;

		damager.setFireTicks(100);
	}

}
