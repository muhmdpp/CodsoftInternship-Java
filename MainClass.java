package StudentGradeCalculator;
import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public static <in> void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Student Name:");
        String name = scan.nextLine();
        System.out.print("Enter no. of Subjects:");

        int subNum = 0;
        try {
            subNum = scan.nextInt();
        } catch (java.util.InputMismatchException im) {
            System.out.println("Enter a number!,type here...");
            subNum = scan.nextInt();
            scan.next();
        }
        scan.nextLine();

//        System.out.print("Enter subject names:");
        String[] subjects = new String[subNum];
        for (int i = 0; i < subNum; i++) {
            System.out.print("subject" + (i + 1) + ":");
            subjects[i] = scan.nextLine();
        }

//        scan.nextLine();

        //Subject Entered , Verification
//        for(int i=0;i<subNum;i++){
//            System.out.println(subjects[i]);
//        }

        int[] subScore = new int[subNum];
        System.out.println("Subject Entered,Enter marks for Each:");
        for (int i = 0; i < subNum; i++) {
            System.out.print(subjects[i] + ":");
            subScore[i] = scan.nextInt();
        }
        String status = "pass";
        for (int i = 0; i < subNum; i++) {
            if (subScore[i] < 50) {
                status = "fail";
            }
        }
        System.out.println("Analysing your Data");
        System.out.println("\n");
        int sum = 0;
        for (int i = 0; i < subNum; i++) {
            sum = sum + subScore[i];
        }
        int avg = sum / subNum;
        int percentage = (sum * 100) / (subNum * 100);
        String grade = null;

//        String status="Fail";

        if (percentage >= 90) {
            grade = "O";
        } else if (percentage >= 80) {
            grade = "A+";
        } else if (percentage >= 70) {
            grade = "A";
        } else if (percentage >= 60) {
            grade = "B+";
        } else if (percentage >= 50) {
            grade = "B";
        } else {
            grade = "U";
//            System.out.println("Sorry! Better luck next Time..");
        }
//        System.out.println(percentage+"%");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Student Name:" + name + "\t\tNumber of Subjects:" + subNum);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        for (int i = 0; i < subNum; i++) {
            System.out.println((i + 1) + "." + subjects[i] + ":" + subScore[i]);

        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Grade: " + grade + " Status:" + status);


    }
}
