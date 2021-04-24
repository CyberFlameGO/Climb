package net.cyberflame.climb;

import java.util.HashMap;
import java.util.Random;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Climb
  extends JavaPlugin
  implements Listener {
  public static HashMap<Player, Boolean> climb = new HashMap<>();
  
  public void onEnable() {
    Bukkit.getServer().getPluginManager().registerEvents(this, (Plugin)this);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("climb")) {
      if (args.length == 0) {
        if (p.hasPermission("climb.use")) {
          if (climb.containsKey(p)) {
            if (((Boolean)climb.get(p)).booleanValue()) {
              climb.put(p, Boolean.valueOf(false));
              p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[FS] &3Climb disabled."));
            } else {
              climb.put(p, Boolean.valueOf(true));
              p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[FS] &3Climb enabled."));
            } 
          } else {
            climb.put(p, Boolean.valueOf(true));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[FS] &3Climb enabled."));
          } 
        } else {
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[FS] &cYou do not have permission for that."));
        }
      
      } else if (args.length == 1 && 
        args[0].equalsIgnoreCase("item")) {
        if (p.hasPermission("climb.give")) {
          ItemStack stack = new ItemStack(Material.POTION, 1);
          ItemMeta meta = stack.getItemMeta();
          meta.setDisplayName(ChatColor.RESET + "Potion of Slope");
          stack.setItemMeta(meta);
          p.getInventory().addItem(new ItemStack[] { stack });
        } else {
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[FS] &cYou do not have permission for that."));
        } 
      } 
    }



    
    return true;
  }



  
  @EventHandler
  public void onPlayerMove(PlayerMoveEvent e) {
    Player p = e.getPlayer();
    int intPlayerX = p.getLocation().getBlockX();
    int intPlayerY = p.getLocation().getBlockY();
    int intPlayerZ = p.getLocation().getBlockZ();
    double dubPlayerX = p.getLocation().getX();
    double dubPlayerZ = p.getLocation().getZ();
    if (climb.containsKey(p)) {
      if (((Boolean)climb.get(p)).booleanValue()) {
        if (!p.isOnGround() && dubPlayerX - intPlayerX >= 0.69D && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.AIR && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.WATER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.STATIONARY_WATER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.SAPLING && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.CARPET && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.CROPS && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.DOUBLE_PLANT && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.FIRE && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.FLOWER_POT && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.IRON_TRAPDOOR && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.LADDER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.LAVA && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.LEVER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.LONG_GRASS && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.MELON_SEEDS && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.MELON_STEM && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.NETHER_STALK && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.NETHER_WARTS && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.PAINTING && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.POWERED_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.RAILS && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.ACTIVATOR_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.DETECTOR_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.POWERED_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.RED_MUSHROOM && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.BROWN_MUSHROOM && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.SNOW && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.SAPLING && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.TRAP_DOOR && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.SKULL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.SKULL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.STATIONARY_LAVA && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.BANNER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.STANDING_BANNER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.WALL_SIGN && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX + 1), intPlayerY, intPlayerZ)).getType() != Material.WALL_BANNER) {
          if (getRandom(1, 11) < 10) {
            p.setVelocity(new Vector(0.0D, 0.3D, 0.0D));
          }
        } else if (!p.isOnGround() && dubPlayerX - intPlayerX <= 0.31D && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.AIR && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.WATER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.STATIONARY_WATER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.SAPLING && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.CARPET && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.CROPS && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.DOUBLE_PLANT && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.FIRE && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.FLOWER_POT && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.IRON_TRAPDOOR && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.LADDER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.LAVA && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.LEVER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.LONG_GRASS && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.MELON_SEEDS && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.MELON_STEM && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.NETHER_STALK && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.NETHER_WARTS && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.PAINTING && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.POWERED_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.RAILS && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.ACTIVATOR_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.DETECTOR_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.POWERED_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.RED_MUSHROOM && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.BROWN_MUSHROOM && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.SNOW && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.SAPLING && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.TRAP_DOOR && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.SKULL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.SKULL && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.STATIONARY_LAVA && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.BANNER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.STANDING_BANNER && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.WALL_SIGN && p.getWorld().getBlockAt(new Location(p.getWorld(), (intPlayerX - 1), intPlayerY, intPlayerZ)).getType() != Material.WALL_BANNER) {
          if (getRandom(1, 11) < 10) {
            p.setVelocity(new Vector(0.0D, 0.3D, 0.0D));
          }
        } else if (!p.isOnGround() && dubPlayerZ - intPlayerZ >= 0.69D && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.AIR && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.WATER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.STATIONARY_WATER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.SAPLING && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.CARPET && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.CROPS && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.DOUBLE_PLANT && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.FIRE && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.FLOWER_POT && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.IRON_TRAPDOOR && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.LADDER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.LAVA && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.LEVER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.LONG_GRASS && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.MELON_SEEDS && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.MELON_STEM && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.NETHER_STALK && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.NETHER_WARTS && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.PAINTING && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.POWERED_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.RAILS && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.ACTIVATOR_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.DETECTOR_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.POWERED_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.RED_MUSHROOM && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.BROWN_MUSHROOM && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.SNOW && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.SAPLING && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.TRAP_DOOR && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.SKULL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.SKULL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.STATIONARY_LAVA && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.BANNER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.STANDING_BANNER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.WALL_SIGN && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ + 1))).getType() != Material.WALL_BANNER) {
          if (getRandom(1, 11) < 10) {
            p.setVelocity(new Vector(0.0D, 0.3D, 0.0D));
          }
        } else if (!p.isOnGround() && dubPlayerZ - intPlayerZ <= 0.31D && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.AIR && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.WATER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.STATIONARY_WATER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.SAPLING && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.CARPET && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.CROPS && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.DOUBLE_PLANT && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.FIRE && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.FLOWER_POT && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.IRON_TRAPDOOR && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.LADDER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.LAVA && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.LEVER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.LONG_GRASS && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.MELON_SEEDS && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.MELON_STEM && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.NETHER_STALK && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.NETHER_WARTS && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.PAINTING && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.POWERED_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.RAILS && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.ACTIVATOR_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.DETECTOR_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.POWERED_RAIL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.RED_MUSHROOM && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.BROWN_MUSHROOM && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.SNOW && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.SAPLING && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.TRAP_DOOR && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.SKULL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.SKULL && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.STATIONARY_LAVA && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.BANNER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.STANDING_BANNER && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.WALL_SIGN && p.getWorld().getBlockAt(new Location(p.getWorld(), intPlayerX, intPlayerY, (intPlayerZ - 1))).getType() != Material.WALL_BANNER && 
          getRandom(1, 11) < 10) {
          p.setVelocity(new Vector(0.0D, 0.3D, 0.0D));
        } 
      }
    } else {
      
      climb.put(p, Boolean.valueOf(false));
    } 
  }
  
  @EventHandler
  public void playerConsume(PlayerItemConsumeEvent e) {
    Player p = e.getPlayer();
    if (e.getItem().getType() == Material.POTION && 
      e.getItem().getItemMeta().getDisplayName().contains("Slope")) {
      climb.put(p, Boolean.valueOf(true));
      p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[FS] &3Climb enabled."));
    } 
  }

  
  @EventHandler
  public void playerDeath(PlayerDeathEvent e) {
    Player p = e.getEntity();
    if (((Boolean)climb.get(p)).booleanValue()) {
      climb.put(p, Boolean.valueOf(false));
      p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b[FS] &3Climb disabled."));
    } 
  }
  
  public static int getRandom(int lower, int upper) {
    Random random = new Random();
    return random.nextInt(upper - lower + 1) + lower;
  }
}
