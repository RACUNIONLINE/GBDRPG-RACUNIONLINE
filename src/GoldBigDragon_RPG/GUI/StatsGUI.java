package GoldBigDragon_RPG.GUI;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import GoldBigDragon_RPG.Util.YamlController;
import GoldBigDragon_RPG.Util.YamlManager;
import GoldBigDragon_RPG.Event.Damage;


public class StatsGUI extends GUIutil
{
	//스텟 GUI창의 1 페이지를 구성해 주는 메소드//
	public void StatusGUI(Player player)
	{
		Damage dam = new Damage();
	    YamlManager YM,Config;
		YamlController YC_2 = GoldBigDragon_RPG.Main.Main.YC_2;
	  	if(YC_2.isExit("Stats/" + player.getUniqueId()+".yml") == false)
	  		new GoldBigDragon_RPG.Config.StatConfig().CreateNewStats(player);
		YM = YC_2.getNewConfig("Stats/" + player.getUniqueId()+".yml");
		Config = YC_2.getNewConfig("config.yml");
		
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.BLACK + "스텟");

		Stack2(ChatColor.WHITE + "스텟", 160,4,1,Arrays.asList(ChatColor.GRAY + "스텟을 확인합니다."), 0, inv);
		Stack2(ChatColor.WHITE + "스킬", 403,0,1,Arrays.asList(ChatColor.GRAY + "스킬을 확인합니다."), 9, inv);
		Stack2(ChatColor.WHITE + "퀘스트", 358,0,1,Arrays.asList(ChatColor.GRAY + "현재 진행중인 퀘스트를 확인합니다."), 18, inv);
		Stack2(ChatColor.WHITE + "옵션", 145,0,1,Arrays.asList(ChatColor.GRAY + "기타 설정을 합니다."), 27, inv);
		Stack2(ChatColor.WHITE + "기타", 354,0,1,Arrays.asList(ChatColor.GRAY + "기타 내용을 확인합니다."), 36, inv);
		
		Stack2(ChatColor.RED + " ", 66,0,1,Arrays.asList(""), 1, inv);
		Stack2(ChatColor.RED + " ", 66,0,1,Arrays.asList(""), 7, inv);
		Stack2(ChatColor.RED + " ", 66,0,1,Arrays.asList(""), 10, inv);
		Stack2(ChatColor.RED + " ", 66,0,1,Arrays.asList(""), 16, inv);
		Stack2(ChatColor.RED + " ", 66,0,1,Arrays.asList(""), 19, inv);
		Stack2(ChatColor.RED + " ", 66,0,1,Arrays.asList(""), 25, inv);
		Stack2(ChatColor.RED + " ", 66,0,1,Arrays.asList(""), 28, inv);
		Stack2(ChatColor.RED + " ", 66,0,1,Arrays.asList(""), 34, inv);
		Stack2(ChatColor.RED + " ", 66,0,1,Arrays.asList(""), 37, inv);
		Stack2(ChatColor.RED + " ", 66,0,1,Arrays.asList(""), 43, inv);
		
		ItemStack EXIT = new ItemStack(Material.WOOD_DOOR, 1);
		ItemMeta EXIT_BUTTON = EXIT.getItemMeta();
		EXIT_BUTTON.setDisplayName(ChatColor.WHITE  + "" + ChatColor.BOLD + "닫기");
		EXIT_BUTTON.setLore(Arrays.asList(ChatColor.GRAY + "창을 닫습니다."));
		EXIT.setItemMeta(EXIT_BUTTON);
		inv.setItem(26, EXIT);

