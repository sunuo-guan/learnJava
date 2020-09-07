package com.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUcache extends LinkedHashMap<Integer,Integer>{
	private int capacity;
	
	public LRUcache(int capacity) {
		super(capacity,0.75f,true);
		this.capacity=capacity;
	}
	
	public int get(int key) {
		return super.getOrDefault(key, -1);
	}
	
	public void put(int key,int value) {
		super.put(key, value);
	}
	
	public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size()>capacity;
	}
}
