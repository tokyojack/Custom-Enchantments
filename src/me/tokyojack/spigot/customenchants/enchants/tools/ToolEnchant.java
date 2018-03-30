package me.tokyojack.spigot.customenchants.enchants.tools;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import lombok.Getter;
import me.tokyojack.spigot.customenchants.utils.ce.CustomEnchant;
import me.tokyojack.spigot.customenchants.utils.ce.Rarity;

@Getter
public abstract class ToolEnchant extends CustomEnchant {

	ToolType toolType;

	public ToolEnchant(String description, int maxLevel, Rarity rarity, ToolType toolType) {
		super(description, maxLevel, rarity);
		this.toolType = toolType;
	}

	public abstract void run(Player player, Block block, int currentLevel);

}
