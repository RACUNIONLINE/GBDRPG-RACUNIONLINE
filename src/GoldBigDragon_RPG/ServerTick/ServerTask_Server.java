package GoldBigDragon_RPG.ServerTick;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.CommandBlock;

public class ServerTask_Server
{
	public void CreateStructureMain(Long UTC)
	{
		ServerTickScheduleObject STSO = ServerTickMain.Schedule.get(UTC);
		if(STSO.getInt((byte)3)==0)
		{
			if(ServerTickMain.Schedule.get(UTC).getCount()==0)
				CreateCommandBlock(new Location(Bukkit.getServer().getWorld(STSO.getString((byte)1)), STSO.getInt((byte)0), STSO.getInt((byte)1), STSO.getInt((byte)2)));
			String CMD = new GoldBigDragon_RPG.Structure.StructureMain().getCMD(STSO.getString((byte)0), STSO.getCount(),STSO.getString((byte)2),STSO.getString((byte)3));
			if(CMD.compareTo("null")==0)
			{
				ServerTickMain.Schedule.remove(UTC);
				ServerTickMain.ServerTask="null";

				Location CommandLoc = new Location(Bukkit.getServer().getWorld(STSO.getString((byte)1)), STSO.getInt((byte)0), STSO.getInt((byte)1), STSO.getInt((byte)2));
				Block OriginalBlock = CommandLoc.getBlock();
				OriginalBlock.setTypeId(STSO.getInt((byte)6));
				OriginalBlock.setData((byte) STSO.getInt((byte)7));
				RemoveCommandBlock(CommandLoc, OriginalBlock);
				ServerTickMain.Schedule.remove(UTC);
				return;
			}
			else
			{
				Location CommandBlockLoc = new Location(Bukkit.getServer().getWorld(STSO.getString((byte)1)), STSO.getInt((byte)0), STSO.getInt((byte)1), STSO.getInt((byte)2));
				Block Command = CommandBlockLoc.getBlock();
			    CommandBlock CB = (CommandBlock)Command.getState();
			    CB.setCommand(CMD);
			    CB.update();
			    CommandBlockLoc.setY(CommandBlockLoc.getY()-1);
			    CreateRedStone(CommandBlockLoc);
			    new GoldBigDragon_RPG.Effect.Sound().SL(CommandBlockLoc, Sound.STEP_STONE, 1.0F, 1.0F);
			    
				STSO.setInt((byte)3, 1);
				ServerTickMain.Schedule.remove(UTC);
				for(int count=0;;count++)
				{
					if(ServerTickMain.Schedule.containsKey(UTC+(100+count))==false)
					{
						ServerTickMain.Schedule.put(UTC+(100+count), STSO);
						break;
					}
				}
			}
		}
		else
		{
			Location RedStoneLoc = new Location(Bukkit.getServer().getWorld(STSO.getString((byte)1)), STSO.getInt((byte)0), STSO.getInt((byte)1), STSO.getInt((byte)2));
			RedStoneLoc.setY(RedStoneLoc.getY()-1);
			Block OriginalBlock = RedStoneLoc.getBlock();
			OriginalBlock.setTypeId(STSO.getInt((byte)6));
			OriginalBlock.setData((byte) STSO.getInt((byte)7));
			RemoveRedStone(RedStoneLoc, OriginalBlock);
			STSO.setInt((byte)3, 0);
			STSO.setCount(STSO.getCount()+1);
			ServerTickMain.Schedule.remove(UTC);
			for(int count=0;;count++)
			{
				if(ServerTickMain.Schedule.containsKey(UTC+(100+count))==false)
				{
					ServerTickMain.Schedule.put(UTC+(100+count), STSO);
					break;
				}
			}
		}
	}
	
	public void CreateCommandBlock(Location loc)
	{
		Block Command = loc.getBlock();
		Command.setType(Material.COMMAND);
		Command.setData((byte)0);
		return;
	}
	
	public void CreateRedStone(Location loc)
	{
		Block RedStone = loc.getBlock();
		RedStone.setType(Material.REDSTONE_BLOCK);
		RedStone.setData((byte)0);
		return;
	}

	public void RemoveCommandBlock(Location loc, Block OriginalBlock)
	{
		Block Original = loc.getBlock();
		Original.setType(OriginalBlock.getType());
		Original.setData(OriginalBlock.getData());
		return;
	}
	
	public void RemoveRedStone(Location loc, Block OriginalBlock)
	{
		Block Original = loc.getBlock();
		Original.setType(OriginalBlock.getType());
		Original.setData(OriginalBlock.getData());
		return;
	}
}