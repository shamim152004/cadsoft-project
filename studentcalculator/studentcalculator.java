import java.util.Scanner;

public class studentcalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("STUDENT GRADE CALCULATOR");
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            int mark = scanner.nextInt();
            while (mark < 0 || mark > 100) {
                System.out.println("Invalid input. Please enter a value between 0 and 100.");
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                mark = scanner.nextInt();
            }
            marks[i] = mark;
        }
        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        String grade = calculateGrade(averagePercentage);
        System.out.println("\nRESULTS:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
    }
    public static int calculateTotalMarks(int[] marks){
        int totalMarks = 0;
        for (int mark : marks){
            totalMarks += mark;
        }
        return totalMarks;
    }
    public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
       return (double) totalMarks / numSubjects; 
    }
  
    public static String calculateGrade(double averagePercentage){
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

}
