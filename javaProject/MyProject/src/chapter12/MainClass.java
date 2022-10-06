package chapter12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class MainClass {

	public static void main(String[] args) {
		String[] teams = {"RED", "BLUE", "GREEN", "BLACK"};
	
		List<FootballPlayer> list = new ArrayList<>();
		for(int i = 0; i < 10; ++i) {
			list.add(new FootballPlayer("test"+i, i, teams[i % teams.length], ((int)Math.random()*20 + 15)));
		}
		ObjectOutputStream outStream = null;
		
		try { 
			outStream = new ObjectOutputStream(new FileOutputStream("footballS.ser"));
			outStream.writeObject(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<FootballPlayer> readList = null;
		ObjectInputStream inStream = null;
		
		try {
			inStream = new ObjectInputStream(new FileInputStream("footballS.ser"));
			
			if(inStream != null) {
				readList = (ArrayList<FootballPlayer>)inStream.readObject();
				for(FootballPlayer p : readList) {
					System.out.println(p);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
