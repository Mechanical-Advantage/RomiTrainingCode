import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        // declare a built-in Java Scanner object(user input)
        // input is under the variable scanner
        Scanner scanner = new Scanner(System.in); // making a new scanner called scanner
        // Scanner is a class that scans through a sequence of character coming in

        // Get an interger from the user
        System.out.println("Enter an integer:");
        int userInput = scanner.nextInt();

        // Output the user's input
        System.out.println("User input: " + userInput);

        // Closes the scanner to prevent memory leaks
        scanner.close();
    }
}