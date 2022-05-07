package de.robble.sudoplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class sudoCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Player target = Bukkit.getPlayerExact(args[0]);
            String cmd = "";
            String tcmd = "";

            for(int i = 1; i < args.length; i++) {
                cmd = cmd + args[i] + " ";
            }
            if(player.isOp()){
                if(target != null){
                    if(target.isOnline()){
                        if(args[1].equals("c:")){
                            for(int i = 2; i < args.length; i++) {
                                tcmd = tcmd + args[i] + " ";
                            }
                            target.chat(tcmd);
                        }else {
                            target.performCommand(cmd);
                        }
                    }else {
                        player.sendMessage("§cDieser Spieler ist nicht online!");
                    }
                }else {
                    player.sendMessage("§cDieser Spieler ist unbekannt!");
                }
            }else{
                player.sendMessage("§cKeine Rechte!");
            }
        }
        return false;
    }
}
