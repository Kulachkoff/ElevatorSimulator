import java.util.ArrayList;
import java.util.Iterator;

public class Elevator extends ArrayList<Person>{
    private int currentFloor = 1;
    private int peopleInside = this.size();
    private final int CAPACITY = 5;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getPeopleInside() {
        return peopleInside;
    }

    public void setPeopleInside(int peopleInside) {
        this.peopleInside = peopleInside;
    }

    public void moveUp() {
        this.currentFloor++;
    }

    public void moveDown() {
        if(this.currentFloor != 1){
            this.currentFloor--;
        }
    }
}
