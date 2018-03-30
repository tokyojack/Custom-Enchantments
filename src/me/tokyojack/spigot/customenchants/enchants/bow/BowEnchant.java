package me.tokyojack.spigot.customenchants.enchants.bow;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import lombok.Getter;
import me.tokyojack.spigot.customenchants.utils.ce.CustomEnchant;
import me.tokyojack.spigot.customenchants.utils.ce.Rarity;
import me.tokyojack.spigot.customenchants.utils.ce.TargetType;

@Getter
public abstract class BowEnchant extends CustomEnchant {
	
	TargetType targetType;
	
	public BowEnchant(String description, int maxLevel, Rarity rarity) {
		super(description, maxLevel, rarity);
		this.targetType = TargetType.PLAYER_AND_MOB;
	}
	
	public BowEnchant(String description, int maxLevel, Rarity rarity, TargetType targetType) {
		super(description, maxLevel, rarity);
		this.targetType = targetType;
	}

	public abstract void run(Player shooter, LivingEntity taker, Arrow arrow, int currentLevel);
}
