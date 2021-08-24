package fileio;

import java.io.*;
import java.util.*;

public class SortCollections {

    private PrintWriter output;
    private int[] array;

    public SortCollections(String filename) throws FileNotFoundException {
        readData(filename);
        this.output = new PrintWriter(new File("output.txt"));

    }

    private void readData(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        array = new int[100];
        for (int i = 0; i < 10; i++) {
            array[i] = input.nextInt();
        }
    }

    public void display(int[] ar) {
        for (int i = 0; i < 10; i++) {
            output.print(ar[i]);
            output.print(' ');
        }
        output.println();
    }

    public void selectionSort() {
        int[] ar = new int[100];
        System.arraycopy(array, 0, ar, 0, 10);
        for (int i = 0; i < 10; i++) {
            int index = i;
            int min = ar[i];
            for (int j = i; j < 10; j++) {
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
            display(ar);
        }
    }

    public void inserttionSort() {
        int[] ar = new int[100];
        System.arraycopy(array, 0, ar, 0, 10);
        for (int i = 1; i < 10; i++) {
            int key = ar[i];
            int j = i - 1;
            while (j >= 0 && ar[j] > key) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = key;
            display(ar);
        }
    }

    public void bubbleSort() {
        int[] ar = new int[100];
        System.arraycopy(array, 0, ar, 0, 10);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9 - i; j++) {
                if (ar[j] > ar[j + 1]) {
                    int tmp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = tmp;
                }
            }
            display(ar);
        }
    }

    public int search(int x) {
        for (int i = 0; i < 10; i++) {
            if (this.array[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int x) {
        int l = 0;
        int r = 9;
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
        sc.output.println("Quy trinh sap xep noi boi: ");
        sc.bubbleSort();
        sc.output.println("Quy trinh sap xep chon: ");
        sc.selectionSort();
        sc.output.println("Quy trinh sap xep chen: ");
        sc.inserttionSort();
        
        sc.output.close();
    }

}
