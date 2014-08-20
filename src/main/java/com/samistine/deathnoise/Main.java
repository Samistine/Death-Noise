package com.samistine.deathnoise;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		// TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("onEnable has been invoked!");
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
		getLogger().info("onDisable has been invoked!");
	}

	@EventHandler
	public void onKill(PlayerDeathEvent e) {
	    if (e.getEntity().getKiller() != null) {
			String killed = e.getEntity().getName();
			String killer = e.getEntity().getKiller().getName();
			e.setDeathMessage(ChatColor.RED + killed + " has been slain by " + killer);
		    Player player = (Player) e.getEntity();
		    player.getLocation().getWorld().strikeLightningEffect(player.getLocation());
		    player.getLocation().getWorld().playSound(player.getLocation(), Sound.GHAST_SCREAM2, 1, 1);
		    player.getLocation().getWorld().createExplosion(player.getLocation(), 0.0F);
		    player.getLocation().getWorld().playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 0 );
	    }
	}
}
