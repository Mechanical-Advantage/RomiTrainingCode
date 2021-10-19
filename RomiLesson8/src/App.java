public class App {
    public static void main(String[] args) throws Exception {
        // for (int i = 0; i < 10; i ++){
        //     System.out.println(i);
        // }
        // int x = -10;
        // while (x < 21){
        //     System.out.println(x);
        //     x ++;
        // }

    //    int exponent = 100;
    //    int sumOfSquares = 0;
    //    int sum = 0;

    //     for(int counter = 1; counter <= exponent; counter ++ ){
    //         sumOfSquares += counter * counter;
    //         sum += counter;
    //     }
    //     System.out.println(sumOfSquares);
    //     System.out.println(sum*sum);
    //     System.out.println(sum*sum - sumOfSquares);
    

    for (int i = 1;i <= 10; i++){
        System.out.print(i+"\t");
        for (int x = 1; x <= 10; x ++){
            System.out.print(x*i+"\t");      
        }
        System.out.println();
    }

        
    }
}
