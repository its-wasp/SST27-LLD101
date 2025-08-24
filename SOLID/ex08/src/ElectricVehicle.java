public class ElectricVehicle implements EngineStart, Recharge {

    public void startEngine(){
        System.out.println("Electric vehicle engine started..");
    }

    public void recharge(int kwH){
        System.out.println("Electric vehicle recharged with "+kwH+" kWh");
    }
}
