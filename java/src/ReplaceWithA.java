import java.util.Scanner;

public class ReplaceWithA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                output += 'b';
            } else {
                output += input.charAt(i);
            }
        }
        System.out.println(output);
    }
}

/*
better solution

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str.replace("a", "b"));
    }
 */
