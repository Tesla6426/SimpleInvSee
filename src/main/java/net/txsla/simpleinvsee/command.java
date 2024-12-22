package net.txsla.simpleinvsee;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class command implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        // break apart command args to make code more readable
        // compiler will prob undo this
        String action = args[1];
        String username = args[2];

        // get payer info
        Player player = sender.getServer().getPlayer(username);

        // make sure player isn't null
        if (player == null) {
            sender.sendMessage( "Error: Player not found!");
            return true;
        }


        switch (action.toLowerCase()) {
            case "view":
                // format display inv

                Inventory inv = Bukkit.createInventory((Player) sender, 54, player.displayName());
                player.getInventory().getStorageContents();
                // add stored items

                inv.setContents( player.getInventory().getStorageContents() );

                break;
            case "echest":

                break;
            default:
                return false;
        }

        return false;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> tab = new ArrayList<>();
        switch (strings.length) {
            case 1:
                tab.add("view");
                tab.add("echest");
                break;
            default:
                return null;
        }

        return tab;
    }
}
