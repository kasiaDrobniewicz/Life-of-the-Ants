import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Position {

    protected List<Ant> antsList;

    public Position() {
        this.antsList = new CopyOnWriteArrayList<>();
    }

    public void addAnt(Ant ant) {
        antsList.add(ant);
    }

    public void removeAnt(Ant ant) {
        antsList.remove(ant);
    }

    public String antToDisplay() {
        if (!antsList.isEmpty()) {
            return antsList.get(0).getSign();
        } else {
            return null;
        }
    }

    public List<Ant> getAntsList() {
        return antsList;
    }

}
