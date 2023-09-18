package SEPTEMBER18;

public class RobotControlMoveRobot {
    public static void moveRobot(Robot robot, int toX, int toY) {
        // Calculate the horizontal and vertical distances from the current position to the target position
        int distanceX = toX - robot.getX();
        int distanceY = toY - robot.getY();

        // Adjust the horizontal direction first
        if (distanceX > 0) {
            // If the horizontal distance is positive, turn right until facing right
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
        } else if (distanceX < 0) {
            // If the horizontal distance is negative, turn left until facing left
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnLeft();
            }
        }

        // Move horizontally until reaching the target X coordinate
        while (robot.getX() != toX) {
            robot.stepForward();
        }

        // Adjust the vertical direction
        if (distanceY > 0) {
            // If the vertical distance is positive, turn right twice to face up
            while (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
        } else if (distanceY < 0) {
            // If the vertical distance is negative, turn left twice to face down
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnLeft();
            }
        }

        // Move vertically until reaching the target Y coordinate
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }

}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}