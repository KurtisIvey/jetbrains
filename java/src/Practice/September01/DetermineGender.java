package Practice.September01;

public class DetermineGender {
    public static String chromosomeCheck(String sperm) {
        if(sperm == "XY") {
            return "Congratulations! You're going to have a son.";
        } else {
            return "Congratulations! You're going to have a daughter.";
        }
    }
}