		if(Config.getBoolean("Server.Like_The_Mabinogi_Online_Stat_System") == true)
		{
			Stack2(ChatColor.GREEN + "    [" + ChatColor.WHITE +""+ChatColor.BOLD + "상태"+ChatColor.GREEN + "]", 397,3,1,
					Arrays.asList(ChatColor.WHITE + "[레벨] : " +ChatColor.BOLD + YM.getInt("Stat.Level"),
							ChatColor.WHITE + "[누적 레벨] : " +ChatColor.BOLD + YM.getInt("Stat.RealLevel"),
							ChatColor.WHITE + "[경험치] : " + ChatColor.BOLD + YM.getInt("Stat.EXP") + " / " + YM.getInt("Stat.MaxEXP"),
							ChatColor.AQUA + "[스킬 포인트] : " + ChatColor.WHITE + ChatColor.BOLD + YM.getInt("Stat.SkillPoint")), 13, inv);
		}
		else
		{
			YamlManager PlayerSkillYML = YC_2.getNewConfig("Skill/PlayerData/"+player.getUniqueId()+".yml");
			Stack2(ChatColor.GREEN + "       [" + ChatColor.WHITE +""+ChatColor.BOLD + "상태"+ChatColor.GREEN + "]", 397,3,1,
					Arrays.asList(ChatColor.WHITE + "[레벨] : " +ChatColor.BOLD + YM.getInt("Stat.Level"),
							ChatColor.WHITE + "[직업] : " +ChatColor.BOLD + PlayerSkillYML.getString("Job.Type"),
							ChatColor.WHITE + "[경험치] : " + ChatColor.BOLD + YM.getInt("Stat.EXP") + " / " + YM.getInt("Stat.MaxEXP"),
							ChatColor.GREEN + "[스텟 포인트] : " + ChatColor.WHITE + ChatColor.BOLD + YM.getInt("Stat.StatPoint"),
							ChatColor.AQUA + "[스킬 포인트] : " + ChatColor.WHITE + ChatColor.BOLD + YM.getInt("Stat.SkillPoint")), 13, inv);
		}
		
		int DefaultDamage = 0;
		if(player.getItemInHand().hasItemMeta() == true)
		{
			if(player.getItemInHand().getItemMeta().hasLore() == true)
			{
				if(player.getItemInHand().getItemMeta().getLore().toString().contains(GoldBigDragon_RPG.Main.ServerOption.Damage+" : ") == true)
				{
					switch(player.getItemInHand().getType())
					{
					case WOOD_SPADE :
					case GOLD_SPADE :
						DefaultDamage = 1;
						break;
					case WOOD_PICKAXE :
					case GOLD_PICKAXE:
					case STONE_SPADE:
						DefaultDamage = 2;
						break;
					case WOOD_AXE:
					case GOLD_AXE:
					case STONE_PICKAXE:
					case IRON_SPADE:
						DefaultDamage = 3;
						break;
					case WOOD_SWORD:
					case GOLD_SWORD:
					case STONE_AXE:
					case IRON_PICKAXE:
					case DIAMOND_SPADE:
						DefaultDamage = 4;
						break;
					case STONE_SWORD:
					case IRON_AXE:
					case DIAMOND_PICKAXE:
						DefaultDamage = 5;
						break;
					case IRON_SWORD:
					case DIAMOND_AXE:
						DefaultDamage = 6;
						break;
					case DIAMOND_SWORD:
						DefaultDamage = 7;
						break;
					}
				}
			}
		}
		int stat=dam.getPlayerEquipmentStat(player, "STR")[0];
		String Additional = ChatColor.RED +""+ChatColor.BOLD+(dam.CombatMinDamageGet(player,DefaultDamage,YM.getInt("Stat.STR"))) + " ~ " + (dam.CombatMaxDamageGet(player,DefaultDamage, YM.getInt("Stat.STR")));
		String CurrentStat;
		if(stat == 0)
			CurrentStat = ChatColor.WHITE +""+ChatColor.BOLD +""+ YM.getInt("Stat.STR");
		else if(stat > 0)
			CurrentStat = ChatColor.YELLOW +""+ChatColor.BOLD +""+ (YM.getInt("Stat.STR") + stat) +ChatColor.WHITE + "("+ YM.getInt("Stat.STR")+")";
		else
			CurrentStat = ChatColor.RED +""+ChatColor.BOLD +""+(YM.getInt("Stat.STR") + stat) +ChatColor.WHITE + "("+ YM.getInt("Stat.STR")+")";
		
		String lore = GoldBigDragon_RPG.Main.ServerOption.STR_Lore;
		lore = LineUp(CurrentStat, GoldBigDragon_RPG.Main.ServerOption.STR.length()+20)+"%enter%"+lore.replace("%stat%", GoldBigDragon_RPG.Main.ServerOption.STR)
				+"%enter%"+ChatColor.AQUA + "" + ChatColor.BOLD +"[추가 근접 공격력]%enter%"+LineUp(Additional, 24);
		
