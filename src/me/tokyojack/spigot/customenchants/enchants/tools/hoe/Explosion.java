package me.tokyojack.spigot.customenchants.enchants.tools.hoe;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import me.tokyojack.spigot.customenchants.enchants.tools.ToolEnchant;
import me.tokyojack.spigot.customenchants.enchants.tools.ToolType;
import me.tokyojack.spigot.customenchants.utils.ce.Rarity;

public class Explosion extends ToolEnchant{

	public Explosion() {
		super("Explodes when you mine something", 2, Rarity.RARE, ToolType.HOE);
	}

	@Override
	public void run(Player player, Block block, int currentLevel) {
		if (!testChance(currentLevel))
			return;
		
		block.getWorld().createExplosion(block.getLocation(), 2);
	}

	@Override
	public boolean testChance(int currentLevel) {
		return true;
	}

}