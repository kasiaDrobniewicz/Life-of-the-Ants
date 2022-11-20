public class Queen extends Ant {

    private String sign = "Q";
    private static final int MINIMUM_VALUE = 50;
    private static final int MAXIMUM_VALUE = 100;
    protected int queenMoodCounter;
    

    public Queen() {
        queenMoodCounter = getRandomNumber(MINIMUM_VALUE,MAXIMUM_VALUE);
    }

    public String getSign() {
        return sign;
    }

    public static int getMinimumValue() {
        return MINIMUM_VALUE;
    }

    public static int getMaximumValue() {
        return MAXIMUM_VALUE;
    }

    public void setQueenMoodCounter(int queenMoodCounter) {
        this.queenMoodCounter = queenMoodCounter;
    }

    public int getQueenMoodCounter() {
        return queenMoodCounter;
    }
    
    @Override
    public void act() {
    }
}
