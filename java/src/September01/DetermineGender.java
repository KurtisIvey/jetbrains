package September01;

import java.util.Objects;

public class DetermineGender {
    public static String chromosomeCheck(String sperm) {
        if(Objects.equals(sperm, "XY")) {
            return "Congratulations! You're going to have a son.";
        } else {
            return "Congratulations! You're going to have a daughter.";
        }
    }
}
