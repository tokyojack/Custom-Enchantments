package me.tokyojack.spigot.customenchants.enchants.bow;

import lombok.Getter;
import me.tokyojack.spigot.customenchants.enchants.bow.bow.Smite;

@Getter
public enum BowEnchants {
	SMITE(new Smite());
	
	private BowEnchant bowEnchant;
	
	private BowEnchants(BowEnchant bowEnchant) {
		this.bowEnchant = bowEnchant;
		
		this.bowEnchant.setName(bowEnchant.getClass().getSimpleName());
	}
}
