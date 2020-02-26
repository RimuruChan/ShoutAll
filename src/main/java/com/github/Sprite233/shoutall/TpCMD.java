package com.github.Sprite233.shoutall;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TpCMD extends Command {
    public TpCMD(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage("§c后台不能使用此命令");
            return;
        }
        if (args.length != 1) {
            sender.sendMessage("§c参数错误");
            return;
        }

        Data data = null;
        for (Data tmpData : ShoutAll.getInstance().getAllData().values()) {
            if (tmpData.token.equals(args[0])) {
                data = tmpData;
                break;
            }
        }

        if (data != null && (180 - (int) (System.currentTimeMillis() / 1000 - data.time)) <= 0) {
            ((ProxiedPlayer) sender).connect(ShoutAll.getInstance().getProxy().getServerInfo(data.server));
        } else {
            sender.sendMessage(new TextComponent("§c未知的 Token 或 Token 已失效."));
        }
    }
}
