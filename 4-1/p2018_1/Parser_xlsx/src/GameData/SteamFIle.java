package GameData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Spliterators;

public class SteamFIle {
	private String game_name;
	private String Date_year;
	private String game_Player;
	private String Category;
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}
	private String filename = "steam.txt";
//	private ArrayList<String> listOfLines;
	
	dump_remove dr = new dump_remove();
	
	public SteamFIle() {
		this.game_name = null;
		this.Date_year = null;
		this.game_Player = null;
	}
	
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}

	public void setDate_year(String date_year) {
		Date_year = date_year;
	}

	public void setGame_Player(String game_Player) {
		this.game_Player = game_Player;
	}

	public SteamFIle(String game_name, String Data_year, String game_Player) {
		this.game_name = game_name;
		this.Date_year = Data_year;
		this.game_Player = game_Player;
	}
	public String getGame_name() {
		return game_name;
	}
	public String getDate_year() {
		return Date_year;
	}
	public String getGame_Player() {
		return game_Player;
	}
	


//	public static void main(String args[]) {
//		SteamFIle sf = new SteamFIle();
//
//		System.out.println("����");
//		sf.File_Readers();
//		System.out.println("��");
//	}



}
