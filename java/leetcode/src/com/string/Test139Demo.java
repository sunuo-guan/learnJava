package com.string;

import java.util.*;

public class Test139Demo {
	public static void main(String[] args) {
		
	}
	
	public boolean wordBreak2(String s, List<String> wordDict) {
		ArrayList<String> res=new ArrayList<String>();
        StringBuilder temp=new StringBuilder();
        recur(s,wordDict,temp,res);
        return res.isEmpty()?false:true;
    }

	//���ݳ�ʱ
    public void recur(String s, List<String> wordDict,StringBuilder sb,ArrayList<String> list){
        if(sb.length()>=s.length()){
            return;
        }else{
            for(String temp:wordDict){
            	int start=sb.length();
                sb.append(temp);
            	int end=sb.length();
                recur(s,wordDict,sb,list);
                if(sb.length()==s.length()){
                    boolean isSame=true;
                    for(int i=0;i<s.length();i++){
                        if(sb.charAt(i)!=s.charAt(i)){
                            isSame=false;
                            break;
                        }
                    }
                    if(isSame){
                        list.add(s);
                    }
                }
                sb.delete(start, end);
                
            }
        }
    }
    
    //�ֵ�������ȱ���
    public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> set=new HashSet<String>(wordDict);
		
		//���У�������ʼλ��
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(0);
		boolean isVisited[]=new boolean[s.length()];
		while(!queue.isEmpty()) {
			int start=queue.remove();
			if(!isVisited[start]) {
				//��ʼλ�ù̶����յ�λ���������������򲻶ϼ��������
				for(int end=start+1;end<=s.length();end++) {
					if(set.contains(s.substring(start, end))) {
						queue.add(end);
						if(end==s.length()) {
							return true;
						}
					}
				}
				isVisited[start]=true;
			}
		}
		
		return false;
		
    }
}
