package uk.co.breadhub.mudmessages;

import java.sql.Timestamp;
import java.util.Objects;

import static java.lang.System.currentTimeMillis;

public class Util {

    public static void sendAnnouncementOfDeath(String name, String reason) {
        // Send Annoucementy of death with reason Lol
        // getInstance().getConfig().getString("plugin.channelID")
        MudMessages.getInstance().getServer().getConsoleSender().sendMessage("say Lol " + reason);
        MudMessages.getJda().getTextChannelById(Objects.requireNonNull(MudMessages.getInstance().getConfig().getString("plugin.channelID")))
                   .sendMessage(String.format(String.format("[%s] %%s", new Timestamp(currentTimeMillis())), reason)).queue();
    }
}
