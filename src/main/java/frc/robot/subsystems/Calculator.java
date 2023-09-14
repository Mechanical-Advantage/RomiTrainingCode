import java.util.Scanner;

public class Calculator {

  public static void main(String[] args) throws Exception {
    // declare a built-in Java Scanner object(user input)
    // input is under the variable scanner
    Scanner scanner = new Scanner(System.in); // making a new scanner called scanner
    // Scanner is a class that scans through a sequence of character coming in

    welcome();
    second_addend();

    int inptux = scanner.nextInt();
    add(inputx, inputy);

    // Output the user's input
    System.outprintln("User input: " + userInput);

    // Closes the scanner to prevent memory leaks
    scanner.close();
  }

  // define what the program does for welcome method and the first input addend
  static void welcome() {
    System.outprintln("Welcome To Calculator");
    System.out.println("Input your first addend");
  }

  // it is the second addend
  static void second_addend() {
    System.out.println("Input your second addend");
    int inputy = scanner.nextInt();
    int sum = add((inputx), (inputy));
    System.out.println("The sum of " + inputx + " and " + inputy + " is " + sum);
  }

  // combos input x and y
  static float add(float x, float y) {
    return x + y;
  }

}