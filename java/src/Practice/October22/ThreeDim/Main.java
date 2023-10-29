package Practice.October22.ThreeDim;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.print(Arrays.deepToString(createCube()));

    }

    public static int[][][] createCube() {
        // write your code here
        int[][][] threeDimArray = new int[3][3][3];
        int element = 0;
        // Populate the array with values
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    // Calculate the value for each element based on its position
                    threeDimArray[i][j][k] = element;
                    element++;
                }
            }
            element = 0;
        }
        return threeDimArray;
    }
}
