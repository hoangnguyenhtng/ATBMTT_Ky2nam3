import java.io.*;
import java.util.Scanner;

public class CaesarCipher {
    public static String encrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    c = (char) ((c - 'A' + key) % 26 + 'A');
                } else {
                    c = (char) ((c - 'a' + key) % 26 + 'a');
                }
                output.append(c);
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static String decrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    c = (char) ((c - 'A' - key + 26) % 26 + 'A');
                } else {
                    c = (char) ((c - 'a' - key + 26) % 26 + 'a');
                }
                output.append(c);
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Encrypt\n2. Decrypt\n3. Exit\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 1) {
                try {
                    FileReader fileReader = new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\Caesar\\Caesar\\en_caesar_input.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String input = bufferedReader.readLine().trim();
                    int key = Integer.parseInt(bufferedReader.readLine().trim());

                    String encryptedMessage = encrypt(input, key);
                    FileWriter fileWriter = new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\Caesar\\Caesar\\output.txt");
                    fileWriter.write(encryptedMessage);
                    fileWriter.flush();
                    fileWriter.close();
                    System.out.println("Encrypted message written to output.txt");
                } catch (IOException e) {
                    System.out.println("Error reading/writing file: " + e.getMessage());
                }
            } else if (choice == 2) {
                try {
                    FileReader fileReader = new FileReader("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\Caesar\\Caesar\\de_caesar_input.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String input = bufferedReader.readLine().trim();
                    int key = Integer.parseInt(bufferedReader.readLine().trim());

                    String decryptedMessage = decrypt(input, key);
                    FileWriter fileWriter = new FileWriter("D:\\AnToanVaBaoMatThongTin-Ky2Nam3\\AnToanBaoMatThongTin\\ATBMTT-Java\\Caesar\\Caesar\\output.txt");
                    fileWriter.write(decryptedMessage);
                    fileWriter.flush();
                    fileWriter.close();
                    System.out.println("Decrypted message written to output.txt");
                } catch (IOException e) {
                    System.out.println("Error reading/writing file: " + e.getMessage());
                }
            } else if (choice != 3) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
}