package me.tokyojack.spigot.customenchants.enchants.weapon;

import lombok.Getter;
import me.tokyojack.spigot.customenchants.enchants.weapon.sword.Poison;

@Getter
public enum WeaponEnchants {
	POISON(new Poison());
	
	private WeaponEnchant weaponEnchant;
	
	private WeaponEnchants(WeaponEnchant weaponEnchant) {
		this.weaponEnchant = weaponEnchant;
		
		this.weaponEnchant.setName(weaponEnchant.getClass().getSimpleName());
	}
}
