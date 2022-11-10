package com.github.akagiant.simpleluckyblocks.util;

import com.github.akagiant.simpleluckyblocks.SimpleLuckyBlocks;
import me.akagiant.giantapi.util.ColorManager;
import org.bukkit.Bukkit;

public class Logger {

	private Logger() {
		//no instance
	}
	
	public static void info(String msg) {
		Bukkit.getConsoleSender().sendMessage(
				ColorManager.formatColours("&8[&b" + SimpleLuckyBlocks.getPlugin().getName() + " &b&lINFO&8] " + msg)
		);
	}

	public static void warn(String msg) {
		Bukkit.getConsoleSender().sendMessage(
				ColorManager.formatColours("&8[&6" + SimpleLuckyBlocks.getPlugin().getName() + " &6&lWARN&8] " + msg)
		);
	}

	public static void severe(String msg) {
		Bukkit.getConsoleSender().sendMessage(
				ColorManager.formatColours("&8[&c" + SimpleLuckyBlocks.getPlugin().getName() + " &c&lSEVERE&8] " + msg)
		);
	}

	public static void toConsole(String msg) {
		Bukkit.getConsoleSender().sendMessage(
				ColorManager.formatColours("&8[&b" + SimpleLuckyBlocks.getPlugin().getName() + "&8] " + msg)
		);
	}

}
