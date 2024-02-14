import java.util.*;

public class task2 {
    public static void main(String[] args) {
        
        Scanner sc1 = new Scanner(System.in);
        int English = sc1.nextInt();
        System.out.println("Enter the marks of English:"+English);

        Scanner sc2 = new Scanner(System.in);
        int Maths = sc2.nextInt();
        System.out.println("Enter the marks of Maths:"+Maths);

        Scanner sc3 = new Scanner(System.in);
        int SST = sc3.nextInt();
        System.out.println("Enter the marks of SST:"+SST);

        Scanner sc4 = new Scanner(System.in);
        int Hindi = sc4.nextInt();
        System.out.println("Enter the marks of Hindi:"+Hindi);

        Scanner sc5 = new Scanner(System.in);
        int IT = sc5.nextInt();
        System.out.println("Enter the marks of IT:"+IT);

        int Total = English + Maths + SST + Hindi + IT;
        System.out.println("Toatl marks: "+Total);

        int Average_Percentage = Total / 5;
        System.out.println("Average Percentage: "+Average_Percentage);

        if(Average_Percentage>=85){
            System.out.println("You have achieved A+ Grade");
        }
        else if(Average_Percentage>60 && Average_Percentage<85){
            System.out.println("You have achieved B+ Grade");
        }
        else{
            System.out.println("You have achieved C+ Grade");
        }


        sc1.close();
        sc2.close();
        sc3.close();
        sc4.close();
        sc5.close();
    }
    
}
