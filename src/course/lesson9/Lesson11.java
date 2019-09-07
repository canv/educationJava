package course.lesson9;

import static course.lesson9.CityCalculation.*;
import static packAlternative.AOutput.consoleOut;

public class Lesson11 {
    public static void main(String[] args) {
// 1) Сделать получение всех данных для города из текстового файла на диске


        City city17 = new City();

        CityReader qw = new CityReader(myAddress());

        qw.cityLoading(city17);

//        city17.addSector(new Park("May", 123, 221));
//        addDamage(city17.getParks(), "May", 5, 5);
//        addDamage(city17.getParks(), "May", 2, 14);
//
//        city17.addSector(new Park("Lenin", 23, 22));
//        addDamage(city17.getParks(), "Lenin", 2, 3);


        consoleOut.println("fine");

//        city17.addSector(new Park("Work", 112, 56));
//        addDamage(city17.getParks(), "Work", 11, 6);
//
//
//        city17.addSector(new Street("Cosmonauts", 3234, 700));
//        addDamage(city17.getParks(), "Cosmonauts", 2034, 56);
//
//        city17.addSector(new Street("Builders", 1664, 760));
//        addDamage(city17.getParks(), "Builders", 231, 12);
//        addDamage(city17.getParks(), "Builders", 459, 29);
//
//        city17.addSector(new Street("Farmers", 6664, 650));
//        addDamage(city17.getParks(), "Farmers", 1789, 77);
//
//
//        city17.addSector(new LivingDistrict("PSO-43", 234, 112));
//        addDamage(city17.getParks(), "PSO-43", 44, 56);
//
//        city17.addSector(new LivingDistrict("RS-1", 664, 398));
//        addDamage(city17.getParks(), "RS-1", 34, 43);
//
//        city17.addSector(new LivingDistrict("GG-R7", 664, 600));
//        addDamage(city17.getParks(), "GG-R7", 3, 77);


        consoleOut.println("Total area of all city parks - " +
                totalSectorArea(city17.getParks()) +
                "\nTotal area of all city streets - " +
                totalSectorArea(city17.getStreets()) + "" +
                "\nTotal area of all living districts - " +
                totalSectorArea(city17.getLivingDistricts()) +
                "\nTotal length of all streets - " +
                streetsLength(city17.getStreets()) +
                "\nTotal area of damaged roads - " +
                totalSectorDamageArea(city17.getParks()) +
                "\nTotal usable area of all coverage of the city - " +
                totalUsableArea(city17) + "\n");

    }
    private static String myAddress() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\myfirstproj\\src\\course\\lesson9\\city17.txt";
    }
}