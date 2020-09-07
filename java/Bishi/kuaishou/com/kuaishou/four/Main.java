package com.kuaishou.four;

public class Main {

}

class Solution {
    /**
     * ��ȡ����ͬ�°칫Ա����
     * @param pos char�ַ��Ͷ�ά���� ��λ�ֲ�
     * @return int����
     */
    public int GetMaxStaffs (char[][] pos) {
        // write code here
    	boolean canSit[][]=new boolean[pos.length][pos[0].length];
    	for (int i = 0; i < canSit.length; i++) {
			for (int j = 0; j < canSit[0].length; j++) {
				if(pos[i][j]=='.') {
					canSit[i][j]=true;
				}
			}
		}
    	
    	int res=0;
    	for (int i = 0; i < canSit.length; i++) {
			for (int j = 0; j < canSit[0].length; j++) {
				if(canSit[i][j]==true) {
					res++;
					if(j<canSit[0].length-1) {
						canSit[i][j+1]=false;
					}
					if(i<canSit.length-1) {
						canSit[i+1][j]=false;
					}
				}
			}
		}
    	
    	return res;
    	
    	
    }
}