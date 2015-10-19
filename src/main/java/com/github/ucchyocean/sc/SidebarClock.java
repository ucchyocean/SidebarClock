/*
 * @author     ucchy
 * @license    GPLv3
 * @copyright  Copyright ucchy 2013
 */
package com.github.ucchyocean.sc;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author ucchy
 * サイドバーに日付と時刻を表示するプラグイン
 */
public class SidebarClock extends JavaPlugin {

    private SidebarClockConfig config;
    private SidebarDisplay display;

    /**
     * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
     */
    @Override
    public void onEnable() {

        // コンフィグのロード
        config = new SidebarClockConfig(this);

        display = new SidebarDisplay(this);
        display.runTaskTimer(this, 20, 20);
    }

    /**
     * @see org.bukkit.plugin.java.JavaPlugin#onCommand(org.bukkit.command.CommandSender, org.bukkit.command.Command, java.lang.String, java.lang.String[])
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if ( args.length >= 1 && args[0].equalsIgnoreCase("reload") ) {
            config.reload();
            display.cancel();
            display = new SidebarDisplay(this);
            display.runTaskTimer(this, 20, 20);
            sender.sendMessage("Sidebar reload completed.");
            return true;
        }

        return true;
    }

    protected File getFile() {
        return super.getFile();
    }

    protected SidebarClockConfig getClockConfig() {
        return config;
    }
}
