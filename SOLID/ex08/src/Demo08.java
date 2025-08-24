public class Demo08 {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        PetrolVehicle petrolVehicle = new PetrolVehicle();
        ElectricVehicle electricVehicle = new ElectricVehicle();

        bicycle.pedal(100);

//        bicycle.startEngine(); // compile-time error
//        petrolVehicle.recharge(100); // compile-time error

        petrolVehicle.startEngine();

        electricVehicle.startEngine();
        electricVehicle.recharge(100);
    }
}
