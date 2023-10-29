package Practice.September14;

public class Cats {
    // write static and instance variables
    String name;
    int age;
    static int counter = 0;

    public void Cat(String name, int age) {
        // implement the constructor
        this.name = name;
        this.age = age;
        counter++;
        // do not forget to check the number of cats
        if (counter > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        // implement the static method
        return counter;
    }
}