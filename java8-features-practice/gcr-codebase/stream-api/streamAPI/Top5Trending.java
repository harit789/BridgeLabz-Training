
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Movie {
	int rating;
	int releaseYr;

	public Movie(int rating, int releaseYr) {
		this.rating = rating;
		this.releaseYr = releaseYr;
	}
	
	public String toString() {
		return "Movie [ Rating : " + rating + ", Release Year : " + releaseYr + " ]";
	}
}

public class Top5Trending {
	public static void main(String args[]) {
		
		List<Movie> list = new ArrayList<>();
		list.add(new Movie(4, 2024));
		list.add(new Movie(3, 2025));
		list.add(new Movie(2, 2026));
		list.add(new Movie(5, 2021));
		list.add(new Movie(4, 2010));
		list.add(new Movie(5, 2009));
		
		System.out.println("Sort On the basis of Rating :");
		list.stream().sorted((Movie i, Movie j) -> j.rating - i.rating).limit(5).forEach(x -> System.out.println(x));
		
		System.out.println("Sort on the basis of year : ");
		list.stream().sorted((Movie i, Movie j) -> j.releaseYr - i.releaseYr).limit(5).forEach(x -> System.out.println(x));
	}
}
