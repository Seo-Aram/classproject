package chapter12;

import java.io.File;
import java.util.Scanner;

class Notepad {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String dir = "./text/";
		File directory = new File(dir);
		if(!directory.exists()) {
			directory.mkdir();
		}
		
		String fileName = scan.nextLine();
		
		
		
		File file = new File(dir, "test.txt");
		System.out.println(file.exists());
		System.out.println(file);
		
		scan.close();
	}
}
