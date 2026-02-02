import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Program {
	public static List<CreatorStats> EngagementBoard;

	public void RegisterCreator(CreatorStats record) {
		EngagementBoard.add(record);
	}

	public HashMap<String, Integer> GetTopPostCounts(List<CreatorStats> record, double likeThreshold) {
		HashMap<String, Integer> result = new HashMap<>();
		for (CreatorStats creatorStat : record) {
			double[] weeklyLike = creatorStat.getWeeklyLikes();
			String creatorName = creatorStat.getCreatorName();
			int count = 0;
			for (double like : weeklyLike) {
				if (like >= likeThreshold) {
					count++;
				}
			}
			if (count > 0) {
				result.put(creatorName, count);
			}
		}
		return result;
	}

	public double CalculateAverageLikes() {
		int weeks = 0;
		double allLikes = 0;
		for (CreatorStats creatorStat : EngagementBoard) {
			for (double weeklyLike : creatorStat.getWeeklyLikes()) {
				allLikes += weeklyLike;
				weeks++;
			}

		}
		return allLikes / weeks;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		EngagementBoard = new ArrayList<>();
		Program program = new Program();
		while (true) {
			System.out.println("1. Registor Creator");
			System.out.println("2. Show Top Posts");
			System.out.println("3. Calculate Average Likes");
			System.out.println("4. Exit");

			System.out.println("\nEnter choice :");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				
				System.out.println("\nEnter Creator Name :");
				String creatorName = sc.nextLine();
				System.out.println("Enter WeeklyLikes for four weeks : ");
				double weeklyLikes[] = new double[4];
				for (int i = 0; i < weeklyLikes.length; i++) {
					weeklyLikes[i] = sc.nextDouble();
				}

				CreatorStats creator = new CreatorStats();
				creator.setCreatorName(creatorName);
				creator.setWeeklyLikes(weeklyLikes);
				program.RegisterCreator(creator);
				System.out.println("Creator registered successfully!");
				break;
			case 2:
				System.out.println("Enter Like Threshold : ");
				double likeThreshold = sc.nextDouble();
				HashMap<String, Integer> result = program.GetTopPostCounts(EngagementBoard, likeThreshold);
				if (result.isEmpty()) {
					System.out.println("No top-preforming posts this week");
				} else {
					for (String name : result.keySet()) {
						System.out.println(name + " - " + result.get(name));
					}
				}
				break;
			case 3:
				double average = program.CalculateAverageLikes();
				System.out.println("Overall averge weekly likes : " + average);
				break;
			case 4:
				System.out.println("Logging off - Kepp Creating with StreamBuzz!");
				return;
			}
		}
	}
}
