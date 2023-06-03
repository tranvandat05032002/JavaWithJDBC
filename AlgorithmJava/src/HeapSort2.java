import java.util.*;

public class HeapSort {
	public void heapify(int[] in, int n, int i) {
		int root = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		if(l < n && in[root] < in[l]) {
			root = l;
		}
		if(r < n && in[root] < in[r]) {
			root = r;
		}
		if(root != i) {
			int swap = in[i];
			in[i] = in[root];
			in[root] = swap;
			
			heapify(in, n, root);
		}
	}
	public void heapSort(int[] in, int n) {
		for(int i = n  /2 - 1; i >= 0; i--) {
			heapify(in, n, i);
		}
		for(int i = n -1; i >= 0; i--) {
			int tmp = in[0];
			in[0] = in[i];
			in[i] = tmp;
			heapify(in, n, 0);
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
		int[] in;
		for(int i = 0; i < n; i++) {
			in[i] = scanner.nextInt();
		}
		HeapSort heapsort = new HeapSort();
		heapsort.heapSort(in, n);
	}

}
