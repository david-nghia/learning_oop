
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hiep
 */
public class StackOfIntergers {
    private int[] elements;
    private int size;
    
    public StackOfIntergers() {
        this.elements = new int[16];
        this.size = 0;
    }
    
    public StackOfIntergers(int capacity) {
        this.elements = new int[capacity];
        this.size = 0;
    }
    
    public boolean isEmpty() {
        if (elements.length == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if (size == elements.length) return true;
        return false;
    }
    
    public int peak() {
        return elements[size - 1];
    }
    
    public void push(int value) {
        this.elements[size] = value;
        this.size++;
    }
    
    public int pop() {
        this.size--;
        return elements[size];
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isPrime(int value) {
        if (value < 2) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
    
    public static boolean isPrime1(int value) {
        if (value < 2) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        StackOfIntergers s = new StackOfIntergers();
        for (int i = 2; i < n + 1; i++) {
            if (StackOfIntergers.isPrime1(i)) 
                if (!s.isFull())
                    s.push(i);
                else {
                    System.out.println("stack full");
                    break;
                }
        }
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
