package oops;

class Cylinderw{
    public int radius;

    public void Cylinderq(int radius,int height){
        this.radius=radius;
        this.height=height;
    }
    public int getRadius(){
        return radius;
    }
    public void setRadius(int radius){
        this.radius=radius;
    }
    public int height;

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height=height;
    }
    public double surfaceArea(){
        return  (2*3.14*radius*radius +2*3.14*radius*height);
    }
}
class Rectangle{
    public int length;
    public int breadth;

    public Rectangle(){
        this.length=5;
        this.breadth=4;
    }
    public int getLength(){
        return length;
    }
    public int getBreadth(){
        return breadth;
    }
}
public class Cylinder {
    public static void main(String[] args) {
        Cylinderw myCylinder= new Cylinderw();
        myCylinder.setHeight(12);
        int h=myCylinder.getHeight();
        System.out.println(h);
        myCylinder.setRadius(9);
        System.out.println(myCylinder.getRadius());
        System.out.println(myCylinder.surfaceArea());

        Rectangle r=new Rectangle();
        System.out.println(r.getBreadth());
         System.out.println(r.getLength());
    }
}
