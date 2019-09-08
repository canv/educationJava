package course.lesson9;

import static course.lesson9.CityCalculation.*;
import static packAlternative.AOutput.consoleOut;

public class Lesson11 {
    public static void main(String[] args) {
// 1) Сделать получение всех данных для города из текстового файла на диске

        City city17 = new City();

        CityReader cityFile = new CityReader(fileAddress());
        cityFile.loader(city17);

//        city17.addSector(new Park("May", 123, 221));
//        addDamage(city17.getParks(), "May", 5, 2);
//
//        city17.addSector(new Street("Cosmonauts", 3234, 700));
//        addDamage(city17.getStreets(), "Cosmonauts", 2034, 56);
//
//        city17.addSector(new LivingDistrict("GGR7", 664, 600));
//        addDamage(city17.getLivingDistricts(), "GGR7", 3, 77);
//        addDamage(city17.getLivingDistricts(), "GGR7", 34, 43);

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
    private static String fileAddress() {
        return "C:\\Users\\Admin\\IdeaProjects" +
                "\\myfirstproj\\src\\course\\lesson9\\city17.txt";
    }
}