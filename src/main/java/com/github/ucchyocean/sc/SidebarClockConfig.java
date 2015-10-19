package com.github.ucchyocean.sc;

import java.io.File;
import java.util.TimeZone;

import org.bukkit.configuration.file.YamlConfiguration;

public class SidebarClockConfig {

    private SidebarClock plugin;

    private String titleFormat;
    private String itemFormat;
    private TimeZone timezone;

    public SidebarClockConfig(SidebarClock plugin) {
        this.plugin = plugin;
        reload();
    }

    protected void reload() {

        File folder = plugin.getDataFolder();
        if ( !folder.exists() ) {
            folder.mkdirs();
        }

        File file = new File(folder, "config.yml");
        if ( !file.exists() ) {
            Utility.copyFileFromJar(plugin.getFile(), file, "config_ja.yml", false);
        }

        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);

        titleFormat = conf.getString("titleFormat", "M月d日(E)");
        itemFormat = conf.getString("itemFormat", "HH:mm:");

        String timezoneTemp = conf.getString("timezone", "Asia/Tokyo");
        timezone = TimeZone.getTimeZone(timezoneTemp);
    }

    /**
     * @return titleFormat
     */
    public String getTitleFormat() {
        return titleFormat;
    }

    /**
     * @return itemFormat
     */
    public String getItemFormat() {
        return itemFormat;
    }

    /**
     * @return timezone
     */
    public TimeZone getTimezone() {
        return timezone;
    }
}
