package me.tokyojack.spigot.customenchants.enchants.weapon.sword;

import java.util.Random;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.tokyojack.spigot.customenchants.enchants.weapon.WeaponEnchant;
import me.tokyojack.spigot.customenchants.enchants.weapon.WeaponType;
import me.tokyojack.spigot.customenchants.utils.ce.Rarity;

public class Poison extends WeaponEnchant{

	public Poison() {
		super("Gives your enemy poison", 5, Rarity.RARE, WeaponType.SWORD);
	}

	@Override
	public void run(Player damager, LivingEntity taker, int currentLevel) {
		if (!testChance(currentLevel))
			return;
		
		taker.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * currentLevel, currentLevel));
	}

	@Override
	public boolean testChance(int currentLevel) {
		return (new Random().nextInt(100) + 1) > (currentLevel * 5);
	}

}
