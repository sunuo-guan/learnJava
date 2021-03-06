package com.huawei.first;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nOfPrefect = scanner.nextInt();
		Toy[] prefectToy = new Toy[nOfPrefect];
		int r[] = new int[nOfPrefect];
		int s[] = new int[nOfPrefect];
		for (int i = 0; i < nOfPrefect; i++) {
			r[i] = scanner.nextInt();
		}
		for (int i = 0; i < nOfPrefect; i++) {
			s[i] = scanner.nextInt();
		}
		for (int i = 0; i < nOfPrefect; i++) {
			Toy temp = new Toy();
			temp.character = r[i];
			temp.value = s[i];
			prefectToy[i] = temp;
		}
		int nOfNow = scanner.nextInt();
		Toy[] nowToy = new Toy[nOfNow];
		int rr[] = new int[nOfNow];
		int ss[] = new int[nOfNow];
		for (int i = 0; i < nOfNow; i++) {
			rr[i] = scanner.nextInt();
		}
		for (int i = 0; i < nOfNow; i++) {
			ss[i] = scanner.nextInt();
		}
		for (int i = 0; i < nOfNow; i++) {
			Toy temp = new Toy();
			temp.character = rr[i];
			temp.value = ss[i];
			nowToy[i] = temp;
		}
		System.out.println(solution(prefectToy, nowToy, nOfPrefect, nOfNow));
	}
	
	public static int solution(Toy[] prefectToy, Toy[] nowToy, int nOfPrefect, int nOfNow) {
		if (nOfPrefect == 0) {
			return 0;
		}
		for (int i = 0; i < nOfNow - nOfPrefect; i++) {
			int j = 0;
			while(j<nOfPrefect) {
				if(!nowToy[i+j].isEqual(prefectToy[j]))
					break;
				j++;
			}
			if(j == nOfPrefect)
				return i + 1;
		}
		return 0;
	}
}

class Toy {
	public int character;
	public int value;
	
	public boolean isEqual(Toy temp) {
		if (this.character == temp.character && this.value == temp.value) {
			return true;
		} else {
			return false;
		}
	}
}
