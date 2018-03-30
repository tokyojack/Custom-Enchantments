package me.tokyojack.spigot.customenchants.utils.ce;

import lombok.Getter;

@Getter
public abstract class CustomEnchant {

	private String name;
	private String description;
	private int maxLevel;
	private Rarity rarity;

	public CustomEnchant(String description, int maxLevel, Rarity rarity) {
		this.description = description;
		this.maxLevel = maxLevel;
		this.rarity = rarity;
	}
	public void setName(String name) {
		this.name = name;
	}

	public abstract boolean testChance(int currentLevel);

}
