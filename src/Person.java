public class Person {
    private int destinationFloor;
    private int currentFloor;
    private boolean isGoingUp;

    public Person(int currentFloor, int destinationFloor) {
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
        this.isGoingUp = destinationFloor > currentFloor;
    }

    public boolean isGoingUp() { return isGoingUp; }
    public int getDestinationFloor() { return  destinationFloor; }

    @Override
    public String toString() {
        return String.format("(%d)",destinationFloor);
    }
}
