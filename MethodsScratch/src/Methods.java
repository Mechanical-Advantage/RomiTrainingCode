public class Methods {
    public static void main(String[] args){
        sayHelloWorld();
        sayHelloTo("Charlie!");
        int x = returnFive();

        System.out.println(x);

        int result = square(returnFive());
        System.out.println(divide(returnFive(),3));
    }
    //this method both returns a value, and takes in data 
    static int square(int x){
        return x * x;
    }

    static float divide(float x, float y){
        return x/y;
    }
    
    // this method returns an int type with the value 5
    static int returnFive() {
        return 5;
    }

    //this method will say hello to whatever name is passed when called
    static void sayHelloTo(String name) {
        System.out.println("Hello," + name);
    }

    //this method simply says "Hello, world!"
    static void sayHelloWorld(){
        System.out.println("Hello, world!");
    }
}

