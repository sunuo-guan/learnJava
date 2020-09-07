package com.offer.chapter5;

import java.util.HashMap;

public class Test50Demo {
	public static void main(String[] args) {
		String s="aaffb";
		System.out.println(firstUniqChar(s));
	}
	
	/**
	 * �е��鷳�ˣ����ԸĽ�
	 * @param s
	 * @return
	 */
	public static char firstUniqChar(String s) {
		if(s==null||s.length()==0) {
			return ' ';
		}
		
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		int sLen=s.length();
		int num[]=new int[sLen];  //���ִ������飬�±�Ϊ��һ�γ��ֵ�λ�ã�ֵΪ���ֵĴ���
		
		for (int i = 0; i < sLen; i++) {
			if(map.containsKey(s.charAt(i))) {
				//���ַ���֮ǰ���и��ַ������ȡ��һ�γ��ֵ��±꣬�������ִ�����1
				int index=map.get(s.charAt(i));
				num[index]++;
			}else {
				//���ַ���֮ǰ�����и��ַ����򽫵�ǰ�ַ����±�Ž���ϣ���У��������ִ�����1
				map.put(s.charAt(i), i);
				num[i]=1;
			}
		}
		
		int index=0;
		boolean onlyOne=false;
		for (int i = 0; i < sLen; i++) {
			if(num[i]==1) {
				index=i;
				onlyOne=true;
				break;
			}
		}
		
		if(onlyOne) {
			return s.charAt(index);
		}else {
			return ' ';
		}
		
    }
}
