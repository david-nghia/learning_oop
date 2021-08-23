
import java.util.Scanner;


public class Matrix {
    private int rows = 100, cols = 100;
    private float[][] a = new float[rows][cols];
    Scanner sc = new Scanner(System.in);
    
    public Matrix() {
        this.rows = 3;
        this.cols = 3;
    }
    
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }
    
    public Matrix add(Matrix m) {
        Matrix res = new Matrix(this.rows, this.cols);
        if (this.cols != m.cols || this.rows != m.rows) {
            System.out.println("Can't add");
            return null;
        }
        else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    res.a[i][j] = this.a[i][j] + m.a[i][j];
                }
            }
        }
        return res;
    }
    
    public Matrix sub(Matrix m) {
        Matrix res = new Matrix(this.rows, this.cols);
        if (this.cols != m.cols || this.rows != m.rows) {
            System.out.println("Can't sub");
            return null;
        }
        else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    res.a[i][j] = this.a[i][j] - m.a[i][j];
                }
            }
        }
        return res;
    }
    
    public Matrix neg() {
        Matrix res = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                res.a[i][j] = -this.a[i][j];
            }
        }
        return res;
    }
    
    public Matrix mul(Matrix m) {
        if (this.cols != m.rows) {
            System.out.println("Can't mul");
            return null;
        }
        else {
            Matrix res = new Matrix(this.rows, m.cols);
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < m.cols; j++) {
                    float sum = 0;
                    for (int k = 0; k < m.cols; k++) {
                        sum += (this.a[i][k] * m.a[k][j]);
                        res.a[i][j] = sum;
                    }
                }
            }
            return res;
        }
    } 
    
    public Matrix transpose() {
        Matrix res = new Matrix(this.cols, this.rows);
        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                res.a[i][j] = this.a[j][i];
            }
        }
        return res;
    }
    
    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.a[i][j] +  " ");
            }
            System.out.println("");
        }
    }
    
    public void input() {
        
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                a[i][j] = sc.nextFloat();
            }
        }
    }
    
    public static void main(String[] args) {
        Matrix a = new Matrix();
        Matrix b = new Matrix();
        Matrix res1 = new Matrix();
        Matrix res2 = new Matrix();
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("------------Menu-------------");
        System.out.println("1. Tinh tong, hieu 2 ma tran");
        System.out.println("2. Tich 2 ma tran");
        System.out.println("3. Ma tran chuyen vi");
        System.out.println("4. Ket thuc");
        
        int n;
        while (true) {
            n = sc.nextInt();
            if (n == 1) {
                System.out.println("Matrix 1: ");
                a.input();
                System.out.println("Matrix 2: ");
                b.input();
                res1 = a.add(b);
                res2 = a.sub(b);
                System.out.println("Tong: "); if (res1 != null) res1.print();
                System.out.println("Hieu: "); if (res2 != null) res2.print();
            }
            if (n == 2) {
                System.out.println("Matrix 1: ");
                a.input();
                System.out.println("Matrix 2: ");
                b.input();
                res1 = a.mul(b);
                System.out.println("Tich: ");
                if (res1 != null) res1.print();
            }
            if (n == 3) {
                System.out.println("Matrix 1: ");
                a.input();
                res1 = a.transpose();
                res1.print();
            }
            if (n == 4) {
                break;
            }
        }
    }
}
