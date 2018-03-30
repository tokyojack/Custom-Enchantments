package me.tokyojack.spigot.customenchants.enchants.tools;

import lombok.Getter;
import me.tokyojack.spigot.customenchants.enchants.tools.hoe.Explosion;
import me.tokyojack.spigot.customenchants.enchants.tools.pickaxe.Haste;


@Getter
public enum ToolEnchants {
	HASTE(new Haste()),
	EXPLOSION(new Explosion());

	
	private ToolEnchant toolEnchant;
	
	private ToolEnchants(ToolEnchant toolEnchant) {
		this.toolEnchant = toolEnchant;
		
		this.toolEnchant.setName(toolEnchant.getClass().getSimpleName());
	}
}
