package com.kirelcodes.RoboticCraft.robot;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

public class RobotBreader extends RobotBase{
	
	private boolean isBreading=false;
	
	public RobotBreader(Location loc) {
		super(loc);
		getArmorStand().setItemInHand(new ItemStack(Material.WHEAT));
		
	}
	
	public void bread() {
		Ageable a1 = null;
		Ageable a2 = null;
		for(Entity e : getArmorStand().getNearbyEntities(10, 10, 10)) {
			if(e instanceof Ageable) {
				Ageable a = (Ageable)e;
				if(a.canBreed()) {
					if(a1==null) {
						a1=a;
					} else {
						if(a1.getType()==a.getType()){
							a2=a;
							break;
						}
					}
				}
			}
		}
		a1.setBreed(true);
		a2.setBreed(true);
	}
	
	public boolean isBreading() {
		return isBreading;
	}
	
	
	
	
	
}