package SEPTEMBER18;

enum DangerLevel {
    HIGH(3),   // Associate HIGH with the integer 3
    MEDIUM(2), // Associate MEDIUM with the integer 2
    LOW(1);    // Associate LOW with the integer 1

    private final int level; // Integer field to store the danger level

    // Constructor to initialize the danger level
    DangerLevel(int level) {
        this.level = level;
    }

    // Getter method to retrieve the associated integer number
    public int getLevel() {
        return level;
    }
}