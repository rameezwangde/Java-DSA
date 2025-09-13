package OOPS;
class Student{
    String name;
    int age;

    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }

    Student(Student s2){
        // System.out.println("constructor called:");
        this.name=s2.name;
        this.age=s2.age;
    }
    Student(){
        
    }

    public void printInfo(String name){
        System.out.println(name);
    }
    public void printInfo(int age){
        System.out.println(age);
    }
    public void  printInfo(String name,int age ){
        System.out.println(name + " " + age);
    }
}
public class Polymorphism {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.name="aman";
        s1.age=22;

        s1.printInfo(s1.name,s1.age);
    }
}
