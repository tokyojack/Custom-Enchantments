package me.tokyojack.spigot.customenchants.enchants.armour;

import lombok.Getter;
import me.tokyojack.spigot.customenchants.enchants.armour.chestplate.Fire;

@Getter
public enum ArmourEnchants {
	FIRE(new Fire());
	
	private ArmourEnchant armourEnchant;
	
	private ArmourEnchants(ArmourEnchant armourEnchant) {
		this.armourEnchant = armourEnchant;
		
		this.armourEnchant.setName(armourEnchant.getClass().getSimpleName());
	}
}
