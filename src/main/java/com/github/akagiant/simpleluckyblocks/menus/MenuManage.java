package com.github.akagiant.simpleluckyblocks.menus;

import com.github.akagiant.simpleluckyblocks.util.ItemManager;
import com.github.akagiant.simpleluckyblocks.util.MenuUtils;
import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class MenuManage {

	private MenuManage() {
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


		pane.addItem(new GuiItem(ItemManager.createCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzhmY2EzNDVlNGZkOWM0MjJiNzNjNGMxYzUwNTZmMzc5ZGU5MjUxMGZjOTRiNGNjOTA3ZmIyMGNlNzUwZGM5MCJ9fX0=",
				"&a&lCREATE NEW", "&7&o(( Click to create a new LuckyBlock Type ))"), e -> {
			gui.setOnClose(ev -> { return; });
			MenuCreate.open(player);
		}), 4, 0);

		pane.addItem(new GuiItem(ItemManager.createCustomSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzE2ODA4MTI2ZWVjMGNkNDFkNjA0MGUyMTE5ODU3MTkyNzJjMzg4ZDMyZWNhZTc5NWQ0N2Y3YTljZWU3MTExMyJ9fX0=",
				"&a&lFILTER", "&7&o(( Click to filter between All, Draft, Enabled and Disabled Lucky Blocks  ))"), e -> {
			// TODO: Filter between LuckyBlock States.
		}), 6, 0);

		gui.addPane(pane);


		gui.setOnClose(e -> {
			MenuConfirmClose.open(player);
		});

		gui.setOnGlobalClick(e -> e.setCancelled(true));
		gui.show(player);

	}

}
