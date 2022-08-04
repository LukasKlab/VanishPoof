package net.labindustries.vanishpoof.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.labindustries.vanishpoof.VanishPoof;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Message implements Listener {


    VanishPoof vanishPoof;
    public Message(VanishPoof vanishPoof) {
        this.vanishPoof = vanishPoof;
    }


    @EventHandler
    public void onPlayerMessage(AsyncChatEvent event) {
        Player player = event.getPlayer();



        if(vanishPoof.invisible_list.contains(player)) {
            event.setCancelled(true);
            player.sendMessage("You cannot type while in vanish!");

        } else if(vanishPoof.chat_revoke.contains(player)) {
            event.setCancelled(true);
            player.sendMessage("You cannot type while in vanish!");

        }



    }



}
