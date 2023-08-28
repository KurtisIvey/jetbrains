import java.util.Scanner;

public class IntegerBarrier {
    /*
    Write a program that inputs a sequence of integer numbers in a loop and calculates
    their sum under the following conditions:
        1) if a new number is 0, the program must stop the loop and output the accumulated sum;
        2) if the sum is equal to or exceeds the limit of 1000, the program must also stop reading the
           numbers and output the value equal to the sum minus 1000.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while(scanner.hasNextInt()) {
            // must call inside loop only once to prevent multiple iterating
            int num = scanner.nextInt();
            if(num == 0) {
                break;
            }
            sum += num;
            if (sum >= 1000) {
                sum -= 1000;
                break;
            }
        }
        System.out.println(sum);
    }
}
