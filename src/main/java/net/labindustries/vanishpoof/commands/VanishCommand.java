package net.labindustries.vanishpoof.commands;

import net.labindustries.vanishpoof.VanishPoof;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VanishCommand implements CommandExecutor {

    VanishPoof vanishPoof;
    public VanishCommand(VanishPoof vanishPoof) {
        this.vanishPoof = vanishPoof;
    }


    @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (sender instanceof Player){
                Player player = (Player) sender;
                if (vanishPoof.invisible_list.contains(player)){

                    String fakeJoinMessage = ChatColor.GRAY + " has entered the game!";

                    for (Player people : Bukkit.getOnlinePlayers()){
                        people.showPlayer(vanishPoof, player);
                    }
                    vanishPoof.chat_revoke.remove(player);
                    vanishPoof.invisible_list.remove(player);
                    player.sendMessage("You are now visible to other players on the server.");
                    Bukkit.broadcastMessage(ChatColor.GRAY + player.getName() + fakeJoinMessage);


                }else if(!vanishPoof.invisible_list.contains(player)){

                    String fakeQuitMessage = ChatColor.GRAY + " has disembarked!";

                    for (Player people : Bukkit.getOnlinePlayers()){
                        if(!people.hasPermission("vanishpoof.always-visible")) {
                            people.hidePlayer(vanishPoof, player);
                        }

                    }

                    vanishPoof.chat_revoke.add(player);
                    vanishPoof.invisible_list.add(player);
                    player.sendMessage("You are now invisible!");
                    Bukkit.broadcastMessage(ChatColor.GRAY + player.getName() + fakeQuitMessage);
                }
            }

            return true;
        }

    }

