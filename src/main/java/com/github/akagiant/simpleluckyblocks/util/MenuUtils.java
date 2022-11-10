package com.github.akagiant.simpleluckyblocks.util;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import org.bukkit.Bukkit;
import org.bukkit.Material;

public class MenuUtils {

	private MenuUtils() {
		//no instance
	}
	
	public static OutlinePane getFiller(Material filler, int length, int height) {
		OutlinePane outlinePane = new OutlinePane(length, height);
		outlinePane.addItem(new GuiItem(ItemManager.makeItem(filler, " ")));
		outlinePane.setRepeat(true);
		outlinePane.setPriority(Pane.Priority.LOWEST);
		return outlinePane;
	}

	public static OutlinePane getSeparatorPane(Material material, int length, int height, int startX, int startY) {

		OutlinePane pane = new OutlinePane(startX, startY - height, length, height);
		pane.setPriority(Pane.Priority.LOW);
		pane.setRepeat(true);
		pane.addItem(new GuiItem(ItemManager.makeItem(material, " ")));

		return pane;
	}
}
