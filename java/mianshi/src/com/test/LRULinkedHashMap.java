package com.test;

import java.util.*;
public class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V>{     
    private int capacity;                     //��ʼ�ڴ�����
    
    LRULinkedHashMap(int capacity){          //���췽��������һ������
        super(16,0.75f,true);               //����LinkedHashMap���������    
        this.capacity=capacity;             //����ָ��������ڴ�����
    }
    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest){     
        //��ÿ����һ��Ԫ�أ����ж���size�Ƿ񳬹����Ѷ�������
        System.out.println("��ʱ��size��С="+size());
        if((size()>capacity))
        {
            System.out.println("�����Ѷ����ڴ���������������Ԫ���Ƴ���"+eldest.getValue());
        }
        return size()>capacity;        
    }
    
    public static void main(String[] args) throws Exception{
        Scanner cin = new Scanner(System.in);
        
        System.out.println("�������ܹ��ڴ�ҳ������ ");
        int n = cin.nextInt();
        Map<Integer,Integer> map=new LRULinkedHashMap<Integer, Integer>(n);
        
        System.out.println("�����밴˳������Ҫ�����ڴ���ܹ�ҳ������ ");
        int y = cin.nextInt();
        
        System.out.println("�����밴˳����������ڴ��ҳ�����У� ");
        for(int i=1;i<=y;i++)
        {
            int x = cin.nextInt();
            map.put(x,  x);  
        }
        System.out.println("��ʱ�ڴ��а�����ҳ��������:");
        //��for-each��䣬������ʱ�ڴ��е�ҳ�沢���
        for(java.util.Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
