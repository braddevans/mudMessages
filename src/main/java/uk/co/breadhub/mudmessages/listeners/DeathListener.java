package uk.co.breadhub.mudmessages.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import uk.co.breadhub.mudmessages.MudMessages;
import uk.co.breadhub.mudmessages.Util;

import java.util.Objects;

public class DeathListener implements Listener {
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();
        if (player.getUniqueId().toString().equals(MudMessages.getInstance().getConfig().getString("plugin.playerUUID"))) {
            Util.sendAnnouncementOfDeath(player.getName(), event.getDeathMessage());
        }
    }
}
