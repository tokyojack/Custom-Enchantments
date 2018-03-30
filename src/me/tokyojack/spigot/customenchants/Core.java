package me.tokyojack.spigot.customenchants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.tokyojack.spigot.customenchants.enchants.armour.ArmourEnchant;
import me.tokyojack.spigot.customenchants.enchants.armour.ArmourEnchants;
import me.tokyojack.spigot.customenchants.enchants.armour.ArmourType;
import me.tokyojack.spigot.customenchants.enchants.bow.BowEnchant;
import me.tokyojack.spigot.customenchants.enchants.bow.BowEnchants;
import me.tokyojack.spigot.customenchants.enchants.tools.ToolEnchant;
import me.tokyojack.spigot.customenchants.enchants.tools.ToolEnchants;
import me.tokyojack.spigot.customenchants.enchants.tools.ToolType;
import me.tokyojack.spigot.customenchants.enchants.weapon.WeaponEnchant;
import me.tokyojack.spigot.customenchants.enchants.weapon.WeaponEnchants;
import me.tokyojack.spigot.customenchants.enchants.weapon.WeaponType;
import me.tokyojack.spigot.customenchants.events.AxeChop;
import me.tokyojack.spigot.customenchants.events.AxeWeaponUse;
import me.tokyojack.spigot.customenchants.events.BootsDamage;
import me.tokyojack.spigot.customenchants.events.BowArrowDamage;
import me.tokyojack.spigot.customenchants.events.ChestplateDamage;
import me.tokyojack.spigot.customenchants.events.HelmentDamage;
import me.tokyojack.spigot.customenchants.events.HoeUse;
import me.tokyojack.spigot.customenchants.events.LeggingsDamage;
import me.tokyojack.spigot.customenchants.events.PickaxeMine;
import me.tokyojack.spigot.customenchants.events.PlayerJoin;
import me.tokyojack.spigot.customenchants.events.ShovelDig;
import me.tokyojack.spigot.customenchants.events.SwordUse;

@Getter
public class Core extends JavaPlugin {

	private static Core plugin;

	public static Core getPlugin() {
		return plugin;
	}

	private Map<String, ArmourEnchant> helmentEnchants = new HashMap<String, ArmourEnchant>();
	private Map<String, ArmourEnchant> chestplateEnchants = new HashMap<String, ArmourEnchant>();
	private Map<String, ArmourEnchant> leggingsEnchants = new HashMap<String, ArmourEnchant>();
	private Map<String, ArmourEnchant> bootsEnchants = new HashMap<String, ArmourEnchant>();

	private Map<String, ToolEnchant> axeEnchants = new HashMap<String, ToolEnchant>();
	private Map<String, ToolEnchant> hoeEnchants = new HashMap<String, ToolEnchant>();
	private Map<String, ToolEnchant> pickaxeEnchants = new HashMap<String, ToolEnchant>();
	private Map<String, ToolEnchant> shovelEnchants = new HashMap<String, ToolEnchant>();

	private Map<String, WeaponEnchant> swordEnchants = new HashMap<String, WeaponEnchant>();
	private Map<String, WeaponEnchant> axeWeaponEnchants = new HashMap<String, WeaponEnchant>();

	private Map<String, BowEnchant> bowEnchants = new HashMap<String, BowEnchant>();

	public void onEnable() {
		plugin = this;

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerJoin(this), this);

		pm.registerEvents(new HelmentDamage(this), this);
		pm.registerEvents(new ChestplateDamage(this), this);
		pm.registerEvents(new LeggingsDamage(this), this);
		pm.registerEvents(new BootsDamage(this), this);

		pm.registerEvents(new AxeChop(this), this);
		pm.registerEvents(new PickaxeMine(this), this);
		pm.registerEvents(new ShovelDig(this), this);
		pm.registerEvents(new HoeUse(this), this);

		pm.registerEvents(new SwordUse(this), this);
		pm.registerEvents(new AxeWeaponUse(this), this);

		pm.registerEvents(new BowArrowDamage(this), this);

		Arrays.asList(ArmourEnchants.values()).forEach(enchant -> {
			if (enchant.getArmourEnchant().getArmourType() == ArmourType.HELMENT)
				helmentEnchants.put(enchant.getArmourEnchant().getName(), enchant.getArmourEnchant());

			if (enchant.getArmourEnchant().getArmourType() == ArmourType.CHESTPLATE)
				chestplateEnchants.put(enchant.getArmourEnchant().getName(), enchant.getArmourEnchant());

			if (enchant.getArmourEnchant().getArmourType() == ArmourType.LEGGINGS)
				leggingsEnchants.put(enchant.getArmourEnchant().getName(), enchant.getArmourEnchant());

			if (enchant.getArmourEnchant().getArmourType() == ArmourType.BOOTS)
				bootsEnchants.put(enchant.getArmourEnchant().getName(), enchant.getArmourEnchant());
		});

		Arrays.asList(ToolEnchants.values()).forEach(enchant -> {
			if (enchant.getToolEnchant().getToolType() == ToolType.AXE)
				axeEnchants.put(enchant.getToolEnchant().getName(), enchant.getToolEnchant());

			if (enchant.getToolEnchant().getToolType() == ToolType.HOE)
				hoeEnchants.put(enchant.getToolEnchant().getName(), enchant.getToolEnchant());

			if (enchant.getToolEnchant().getToolType() == ToolType.PICKAXE)
				pickaxeEnchants.put(enchant.getToolEnchant().getName(), enchant.getToolEnchant());

			if (enchant.getToolEnchant().getToolType() == ToolType.SHOVEL)
				shovelEnchants.put(enchant.getToolEnchant().getName(), enchant.getToolEnchant());
		});

		Arrays.asList(WeaponEnchants.values()).forEach(enchant -> {
			if (enchant.getWeaponEnchant().getWeaponType() == WeaponType.SWORD)
				swordEnchants.put(enchant.getWeaponEnchant().getName(), enchant.getWeaponEnchant());

			if (enchant.getWeaponEnchant().getWeaponType() == WeaponType.AXE)
				axeWeaponEnchants.put(enchant.getWeaponEnchant().getName(), enchant.getWeaponEnchant());
		});

		Arrays.asList(BowEnchants.values()).forEach(enchant -> bowEnchants.put(enchant.getBowEnchant().getName(), enchant.getBowEnchant()));
	}

}