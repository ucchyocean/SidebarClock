/*
 * @author     ucchy
 * @license    GPLv3
 * @copyright  Copyright ucchy 2013
 */
package com.github.ucchyocean.sc;

import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/**
 * @author ucchy
 * サイドバーに表示するチーム項目クラス
 */
public class SidebarItem implements OfflinePlayer {

    private String name;

    /**
     * コンストラクタ
     * @param team チーム
     */
    public SidebarItem(String name) {
        this.name = name;
    }

    /**
     * @see org.bukkit.OfflinePlayer#getName()
     */
    public String getName() {
        return name;
    }

    // 以下、OfflinePlayerインターフェイスのクラスで、使用しないメソッド。

    @Deprecated
    public boolean isOp() {
        return false;
    }

    @Deprecated
    public void setOp(boolean arg0) {
    }

    @Deprecated
    public Map<String, Object> serialize() {
        return null;
    }

    @Deprecated
    public Location getBedSpawnLocation() {
        return null;
    }

    @Deprecated
    public long getFirstPlayed() {
        return 0;
    }

    @Deprecated
    public long getLastPlayed() {
        return 0;
    }

    @Deprecated
    public Player getPlayer() {
        return null;
    }

    @Deprecated
    public boolean hasPlayedBefore() {
        return false;
    }

    @Deprecated
    public boolean isBanned() {
        return false;
    }

    @Deprecated
    public boolean isOnline() {
        return false;
    }

    @Deprecated
    public boolean isWhitelisted() {
        return true;
    }

    @Deprecated
    public void setBanned(boolean arg0) {
    }

    @Deprecated
    public void setWhitelisted(boolean arg0) {
    }

    @Deprecated
    public UUID getUniqueId() {
        return null;
    }
}
