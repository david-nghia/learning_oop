
import java.util.Scanner;


public class SoPhuc {

    private float a, b;
    
    public SoPhuc() {
        this.a = 0;
        this.b = 0;
    }
    
    public SoPhuc (float thuc, float ao) {
        this.a = thuc;
        this.b = ao;
    }
    
    public SoPhuc cong(SoPhuc sp2) {
        SoPhuc res = new SoPhuc();
        res.a = this.a + sp2.a;
        res.b = this.b + sp2.b;
        return res;
    }
    
    public SoPhuc tru(SoPhuc sp2) {
        SoPhuc res = new SoPhuc();
        res.a = this.a - sp2.a;
        res.b = this.b - sp2.b;
        return res;
    }
    
    public SoPhuc nhan(SoPhuc sp2) {
        SoPhuc res = new SoPhuc();
        res.a = this.a * sp2.a - this.b * sp2.b;
        res.b = this.a * sp2.b + this.b * sp2.a;
        return res;
    }
    
    public SoPhuc chia(SoPhuc sp2) {
        SoPhuc res = new SoPhuc();
        res.a = ((this.a * sp2.a) + (this.b * sp2.b)) / ((sp2.a * sp2.a) + (sp2.b * sp2.b));
        res.b = ((sp2.a * this.b) - (sp2.b * this.a)) / ((sp2.a * sp2.a) + (sp2.b * sp2.b));
        return res;
    }
    
    public SoPhuc nghichDao() {
        SoPhuc res = new SoPhuc();
        res.a = this.a / ((this.a * this.a) + (this.b * this.b));
        res.b = -this.b / ((this.a * this.a) + (this.b * this.b));
        return res;
    }
    
    public boolean bangNhau(SoPhuc sp2) {
        if (this.a == sp2.a && this.b == sp2.b) {
            return true;
        }
        return false;
    }
            
    public void hien() {
        System.out.println(this.a + " + j" + this.b);
    }
    
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        this.a = sc.nextFloat();
        this.b = sc.nextFloat();
    }
    
    public static void main(String[] args) {
        SoPhuc a = new SoPhuc();
        SoPhuc b = new SoPhuc();
        SoPhuc res = new SoPhuc();
        System.out.println("So thu 1: ");
        a.nhap();
        System.out.println("So thu 2: ");
        b.nhap();
        
        res = a.cong(b);
        System.out.println("Tonng: "); res.hien();
        
        res = a.tru(b);
        System.out.println("Hieu: "); res.hien();
        
        res = a.nhan(b);
        System.out.println("Tich: "); res.hien();
        
        res = a.chia(b);
        System.out.println("Thuong: "); res.hien();
        
        res = a.nghichDao();
        System.out.println("Nghich dao 1: "); res.hien();
        
        res = b.nghichDao();
        System.out.println("Nghich dao 2: "); res.hien();
        
        
        if (a.bangNhau(b)) System.out.println("Bang nhau");
        else System.out.println("Khong bang nhau");
    }
    
}
