package GoldBigDragon_RPG.Event;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftItem;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.inventory.ItemStack;

import GoldBigDragon_RPG.Util.YamlController;
import GoldBigDragon_RPG.Util.YamlManager;

public class Fishing
{
	public void PlayerFishing(PlayerFishEvent event)
	{
		if(event.getState() == State.CAUGHT_FISH)
		{
			GoldBigDragon_RPG.ETC.Area A = new GoldBigDragon_RPG.ETC.Area();
			String Area = A.getAreaName(event.getPlayer());
			if(Area != null)
			{
				if(event.getCaught().getType() == EntityType.DROPPED_ITEM)
				{
					CraftItem fish = (CraftItem) event.getCaught();
					
					GoldBigDragon_RPG.Util.Number etc = new GoldBigDragon_RPG.Util.Number();
				    YamlController Event_YC=GoldBigDragon_RPG.Main.Main.YC_1;
					YamlManager AreaConfig =Event_YC.getNewConfig("Area/AreaList.yml");
					int randomnum = etc.RandomNum(1, 100);
					int size = 0;
					ItemStack item = fish.getItemStack();
					if(randomnum <= 54)
					{
						size = AreaConfig.getConfigurationSection(Area+".Fishing.54").getKeys(false).size();
						if(size !=0)
						{
							randomnum = etc.RandomNum(1, size)-1;
							item = AreaConfig.getItemStack(Area+".Fishing.54."+randomnum);
						}
					}
					else if(randomnum <= 84)
					{
						size = AreaConfig.getConfigurationSection(Area+".Fishing.30").getKeys(false).size();
						if(size !=0)
						{
							randomnum = etc.RandomNum(1, size)-1;
							item = AreaConfig.getItemStack(Area+".Fishing.30."+randomnum);
						}
					}
					else if(randomnum <= 94)
					{
						size = AreaConfig.getConfigurationSection(Area+".Fishing.10").getKeys(false).size();
						if(size !=0)
						{
							randomnum = etc.RandomNum(1, size)-1;
							item = AreaConfig.getItemStack(Area+".Fishing.10."+randomnum);
						}
					}
					else if(randomnum <= 99)
					{
						size = AreaConfig.getConfigurationSection(Area+".Fishing.5").getKeys(false).size();
						if(size !=0)
						{
							randomnum = etc.RandomNum(1, size)-1;
							item = AreaConfig.getItemStack(Area+".Fishing.5."+randomnum);
						}
					}
					else
					{
						size = AreaConfig.getConfigurationSection(Area+".Fishing.1").getKeys(false).size();
						if(size !=0)
						{
							randomnum = etc.RandomNum(1, size)-1;
							item = AreaConfig.getItemStack(Area+".Fishing.1."+randomnum);
						}
					}
					fish.setItemStack(item);
				}
			}
		}
		return;
	}
}
