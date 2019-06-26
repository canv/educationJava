package pack7ch.VehiclePack;

class VehicleT implements IVehicle{
    private int passengers;
    private int fuelcup;
    private int mpg;
    private String name;
    private int distance;

    VehicleT(String nm,int p, int f, int m) {
        name = nm;
        passengers = p;
        fuelcup = f;
        mpg = m;
    }

    int range() {
        return mpg * fuelcup;
    }

    private double fuelneeded() {
        return (double) distance / mpg;
    }

    public void showInfo() {
        System.out.println( "For overcame " + distance +
                " miles needed " + fuelneeded() +
                " gallons." );

    }

    int getPassengers() {
        return passengers;
    }
    int getFuelcup() {
        return fuelcup;
    }
    int getMpg() {
        return mpg;
    }
    int getDistance() {
        return distance;
    }
    String getName() {
        return name;
    }

    void setPassengers(int p) {
        passengers = p;
    }
    void setFuelcups(int f) {
        fuelcup = f;
    }
    void setMpg(int m) {
        mpg = m;
    }
    void setDistance(int d) {
        distance = d;
    }
    void setName(String nm) {name = nm;}
}

class Truck extends VehicleT{
    private int cargocap;

    Truck (String nm, int p, int f, int m, int c){
        super(nm, p, f, m);
        cargocap = c;
    }

    public void showInfo() {
        System.out.println(getName() + " can transport " +
                cargocap + " pounds.");
        super.showInfo();
        System.out.println();
    }

    int getCargocap() {return cargocap;}
    void setCargocap(int c){cargocap = c;}
}

class OffRoad extends VehicleT{
    private int groudClearance;

    OffRoad(String nm, int p, int f, int m, int gC) {
        super(nm, p, f, m);
        groudClearance = gC;
    }

    public void showInfo() {
        System.out.println(getName() + " have a " +
                groudClearance + " inches.");
        super.showInfo();
        System.out.println();
    }

    int getGroudClearance() {return groudClearance;}
    void setGroudClearance(int gC){groudClearance = gC;}

}

public class TruckDemo {
    public static void main(String[] args) {

        Truck semi = new Truck("Truck",2, 200, 7, 44000);
        Truck pickup = new Truck("Pickup",3,28,15,2000);
        OffRoad niva = new OffRoad("Niva",4,80,10,17);

        semi.setDistance(252);
        pickup.setDistance(252);
        niva.setDistance(252);

        semi.showInfo();
        pickup.showInfo();
        niva.showInfo();

    }
}
