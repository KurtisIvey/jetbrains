/*
p: integer, array of integers
r: return the output of the array of ints shifted one to the right with spaces between
ep:
    identify integer length and set to int var
    set int[] arr to be array; pass n as the parameter in [n] to set the size of the array
    use for loop, to iterate through and add ints into index of arr

    pt 2 : rotate
        create temp var for last element
        for loop to iterate through assigning arr[i] = arr[i-1]. iterate backwards i--. i = length -1
        afterwards a[0] is temp

    pt 3: output
        for loop to print each num in arr + " "

 */

import java.util.Scanner;

public class CyclicallyShiftingElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // pt 1
        int length = scanner.nextInt();
        int[] array = new int[length];

        for(int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        // pt 2
        int temp = array[length - 1];
        for(int i = length - 1; i > 0; i--) {
            array[i] = array[i-1];
        }
        array[0] = temp;
        // pt 3
        for(int num: array) {
            System.out.print(num + " ");
        }
    }
}

/*
better
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];

        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        numbers[0] = scanner.nextInt();

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
 */
