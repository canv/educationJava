//package pack4ch;
//
//public class Vehicle {
//    byte passengers;
//    byte fuelcap;
//    byte mpg;
//
//    // на какое расстоение может проехать Vehicle
//    int range() {
//        return fuelcap * mpg;
//    }
//
//    // Он  получает  в  качестве  параметра
//    // расстояние в милях (int miles),  которое должно проехать
//    // транспортное средство,
//    // а возвращает (return (double) miles / mpg) необходимое
//    // для этого количество галлонов  топлива
//    double fuelneeded(int miles) {
//        return (double) miles / mpg;
//    }
//}

package pack4ch;

public class Vehicle {
    int passengers;
    int fuelcap;
    int mpg;

    Vehicle(int p, int f, int m){
        passengers = p;
        fuelcap = f;
        mpg = m;
    }

//    int range() {
//        return fuelcap * mpg;
//    }

    double fuelneeded(int miles) {
        return (double) miles / mpg;
    }
}