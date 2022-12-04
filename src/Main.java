import java.util.Collections;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        Building building = new Building(7, 10);
        Building.Elevator elevator = building.new Elevator();
        ListIterator<Building.Floor> floorIterator = building.listIterator();
        updateUI(building, elevator);

        while (!building.isEmpty()) {

            if (elevator.isGoingUp()) {

                while (floorIterator.hasNext()) {

                    ListIterator<Person> personIterator = floorIterator.next().listIterator();
                    updateUI(building, elevator);

                    elevator.removeIf(person -> person.getDestinationFloor() == elevator.getCurrent());
                    updateUI(building, elevator);

                    while (personIterator.hasNext() && elevator.hasSpace()) {
                        Person person = personIterator.next();

                        if (person.isGoingUp()) {
                            elevator.add(person);
                            personIterator.remove();
                            updateUI(building, elevator);
                        }
                    }
                    elevator.moveUp();
                }

            } else {

                while (floorIterator.hasPrevious()) {

                    ListIterator<Person> personIterator = floorIterator.previous().listIterator();
                    updateUI(building, elevator);

                    elevator.removeIf(person -> person.getDestinationFloor() == elevator.getCurrent());
                    updateUI(building, elevator);

                    while (personIterator.hasNext() && elevator.hasSpace()) {
                        Person person = personIterator.next();

                        if (!person.isGoingUp()) {
                            elevator.add(person);
                            personIterator.remove();
                            updateUI(building, elevator);
                        }
                    }
                    elevator.moveDown();
                }
            }
        }
    }


    public static void updateUI(Building building, Building.Elevator elevator) {
        Collections.reverse(building);

        for (Building.Floor floor : building) {
            String result = floor.toString();

            if (floor.getCurrent() == elevator.getCurrent()) {
                result += " " + elevator.toString();
            }
            System.out.println(result);
        }
        System.out.print("\n\n\n");
        Collections.reverse(building);
    }
}