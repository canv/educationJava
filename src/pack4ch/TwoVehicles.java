/*
package pack4ch;

public class TwoVehicles {
    public static void main(String args[]) {
        Vehicle minivan = new Vehicle();
        Vehicle sportcar = new Vehicle();

        int range1, range2;

        // Присвоить значения полям в объекте minivan
        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        // Присвоить значения полям в объекте sportscar
        sportcar.passengers = 2;
        sportcar.fuelcap = 14;
        sportcar.mpg = 12;

        // Рассчитать даль ность поездки при полном баке
        range1 = minivan.fuelcap * minivan.mpg;
        range2 = sportcar.fuelcap * sportcar.mpg;

        System.out.println("Минивен может перевезти " +
                minivan.passengers + " пассажиров на расстояние "
                + range1 + " миль.");

        System.out.println("Спорткар может перевезти " +
                sportcar.passengers + " пассажиров на расстояние "
                + range2 + " миль.");

    }
}
*/

/*
package pack4ch;

public class TwoVehicles {
    public static void main(String[] args) {
        Vehicle minivan = new Vehicle();
        Vehicle sportcar = new Vehicle();

        // Присвоить значения полям в объекте minivan
        minivan.passengers = 7;
        minivan.fuelcap = 16;
        minivan.mpg = 21;

        // Присвоить значения полям в объекте sportscar
        sportcar.passengers = 2;
        sportcar.fuelcap = 14;
        sportcar.mpg = 12;


        System.out.println("Минивен может перевезти " +
                minivan.passengers + " пассажиров на расстояние " +
                minivan.range() + " миль" +
                "\nСпорткар может перевезти " +
                sportcar.passengers + " пассажиров на расстояние " +
                sportcar.range() + " миль");

    }
}
*/

//package pack4ch;
//
//public class TwoVehicles {
//    public static void main(String[] args) {
//        Vehicle minivan = new Vehicle();
//        Vehicle sportcar = new Vehicle();
//        // double gallons;
//        int dist = 252;
//
//        // Присвоить значения полям в объекте minivan
//        minivan.passengers = 7;
//        minivan.fuelcap = 16;
//        minivan.mpg = 21;
//
//        // Присвоить значения полям в объекте sportscar
//        sportcar.passengers = 2;
//        sportcar.fuelcap = 14;
//        sportcar.mpg = 12;
//
//        /*
//        gallons = minivan.fuelneeded(dist);
//        gallons = sportcar.fuelneeded(dist);
//        */
//
//        System.out.println("Для преодоления " + dist +
//                " миль Минивэну понадобиться " + minivan.fuelneeded(dist) +
//                " галлонов топлива." +
//                "\nДля преодоления " + dist +
//                " миль Спорткару понадобиться " + sportcar.fuelneeded(dist) +
//                " галлонов топлива.");
//
//    }
//}
package pack4ch;

public class TwoVehicles {
    public static void main(String[] args) {
        Vehicle minivan = new Vehicle(7,16,21);
        Vehicle sportcar = new Vehicle(2,14,12);
        int dist = 252;

        System.out.println("Для преодоления " + dist +
                " миль Минивэну понадобиться " + minivan.fuelneeded(dist) +
                " галлонов топлива." +
                "\nДля преодоления " + dist +
                " миль Спорткару понадобиться " + sportcar.fuelneeded(dist) +
                " галлонов топлива.");

    }
}
