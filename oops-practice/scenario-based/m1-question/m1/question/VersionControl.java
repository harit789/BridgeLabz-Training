package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class File {
	private String fileName;
	private String version;
	private int fileSize;

	public File(String fileName, String version, int fileSize) {
		this.fileName = fileName;
		this.version = version;
		this.fileSize = fileSize;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String toString() {
		return fileName + " " + version + " " + fileSize;
	}
}

class FileManager {
	private List<File> list = new ArrayList<>();

	public void addFile(File newFile) {
		if (list.contains(newFile)) {
			return;
		} else {
			list.add(newFile);
		}
	}

	public void fetch(String fileName) {
		list.sort((File f1, File f2) -> f1.getFileSize() - f2.getFileSize());
		boolean isAvail = false;
		for (File f : list) {
			if (f.getFileName().equalsIgnoreCase(fileName)) {
				isAvail = true;
				System.out.println(f);
			}
		}
		if(!isAvail) {
			System.out.println("File Not Found");
		}
		
	}

	public void totalStorage(String fileName) {
		int sum = 0;
		for (File f : list) {
			if (f.getFileName().equalsIgnoreCase(fileName)) {
				sum += f.getFileSize();
			}
		}
		System.out.println(fileName + " " + sum);
	}

	public void latest(String fileName) {
		list.reversed();
		for (File f : list) {
			if (f.getFileName().equalsIgnoreCase(fileName)) {
				System.out.println(f);
				return;
			}
		}
	}
}

public class VersionControl {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] inputArr = new String[n];
		sc.nextLine();
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = sc.nextLine();
		}
		FileManager util = new FileManager();
		for (int i = 0; i < inputArr.length; i++) {
			String[] details = inputArr[i].split("\\s+");
			if (details[0].equalsIgnoreCase("UPLOAD")) {
				File newFile = new File(details[1], details[2], Integer.parseInt(details[3]));
				util.addFile(newFile);
			} else if (details[0].equalsIgnoreCase("FETCH")) {
				util.fetch(details[1]);
			} else if (details[0].equalsIgnoreCase("TOTAL_STORAGE")) {
				util.totalStorage(details[1]);
			} else if (details[0].equalsIgnoreCase("LATEST")) {
				util.latest(details[1]);
			}
		}
	}
}
