public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        for (int i=0; i<10; i++) {
            System.out.println(i);
        }
        int i=-10;
        while (i<21){
            System.out.println(i); 
            i++;
        }
        int sum=0;
        for (i=1; i<11; i++){
            sum=sum+i*i;
        }
        System.out.println(sum);
    }
}
