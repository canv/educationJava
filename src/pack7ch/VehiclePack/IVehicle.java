package pack7ch.VehiclePack;

public interface IVehicle {

    default void showInfo(){
        System.out.println("You must complete the method!");
    }
}
