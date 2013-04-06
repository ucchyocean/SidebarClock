/*
 * @author     ucchy
 * @license    GPLv3
 * @copyright  Copyright ucchy 2013
 */
package com.github.ucchyocean.sc;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author ucchy
 * サイドバーに日付と時刻を表示するプラグイン
 */
public class SidebarClock extends JavaPlugin {

    /**
     * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
     */
    @Override
    public void onEnable() {
        SidebarDisplay display = new SidebarDisplay(getServer());
        getServer().getScheduler().scheduleSyncRepeatingTask(this, display, 20, 20);
    }
}
