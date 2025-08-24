public class Penguin extends Bird implements Walkable {
    // Penguins can't fly

    // Penguins can walk
    @Override
    public void walk() {
        System.out.println("Penguin is walking..");
    }
}