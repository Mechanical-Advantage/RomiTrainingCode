
public class App {
    public static void main(String[] args) throws Exception {
    int number = 0;
    int number2 = 0;
    int stage = 0;

        for (double num = 1; num < 11; num++) {
            System.out.print(number + " x " + number2 + " = " + (number * number2) + "  ");
            number2 += 1;
            if (number2 == 10 && stage <= 9) {
                number2 = 0;
                number += 1;
                num = 0;
                stage += 1;
        
            }
            


        }

        }
    }