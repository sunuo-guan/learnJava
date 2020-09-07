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
		
		//�ҵ�һ�� �������ȥ��
		HashSet<String> allAdress=new HashSet<String>();
		allAdress.add("a");
		allAdress.add("b");
		allAdress.add("c");
		allAdress.add("d");
		allAdress.add("e");
		allAdress.add("f");
		allAdress.add("g");
		allAdress.add("h");
		
		//ѡ��ĵ�̨
		ArrayList<String> select=new ArrayList<String>();
		
		//��ǰ�㲥վ���ǵĵ���
		ArrayList<String> tempSet=new ArrayList<String>();
		
		//maxKey��󸲸ǵ�ָ��
		String maxKey=null;
		
		//allAdress�����Ժ��е�ַ �����ѭ��
		while(allAdress.size()>0) {
			maxKey=null;
			
			//����ÿ���㲥վ
			for(String key:broadcasts.keySet()) {
				//tempSetҪ���
				tempSet.clear();
				//��ǰkey�ܸ��ǵĵ���
				HashSet<String> areas=broadcasts.get(key);
				tempSet.addAll(areas);
				//�󽻼�
				tempSet.retainAll(allAdress);
				//����ý�����maxkey����maxkeyָ��ù㲥վ
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
		System.out.println("ѡ��Ľ���ǣ�"+select);
	}
}
