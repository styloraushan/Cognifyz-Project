package Levele1;

import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

     
        if (isPalindrome(input)) {
            System.out.println("The entered word or phrase is a palindrome.");
        } else {
            System.out.println("The entered word or phrase is not a palindrome.");
        }

        scanner.close();
    }

    
    public static boolean isPalindrome(String str) {
       
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleanedStr.length() - 1;

     
        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
