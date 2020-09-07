package com.array;

import java.util.Arrays;

public class Test253Demo {
	public int minMeetRooms(int times[][]) {
		int len=times.length;
		int start[]=new int[len];
		int end[]=new int[len];
		for (int i = 0; i < len; i++) {
			start[i]=times[i][0];
			end[i]=times[i][1];
		}
		
		Arrays.sort(start);
		Arrays.sort(end);
		int ans=0,endpos=0;
		
		for (int i = 0; i < len; i++) {
			if(start[i]<end[i]) {
				ans++;
			}else {
				endpos++;
			}
		}
		
		return ans;
	}
}
