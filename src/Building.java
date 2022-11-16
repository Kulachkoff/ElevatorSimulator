import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Building extends ArrayList<ArrayList<Person>> {

    private int floorAmount;
    private int maxPeoplePerFloor;

    public Building(int floorAmount, int maxPeoplePerFloor) {
        this.floorAmount = floorAmount;
        this.maxPeoplePerFloor = maxPeoplePerFloor;
    }

    @Override
    public String toString() {
        StringBuilder building = new StringBuilder();
        
    }

    public static Building generateBuilding(int floorAmount, int maxPeoplePerFloor) {
        Building building = new Building(floorAmount, maxPeoplePerFloor);
        Random random = new Random();

        for (int i = 0; i < floorAmount; i++) {
            building.add(new ArrayList<Person>());
            for (int j = 0; j < maxPeoplePerFloor; j++) {
                Person person = new Person(i + 1, random.nextInt(floorAmount) + 1);
                while (person.getDestinationFloor() == person.getCurrentFloor()) {
                    person.setDestinationFloor(random.nextInt(floorAmount) + 1);
                }
                building.get(i).add(person);
            }
        }
        return building;
    }
}

