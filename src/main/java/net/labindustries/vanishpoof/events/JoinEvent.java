package net.labindustries.vanishpoof.events;

import net.labindustries.vanishpoof.VanishPoof;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class JoinEvent implements Listener {


    VanishPoof vanishPoof;
    public JoinEvent(VanishPoof vanishPoof) {
        this.vanishPoof = vanishPoof;
    }


    @EventHandler
    public void PlayerJoin(org.bukkit.event.player.PlayerJoinEvent event){
        Player player = event.getPlayer();
        for (int i = 0; i < vanishPoof.invisible_list.size(); i++){
            player.hidePlayer(vanishPoof, vanishPoof.invisible_list.get(i));
        }
    }



}
