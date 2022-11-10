package com.github.akagiant.simpleluckyblocks.commands;

import com.github.akagiant.simpleluckyblocks.menus.MenuManage;
import dev.jorel.commandapi.CommandAPICommand;

public class SLP {

	public static void register() {
		new CommandAPICommand("slp")
				.withAliases("simpleluckyblocks", "simpleluckyblock")
				.withPermission("simpleluckyblocks.create")
				.executesPlayer((player, objects) -> {
					MenuManage.open(player);
				})
				.register();
	}

}