		Stack2(ChatColor.DARK_RED + LineUp(ChatColor.RED+"[" + ChatColor.WHITE +""+ChatColor.BOLD + ""+GoldBigDragon_RPG.Main.ServerOption.STR+""+ChatColor.DARK_RED + "]", 24), 267,0,1,
				Arrays.asList(lore.split("%enter%")), 20, inv);
		
		
		stat=dam.getPlayerEquipmentStat(player, "DEX")[0];
		Additional = ChatColor.RED + "" + ChatColor.BOLD + "" + dam.returnRangeDamageValue(player, YM.getInt("Stat.DEX"), 0, true) + " ~ " + dam.returnRangeDamageValue(player, YM.getInt("Stat.DEX"), 0, false);
		if(stat == 0)
			CurrentStat = ChatColor.WHITE +""+ChatColor.BOLD +""+ YM.getInt("Stat.DEX");
		else if(stat > 0)
			CurrentStat = ChatColor.YELLOW +""+ChatColor.BOLD +""+ (YM.getInt("Stat.DEX") + stat) +ChatColor.WHITE + "("+ YM.getInt("Stat.DEX")+")";
		else
			CurrentStat = ChatColor.RED +""+ChatColor.BOLD +""+(YM.getInt("Stat.DEX") + stat) +ChatColor.WHITE + "("+ YM.getInt("Stat.DEX")+")";

		lore = GoldBigDragon_RPG.Main.ServerOption.DEX_Lore;
		lore = LineUp(CurrentStat, GoldBigDragon_RPG.Main.ServerOption.DEX.length()+20)+"%enter%"+lore.replace("%stat%", GoldBigDragon_RPG.Main.ServerOption.DEX)
					+"%enter%"+ChatColor.AQUA + "" + ChatColor.BOLD +"[추가 원거리 공격력]%enter%"+LineUp(Additional, 24);
			
		Stack2(LineUp(ChatColor.GREEN+"[" + ChatColor.WHITE +""+ChatColor.BOLD + ""+GoldBigDragon_RPG.Main.ServerOption.DEX+""+ChatColor.GREEN + "]", 24), 261,0,1,
				Arrays.asList(lore.split("%enter%")), 21, inv);
		
		
		stat=dam.getPlayerEquipmentStat(player, "INT")[0];
		Additional = ChatColor.RED + "" + ChatColor.BOLD + "" + ((YM.getInt("Stat.INT")+dam.getPlayerEquipmentStat(player, "INT")[0])*0.6+100) + " %";
		if(stat == 0)
			CurrentStat = ChatColor.WHITE +""+ChatColor.BOLD +""+ YM.getInt("Stat.INT");
		else if(stat > 0)
			CurrentStat = ChatColor.YELLOW +""+ChatColor.BOLD +""+ (YM.getInt("Stat.INT") + stat) +ChatColor.WHITE + "("+ YM.getInt("Stat.INT")+")";
		else
			CurrentStat = ChatColor.RED +""+ChatColor.BOLD +""+(YM.getInt("Stat.INT") + stat) +ChatColor.WHITE + "("+ YM.getInt("Stat.INT")+")";

		lore = GoldBigDragon_RPG.Main.ServerOption.INT_Lore;
		lore = LineUp(CurrentStat, GoldBigDragon_RPG.Main.ServerOption.INT.length()+20)+"%enter%"+lore.replace("%stat%", GoldBigDragon_RPG.Main.ServerOption.INT)
					+"%enter%"+ChatColor.AQUA + "" + ChatColor.BOLD +"[추가 스킬 공격력]%enter%"+LineUp(Additional, 24);
			
		Stack2(LineUp(ChatColor.AQUA + "[" + ChatColor.WHITE +""+ChatColor.BOLD + ""+GoldBigDragon_RPG.Main.ServerOption.INT+""+ChatColor.AQUA + "]",24), 369,0,1,
				Arrays.asList(lore.split("%enter%")), 22, inv);
		
