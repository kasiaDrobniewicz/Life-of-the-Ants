import Geometry.Direction;

public class Soldier extends Ant {

    private String sign = "S";
    Direction direction;

    public Soldier(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public int[] getLocation() {
        return super.getLocation();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public void act() {
        Direction direction = getDirection();
        switch (direction) {
            case NORTH:
                setX(getX() - 1);
                setDirection(Direction.WEST);
                break;
            case EAST:
                setY(getY() + 1);
                setDirection(Direction.NORTH);
                break;
            case SOUTH:
                setX(getX() + 1);
                setDirection(Direction.EAST);
                break;
            case WEST:
                setY(getY() - 1);
                setDirection(Direction.SOUTH);
                break;
        }
    }
}
