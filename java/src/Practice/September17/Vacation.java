package Practice.September17;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String inputLine = scanner.nextLine();
        String[] tokens = inputLine.split(" ");

        int duration = parseInt(tokens[0]);
        int foodCostPerDay = parseInt(tokens[1]);
        int flightCost = parseInt(tokens[2]);
        int oneNightHotelCost = parseInt(tokens[3]);

        int total = 0;

        total += duration * foodCostPerDay;
        total += flightCost * 2;
        total += oneNightHotelCost * (duration - 1);

        System.out.print(total);
    }
}

/*
better

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vacationDays = scanner.nextInt();
        int totalCostFoodPerDay = scanner.nextInt() * vacationDays;
        int oneFlightCost = scanner.nextInt() * 2;
        int costOfOneNightInHotel = scanner.nextInt() * (vacationDays - 1);

        System.out.println(totalCostFoodPerDay + oneFlightCost + costOfOneNightInHotel);
    }
 */
