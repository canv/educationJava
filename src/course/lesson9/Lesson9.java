package course.lesson9;

import java.util.ArrayList;
import java.util.Collections;

import static course.lesson9.City.addDamage;
import static course.lesson9.CityCalculation.*;
import static packAlternative.AOutput.consoleOut;

public class Lesson9 {
    public static void main(String[] args) {
// 1) Сделать HashSet Городов (с сэтами: жилых районов, дорог, зон отдыха)
//      Создать методы к нему, которые:
//          - подсчитывает общую площадь всех покрытий;
//          - подсчитывает общую площадь всех дамагов;
//          - подсчитывает общую длинну всех дорог.

        City city17 = new City();

        city17.addSector(new Park("May",123,221));
        addDamage(city17.getParks(),"May",5,5);
        addDamage(city17.getParks(),"May",2,14);

        city17.addSector(new Park("Lenin",23,22));
        addDamage(city17.getParks(),"Lenin",2,3);

        city17.addSector(new Park("Work",112,56));
        addDamage(city17.getParks(),"Work",11,6);


        city17.addSector(new Street("Cosmonauts",3234,700));
        addDamage(city17.getStreets(),"Cosmonauts",2034,56);

        city17.addSector(new Street("Builders",1664,760));
        addDamage(city17.getStreets(),"Builders",231,12);
        addDamage(city17.getStreets(),"Builders",459,29);

        city17.addSector(new Street("Farmers",6664,650));
        addDamage(city17.getStreets(),"Farmers",1789,77);


        city17.addSector(new LivingDistrict("PSO-43",234,112));
        addDamage(city17.getLivingDistricts(),"PSO-43",44,56);

        city17.addSector(new LivingDistrict("RS-1",664,398));
        addDamage(city17.getLivingDistricts(),"RS-1",34,43);

        city17.addSector(new LivingDistrict("GG-R7",664,600));
        addDamage(city17.getLivingDistricts(),"GG-R7",3,77);


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


// 2) Сделать Коллекцию Person со значением rank
//      Создать метод sort() (Как у Collections) Который
//      выстраивает rank'и в соответствии с иерархией.

        Person personOne = new Person.PersonBuilder()
                .withMilitary(Profession.CORPORAL).build();
        Person personTwo = new Person.PersonBuilder()
                .withMilitary(Profession.MAJOR).build();
        Person personThree = new Person.PersonBuilder()
                .withMilitary(Profession.OFFICER).build();
        Person personFour = new Person.PersonBuilder()
                .withMilitary(Profession.GENERAL).build();
        Person personFive = new Person.PersonBuilder()
                .withMilitary(Profession.PRIVATE).build();

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(personOne);
        persons.add(personTwo);
        persons.add(personThree);
        persons.add(personFour);
        persons.add(personFive);


        persons = sortByRank(persons);
        for (Person person : persons) {
            consoleOut.println(person);
        }
    }

    private static ArrayList<Person> sortByRank(ArrayList<Person> persons) {

        Person[] personsArr = new Person[persons.size()];
        for (int i = 0; i < personsArr.length; i++) {
            personsArr[i] = persons.get(i);
        }

        int actualIndex, sortIndex;
        Person tempVal;
        for (actualIndex = 1; actualIndex < personsArr.length; actualIndex++) {
            for (sortIndex = personsArr.length - 1; sortIndex >= actualIndex; sortIndex--) {
                if (personsArr[sortIndex - 1].getMilitary().getRank()
                        > personsArr[sortIndex].getMilitary().getRank()) {
                    tempVal = personsArr[sortIndex - 1];
                    personsArr[sortIndex - 1] = personsArr[sortIndex];
                    personsArr[sortIndex] = tempVal;
                }
            }
        }

        ArrayList<Person> sortedPersons = new ArrayList<>();
        Collections.addAll(sortedPersons, personsArr);

        return sortedPersons;
    }
}