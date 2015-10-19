/*
 * @author     ucchy
 * @license    GPLv3
 * @copyright  Copyright ucchy 2013
 */
package com.github.ucchyocean.sc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

/**
 * @author ucchy
 * サイドバー表示をするためのAPIクラス
 */
public class SidebarDisplay extends BukkitRunnable {

    private SimpleDateFormat fDate;
    private SimpleDateFormat fHM;
    private Calendar calendar;

    private Scoreboard scoreboard;
    private Objective objective;
    private SidebarItem item;

    /**
     * コンストラクタ。
     */
    public SidebarDisplay(SidebarClock plugin) {

        this.fDate = new SimpleDateFormat(plugin.getClockConfig().getTitleFormat());
        this.fHM = new SimpleDateFormat(plugin.getClockConfig().getItemFormat());
        this.calendar = Calendar.getInstance(plugin.getClockConfig().getTimezone());
        this.scoreboard = plugin.getServer().getScoreboardManager().getMainScoreboard();
    }

    /**
     * 表示の初期化
     */
    public void init() {

        if ( scoreboard.getObjective("clock") != null ) {
            scoreboard.getObjective("clock").unregister();
        }
        objective = scoreboard.registerNewObjective("clock", "");
        objective.setDisplayName("");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        setTime();
    }

    /**
     * 1秒ごとに呼び出されるメソッド
     * @see java.lang.Runnable#run()
     */
    public void run() {
        if ( objective == null ) {
            init();
        }
        setTime();
    }

    /**
     * サイドバーに時刻を表示する
     */
    @SuppressWarnings("deprecation")
    private void setTime() {

        Date date = new Date();
        calendar.setTime(date);
        String dateDisplay = fDate.format(date);
        String hmDisplay = ChatColor.RED + fHM.format(date);
        int seconds = calendar.get(Calendar.SECOND);

        objective.setDisplayName(dateDisplay);

        if ( item == null ) {
            item = new SidebarItem(hmDisplay);
        } else if ( !item.getName().equals(hmDisplay) ) {
            objective.getScore(item).setScore(0);
            scoreboard.resetScores(item);
            item = new SidebarItem(hmDisplay);
        }

        if ( seconds == 0 ) {
            // NOTE: 全ての項目に0点を設定すると、スコアボードが非表示になるため、
            //       一旦1を設定する必要がある。
            objective.getScore(item).setScore(1);
            objective.getScore(item).setScore(0);
        } else {
            objective.getScore(item).setScore(seconds);
        }
    }
}
