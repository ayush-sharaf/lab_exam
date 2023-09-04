import java.util.Random;
import java.util.Scanner;

class MSort {
    int n;
    int arr[];
    int tempArr[]; // to store the result

    public void createArray(int n, int choice) {
        this.n = n;
        arr = new int[n + 1];
        if (choice == 0) {
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        } else if (choice == 1) {
            for (int i = 0; i < n; i++) {
                arr[i] = n - i;
            }
        } else {
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(1000000);
            }
        }
    }

    public void printArray() {
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public void sort(int low, int high) {
        if (low < high) {
            int middle = (high + low) / 2;
            sort(low, middle);
            sort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    public void merge(int low, int middle, int high) {
        tempArr = new int[n + 1];
        for (int i = low; i <= high; i++) {
            tempArr[i] = arr[i];
        }
        int i = low;
        int k = low;
        int j = middle;

        while (i <= middle && j <= high) {
            if (tempArr[i] <= tempArr[j]) {
                arr[k] = tempArr[i];
                i++;
            } else {
                arr[k] = tempArr[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            arr[k] = tempArr[i];
            i++;
            k++;
        }

        while (j <= high) {
            arr[k] = tempArr[j];
            j++;
            k++;
        }
    }
}

public class MergeSort {
    public static void main(String[] args) {
        MSort obj = new MSort();
        int n;
        long start, end, time;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        n = sc.nextInt();

        obj.createArray(n, 2);
        System.out.println("The elements in array are: ");
        obj.printArray();

        start = System.nanoTime();
        obj.sort(0, n - 1);
        end = System.nanoTime();

        System.out.println("The sorted elements are: ");
        obj.printArray();
        time = (end - start) / 1000000L;
        System.out.println("The time taken to sort is: " + time + " ms");
        sc.close();
    }
}
