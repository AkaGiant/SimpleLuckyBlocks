package com.github.akagiant.simpleluckyblocks.menus;

import com.github.akagiant.simpleluckyblocks.util.ItemManager;
import com.github.akagiant.simpleluckyblocks.util.MenuUtils;
import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class MenuConfirmClose {

	private MenuConfirmClose() {
		//no instance
	}
	
	public static void open(Player player) {
		ChestGui gui = new ChestGui(3, "Confirm Close");
		gui.addPane(MenuUtils.getFiller(Material.BLACK_STAINED_GLASS_PANE, 9, gui.getRows()));

		StaticPane pane = new StaticPane(0, 1, 9, 1);

		// Will save the current lucky block as a draft.
		pane.addItem(new GuiItem(ItemManager.makeItem(Material.GREEN_STAINED_GLASS_PANE, "&a&lSAVE AND CLOSE"), e -> {
			player.sendMessage("NOT ACTUALLY SAVED");

			// Cancels out the fact they closed without selecting anything as they did select something.
			gui.setOnClose(ev -> { return; });
			player.closeInventory();
		}), 3, 0);

		// Will NOT save the current lucky block.
		pane.addItem(new GuiItem(ItemManager.makeItem(Material.RED_STAINED_GLASS_PANE, "&a&lDELETE AND CLOSE"), e -> {
			player.closeInventory();
		}), 5, 0);

		gui.addPane(pane);

		gui.setOnClose(e -> {
			// Only to be run if a player closes without selecting anything or if the select "delete and close"
			player.sendMessage("test");
		});

		gui.setOnGlobalClick(e -> e.setCancelled(true));
		gui.show(player);
	}

}
