package com.github.Sprite233.shoutall;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

import java.util.HashMap;
import java.util.Map;

public final class ShoutAll extends Plugin {

    private Map<ProxiedPlayer, Data> allData = new HashMap<>();

    public static ShoutAll getInstance() {
        return ((ShoutAll) ProxyServer.getInstance().getPluginManager().getPlugin("ShoutAll"));
    }

    @Override
    public void onEnable() {
        installCMD();
        getProxy().getPluginManager().registerListener(this, new PlayerListener());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void installCMD() {
        getProxy().getPluginManager().registerCommand(this, new ShoutCMD("shoutall", "shoutall.shout", "hh"));
        getProxy().getPluginManager().registerCommand(this, new TpCMD("tpserver", "shoutall.tp"));
    }

    public Map<ProxiedPlayer, Data> getAllData() {
        return allData;
    }
}
