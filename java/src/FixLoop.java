public class FixLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String output = (i % 2 == 0) ? "even" : "odd";
            System.out.println("Number " + i + " is " + output);

            // Decrement i inside the loop
            i--;
        }
    }
}
s