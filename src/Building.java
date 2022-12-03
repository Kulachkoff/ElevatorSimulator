import java.util.ArrayList;
import java.util.Random;

public class Building extends ArrayList<Building.Floor> {
    private int height;
    private int maxPeoplePerFloor;

    public Building(int height, int maxPeoplePerFloor){
        this.height = height;
        generateBuilding(this, height, maxPeoplePerFloor);
    }

    public void generateBuilding(Building building, int buildingHeight, int maxPeoplePerFloor){

        for (int i = 0; i < buildingHeight; i++){
            building.add(new Floor(maxPeoplePerFloor));
        }
    }

    @Override
    public boolean isEmpty() {
        for (Floor floor : this){
            if(!floor.isEmpty()){
                return false;
            }
        } return true;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        for (Floor floor : this){
            result.append(floor).append("\n");
        }

        return result.toString();
    }


    class Floor extends ArrayList<Person> {

        private static int floorCount = 0;
        private int current;

        private Floor(int maxPeople) {
            this.current = 1 + floorCount++;
            fill(this, maxPeople);
        }

        private void fill(Floor floor, int maxPeople){
            Random random = new Random();
            for (int i = 0; i < random.nextInt(maxPeople); i++){
                int randomDestination = random.nextInt(height) + 1;
                while (floor.current == randomDestination){
                    randomDestination = random.nextInt(height) + 1;
                }
                floor.add(new Person(this.current, randomDestination));
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for(Person p : this){
                result.append(p);
            }
            return String.format("#%d: [%s]", this.current, result.toString());
        }

        public int getCurrent() { return current; }

    }


    class Elevator extends ArrayList<Person>{

        private static final int MAX_CAPACITY = 5;
        private int currentFloor;
        private boolean isGoingUp;

        public Elevator(){
            this.currentFloor = 1;
            this.isGoingUp = true;
        }

        public void moveUp(){
            if(this.currentFloor < height){
                this.currentFloor++;
            } else {
                this.isGoingUp = false;
            }
        }

        public void moveDown(){
            if(this.currentFloor > 1){
                this.currentFloor--;
            } else {
                this.isGoingUp = true;
            }
        }

        @Override
        public boolean add(Person person) {
            if (this.size() < MAX_CAPACITY)
            {
                return super.add(person);
            }
            return false;
        }

        public boolean isGoingUp(){ return isGoingUp; }
        public int getCurrent(){ return currentFloor; }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (Person p : this){
                result.append(p);
            }
            return String.format("Elevator: [%s] ", result);
        }
    }
}

