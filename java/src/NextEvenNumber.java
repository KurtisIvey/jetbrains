import java.util.Scanner;

public class NextEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int nextEvenNumber = (number + 1) % 2 == 0 ? number + 1 : number + 2;

        System.out.println(nextEvenNumber);
    }
}
