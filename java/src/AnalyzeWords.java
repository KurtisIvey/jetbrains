import java.util.Scanner;

public class AnalyzeWords {
    public static void main(String[] args) {
        // take input
        System.out.print("Input string: ");
        // read input
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for(int i = 0; i <input.length();i++) {
            System.out.print(input.charAt(i) + " ");
        }
    }
}
