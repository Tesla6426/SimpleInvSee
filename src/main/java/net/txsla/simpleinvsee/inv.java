package net.txsla.simpleinvsee;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;

public class inv {
    Inventory invToChest(Player p) {

        Inventory inv = Bukkit.createInventory(p, 54, p.displayName());

        return null;
    }
}
