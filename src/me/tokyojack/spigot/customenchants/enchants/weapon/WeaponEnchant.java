package me.tokyojack.spigot.customenchants.enchants.weapon;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import lombok.Getter;
import me.tokyojack.spigot.customenchants.utils.ce.CustomEnchant;
import me.tokyojack.spigot.customenchants.utils.ce.Rarity;
import me.tokyojack.spigot.customenchants.utils.ce.TargetType;

@Getter
public abstract class WeaponEnchant extends CustomEnchant {

	TargetType targetType;
	WeaponType weaponType;

	public WeaponEnchant(String description, int maxLevel, Rarity rarity, WeaponType weaponType) {
		super(description, maxLevel, rarity);
		this.targetType = TargetType.PLAYER_AND_MOB;
		this.weaponType = weaponType;
	}

	public WeaponEnchant(String description, int maxLevel, Rarity rarity, TargetType targetType,
			WeaponType weaponType) {
		super(description, maxLevel, rarity);
		this.targetType = targetType;
		this.weaponType = weaponType;
	}
	
	
	public abstract void run(Player damager, LivingEntity taker, int currentLevel);
	
}
