import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Declare a built-in Java Scanner object
        Scanner scanner = new Scanner(System.in);

        //Get an integer from the user
        System.out.println("Enter an integer:");
        int userInput = scanner.nextInt();

        //Output the user's input
        System.out.println("User input: " + userInput);

        //Closes the scanner to prevent memory leaks
        scanner.close();
    }
}