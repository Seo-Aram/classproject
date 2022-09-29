package chapter11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class MainClass {
	public static void main(String[] args) {
		System.out.println("=====================LIST");
		List<FootballPlayer> list = new ArrayList<FootballPlayer>();
		list.add(new FootballPlayer("Kim", 0, "FCA", 0));
		for(FootballPlayer f : list) {
			System.out.println(f);
		}

		System.out.println();
		System.out.println("=====================SET");
		Set<FootballPlayer> set = new HashSet<>();
		set.add(new FootballPlayer("Kim", 0, "FCA", 0));
		set.add(new FootballPlayer("Kim", 0, "FCA", 0));
		set.add(new FootballPlayer("Kim", 0, "FCAD", 0));
		System.out.println(set.size());
		for(FootballPlayer f : set) {
			System.out.println(f);
		}

		System.out.println();
		System.out.println("=====================HASH_SET");
		Set<FootballPlayer> treeSet = new TreeSet<FootballPlayer>();
		treeSet.add(new FootballPlayer("Kim", 0, null, 0));
		treeSet.add(new FootballPlayer("Jeon", 1, null, 0));
		treeSet.add(new FootballPlayer("Yang", 10, null, 0));
		treeSet.add(new FootballPlayer("Sin", 0, null, 0));
		treeSet.add(new FootballPlayer("Yang", 0, null, 0));
		treeSet.add(new FootballPlayer("Jeon", 0, null, 0));
		
		for(FootballPlayer f : treeSet) {
			System.out.println(f);
		}

		System.out.println();
		System.out.println("=====================HASH_MAP");
		Map<Integer, FootballPlayer> hashMap = new HashMap<>();
		hashMap.put(0, new FootballPlayer("Kim", 0, null, 0));
		hashMap.put(1, new FootballPlayer("Jeon", 1, null, 0));
		hashMap.put(0, new FootballPlayer("Yang", 0, null, 0));
		hashMap.put(5, new FootballPlayer("Sin", 5, null, 0));
		hashMap.put(7, new FootballPlayer("Kim", 7, null, 0));
		
		System.out.println(hashMap.size());
		Set<Integer> keys = hashMap.keySet();
		for(int i : keys) {
			System.out.println(hashMap.get(i));
		}
	}
}

