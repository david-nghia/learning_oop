package Basic;


import java.util.Scanner;


public class MyPoint {
    private double x, y;
    
    public MyPoint() {
        x = 0;
        y = 0;
    }
    
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public MyPoint(MyPoint p) {
        this.x = p.x;
        this.y = p.y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double distance(MyPoint secondPoint) {
        return Math.sqrt((this.x - secondPoint.x)*(this.x - secondPoint.x)+(this.y - secondPoint.y)*(this.y - secondPoint.y));
    }
    
    public double distance(MyPoint p1, MyPoint p2) {
        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double max = 0;
        n = sc.nextInt();
        MyPoint[] a = new MyPoint[n];
        MyPoint res1 = new MyPoint();
        MyPoint res2 = new MyPoint();
        
        for (int i = 0; i < n; i++) {
            
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            a[i] = new MyPoint(x, y);
        }
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i].distance(a[j]) > max) {
                    max = a[i].distance(a[j]);
                    res1 = new MyPoint(a[i]);
                    res2 = new MyPoint(a[j]);
                }
            }
        }
        
        System.out.println("Max distance = " + max);
        System.out.printf("Between (%.2f;%.2f) and (%.2f;%.2f)", res1.getX(), res1.getY(), res2.getX(), res2.getY());
        
    }
}