		stat=dam.getPlayerEquipmentStat(player, "WILL")[0];
		Additional = ChatColor.RED + "" + ChatColor.BOLD + "" + ((YM.getInt("Stat.WILL")+dam.getPlayerEquipmentStat(player, "WILL")[0])*0.6+100) + " %";
		if(stat == 0)
			CurrentStat = ChatColor.WHITE +""+ChatColor.BOLD +""+ YM.getInt("Stat.WILL");
		else if(stat > 0)
			CurrentStat = ChatColor.YELLOW +""+ChatColor.BOLD +""+ (YM.getInt("Stat.WILL") + stat) +ChatColor.WHITE + "("+ YM.getInt("Stat.WILL")+")";
		else
			CurrentStat = ChatColor.RED +""+ChatColor.BOLD +""+(YM.getInt("Stat.WILL") + stat) +ChatColor.WHITE + "("+ YM.getInt("Stat.WILL")+")";

		lore = GoldBigDragon_RPG.Main.ServerOption.WILL_Lore;
		lore = LineUp(CurrentStat, GoldBigDragon_RPG.Main.ServerOption.WILL.length()+20)+"%enter%"+lore.replace("%stat%", GoldBigDragon_RPG.Main.ServerOption.WILL)
					+"%enter%"+ChatColor.AQUA + "" + ChatColor.BOLD +"[추가 스킬 공격력]%enter%"+LineUp(Additional, 24);
			
		Stack2(LineUp(ChatColor.GRAY + "[" + ChatColor.WHITE +""+ChatColor.BOLD + ""+GoldBigDragon_RPG.Main.ServerOption.WILL+""+ChatColor.GRAY + "]",24), 370,0,1,
				Arrays.asList(lore.split("%enter%")), 23, inv);
		
		
		stat=dam.getPlayerEquipmentStat(player, "LUK")[0];
		if(stat == 0)
			CurrentStat = ChatColor.WHITE +""+ChatColor.BOLD +""+ YM.getInt("Stat.LUK");
		else if(stat > 0)
			CurrentStat = ChatColor.YELLOW +""+ChatColor.BOLD +""+ (YM.getInt("Stat.LUK") + stat) +ChatColor.WHITE + "("+ YM.getInt("Stat.LUK")+")";
		else
			CurrentStat = ChatColor.RED +""+ChatColor.BOLD +""+(YM.getInt("Stat.LUK") + stat) +ChatColor.WHITE + "("+ YM.getInt("Stat.LUK")+")";

		lore = GoldBigDragon_RPG.Main.ServerOption.LUK_Lore;
		lore = LineUp(CurrentStat, GoldBigDragon_RPG.Main.ServerOption.LUK.length()+20)+"%enter%"+lore.replace("%stat%", GoldBigDragon_RPG.Main.ServerOption.LUK)
					+"%enter%";
			
		Stack2(LineUp(ChatColor.YELLOW + "[" + ChatColor.WHITE +""+ChatColor.BOLD + ""+GoldBigDragon_RPG.Main.ServerOption.LUK+""+ChatColor.YELLOW + "]",24), 322,0,1,
				Arrays.asList(lore.split("%enter%")), 24, inv);


