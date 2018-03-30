package me.tokyojack.spigot.customenchants.enchants.tools.pickaxe;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.tokyojack.spigot.customenchants.enchants.tools.ToolEnchant;
import me.tokyojack.spigot.customenchants.enchants.tools.ToolType;
import me.tokyojack.spigot.customenchants.utils.ce.Rarity;

public class Haste extends ToolEnchant {

	public Haste() {
		super("Gives you haste when mining", 2, Rarity.RARE, ToolType.PICKAXE);
	}

	@Override
	public void run(Player player, Block block, int currentLevel) {
		if (!testChance(currentLevel))
			return;

		player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * currentLevel, currentLevel));
	}

	@Override
	public boolean testChance(int currentLevel) {
		return true;
	}

}
