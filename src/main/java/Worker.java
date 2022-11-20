import Geometry.Direction;

public class Worker extends Ant {

    private String sign = "W";

    @Override
    public void act() {
        int[] deltaToPosition = Direction.moveTowardsRandomDirection(1);
        setX(x + deltaToPosition[0]);
        setY(y + deltaToPosition[1]);
    }

    public String getSign() {
        return sign;
    }

    @Override
    public int[] getLocation() {
        return super.getLocation();
    }
}