		if(Config.getBoolean("Server.Like_The_Mabinogi_Online_Stat_System") == false)
		{
			Stack2(ChatColor.GOLD + "    [" + ChatColor.WHITE +""+ChatColor.BOLD + ""+GoldBigDragon_RPG.Main.ServerOption.STR+" 상승"+ChatColor.GOLD + "]", 399,0,1,
					Arrays.asList(ChatColor.GRAY + ""+GoldBigDragon_RPG.Main.ServerOption.STR+" 스텟을 한단계 상승 시킵니다.",ChatColor.GRAY + "남은 스텟 포인트 : "+YM.getInt("Stat.StatPoint")), 29, inv);
			Stack2(ChatColor.GOLD + "    [" + ChatColor.WHITE +""+ChatColor.BOLD + ""+GoldBigDragon_RPG.Main.ServerOption.DEX+" 상승"+ChatColor.GOLD + "]", 399,0,1,
					Arrays.asList(ChatColor.GRAY + ""+GoldBigDragon_RPG.Main.ServerOption.DEX+" 스텟을 한단계 상승 시킵니다.",ChatColor.GRAY + "남은 스텟 포인트 : "+YM.getInt("Stat.StatPoint")), 30, inv);
			Stack2(ChatColor.GOLD + "    [" + ChatColor.WHITE +""+ChatColor.BOLD + ""+GoldBigDragon_RPG.Main.ServerOption.INT+" 상승"+ChatColor.GOLD + "]", 399,0,1,
					Arrays.asList(ChatColor.GRAY + ""+GoldBigDragon_RPG.Main.ServerOption.INT+" 스텟을 한단계 상승 시킵니다.",ChatColor.GRAY + "남은 스텟 포인트 : "+YM.getInt("Stat.StatPoint")), 31, inv);
			Stack2(ChatColor.GOLD + "    [" + ChatColor.WHITE +""+ChatColor.BOLD + ""+GoldBigDragon_RPG.Main.ServerOption.WILL+" 상승"+ChatColor.GOLD + "]", 399,0,1,
					Arrays.asList(ChatColor.GRAY + ""+GoldBigDragon_RPG.Main.ServerOption.WILL+" 스텟을 한단계 상승 시킵니다.",ChatColor.GRAY + "남은 스텟 포인트 : "+YM.getInt("Stat.StatPoint")), 32, inv);
			Stack2(ChatColor.GOLD + "    [" + ChatColor.WHITE +""+ChatColor.BOLD + ""+GoldBigDragon_RPG.Main.ServerOption.LUK+" 상승"+ChatColor.GOLD + "]", 399,0,1,
					Arrays.asList(ChatColor.GRAY + ""+GoldBigDragon_RPG.Main.ServerOption.LUK+" 스텟을 한단계 상승 시킵니다.",ChatColor.GRAY + "남은 스텟 포인트 : "+YM.getInt("Stat.StatPoint")), 33, inv);
		}
		GoldBigDragon_RPG.Event.Damage d = new GoldBigDragon_RPG.Event.Damage();
		Stack2(ChatColor.GRAY + "    [" + ChatColor.WHITE +""+ChatColor.BOLD + "방어"+ChatColor.GRAY + "]", 307,0,1,
				Arrays.asList(ChatColor.WHITE + "물리 방어 : "+ChatColor.WHITE +(YM.getInt("Stat.DEF")+d.getPlayerEquipmentStat(player, "방어")[0]),
						ChatColor.GRAY + "추가 물리 보호 : "+ChatColor.WHITE + (YM.getInt("Stat.Protect")+d.getPlayerEquipmentStat(player, "보호")[0]),
						ChatColor.AQUA + "추가 마법 방어 : "+ChatColor.WHITE + (YM.getInt("Stat.Magic_DEF")+d.getMagicDEF(player,YM.getInt("Stat.INT"))),
						ChatColor.DARK_AQUA + "추가 마법 보호 : "+ChatColor.WHITE + (YM.getInt("Stat.Magic_Protect")+d.getMagicProtect(player, YM.getInt("Stat.INT")))), 38, inv);

		Stack2(ChatColor.RED + "    [" + ChatColor.WHITE +""+ChatColor.BOLD + "관통"+ChatColor.RED + "]", 409,0,1,
				Arrays.asList(ChatColor.RED + "추가 물리 방어 관통 : "+ChatColor.WHITE + (YM.getInt("Stat.DEFcrash")+d.getDEFcrash(player, YM.getInt("Stat.DEX"))),
						ChatColor.BLUE + "추가 마법 방어 관통 : "+ChatColor.WHITE + (YM.getInt("Stat.MagicDEFcrash")+d.getMagicDEFcrash(player, YM.getInt("Stat.INT")))), 39, inv);
		
		Stack2(ChatColor.GREEN + "    [" + ChatColor.WHITE +""+ChatColor.BOLD + "기회"+ChatColor.GREEN + "]", 377,0,1,
				Arrays.asList(ChatColor.GREEN + "추가 밸런스 : "+ChatColor.WHITE + d.getBalance(player, YM.getInt("Stat.DEX"), YM.getInt("Stat.Balance"))+"%",
						ChatColor.YELLOW + "추가 크리티컬 : "+ChatColor.WHITE + d.getCritical(player,YM.getInt("Stat.LUK"), YM.getInt("Stat.WILL"),YM.getInt("Stat.Critical"))+"%"), 42, inv);
		
