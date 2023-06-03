package com.tvdat.algorithm.sort;

import java.util.Scanner;
public class HeapSort {
	public void heapify(int[] in, int n, int i) {
		int root = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		if(l < n && in[l] > in[root]) {
			root = l;
		}
		if(r < n && in[r] > in[root]) {
			root = r;
		}
		if(root != i) {
			int swap = in[i];
			in[i] = in[root];
			in[root] = swap;
			
			heapify(in, n, root);
		}
	}
	public void heapSort(int[] in) {
		int n = in.length;
		for(int i = n  /2 - 1; i >= 0; i--) {
			heapify(in, n, i);
		}
		for(int i = n - 1; i >= 0; i--) {
			int tmp = in[0];
			in[0] = in[i];
			in[i] = tmp;
			heapify(in, i, 0);
		}
	}
	public void printArray(int[] in, int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(in[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		HeapSort heapsort = new HeapSort();
		heapsort.heapSort(arr);
		heapsort.printArray(arr, n);
	}

}

