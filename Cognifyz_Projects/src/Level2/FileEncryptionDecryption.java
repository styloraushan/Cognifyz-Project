package Level2;

import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {

    private static final int SHIFT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose an option (encrypt/decrypt):");
        String option = scanner.nextLine().toLowerCase();

        System.out.println("Enter the input file name or path:");
        String inputFileName = scanner.nextLine();

        System.out.println("Enter the output file name or path:");
        String outputFileName = scanner.nextLine();
        
        try {
            if (option.equals("encrypt")) {
                processFile(inputFileName, outputFileName, true);
                System.out.println("File encrypted successfully.");
            } else if (option.equals("decrypt")) {
                processFile(inputFileName, outputFileName, false);
                System.out.println("File decrypted successfully.");
            } else {
                System.out.println("Invalid option. Please choose 'encrypt' or 'decrypt'.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }

    private static void processFile(String inputFileName, String outputFileName, boolean encrypt) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = encrypt ? encrypt(line) : decrypt(line);
                writer.write(processedLine);
                writer.newLine();
            }
        }
    }

    private static String encrypt(String text) {
        return shiftText(text, SHIFT);
    }

    private static String decrypt(String text) {
        return shiftText(text, -SHIFT);
    }

    private static String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}

