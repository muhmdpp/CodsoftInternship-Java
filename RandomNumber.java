package RandomNumber;

import java.util.Random;
import java.util.Scanner;


public class RandomNumber   {
    public static void main(String[] args) {
        Random random= new Random();
//        int a= random.nextInt(1,100);
        System.out.println("-----****Number Guessing Game****----");
        System.out.println("Number Generated");
        System.out.println("Hint: Number is between 1 to 100");
        System.out.println("You have only five chances to guess");
      //  System.out.println("\nInitially you'll have 100 points in your hand\ni)you'll lose 10 points for each wrong guess");
        System.out.println("All the Best!\nStart the Game!");
//        System.out.println("Enter your Guess..!");

        Scanner scan = new Scanner(System.in);

        int a=random.nextInt(0,100);

        int i=5;
        try {
            while (i >= 1) {
                //int score=100;

                int input;
                System.out.println("Enter your Guess:");
               // System.out.println("Current Score:"+score);
                try {
                    input = scan.nextInt();
                } catch (java.util.InputMismatchException im) {
                    System.out.println("Enter Valid Number instead of anything");
                    scan.next();
                    continue;
                }
                if(input<0 || input>100){
                    System.out.println("Enter number inside the range(1-100)");
                    i--;
                }else{
                    if (input > a) {
                        System.out.println("Guess is high..");
                    //    score-=10;
                    } else if (input < a) {
                        System.out.println("Guess is Low..");
                    //    score-=10;
                    } else {
                        System.out.println("Congratulations!! Correct answer");
                        System.exit(0);
                    }
                }
                System.out.println("you have " + (i - 1) + " chances left");
                i--;
            }
        }catch (Exception e){
            System.out.println("Exception Occurred");
        }finally {
            scan.close();
        }
        System.out.println("Sorry try Again, number is : "+a);
        System.exit(0);
    }

}



