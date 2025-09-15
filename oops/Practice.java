package oops;
class Employee {
    int salary;
    String name;

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }
}

class CellPhone{
    public void ringing(){
        System.out.println("Ringing....");
    }
    public void vibrating(){
        System.out.println("vibrating!!");
    }
}

class Square{
    int side;
    
    public int Area(){
        return side*side;
    }
    public int perimeter(){
        return  4*side;
    }
}
class Tommy{
    public void hit(){
        System.out.println("Hitting the enemy");
    }
     public void run(){
        System.out.println("running from  the enemy");
    }
     public void fire(){
        System.out.println("firing on the enemy");
    }
}

public class Practice {
    public static void main(String[] args) {
        Employee rameez = new Employee();
        rameez.setName("anmol");
        System.out.println("Employee Name: " + rameez.getName());

        rameez.salary = 13000;
        System.out.println("Employee Salary: " + rameez.getSalary());

        CellPhone apple=new CellPhone();
        apple.ringing();
        apple.vibrating();

        Square sq=new Square();
        sq.side=4;
        System.out.println(sq.Area());
         System.out.println(sq.perimeter());

         Tommy v=new Tommy();
            v.run();
            v.fire();
            v.hit();
    }
}

