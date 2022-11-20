import Geometry.Direction;
import java.util.Random;

public abstract class Ant {

    protected String sign;
    private static final String SYMBOL_OF_COLONY = "*";
    protected int x;
    protected int y;
    protected Direction direction;
    protected boolean antMovedFlag;

    public Ant() {
        this.antMovedFlag = false;
    }

    public int[] getLocation() {
        return new int[]{this.x, this.y};
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static String getSymbolOfColony() {
        return SYMBOL_OF_COLONY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getSign() {
        return sign;
    }
    
    public void setLocation(int[] location) {
        this.x = location[0];
        this.y = location[1];
    }

    public void setAntMovedFlag(boolean antMovedFlag) {
        this.antMovedFlag = antMovedFlag;
    }

    public boolean isAntMovedFlag() {
        return antMovedFlag;
    }
    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    
    public abstract void act();
}