		player.openInventory(inv);
	}
	
	//각종 GUI창 속의 아이콘을 눌렸을 때, 해당 아이콘에 기능을 넣는 메소드1   -스텟 GUI, 오피박스, 커스텀 몬스터GUI-//
	public void StatusInventoryclick(InventoryClickEvent event)
	{
	    YamlManager YM,Config;
		YamlController YC_2 = GoldBigDragon_RPG.Main.Main.YC_2;
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		GoldBigDragon_RPG.Effect.Sound s = new GoldBigDragon_RPG.Effect.Sound();
	  	if(YC_2.isExit("Stats/" + player.getUniqueId()+".yml") == false)
	  		new GoldBigDragon_RPG.Config.StatConfig().CreateNewStats(player);
		YM = YC_2.getNewConfig("Stats/" + player.getUniqueId()+".yml");
		
		switch (event.getSlot())
		{
		case 99:
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			break;
		case 98:
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			break;
		case 36:
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			ETCGUI EGUI = new ETCGUI();
			EGUI.ETCGUI_Main(player);
			break;
		case 9:
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			PlayerSkillGUI PGUI = new PlayerSkillGUI();
			PGUI.MainSkillsListGUI(player, 0);
			break;
		case 18:
			GoldBigDragon_RPG.GUI.QuestGUI QGUI = new GoldBigDragon_RPG.GUI.QuestGUI();
			QGUI.MyQuestListGUI(player, 0);
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			break;
		case 27:
			GoldBigDragon_RPG.GUI.OptionGUI oGUI = new GoldBigDragon_RPG.GUI.OptionGUI();
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			oGUI.optionGUI(player);
			break;
		case 29:
			Config = YC_2.getNewConfig("config.yml");
			if(Config.getBoolean("Server.Like_The_Mabinogi_Online_Stat_System") == false)
				if(YM.getInt("Stat.StatPoint") >= 1)
				{
					YM.set("Stat.StatPoint", YM.getInt("Stat.StatPoint")-1);
					YM.set("Stat.STR", YM.getInt("Stat.STR")+1);
					YM.saveConfig();
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				}
			StatusGUI(player);
			break;
		case 30:
			Config = YC_2.getNewConfig("config.yml");
			if(Config.getBoolean("Server.Like_The_Mabinogi_Online_Stat_System") == false)
				if(YM.getInt("Stat.StatPoint") >= 1)
				{
					YM.set("Stat.StatPoint", YM.getInt("Stat.StatPoint")-1);
					YM.set("Stat.DEX", YM.getInt("Stat.DEX")+1);
					YM.saveConfig();
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				}
			StatusGUI(player);
			break;
		case 31:
			Config = YC_2.getNewConfig("config.yml");
			if(Config.getBoolean("Server.Like_The_Mabinogi_Online_Stat_System") == false)
				if(YM.getInt("Stat.StatPoint") >= 1)
				{
					YM.set("Stat.StatPoint", YM.getInt("Stat.StatPoint")-1);
					YM.set("Stat.INT", YM.getInt("Stat.INT")+1);
					YM.saveConfig();
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				}
			StatusGUI(player);
			break;
		case 32:
			Config = YC_2.getNewConfig("config.yml");
			if(Config.getBoolean("Server.Like_The_Mabinogi_Online_Stat_System") == false)
				if(YM.getInt("Stat.StatPoint") >= 1)
				{
					YM.set("Stat.StatPoint", YM.getInt("Stat.StatPoint")-1);
					YM.set("Stat.WILL", YM.getInt("Stat.WILL")+1);
					YM.saveConfig();
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				}
			StatusGUI(player);
			break;
		case 33:
			Config = YC_2.getNewConfig("config.yml");
			if(Config.getBoolean("Server.Like_The_Mabinogi_Online_Stat_System") == false)
				if(YM.getInt("Stat.StatPoint") >= 1)
				{
					YM.set("Stat.StatPoint", YM.getInt("Stat.StatPoint")-1);
					YM.set("Stat.LUK", YM.getInt("Stat.LUK")+1);
					YM.saveConfig();
					s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
				}
			StatusGUI(player);
			break;
		case 26:
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			break;
		}
		return;
	}
	
	
	public String LineUp(String RawString,int size)
	{
		if(RawString.length()>=size)
			return RawString;
		else
		{
			int spaceSize = size - RawString.length();
			StringBuffer TempString = new StringBuffer();
			for(int count = 0; count < spaceSize/2; count++)
				TempString.append(" ");
			TempString.append(RawString);
			for(int count = 0; count < spaceSize/2; count++)
				TempString.append(" ");
			return TempString.toString();
		}
	}
}
