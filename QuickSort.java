 import java.util.Random;
import java.util.Scanner;

class Qsort{
	int n;
	int arr[];
	
	public void createArray(int n, int choice) {
		this.n = n;
		arr = new int[n+1];
		if (choice == 0) {
			for(int i = 0; i<n; i++) {
				arr[i] = i;
			}
		}
		else if (choice==1) {
			for(int i = 0; i<n; i++) {
				arr[i] = n-i;
			}
		}
		else {
			Random rand = new Random();
	    	 for(int i=0;i<n;i++) {
	    		 arr[i]=rand.nextInt(1000000);
			}
		}
	}
	
	public void printArray() {
		for(int i = 0; i< n; i++) {
			System.out.println(arr[i] + " ");
		}
	}
	
	
	public void sort(int l, int r) {
		if(l < r) {
			int p = partition(l,r);
			sort(l, p-1);
			sort(p+1, r);                                            
		}
	}
	public int partition(int l, int r) {
		int i = l;
		int j = r;
		int p = arr[l];
		
		while(i <= j) {
			while(arr[i] <= p) {
				i = i + 1;
			}
			while(arr[j] > p) {
				j = j - 1;
			}
			int a = arr[i];
			arr[i] = arr[j];
			arr[j] = a;
		}
		int b = arr[i];
		arr[i] = arr[j];
		arr[j] = b;
		
		int c = arr[l];
		arr[l] = arr[j];
		arr[j] = c;
		
		return j;
	}
}

public class QuickSort {
	public static void main(String[] args) {
		int n;
		long start,end,time;
		Qsort qsort = new Qsort();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		n = sc.nextInt();
		
		qsort.createArray(n, 2);
		System.out.println("The elements in array are: ");
		qsort.printArray();
		
		start = System.nanoTime();
		qsort.sort(0,n-1);
		end = System.nanoTime();
		
		System.out.println("The sorted elements are: ");
		qsort.printArray();
		time = (end-start)/1000000L;
		System.out.println("The time taken to sort is: " + time + " ms");
		sc.close();
	}
}