package com.kirelcodes.RoboticCraft;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.kirelcodes.RoboticCraft.robot.RobotBase;
import com.kirelcodes.RoboticCraft.robot.RobotFarmer;
import com.kirelcodes.RoboticCraft.robot.RobotHunter;
import com.kirelcodes.RoboticCraft.robot.RobotLighter;
import com.kirelcodes.RoboticCraft.robot.RobotLumberjack;
import com.kirelcodes.RoboticCraft.robot.RobotMiner;
import com.kirelcodes.RoboticCraft.utils.ItemStackUtils;

public class RecipeAdder {
	private static ItemStack remoteBase, remoteFarmer, remoteHunter,
			remoteLighter, remoteLumberjack, remoteMiner;
	private static ArrayList<ItemStack> items;
	
	public static void addAll(){
		items = new ArrayList<>();
		initializeItem();
		addRecipeBasicRobot();
		addRecipeFarmerRobot();
		addRecipeHunterRobot();
		addRecipeLighterRobot();
		addRecipeLumberjackRobot();
		addRecipeMinerRobot();
	}
	
	
	
	
	public static void initializeItem(){
		remoteBase = ItemStackUtils.createItem(Material.END_CRYSTAL, "&cRemote Control Basic", ChatColor.AQUA + "Remote for the basic robot");
		items.add(remoteBase);
		remoteFarmer = ItemStackUtils.createItem(Material.END_CRYSTAL, "&cRemote Control Farmer", ChatColor.AQUA + "Remote for the farmer robot");
		items.add(remoteFarmer);
		remoteHunter = ItemStackUtils.createItem(Material.END_CRYSTAL, "&cRemote Control Hunter", ChatColor.AQUA + "Remote for the hunter robot");
		items.add(remoteHunter);
		remoteLighter = ItemStackUtils.createItem(Material.END_CRYSTAL, "&cRemote Control Lighter", ChatColor.AQUA + "Remote for the lighter robot");
		items.add(remoteLighter);
		remoteLumberjack = ItemStackUtils.createItem(Material.END_CRYSTAL, "&cRemote Lumberjack Basic", ChatColor.AQUA + "Remote for the lumberjack robot");
		items.add(remoteLumberjack);
		remoteMiner = ItemStackUtils.createItem(Material.END_CRYSTAL, "&cRemote Miner Basic", ChatColor.AQUA + "Remote for the miner robot");
		items.add(remoteMiner);
	}
	public static boolean containsItem(ItemStack item){
		for(ItemStack itemC : items)
			if(itemC.isSimilar(item))
				return true;
		return false;
	}
	public static void addRemote(ItemStack item){
		items.add(item);
	}
	public static ItemStack getItem(RobotBase robot){
		if(robot.getClass().getName().equalsIgnoreCase(RobotBase.class.getName())){
			return remoteBase;
		}
		if(robot.getClass().getName().equalsIgnoreCase(RobotMiner.class.getName())){
			return remoteMiner;
		}
		if(robot.getClass().getName().equalsIgnoreCase(RobotFarmer.class.getName())){
			return remoteFarmer;
		}
		if(robot.getClass().getName().equalsIgnoreCase(RobotHunter.class.getName())){
			return remoteHunter;
		}
		if(robot.getClass().getName().equalsIgnoreCase(RobotLighter.class.getName())){
			return remoteLighter;
		}
		if(robot.getClass().getName().equalsIgnoreCase(RobotLumberjack.class.getName())){
			return remoteLumberjack;
		}
		return null;
	}
	public static RobotBase getRobot(ItemStack item , Location loc){
		if(remoteBase.isSimilar(item))
			return new RobotBase(loc);
		if(remoteFarmer.isSimilar(item))
			return new RobotFarmer(loc);
		if(remoteHunter.isSimilar(item))
			return new RobotHunter(loc);
		if(remoteLighter.isSimilar(item))
			return new RobotLighter(loc);
		if(remoteLumberjack.isSimilar(item))
			return new RobotLumberjack(loc);
		if(remoteMiner.isSimilar(item))
			return new RobotMiner(loc);
		return null;
	}
	
	public static void addRecipeBasicRobot() {
		Bukkit.addRecipe(new ShapedRecipe(remoteBase)
				.shape("G G", "DSD", "DDD")
				.setIngredient('D', Material.DIAMOND_BLOCK)
				.setIngredient('S', Material.ARMOR_STAND)
				.setIngredient('G', Material.GOLD_BLOCK));
	}

	public static void addRecipeFarmerRobot() {
		Bukkit.addRecipe(new ShapedRecipe(remoteFarmer)
				.shape("GAG", "DSD", "DDD")
				.setIngredient('D', Material.DIAMOND_BLOCK)
				.setIngredient('S', Material.ARMOR_STAND)
				.setIngredient('G', Material.GOLD_BLOCK)
				.setIngredient('A', Material.DIAMOND_HOE));
	}
	public static void addRecipeHunterRobot() {
		Bukkit.addRecipe(new ShapedRecipe(remoteHunter)
				.shape("GAG", "DSD", "DDD")
				.setIngredient('D', Material.DIAMOND_BLOCK)
				.setIngredient('S', Material.ARMOR_STAND)
				.setIngredient('G', Material.GOLD_BLOCK)
				.setIngredient('A', Material.DIAMOND_SWORD));
	}
	public static void addRecipeLighterRobot() {
		Bukkit.addRecipe(new ShapedRecipe(remoteLighter)
				.shape("GAG", "DSD", "DDD")
				.setIngredient('D', Material.DIAMOND_BLOCK)
				.setIngredient('S', Material.ARMOR_STAND)
				.setIngredient('G', Material.GOLD_BLOCK)
				.setIngredient('A', Material.TORCH));
	}
	public static void addRecipeLumberjackRobot() {
		Bukkit.addRecipe(new ShapedRecipe(remoteLumberjack)
				.shape("GAG", "DSD", "DDD")
				.setIngredient('D', Material.DIAMOND_BLOCK)
				.setIngredient('S', Material.ARMOR_STAND)
				.setIngredient('G', Material.GOLD_BLOCK)
				.setIngredient('A', Material.GOLD_AXE));
	}
	public static void addRecipeMinerRobot() {
		Bukkit.addRecipe(new ShapedRecipe(remoteMiner)
				.shape("GAG", "DSD", "DDD")
				.setIngredient('D', Material.DIAMOND_BLOCK)
				.setIngredient('S', Material.ARMOR_STAND)
				.setIngredient('G', Material.GOLD_BLOCK)
				.setIngredient('A', Material.DIAMOND_PICKAXE));
	}
}
