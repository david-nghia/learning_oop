package basic;


public class Rectangle {
    private double width, height;
    String color;
    
    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }
    
    public Rectangle(double a, double b) {
        this.width = a;
        this.height = b;
    }
    
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double a) {
        this.width = a;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double a) {
        this.height = a;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String newColor) {
        this.color = newColor;
    }
    
    public double findArea() {
        return this.height * this.width;
    }
    
    public double findPerimeter() {
        return 2*(this.height + this.width);
    }
    
    public static void main(String[] args) {
        Rectangle a = new Rectangle(5, 6);
        a.setColor("Red");
        System.out.println("M�u s?c: " + a.getColor());
        System.out.println("Di?n t�ch: " + a.findArea());
        System.out.println("Chu vi: " + a.findPerimeter());
    }
    
}
