import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        //declare a built-in Java Scanner object
        Scanner scanner = new Scanner(System.in);

        //welcome user to calculator
        welcome();

        //user input for first addend
        System.out.println("Input your first addend:");
        //define the first addend/variable inputed
        int inputx = scanner.nextInt();

        //user input for first addend
        System.out.println("Input your second addend:");
        int inputy = scanner.nextInt();
        //define the first addend/variable outputed
        System.out.println("The sum of " + inputx + " and " + inputy + " is " + add((inputx),(inputy)));


        //closes the scanner to prevent memory leaks
        scanner.close();
    }

    //define what the program says for welcome method
    static void welcome(){
        System.out.println("Welcome to calculator.");
    }

    //define method that adds together two inputs from the user
    static float add(float x, float y){
        return x+y;
    }
}