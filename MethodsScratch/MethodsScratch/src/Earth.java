public class Earth {
    public static void main(String args[]) {

        Human tom;

        tom = new Human();
        tom.age = 5;
        tom.eyeColor = "brown";
        tom.heightInches = 72;
        tom.name = "Tom Zsabo";

        tom.speak();

        System.out.println("\n");

        Human joe;

        joe = new Human();
        joe.age = 5;
        joe.eyeColor = "brown";
        joe.heightInches = 72;
        joe.name = "Joe Zsabo";

        joe.speak();
    }
}
