public class Sparrow extends Bird implements Flyable, Walkable{
    @Override
    public void fly(){
        System.out.println("Sparrow is flying.. ");
    }

    public void walk(){
        System.out.println("Sparrow is walking.. ");
    }
}
