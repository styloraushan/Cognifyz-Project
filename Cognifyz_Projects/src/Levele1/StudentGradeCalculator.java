package Levele1;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();

      
        double[] grades = new double[numGrades];

       
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

    
        double sum = 0;
        for (int i = 0; i < numGrades; i++) {
            sum += grades[i];
        }
        double average = sum / numGrades;

       
        System.out.printf("The average grade is: %.2f%n", average);

        scanner.close();
    }
}

