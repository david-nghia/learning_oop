package Basic;


import java.util.Scanner;


public class PhanSo {
    
    private int ts, ms;
    
    public int GCD(int a, int b) {
        while (b > 0) {
           if (a > b) {
               int tmp = a;
               a = b;
               b = tmp;
           }
           b %= a;
        }
        return a;
    }
    
    public PhanSo() {
        this.ts = 0;
        this.ms = 1;
    }
    
    public PhanSo(int ts, int ms) {
        this.ts = ts;
        this.ms = ms;
    }
    
    public PhanSo cong(PhanSo sp2) {
        PhanSo res = new PhanSo();
        res.ms = this.ms * sp2.ms;
        res.ts = this.ts * sp2.ms + this.ms * sp2.ts;
        return res;
    }
    
    public PhanSo tru(PhanSo sp2) {
        PhanSo res = new PhanSo();
        res.ms = this.ms * sp2.ms;
        res.ts = this.ts * sp2.ms - this.ms * sp2.ts;
        return res;
    }
    
    public PhanSo nhan(PhanSo sp2) {
        PhanSo res = new PhanSo();
        res.ms = this.ms * sp2.ms;
        res.ts = this.ts * sp2.ts;
        return res;
    }
    
    public PhanSo chia(PhanSo sp2) {
        PhanSo res = new PhanSo();
        res.ms = this.ms * sp2.ts;
        res.ts = this.ts * sp2.ms;
        return res;
    }
    
    public PhanSo nghichDao () {
        PhanSo res = new PhanSo();
        res.ts = this.ms;
        res.ms = this.ts;
        return res;
    }
    
    public PhanSo doiDau() {
        PhanSo res = new PhanSo(-this.ts, this.ms);
        return res;
    }
    
    public PhanSo toiGian() {
        PhanSo res = new PhanSo(this.ts, this.ms);
        int value = GCD(this.ts, this.ms);
        res.ts = this.ts / value;
        res.ms = this.ms / value;
        return res;
    }
    
    public boolean bangNhau(PhanSo ps2) {
        this.toiGian();
        ps2.toiGian();
        if (ps2.ts == this.ts && ps2.ms == this.ms) return true;
        return false;
    }
    
    public boolean nhoHon(PhanSo ps2) {
        PhanSo res = new PhanSo();
        res = this.tru(ps2);
        if (res.ts * res.ms < 0) return true;
        return false;
    }
    
    public boolean lonHon(PhanSo ps2) {
        PhanSo res = new PhanSo();
        res = this.tru(ps2);
        if (res.ts * res.ms > 0) return true;
        return false;
    }
    
    public void hien() {
        System.out.println(this.ts + "/" + this.ms);
    }
    
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        this.ts = sc.nextInt();
        this.ms = sc.nextInt();
    }
    
    public static void main(String[] args) {
        PhanSo p1 = new PhanSo();
        PhanSo p2 = new PhanSo();
        PhanSo res = new PhanSo();
        System.out.println("Nhap ps1: ");
        p1.nhap();
        System.out.println("Nhap ps2: ");
        p2.nhap();
        res = p1.cong(p2);
        System.out.println("Tong = "); res.hien();
        res = p1.tru(p2);
        System.out.println("Hieu = "); res.hien();
        res = p1.nhan(p2);
        System.out.println("Tich = "); res.hien();
        res = p1.chia(p2);
        System.out.println("Thuong = "); res.hien();
    
    
    
    }
    
}
