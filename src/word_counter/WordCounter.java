package word_counter;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== WORD COUNTER =====");
            System.out.println("1. Do you want to count words from a text file?");
            System.out.println("2. DO you want to count words from input?");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter 1 or 2.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter file path: ");
                    sc.nextLine();
                    String path = sc.nextLine();
                    try {
                        File file = new File(path);
                        Scanner fileReader = new Scanner(file);
                        int cnt = 0;
                        while (fileReader.hasNext()) {
                            fileReader.next();
                            cnt++;
                        }
                        fileReader.close();
                        System.out.println("Word Count: " + cnt);
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found!");
                    }
                    break;

                case 2:
                    System.out.print("Input here: ");
                    sc.nextLine();
                    String text = sc.nextLine().trim();
                    int cnt = 0;
                    if (!text.isEmpty()) {
                        cnt = text.split("\\s+").length;
                    }
                    System.out.println("Word Count: " + cnt);
                    break;

                default:
                    System.out.println("Invalid Choice! Choose again.");
            }
        }
    }
}
