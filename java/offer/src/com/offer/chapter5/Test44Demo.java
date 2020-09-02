package com.offer.chapter5;

public class Test44Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution44 solution44 = new Solution44();
		System.out.println(solution44.findNthDigit(1000000000));
	}

}

class Solution44 {
    public int findNthDigit(int n) {
    	if(n<0) {
    		return -1;
    	}
    	int place=1;  //��ʾλ��
    	long index=n;
    	while(true) {
    		long totalNum=getAmountOfPlace(place);          //��λ���������ӵĳ���֮��
    		if(index<totalNum) {            
    			//��nС�ڵ�ǰ����֮��ʱ�����ж�λ
    			return getDigit(index, place);
    		}else {
    			//n��С�ڳ���֮�ͣ�������һ��λ�ĳ���֮������
    			index=index-totalNum;
    			place++;
    		}
    	}
    }
    
    /**
     * �ҵ�placeλ���������ַ����ĳ���֮�ͣ�����ֵҪʹ��long
     * @param place
     * @return
     */
    private long getAmountOfPlace(int place) {
    	if(place==1) {
    		return 10;
    	}
    	return (long)Math.pow(10, place-1)*9*place;
    }
    
    /**
     * �ҵ�placeλ������ʼλ��
     * @param place
     * @return
     */
    private int beginNum(int place) {
    	if(place==1) {
    		return 0;
    	}
    	return (int)Math.pow(10,place-1);
    }
    
    private int getDigit(long index,int place) {
    	int begin=beginNum(place);
    	long shiftNum=index/place;
    	String targetNum=(begin+shiftNum)+"";
    	int countOfTarget=(int)index%place;
    	return targetNum.charAt(countOfTarget)-'0';
    }
}