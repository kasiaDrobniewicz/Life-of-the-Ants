import Geometry.Direction;

import java.util.concurrent.ThreadLocalRandom;

public class ColonyOfAnts {

    protected static int width;
    protected Position[][] colonyOfAnts;

    public ColonyOfAnts(int width) {
        setWidth(width);
        this.colonyOfAnts = new Position[width][width];
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void display() {
        for (Position[] x : colonyOfAnts) {
            for (Position position : x) {
                if (position.antToDisplay() != null) {
                    System.out.print(position.antToDisplay() + " ");
                } else {
                    System.out.print(Ant.getSymbolOfColony() + " ");
                }
            }
            System.out.println();
        }
    }

    public int calculateCenterOfColony() {
        return (int) Math.floor((double) width / 2);

    }

    public int[] getRandomLocation() {
        int randomLocation1 = ThreadLocalRandom.current().nextInt(0, width);
        int randomLocation2 = ThreadLocalRandom.current().nextInt(0, width);
        return new int[]{randomLocation1, randomLocation2};
    }

    public boolean checkIsLocationInRange(int[] location) {
        return location[0] >= 0 && location[0] < width && location[1] >= 0 && location[1] < width;
    }

    public void generateAnts(int numberOfWorkers, int numberOfSoldiers, int numberOfDrones) {
        for (int i =0; i < colonyOfAnts.length; i++) {
            for (int j =0; j < colonyOfAnts.length; j++ ) {
                colonyOfAnts[i][j] = new Position();
            }
        }

        Queen queen = new Queen();
        int centerOfColony = calculateCenterOfColony();
        queen.setLocation(new int[]{centerOfColony, centerOfColony});
        int queenMoodCounter =  queen.getQueenMoodCounter();
        queen.setQueenMoodCounter(queenMoodCounter);
        colonyOfAnts[centerOfColony][centerOfColony].addAnt(queen);

        for (int i = 0; i < numberOfWorkers; i++) {
            int[] antLocation = getRandomLocation();
            Worker worker = new Worker();
            worker.setLocation(antLocation);
            colonyOfAnts[antLocation[0]][antLocation[1]].addAnt(worker);
        }

        for (int i = 0; i < numberOfSoldiers; i++) {
            int[] antLocation = getRandomLocation();
            Direction direction = Direction.getRandomDirection();
            Soldier soldier = new Soldier(direction);
            soldier.setLocation(antLocation);
            soldier.setDirection(direction);
            colonyOfAnts[antLocation[0]][antLocation[1]].addAnt(soldier);
        }

        for (int i = 0; i < numberOfDrones; i++) {
            int[] antLocation = getRandomLocation();
            Drone drone = new Drone(calculateCenterOfColony(),queenMoodCounter);
            drone.setLocation(antLocation);
            colonyOfAnts[antLocation[0]][antLocation[1]].addAnt(drone);
        }
    }

    public void update() {
        for (Position[] x : colonyOfAnts) {
            for (Position position : x) {
                for (Ant ant : position.getAntsList()) {
                    if (ant != null && !ant.isAntMovedFlag()) {
                        int[] oldLocation = ant.getLocation();
                        ant.act();
                        ant.setAntMovedFlag(true);
                        if (checkIsLocationInRange(ant.getLocation())) {
                            position.removeAnt(ant);
                            colonyOfAnts[ant.getX()][ant.getY()].addAnt(ant);
                        } else {
                            ant.setLocation(oldLocation); 
                        }
                    }
                }
            }
        }
        resetAntMovedFlag();
    }

    void resetAntMovedFlag () {
        for (Position[] x : colonyOfAnts) {
            for (Position position : x) {
                for (Ant ant : position.getAntsList()) {
                    if (ant != null) {
                        ant.setAntMovedFlag(false);
                    }
                }
            }
        }
    }
}
















