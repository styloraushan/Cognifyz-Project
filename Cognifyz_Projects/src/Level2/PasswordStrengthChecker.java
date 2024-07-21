package Level2;

import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password to check its strength:");
        String password = scanner.nextLine();
        
        String strength = checkPasswordStrength(password);
        System.out.println("Password strength: " + strength);
        
        scanner.close();
    }

    private static String checkPasswordStrength(String password) {
        if (password.length() < 8) {
            return "Weak: Password is too short. It should be at least 8 characters long.";
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        if (hasUppercase && hasLowercase && hasDigit && hasSpecial) {
            return "Strong: Password meets all criteria.";
        } else if ((hasUppercase || hasLowercase) && hasDigit) {
            return "Moderate: Password should include special characters.";
        } else if (hasDigit) {
            return "Weak: Password should include uppercase letters, lowercase letters, and special characters.";
        } else {
            return "Very Weak: Password should be at least 8 characters long and include uppercase letters, lowercase letters, digits, and special characters.";
        }
    }
}
