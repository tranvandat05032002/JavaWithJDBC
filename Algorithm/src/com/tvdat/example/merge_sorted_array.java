package com.tvdat.example;

public class merge_sorted_array {
	
	public static void merge(int[] list1, int n, int[] list2, int m) {
		for(int ai : list2) {
			chenPhanTuVaoMang(ai, list1, n);
			n++;
		}
	}
	public static void chenPhanTuVaoMang(int x, int[] list1, int n) {
		boolean findElement = false;
		for(int i = 0 ; i < n; i++) {
			if(list1[i] > x) {
				findElement = true;
				
				for(int j = n - 1; j >= i; j--) {
					list1[j + 1] = list1[j];
				}
				list1[i] = x;
				break;
			}
		}
		
		if(findElement == false) {
			list1[n] = x;
		}
	}

	public static void main(String[] args) {
		int[] list1 = {1,2,3,0,0,0};
		int n = 3;
		int[] list2 = {2,5,6};
		int m = 3;
		merge(list1, n, list2, m);
		System.out.println("DONE");

	}

}
