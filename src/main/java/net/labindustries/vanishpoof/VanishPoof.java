package net.labindustries.vanishpoof;

import net.labindustries.vanishpoof.commands.VanishCommand;
import net.labindustries.vanishpoof.events.JoinEvent;
import net.labindustries.vanishpoof.events.Message;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class VanishPoof extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();
    public ArrayList<Player> chat_revoke = new ArrayList<>();

    @Override
    public void onEnable() {


        // Plugin startup logic
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new Message(this), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
