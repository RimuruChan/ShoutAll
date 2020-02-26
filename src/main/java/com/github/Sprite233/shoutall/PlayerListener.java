package com.github.Sprite233.shoutall;

import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PostLoginEvent event) {
        Data data = new Data("", System.currentTimeMillis() / 1000, "", "");
        ShoutAll.getInstance().getAllData().put(event.getPlayer(), data);
    }

    @EventHandler
    public void onLeave(PlayerDisconnectEvent event) {
        ShoutAll.getInstance().getAllData().remove(event.getPlayer());
    }
}
