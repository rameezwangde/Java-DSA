package oops;

class CircleArea{
    private double radius;

    public double getRadius(){
        return radius;
    }

    public void setRadius(double r){
        if(r<0){
            System.out.println("⚠️ Warning: Radius cannot be negative. Setting to 0.");
            radius=0;
        }else{
            radius=r;
        }
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getCircumference(){
        return 2*Math.PI*radius;
    }
}
public class Circle {
    public static void main(String[] args) {
        CircleArea c1=new CircleArea();
        c1.setRadius(5);
        System.out.println("Radius:"+c1.getRadius());
        System.out.println("Area:"+c1.getArea());
        System.out.println("Circumference:"+c1.getCircumference());

        c1.setRadius(-10);
        System.out.println("Radius after invalid input:"+c1.getRadius());
    }
}
