public class App1 {

    public static void main(String[] args) throws Exception {
        intf hourOfDay = 6;

        if (hourOfDay < 10) {
            System.out.println("Good Morning!!!");
        } else if (hourOfDay < 15) {
            System.out.println("Good Day!!!");
        } else if (hourOfDay < 18) {
            System.out.println("Good Afternoon!!!!!");
        } else {
            System.out.println("Good Evening!!!!");
        }
    }
}
