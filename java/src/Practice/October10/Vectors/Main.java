package Practice.October10.Vectors;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y1 = in.nextDouble();
        double y2 = in.nextDouble();

        double angle = Math.atan2(x2, x1) - Math.atan2(y2, y1);

        System.out.println(Math.abs(Math.toDegrees(angle)));

        // put your code here
    }
}