package SEPTEMBER18;

public class DayOfWeek {
    enum DayOfWeeks {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        for (DayOfWeeks day : DayOfWeeks.values()) {
            System.out.println(day);
        }
    }
}
