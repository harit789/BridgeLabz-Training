package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Event{
	String name;
	String location;
	int date;
	
	public Event(String name, String location, int date) {
		this.name = name;
		this.location = location;
		this.date = date;
	}
	
	abstract void display();
}

class Music extends Event{
	String headliner;
	String musicGenre;
	int ticketPrice;
	
	public Music(String name, String location , int date, String headliner, String musicGenre, int ticketPrice) {
		super(name, location, date);
		this.headliner = headliner;
		this.musicGenre = musicGenre;
		this.ticketPrice = ticketPrice;
	}
	
	public void display() {
		System.out.println("\nFestival Name: " + name + "\nLocation: " + location + "\nDate: " + date + "\nHeadliner: " + headliner + "\nMusic Genre: " + musicGenre + "\nTicketPrice: " + ticketPrice);
	}
}

class Food extends Event{
	String cuisine;
	int numStalls;
	int entryFee;
	
	public Food(String name, String location, int date , String cuisine, int numStalls, int entryFee) {
		super(name, location, date);
		this.cuisine = cuisine;
		this.numStalls = numStalls;
		this.entryFee = entryFee;
	}
	
	public void display() {
		System.out.println("\nFestival Name: " + name + "\nLocation: " + location + "\nCuisine: " + cuisine + "\nNumber of Stalls: " + numStalls + "\nEntry Fee: " + entryFee);
	}
}

class Art extends Event{
	String artType;
	int numArtists;
	int exhibutionFee;
	
	public Art(String name, String location, int date, String artType, int numArtists, int exhibutionFee) {
		super(name, location, date);
		this.artType = artType;
		this.numArtists = numArtists;
		this.exhibutionFee = exhibutionFee;
	}
	
	public void display() {
		System.out.println("\nFestival Name: " + name + "\nLocation: " + location + "\nDate: " + date + "\nArt type: " + artType + " \n NumArtist: " + numArtists + "\nExhibution Fee: " + exhibutionFee);
	}
}
public class EventPlanner {
	private List<Event> list = new ArrayList<>();
	
	public void addEvent(Event event) {
		list.add(event);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		EventPlanner util = new EventPlanner();
		while(true) {
			String input = sc.nextLine();
			if(input.equals("EXIT")) {
				break;
			}
			
			String[] splitInput = input.split("\\s+");
			if(splitInput[0].equals("ADD_FESTIVAL")) {
				if(splitInput[1].equals("MUSIC")) {
					Music music = new Music(splitInput[2], splitInput[3], Integer.parseInt(splitInput[4]), splitInput[5], splitInput[6], Integer.parseInt(splitInput[7]));
					util.addEvent(music);
				} else if(splitInput[1].equals("FOOD")){
					Food food = new Food(splitInput[2], splitInput[3], Integer.parseInt(splitInput[4]), splitInput[5], Integer.parseInt(splitInput[6]), Integer.parseInt(splitInput[7]));
					util.addEvent(food);
				} else {
					Art art = new Art(splitInput[2], splitInput[3], Integer.parseInt(splitInput[4]), splitInput[5], Integer.parseInt(splitInput[6]), Integer.parseInt(splitInput[7]));
					util.addEvent(art);
				}
			} else if(splitInput[0].equals("DISPLAY_DETAILS")) {
				for(Event event : util.list) {
					event.display();
				}
			}
		}
	}
}
