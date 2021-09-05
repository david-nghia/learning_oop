package fileio;

import java.io.*;
import java.util.*;


public class SortCollections {

    private PrintWriter output;
    private int[] array;
    private int n;
    public SortCollections(String filename) throws FileNotFoundException {
        readData(filename);
        this.output = new PrintWriter(new File("output.txt"));

    }

    private void readData(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        n = input.nextInt();
        array = new int[n];
        for (int i = 0; i < this.n; i++) {
            array[i] = input.nextInt();
        }
    }

    public void display(int[] ar) {
        for (int i = 0; i < this.n; i++) {
            output.print(ar[i]);
            output.print(' ');
        }
        output.println();
    }

    public int[] selectionSort() {
        int size = array.length;
        int[] ar = new int[size];
        System.arraycopy(array, 0, ar, 0, size);
        for (int i = 0; i < size; i++) {
            int index = i;
            int min = ar[i];
            for (int j = i; j < size; j++) {
                if (ar[j] < min) {
                    min = ar[j];
                    index = j;
                }
            }
            if (index != i) {
                int tmp = ar[i];
                ar[i] = ar[index];
                ar[index] = tmp;
                //System.out.println(index);
            }
        }
        return ar;
    }

    public int[] inserttionSort() {
        int size = array.length;
        int[] ar = new int[size];
        System.arraycopy(array, 0, ar, 0, size);
        for (int i = 1; i < size; i++) {
            int key = ar[i];
            int j = i - 1;
            while (j >= 0 && ar[j] > key) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = key;
        }
        return ar;
    }

    public int[] bubbleSort() {
        int size = array.length;
        int[] ar = new int[size];
        System.arraycopy(array, 0, ar, 0, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (ar[j] > ar[j + 1]) {
                    int tmp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = tmp;
                }
            }
        }
        return ar;
    }

    public int search(int x, int[] ar) {
        int size = this.n;
        for (int i = 0; i < size; i++) {
            if (this.array[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int x) {
        int size = this.array.length;
        int l = 0;
        int r = size - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (this.array[mid] == x) {
                return mid;
            } else if (this.array[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "DAYSO.txt";
        SortCollections sc = new SortCollections(filename);
        int[] res = new int[sc.n];
        
        res = sc.bubbleSort();
        sc.output.println("sap xep noi boi: ");
        sc.display(res);
        
        res = sc.selectionSort();
        sc.output.println("Quy trinh sap xep chon: ");
        sc.display(res);
        
        res = sc.inserttionSort();
        sc.output.println("Quy trinh sap xep chen: ");
        sc.display(res);
        
        sc.output.close();
    }

}
