package com.array;

import java.util.*;

public class Test56Demo {
	public static void main(String[] args) {
		int[][] intervals= {{1,4},{1,2},{5,6}};
//		int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
		System.out.println(merge(intervals));
	}
	
	public static int[][] merge(int[][] arr) {
		if(arr == null || arr.length<=1)
            return arr;
        List<int[]> list = new ArrayList<>();
        //Arrays.sort(arr,(a,b)->a[0]-b[0]);
//        Arrays.sort(arr,new Comparator<int[]>(){
//            @Override
//            public int compare(int[] a,int[] b){
//                return a[0]-b[0];
//            }
//        });
        
        Arrays.sort(arr,new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		// TODO Auto-generated method stub
        		return o1[0]-o2[0];
        	}
		});
        int i=0;
        int n = arr.length;
        while(i<n){
            int left = arr[i][0];
            int right = arr[i][1];
            while(i<n-1 && right>=arr[i+1][0]){
                right = Math.max(right,arr[i+1][1]);
                i++;
            }
            list.add(new int[] {left,right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);

    }
}
