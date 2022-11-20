package Geometry;

import java.util.Random;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public static Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }

    public static int[] moveTowardsRandomDirection (int steps) {
        int[] deltaToPosition = new int[2];
        switch (getRandomDirection()) {
            case NORTH:
                deltaToPosition[0] = -steps;
                deltaToPosition[1] = 0;
                break;
            case EAST:
                deltaToPosition[0] = 0;
                deltaToPosition[1] = steps;
                break;
            case SOUTH:
                deltaToPosition[0] = steps;
                deltaToPosition[1] = 0;
                break;
            case WEST:
                deltaToPosition[0] = 0;
                deltaToPosition[1] = -steps;
                break;
        }
        return deltaToPosition;
    }
}