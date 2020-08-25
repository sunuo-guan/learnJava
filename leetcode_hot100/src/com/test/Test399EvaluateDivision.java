package com.test;

import java.util.*;

public class Test399EvaluateDivision {
	public static void main(String[] args) {
		
	}
	
	//数据结构：图，用Floyd算出没有值的二维矩阵点
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    	int count = 0;
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	for(List<String> list : equations) {
    		for(String str :list) {
    			if(!map.containsKey(str)) {
    				map.put(str, count);
    				count++;
    			}
    		}
    	}
    	
    	double[][] matrix = new double[count][count];
    	for(int i=0;i<values.length;i++) {
    		List<String> list = equations.get(i);
    		matrix[map.get(list.get(0))][map.get(list.get(1))] = values[i];
    		matrix[map.get(list.get(1))][map.get(list.get(0))] = 1 / values[i];
    	}
    	for (int i = 0; i < matrix.length; i++) {
			matrix[i][i] = 1;
		}
    	
    	for(int k = 0;k < count; k++)
    		for (int i = 0; i < count; i++) 
    			for (int j = 0; j < count; j++) {
    				if(matrix[i][j]!=0) continue;
                    if(matrix[i][k]!=0&&matrix[k][j]!=0){
                        matrix[i][j] = matrix[i][k] * matrix[k][j];
                    }
				}
    	
    	double[] result = new double[queries.size()];
    	for (int i = 0; i < queries.size(); i++) {
    		List<String> list = equations.get(i);
    		if(map.containsKey(list.get(0)) && map.containsKey(list.get(1))) {
    			result[i] = matrix[map.get(list.get(0))][map.get(list.get(1))] == 0 ? -1 : matrix[map.get(list.get(0))][map.get(list.get(1))];
    		} else {
    			result[i] = -1;
    		}
		}
    	return result;
    }
}
