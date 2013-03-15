package me.eero911.Heal;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Heal extends JavaPlugin{
  public final Logger logger = Logger.getLogger("Minecraft");
	public static Heal plugin;
	
	@override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	}
	
	@override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		
		if(commandLabel.equalsIgnoreCase("heal")|| commandLabel.equalsIgnoreCase("h")){
			if(args.length == 0){
				//heal = 0 args /heal Eero911 = 1 args
				player.setHealth(20);
				player.setFireTicks (0);
				player.setFoodLevel(20);
				player.sendMessage(ChatColor.GREEN + "You have been healed!");
			}else if(args.length == 1){
				if(player.getServer().getPlayer(args[0])!= null){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				targetPlayer.setHealth(20);
				targetPlayer.setFireTicks(0);
				targetPlayer.setFoodLevel(20);
				player.sendMessage(ChatColor.GREEN + "Player healed!");
				}else{
					player.sendMessage(ChatColor.RED + "That player is not online!");
					
					if(commandLabel.equalsIgnoreCase("heal")){
						
						if(player instanceof Player){
							
							if(player.hasPermission("heal.heal")){
								
								
							}else{
								
								player.sendMessage(ChatColor.DARK_RED + "You do not have permission!");
							}
						}
					}
				}
			}	
		}
		return false;
	}
}
