import java.util.Scanner;

import static net.mindview.util.Print.print;

public class ToyTest {
    static void printInfo(Class cc){
        print("Class Name : "+cc.getName()+
                " is interface? [ "+cc.isInterface()+
        " ]");
        print("Simple name : "+cc.getSimpleName());
        print("Canonical name :"+cc.getCanonicalName());
    }

    public static void main(String[] args) {
     Class c=null;
     String string=null;
     try{
         c=Class.forName("FancyToy");
     }catch (ClassNotFoundException e){
         print("Can't find FancyToy");
         System.exit(1);
     }
     printInfo(c);
        for (Class face:c.getInterfaces()
             ) {
            printInfo(face);
        }
        Class up=c.getSuperclass();
        Object object=null;
        try{
            object=up.newInstance();
        }catch (InstantiationException e){
            print("Can not instance");
            System.exit(1);
        }catch (IllegalAccessException e){
            print("Can not access");
            System.exit(1);
        }
        printInfo(object.getClass());
        print("*********************");
        print("input a class name:");
        string=(new Scanner(System.in)).nextLine();
        String temp[]=string.split(" ");
        if(temp[0].equals("java")&&temp[1].equals("SweetShop")&&temp[2].equals("Candy"))
        {
            try{

                object=Class.forName("FancyToy").newInstance();
            }catch (ClassNotFoundException e){
                print("Can't find FancyToy");
                System.exit(1);
            }catch (InstantiationException e){
                print("Can not instance");
                System.exit(1);
            }catch (IllegalAccessException e){
                print("Can not access");
                System.exit(1);
            }
            printInfo(object.getClass());
        }
    }
}
