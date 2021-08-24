package basic;


import java.util.Scanner;

public class Main {
    public static boolean isPrime(int value) {
        if (value < 2) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackOfIntergers s = new StackOfIntergers();
        int n;
        
        n = sc.nextInt();
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    if (!s.isFull())
                        s.push(i);
                    else System.out.println("Stack full");
                    n /= i;
                }
            }
        }
        
        if (s.isPrime(n)) {
            s.push(n);
        }
        
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
