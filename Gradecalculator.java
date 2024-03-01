package grade;
import java.util.Scanner;
public class GradeCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int[] marks = new int[5];
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }double average = (double) totalMarks / 5;
        double percentage = (double) totalMarks / (5 * 100) * 100;
        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } 
        else if (percentage >= 75) {
            grade = 'B';
        }
        else if (percentage >= 65) {
            grade = 'C';
        }
        else if (percentage >= 50) {
            grade = 'D';
        } 
        else {
            grade = 'E';
        }
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Marks: " + average);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
