package com.github.akagiant.simpleluckyblocks.menus;

import com.github.akagiant.simpleluckyblocks.util.ItemManager;
import com.github.akagiant.simpleluckyblocks.util.MenuUtils;
import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class MenuCreate {

	private MenuCreate() {
		//no instance
	}

	public static void open(Player player) {
		ChestGui gui = new ChestGui(6, "Lucky Block Creator");

		gui.addPane(MenuUtils.getFiller(Material.BLACK_STAINED_GLASS_PANE, 9, gui.getRows()));

		gui.addPane(MenuUtils.getSeparatorPane(Material.PURPLE_STAINED_GLASS_PANE, 9, 1, 0, gui.getRows() - 1));

		// Navigation Pane with Create, Delete, View Draft, View Deleted, View Enabled, View Disabled, Set Permission Data.

		// Permission Data
		// global place ? toggleable
		// global break ? toggleable

		StaticPane pane = new StaticPane(0, gui.getRows() - 1, 9,1);


		// TODO: MAKE SURE THAT ANY MODIFICATIONS ARE SAVED IF THEY GO BACK.
		pane.addItem(new GuiItem(ItemManager.makeItem(Material.BARRIER,
				"&c&lBACK", "&7&o(( Click to go back to the main menu ))"), e -> {
			MenuConfirmClose.open(player);
		}), 5, 0);

		pane.addItem(new GuiItem(ItemManager.makeItem(Material.REDSTONE_TORCH, "&c&lPERMISSION SETTINGS",
				"Left-Click - Place Permission",
				"Shift-Left-Click - Toggle Requires Permission to Place",
				"Right-Click - Break Permission",
				"Right-Left-Click - Toggle Requires Permission to Break"
		)), 7, 0);


		gui.addPane(pane);


		gui.setOnClose(e -> {
			MenuConfirmClose.open(player);
		});

		gui.setOnGlobalClick(e -> e.setCancelled(true));
		gui.show(player);

	}

}
