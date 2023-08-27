import java.util.Scanner;

public class Parts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ready = 0;
        int toBeFixed = 0;
        int rejects = 0;
        for (int i = 0; i < n; i++) {
            int part = scanner.nextInt();
            if (part == 0) {
                ready++;
            } else if (part == 1) {
                toBeFixed++;
            } else if (part == -1) {
                rejects++;
            }
        }
        System.out.println(ready + " " + toBeFixed + " " + rejects);
    }
}
