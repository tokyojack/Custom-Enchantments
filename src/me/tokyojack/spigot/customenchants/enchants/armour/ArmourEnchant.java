package me.tokyojack.spigot.customenchants.enchants.armour;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import lombok.Getter;
import me.tokyojack.spigot.customenchants.utils.ce.CustomEnchant;
import me.tokyojack.spigot.customenchants.utils.ce.Rarity;
import me.tokyojack.spigot.customenchants.utils.ce.TargetType;

@Getter
public abstract class ArmourEnchant extends CustomEnchant {

	TargetType targetType;
	ArmourType armourType;

	public ArmourEnchant(String description, int maxLevel, Rarity rarity, ArmourType armourType) {
		super(description, maxLevel, rarity);
		this.targetType = TargetType.PLAYER_AND_MOB;
		this.armourType = armourType;
	}

	public ArmourEnchant(String description, int maxLevel, Rarity rarity, TargetType targetType,
			ArmourType armourType) {
		super(description, maxLevel, rarity);
		this.targetType = targetType;
		this.armourType = armourType;
	}
	
	
	public abstract void run(Player taker, LivingEntity damager, int currentLevel);
	
}
