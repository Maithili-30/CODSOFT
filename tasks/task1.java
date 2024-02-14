import java.util.*;

public class task1{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int lowerbound =1;
        int upperbound = 100;

        int generatedNumber = rd.nextInt(upperbound - lowerbound + 1) + lowerbound;

        System.out.println("Welcome to the Number game.");
        System.out.println("Guess the number between 1 to 100");

        int User;
        boolean Userguess = false;

        do{
            System.out.println("Enter your guess:");
            User = sc.nextInt();

            if(User==generatedNumber){
                System.out.println("Congratulations, you guessed correctly.");
                Userguess = true;
            }
            else if(User>generatedNumber){
                System.out.println("Oops, the number is lesser than your guess");
            }
            else{
                System.out.println("Oops, the number is greater than your guess");
            }
        } while (!Userguess);
            sc.close();
        
    }
}

