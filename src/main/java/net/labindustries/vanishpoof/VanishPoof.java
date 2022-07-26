package net.labindustries.vanishpoof;

import net.labindustries.vanishpoof.commands.VanishCommand;
import net.labindustries.vanishpoof.events.JoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class VanishPoof extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public void onEnable() {


        // Plugin startup logic
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
