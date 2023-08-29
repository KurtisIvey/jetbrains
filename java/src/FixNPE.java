public class FixNPE {
    public static void printLength(String name) {
        if (name == null) {
            System.out.println("name is null");
        } else {
            System.out.println(name.length());
        }
    }
}
