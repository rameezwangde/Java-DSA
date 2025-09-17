package oops;

class myEmployee{
   private  int id;
   private  String name;


   public myEmployee(String myName,int myId){
    id=myId;
    name=myName;
   }
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
      myEmployee  rameez=new myEmployee("coder",16);
    //   rameez.id=45;
    //   rameez.name="Wangde"; throws an error due to private access modifier
    // rameez.setName("rameezanmol");
    System.out.println(rameez.getName());
    System.out.println(rameez.getId());
    }
}
