package MT_PRACTICE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Music{

	String name;
	String location;
	String date;
	String headliner ;
	String musicGenre;
	int ticketPrice;
	
	public Music(String name, String location, String date, String headliner, String musicGenre, int ticketPrice) {
		super();
		this.name = name;
		this.location = location;
		this.date = date;
		this.headliner = headliner;
		this.musicGenre = musicGenre;
		this.ticketPrice = ticketPrice;
	}
}


class Food{

	String name;
	String location;
	String date;
	String cuisine ;
	String numStalls;
	int entryFee;
	public Food(String name, String location, String date, String cuisine, String numStalls, int entryFee) {
		super();
		this.name = name;
		this.location = location;
		this.date = date;
		this.cuisine = cuisine;
		this.numStalls = numStalls;
		this.entryFee = entryFee;
	}

}

class Art{

	String name;
	String location;
	String date;
	String artType ;
	String numArtists;
	int exhibitionFee;
	
	public Art(String name, String location, String date, String artType, String numArtists, int exhibitionFee) {
		super();
		this.name = name;
		this.location = location;
		this.date = date;
		this.artType = artType;
		this.numArtists = numArtists;
		this.exhibitionFee = exhibitionFee;
	}

}
public class EventPlanner {
	
	static List<Music> music = new ArrayList<>();
	static List<Food> food = new ArrayList<>();
	static List<Art> art = new ArrayList<>();
	
	public static void addFood(String name, String location, String date, 
			String cuisine, String numStalls, int entryFee) {
		food.add(new Food(name, location, date, cuisine, numStalls, entryFee));
	}
	
	public static void addMusic(String name, String location, String date, 
			String headliner, String musicGenre, int ticketPrice) {
		music.add(new Music(name, location, date, headliner, musicGenre, ticketPrice));
	}
	
	public static void addArt(String name, String location, 
			String date, String artType, String numArtists, int exhibitionFee) {
		art.add(new Art(name, location, date, artType, numArtists, exhibitionFee));
	}
	
	public static void display(String name) {
		for(int i=0;i<food.size();i++) {
			if(food.get(i).name.equalsIgnoreCase(name)) {
				System.out.println("Festival Name: "+food.get(i).name
						+"\nLocation: "+food.get(i).location
						+"\nDate: "+food.get(i).date
						+"\nCuisine: "+food.get(i).cuisine
						+"\nNumber of Stalls: "+food.get(i).numStalls
						+"\nEntry Price: "+food.get(i).entryFee);
			}
		}
		for(int i=0;i<music.size();i++) {
			if(music.get(i).name.equalsIgnoreCase(name)) {
				System.out.println("Festival Name: "+music.get(i).name
						+"\nLocation: "+music.get(i).location
						+"\nDate: "+music.get(i).date
						+"\nHeadliner: "+music.get(i).headliner
						+"\nMusic Genre: "+music.get(i).musicGenre
						+"\nTicket Price: "+music.get(i).ticketPrice);
			}
		}
		
		for(int i=0;i<art.size();i++) {
			if(art.get(i).name.equalsIgnoreCase(name)) {
				System.out.println("Festival Name: "+art.get(i).name
						+"\nLocation: "+art.get(i).location
						+"\nDate: "+art.get(i).date
						+"\nArt Type: "+art.get(i).artType
						+"\nNumber of Artists: "+art.get(i).numArtists
						+"\nExhibition Fee: "+art.get(i).exhibitionFee);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String s = sc.nextLine();
			
			String [] arr = s.split(" ");
			
			if(arr[0].equals("ADD_FESTIVAL")) {
				if(arr[1].equals("MUSIC"))addMusic(arr[2], arr[3], arr[4], arr[5], arr[6], Integer.parseInt(arr[7]));
				else if(arr[1].equals("FOOD"))addFood(arr[2], arr[3], arr[4], arr[5], arr[6], Integer.parseInt(arr[7]));
				else if (arr[1].equals("ART"))addArt(arr[2], arr[3], arr[4], arr[5], arr[6], Integer.parseInt(arr[7]));
				else {}
			}else if(arr[0].equals("DISPLAY_DETAILS"))display(arr[1]);
			
			else if(s.equals("EXIT"))break;
			else {}
		}
		
	}

}
