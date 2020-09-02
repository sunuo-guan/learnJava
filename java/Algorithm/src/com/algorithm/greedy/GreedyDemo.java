package com.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyDemo {
	public static void main(String[] args) {
		HashMap<String,HashSet<String>> broadcasts=new HashMap<String,HashSet<String>> ();
		HashSet<String> hashSet1=new HashSet<String>();		
		hashSet1.add("a");
		hashSet1.add("b");
		hashSet1.add("c");
		
		HashSet<String> hashSet2=new HashSet<String>();		
		hashSet2.add("d");
		hashSet2.add("a");
		hashSet2.add("e");
		
		HashSet<String> hashSet3=new HashSet<String>();		
		hashSet3.add("f");
		hashSet3.add("b");
		hashSet3.add("g");
		
		HashSet<String> hashSet4=new HashSet<String>();		
		hashSet4.add("b");
		hashSet4.add("c");
		
		HashSet<String> hashSet5=new HashSet<String>();		
		hashSet5.add("h");
		hashSet5.add("g");
		
		broadcasts.put("K1",hashSet1);
		broadcasts.put("K2",hashSet2);
		broadcasts.put("K3",hashSet3);	
		broadcasts.put("K4",hashSet4);
		broadcasts.put("K5",hashSet5);
		
		//找到一个 则从里面去掉
		HashSet<String> allAdress=new HashSet<String>();
		allAdress.add("a");
		allAdress.add("b");
		allAdress.add("c");
		allAdress.add("d");
		allAdress.add("e");
		allAdress.add("f");
		allAdress.add("g");
		allAdress.add("h");
		
		//选择的电台
		ArrayList<String> select=new ArrayList<String>();
		
		//当前广播站覆盖的地区
		ArrayList<String> tempSet=new ArrayList<String>();
		
		//maxKey最大覆盖的指针
		String maxKey=null;
		
		//allAdress里面仍含有地址 则继续循环
		while(allAdress.size()>0) {
			maxKey=null;
			
			//遍历每个广播站
			for(String key:broadcasts.keySet()) {
				//tempSet要清空
				tempSet.clear();
				//当前key能覆盖的地区
				HashSet<String> areas=broadcasts.get(key);
				tempSet.addAll(areas);
				//求交集
				tempSet.retainAll(allAdress);
				//如果该交集比maxkey大，则maxkey指向该广播站
				if(tempSet.size()>0&&
						(maxKey==null||tempSet.size()>broadcasts.get(maxKey).size())) {
					maxKey=key;
				}
			}
			if(maxKey!=null) {
				select.add(maxKey);
				allAdress.removeAll(broadcasts.get(maxKey));
			}
			
		}
		System.out.println("选择的结果是："+select);
	}
}
