package oops;

class myEmployee{
   private  int id;
   private  String name;

   public String getName(){
        return name;
   }

   public void setName(String n){
    name=n;

   }
   public void setId(int i){
     id=i;
   }
   public int getId(){
    return id;
   }
}
public class Access {
    public static void main(String[] args) {
      myEmployee  rameez=new myEmployee();
    //   rameez.id=45;
    //   rameez.name="Wangde"; throws an error due to private access modifier
    rameez.setName("rameezanmol");
    System.out.println(rameez.getName());
    }
}
