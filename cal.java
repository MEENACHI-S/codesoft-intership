import java.util.*;

public class Cal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the number of subjects: ");
        int numOfSubjects = scanner.nextInt();

        
        int[] marks = new int[numOfSubjects];
        int totalMarks = 0;

       
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

      
        double averagePercentage = (double) totalMarks / numOfSubjects;

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");

        
        String grade = calculateGrade(averagePercentage);

      
        System.out.println("Grade: " + grade);

        scanner.close();
    }

   
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "Fail";
        }
    }
}
