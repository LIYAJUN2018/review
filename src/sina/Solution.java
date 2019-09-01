package sina;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Solution {

	int capacity;
	LinkedHashMap<Integer, Integer> cache;

	public Solution(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<>(capacity);
	}

	public int get(int key) {

		if (!cache.containsKey(key)) {
			return -1;
		}
		int val = cache.get(key);
		cache.remove(key);
		cache.put(key, val);
		return val;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			cache.remove(key);
		}
		if (capacity == cache.size()) {
			Set<Integer> keySet = cache.keySet();
			Iterator<Integer> iterator = keySet.iterator();
			cache.remove(iterator.next());
		}
		cache.put(key, value);
	}

}
