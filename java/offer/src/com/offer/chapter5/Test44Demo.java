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
    	int place=1;  //表示位数
    	long index=n;
    	while(true) {
    		long totalNum=getAmountOfPlace(place);          //找位数不断增加的长度之和
    		if(index<totalNum) {            
    			//当n小于当前长度之和时，进行定位
    			return getDigit(index, place);
    		}else {
    			//n不小于长度之和，则在下一个位的长度之和中找
    			index=index-totalNum;
    			place++;
    		}
    	}
    }
    
    /**
     * 找到place位数的所有字符串的长度之和，返回值要使用long
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
     * 找到place位数的起始位数
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