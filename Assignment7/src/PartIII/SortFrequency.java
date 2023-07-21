package PartIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class SortFrequency {

	public static void sortByFrequency(ArrayList<Integer> ar) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : ar) {
			if (!map.containsKey(num)) {
				map.put(num, 0);
			}
			map.put(num, map.get(num) + 1);
		}
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> ele1, Entry<Integer, Integer> ele2) {
				int compareVal = ele1.getValue().compareTo(ele2.getValue());
				if (compareVal != 0) {
					return compareVal;
				}
				return ele1.getKey().compareTo(ele2.getKey());
			}
		});
		System.out.println(list);

		ar.clear();
		for (Entry<Integer, Integer> e : list) {
			for (int i = 0; i < e.getValue(); i++) {
				ar.add(e.getKey());
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			ar.add((int) (Math.random() * 10));
		}
		System.out.println(ar.toString());
		sortByFrequency(ar);
		System.out.println(ar.toString());
	}
}
