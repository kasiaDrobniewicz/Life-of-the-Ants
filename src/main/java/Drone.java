import Geometry.Direction;

public class Drone extends Ant {

    private String sign = "D";
    private int queenPosition;
    private int queenMoodCounter;
    private int counterAfterMating;
    private static final int REST_TIME_AFTER_MATING = 10;

    public Drone(int queenPosition, int queenMoodCounter) {
        this.queenPosition = queenPosition;
        this.counterAfterMating = 0;
        this.queenMoodCounter = queenMoodCounter;
        
    }

    public String getSign() {
        return sign;
    }

    private boolean isNextToQueen() {
        if (queenPosition == x && queenPosition == y) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void act() {
        if(queenMoodCounter !=0) {
            queenMoodCounter--;
        }
        if (counterAfterMating == 0 && !isNextToQueen()) {
            moveTowardsQueen();
        } else if (counterAfterMating != 0){
            counterAfterMating--;
            } else {
                tryMatingQueen();
        }
}


    private void tryMatingQueen() {
        if (isQueenInTheMood()) {
            matingQueen();
            if (counterAfterMating != 0) {
                counterAfterMating--;
            } else if (counterAfterMating == 0){
                getKickedOut();
            }
        } else {
            getKickedOut();
        }

    }

    private void matingQueen() {
        System.out.println("HALLELUJAH");
        counterAfterMating = REST_TIME_AFTER_MATING;
        queenMoodCounter = getRandomNumber(Queen.getMinimumValue(),Queen.getMaximumValue());
    }

    private void getKickedOut() {
        System.out.println(":(");
        direction = Direction.getRandomDirection();
        switch (direction) {
            case NORTH:
                setX(0);
                setY(queenPosition);
                break;
            case EAST:
                setX(ColonyOfAnts.width -1);
                setY(getY());
                break;
            case SOUTH:
                setX(queenPosition);
                setY(ColonyOfAnts.width -1);
                break;
            case WEST:
                setX(queenPosition);
                setY(0);
                break;
        }
    }

    private void moveTowardsQueen () {
        if (getX() < queenPosition) {
            setX(getX() + 1);
        } else if (getX() > queenPosition) {
            setX(getX() - 1);
        } else if (getY() < queenPosition) {
            setY(getY() + 1);
        } else {
            setY(getY() - 1);
        }

    }
    public boolean isQueenInTheMood() {
        if (queenMoodCounter == 0) {
            return true;
        } else {
            return false;
        }
    }
}



