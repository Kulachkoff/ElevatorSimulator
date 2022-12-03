import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Building building = new Building(5, 5);
        System.out.println(building);

        Building.Elevator elevator = building.new Elevator();

        for (Building.Floor floor : building) {
            Iterator<Person> personIterator = floor.iterator();
            while (personIterator.hasNext()) {
                System.out.println(floor + "    " + elevator);
                System.out.println("================================");
                Person p = personIterator.next();
                if (p.isGoingUp()){
                    elevator.add(p);
                    personIterator.remove();
                }
            }
            elevator.moveUp();
        }
        System.out.println(building);
        System.out.println(elevator);
    }
}