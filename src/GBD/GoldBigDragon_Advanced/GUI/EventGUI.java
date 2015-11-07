package GBD.GoldBigDragon_Advanced.GUI;

import java.util.Arrays;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import GBD.GoldBigDragon_Advanced.Main.Main;
import GBD.GoldBigDragon_Advanced.Util.YamlController;
import GBD.GoldBigDragon_Advanced.Util.YamlManager;

public class EventGUI extends GUIutil
{
	public void EventGUI_Main (Player player)
	{
		YamlController GUI_YC = GBD.GoldBigDragon_Advanced.Main.Main.GUI_YC;
		YamlManager Config =GUI_YC.getNewConfig("config.yml");
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.BLACK + "�̺�Ʈ ����");
		
		if(Config.getInt("Event.Multiple_Level_Up_SkillPoint") == 1)
		{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "��ų ����Ʈ �߰� ȹ��", 340,0,1,Arrays.asList(ChatColor.RED + "[�� Ȱ��ȭ]",ChatColor.GRAY + "���� ���� ��� ��ų ����Ʈ : " + Config.getInt("Server.Level_Up_SkillPoint")), 10, inv);}
		else
		{{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "��ų ����Ʈ �߰� ȹ��", 403,0,Config.getInt("Event.Multiple_Level_Up_SkillPoint"),Arrays.asList(ChatColor.GREEN + "[Ȱ��ȭ]",ChatColor.YELLOW +""+Config.getInt("Event.Multiple_Level_Up_SkillPoint") +ChatColor.GRAY +"��",ChatColor.GRAY + "���� ���� ��� ��ų ����Ʈ : " + (Config.getInt("Server.Level_Up_SkillPoint") * Config.getInt("Event.Multiple_Level_Up_SkillPoint"))), 10, inv);}	}

		if(Config.getInt("Event.Multiple_Level_Up_StatPoint") == 1)
		{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ����Ʈ �߰� ȹ��", 351,15,1,Arrays.asList(ChatColor.RED + "[�� Ȱ��ȭ]",ChatColor.GRAY + "���� ���� ��� ���� ����Ʈ : " + Config.getInt("Server.Level_Up_StatPoint")), 12, inv);}
		else
		{{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� ����Ʈ �߰� ȹ��", 399,0,Config.getInt("Event.Multiple_Level_Up_StatPoint"),Arrays.asList(ChatColor.GREEN + "[Ȱ��ȭ]",ChatColor.YELLOW +""+Config.getInt("Event.Multiple_Level_Up_StatPoint") +ChatColor.GRAY +"��",ChatColor.GRAY + "���� ���� ��� ���� ����Ʈ : " + (Config.getInt("Server.Level_Up_StatPoint")*Config.getInt("Event.Multiple_Level_Up_StatPoint"))), 12, inv);}	}

		if(Config.getInt("Event.Multiple_EXP_Get") == 1)
		{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "����ġ �߰� ȹ��", 374,0,1,Arrays.asList(ChatColor.RED + "[�� Ȱ��ȭ]",ChatColor.GRAY + "����ġ ȹ��� : " + Config.getInt("Event.Multiple_EXP_Get")+"��"), 14, inv);}
		else
		{{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "����ġ �߰� ȹ��", 384,0,Config.getInt("Event.Multiple_EXP_Get"),Arrays.asList(ChatColor.GREEN + "[Ȱ��ȭ]",ChatColor.GRAY + "����ġ ȹ��� : "+ChatColor.YELLOW +""+Config.getInt("Event.Multiple_EXP_Get") +ChatColor.GRAY +"��"), 14, inv);}	}
		
		if(Config.getInt("Event.DropChance") == 1)
		{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "��ӷ� ���", 265,0,1,Arrays.asList(ChatColor.RED + "[�� Ȱ��ȭ]",ChatColor.GRAY + "��ӷ� : " + Config.getInt("Event.DropChance")+"��"), 16, inv);}
		else
		{{Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "��ӷ� ���", 266,0,Config.getInt("Event.DropChance"),Arrays.asList(ChatColor.GREEN + "[Ȱ��ȭ]",ChatColor.GRAY + "��ӷ� : "+ChatColor.YELLOW +""+Config.getInt("Event.DropChance") +ChatColor.GRAY +"��"), 16, inv);}	}
		
		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "��ü �ֱ�", 54,0,1,Arrays.asList(ChatColor.GRAY + "���� ������ ��� ��������",ChatColor.GRAY+"�������� �����մϴ�."), 28, inv);
		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "���� �ֱ�", 130,0,1,Arrays.asList(ChatColor.GRAY + "���� ������ ������ ��,",ChatColor.GRAY+"�� ������Ը� ������",ChatColor.GRAY+"�������� �����մϴ�."), 30, inv);

		
		Stack2(ChatColor.WHITE  + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "�۾� ������ �޴��� ���ư��ϴ�."), 36, inv);

		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "�۾� ������ â�� �ݽ��ϴ�."), 44, inv);
		
		player.openInventory(inv);
	}

	public void AllPlayerGiveEventGUI(Player player, boolean All)
	{
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.BLACK + "�̺�Ʈ ��ü ����");
		if(All==false)
			inv = Bukkit.createInventory(null, 45, ChatColor.BLACK + "�̺�Ʈ ���� ����");
		for(int count = 0; count <10;count++)
			Stack2(ChatColor.YELLOW+"[ ���� �� ������ ]", 160, 4, 1, null, count, inv);
		Stack2(ChatColor.YELLOW+"[ ���� �� ������ ]", 160, 4, 1, null, 17, inv);
		Stack2(ChatColor.YELLOW+"[ ���� �� ������ ]", 160, 4, 1, null, 18, inv);
		for(int count = 26; count <36;count++)
			Stack2(ChatColor.YELLOW+"[ ���� �� ������ ]", 160, 4, 1, null, count, inv);

		for(int count = 36; count <44;count++)
			Stack2(ChatColor.YELLOW+" ", 160, 8, 1, null, count, inv);

		if(All)
			Stack2(ChatColor.WHITE  + "" + ChatColor.BOLD + "[���� ����!]", 54,0,1,Arrays.asList(ChatColor.GRAY + "��� �׵θ� ���� ��������",ChatColor.GRAY+"��� �÷��̾�� �����մϴ�!"), 40, inv);
		else
			Stack2(ChatColor.WHITE  + "" + ChatColor.BOLD + "[���� ����!]", 130,0,1,Arrays.asList(ChatColor.GRAY + "��� �׵θ� ���� ��������",ChatColor.GRAY+"���� ������ �𸨴ϴ�!"), 40, inv);
			
		Stack2(ChatColor.WHITE  + "" + ChatColor.BOLD + "���� ���", 323,0,1,Arrays.asList(ChatColor.GRAY + "�̺�Ʈ �޴��� ���ư��ϴ�."), 36, inv);
		Stack2(ChatColor.WHITE +""+ ChatColor.BOLD + "�ݱ�", 324,0,1,Arrays.asList(ChatColor.GRAY + "�۾� ������ â�� �ݽ��ϴ�."), 44, inv);
		player.openInventory(inv);
	}
	
	
	
	
	//���� GUIâ ���� �������� ������ ��, �ش� �����ܿ� ����� �ִ� �޼ҵ�1   -���� GUI, ���ǹڽ�, Ŀ���� ����GUI-//
	public void EventGUIInventoryclick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();
		switch (event.getSlot())
		{
		case 28://��ü �ֱ�
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			AllPlayerGiveEventGUI(player,true);
			return;
		case 30://���� �ֱ�
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			AllPlayerGiveEventGUI(player,false);
			return;
		case 10:
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[�̺�Ʈ] : ��ų ����Ʈ �߰� ȹ�淮�� �� ��� �ϽǷ���?");
			player.sendMessage(ChatColor.YELLOW+"(1 ~ 10) (1�� ��� �̺�Ʈ ����)");
			Main.UserData.get(player).setType("Event");
			Main.UserData.get(player).setString((byte)1, "SKP");
			return;
		case 12:
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[�̺�Ʈ] : ���� ����Ʈ �߰� ȹ�淮�� �� ��� �ϽǷ���?");
			player.sendMessage(ChatColor.YELLOW+"(1 ~ 10) (1�� ��� �̺�Ʈ ����)");
			Main.UserData.get(player).setType("Event");
			Main.UserData.get(player).setString((byte)1, "STP");
			return;
		case 14:
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[�̺�Ʈ] : ����ġ ȹ�淮 �߰� ȹ�淮�� �� ��� �ϽǷ���?");
			player.sendMessage(ChatColor.YELLOW+"(1 ~ 10) (1�� ��� �̺�Ʈ ����)");
			Main.UserData.get(player).setType("Event");
			Main.UserData.get(player).setString((byte)1, "EXP");
			return;
		case 16:
			s.SP(player, Sound.ITEM_PICKUP, 1.0F, 1.0F);
			player.closeInventory();
			player.sendMessage(ChatColor.GREEN+"[�̺�Ʈ] : ����ġ ȹ�淮 �߰� ȹ�淮�� �� ��� �ϽǷ���?");
			player.sendMessage(ChatColor.YELLOW+"(1 ~ 10) (1�� ��� �̺�Ʈ ����)");
			Main.UserData.get(player).setType("Event");
			Main.UserData.get(player).setString((byte)1, "DROP");
			return;
		case 36:
			OPBoxGUI OGUI = new OPBoxGUI();
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			OGUI.OPBoxGUI_Main(player,1);
			return;
		case 44:
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
		return;
	}

	public void AllPlayerGiveEventGUIclick(InventoryClickEvent event)
	{
		GBD.GoldBigDragon_Advanced.Effect.Sound s = new GBD.GoldBigDragon_Advanced.Effect.Sound();

		Player player = (Player) event.getWhoClicked();
		if(event.getSlot()>=0&&event.getSlot()<=9)
			event.setCancelled(true);
		if(event.getSlot()>=27&&event.getSlot()<=35)
			event.setCancelled(true);
		if(event.getSlot()>=35)
			event.setCancelled(true);
		switch (event.getSlot())
		{
		case 17:
		case 18:
		case 26:
			event.setCancelled(true);
			break;
		case 36:
			event.setCancelled(true);
			s.SP(player, Sound.ITEM_PICKUP, 0.8F, 1.0F);
			EventGUI_Main(player);
			return;
		case 40://���� ����
			event.setCancelled(true);
			GBD.GoldBigDragon_Advanced.Event.Interact IT = new GBD.GoldBigDragon_Advanced.Event.Interact();
			if(event.getInventory().getTitle().contains("����"))
			{
				boolean ItemExit = false;
  		    	Collection<? extends Player> playerlist = Bukkit.getServer().getOnlinePlayers();
  		    	Player[] a = new Player[playerlist.size()];
  		    	playerlist.toArray(a);
  		    	int LuckyGuy = new GBD.GoldBigDragon_Advanced.Util.Number().RandomNum(0, a.length-1);
				for(int count = 10; count < 17;count++)
				{
					if(event.getInventory().getItem(count) != null)
					{
						ItemExit = true;
						ItemStack item = event.getInventory().getItem(count);
		  		    	a[LuckyGuy].getInventory().addItem(item);
					}
				}
				for(int count = 19; count < 26;count++)
				{
					if(event.getInventory().getItem(count) != null)
					{
						ItemExit = true;
						ItemStack item = event.getInventory().getItem(count);
						a[LuckyGuy].getInventory().addItem(item);
					}
				}
				if(ItemExit)
				{
					s.SP(a[LuckyGuy], Sound.ITEM_PICKUP, 1.0F, 1.9F);
					Bukkit.broadcastMessage(ChatColor.YELLOW+"[�̺�Ʈ] : "+ChatColor.GOLD+""+ChatColor.BOLD+a[LuckyGuy].getName()+ChatColor.YELLOW+"�Բ��� ���� ������ ���޿� ��÷ �Ǽ̽��ϴ�!");
					EventGUI_Main(player);
				}
			}
			else
			{
				boolean ItemExit = false;
				for(int count = 10; count < 17;count++)
				{
					if(event.getInventory().getItem(count) != null)
					{
						ItemExit = true;
						ItemStack item = event.getInventory().getItem(count);
		  		    	Collection<? extends Player> playerlist = Bukkit.getServer().getOnlinePlayers();
		  		    	Player[] a = new Player[playerlist.size()];
		  		    	playerlist.toArray(a);
		  	  			for(int counter = 0; counter<a.length;counter++)
		  	  			{
		  	  				a[counter].getInventory().addItem(item);
		  	  				if(item.hasItemMeta())
		  	  				{
		  	  					if(item.getItemMeta().hasDisplayName())
		  	  						a[counter].sendMessage(ChatColor.YELLOW+"[�̺�Ʈ] : "+item.getItemMeta().getDisplayName()+ChatColor.YELLOW+" �������� "+item.getAmount()+"�� ���� �޾ҽ��ϴ�!");
		  	  				}
		  	  				else
	  	  						a[counter].sendMessage(ChatColor.YELLOW+"[�̺�Ʈ] : "+IT.SetItemDefaultName(item.getTypeId(), item.getData().getData())+ChatColor.YELLOW+" �������� "+item.getAmount()+"�� ���� �޾ҽ��ϴ�!");
		  	  				s.SP(a[counter], Sound.ITEM_PICKUP, 0.7F, 1.8F);
		  	  			}
					}
				}
				for(int count = 19; count < 26;count++)
				{
					if(event.getInventory().getItem(count) != null)
					{
						ItemExit = true;
						ItemStack item = event.getInventory().getItem(count);
		  		    	Collection<? extends Player> playerlist = Bukkit.getServer().getOnlinePlayers();
		  		    	Player[] a = new Player[playerlist.size()];
		  		    	playerlist.toArray(a);
		  	  			for(int counter = 0; counter<a.length;counter++)
		  	  			{
		  	  				a[counter].getInventory().addItem(item);
		  	  				if(item.hasItemMeta())
		  	  				{
		  	  					if(item.getItemMeta().hasDisplayName())
		  	  						a[counter].sendMessage(ChatColor.YELLOW+"[�̺�Ʈ] : "+item.getItemMeta().getDisplayName()+ChatColor.YELLOW+" �������� "+item.getAmount()+"�� ���� �޾ҽ��ϴ�!");
		  	  				}
		  	  				else
	  	  						a[counter].sendMessage(ChatColor.YELLOW+"[�̺�Ʈ] : "+IT.SetItemDefaultName(item.getTypeId(), item.getData().getData())+ChatColor.YELLOW+" �������� "+item.getAmount()+"�� ���� �޾ҽ��ϴ�!");
		  	  				s.SP(a[counter], Sound.ITEM_PICKUP, 0.7F, 1.8F);	
		  	  			}
					}
				}
				if(ItemExit)
					EventGUI_Main(player);
			}
			return;
		case 44:
			event.setCancelled(true);
			s.SP(player, Sound.PISTON_RETRACT, 0.8F, 1.8F);
			player.closeInventory();
			return;
		}
	}
}