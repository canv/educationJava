package course.lesson9;

import java.util.ArrayList;
import java.util.Collections;

import static packAlternative.AOutput.consoleOut;
import static course.lesson9.CityCalculation.*;

public class Lesson9 {
    public static void main(String[] args) {
// 1) Сделать HashSet Городов (с сэтами: жилых районов, дорог, зон отдыха)
//      Создать методы к нему, которые:
//          - подсчитывает общую площадь всех покрытий;
//          - подсчитывает общую площадь всех дамагов;
//          - подсчитывает общую длинну всех дорог.

        City city17 = new City();

        city17.addPark(new Park("May",123,221,
                new Damage(12,22)));
        city17.addPark(new Park("Lenin",23,22,
                new Damage(2,3)));
        city17.addPark(new Park("Work",112,56,
                new Damage(11,6)));

        city17.addStreet(new Street("Cosmonauts",3234,700,
                new Damage(2034,56)));
        city17.addStreet(new Street("Builders",1664,760,
                new Damage(680,43)));
        city17.addStreet( new Street("Farmers",6664,650,
                new Damage(1789,77)));

        city17.addLivingDistrict(new LivingDistrict("PSO-43",234,112,
                        new Damage(44,56)));
        city17.addLivingDistrict(new LivingDistrict("RS-1",664,398,
                        new Damage(34,43)));
        city17.addLivingDistrict( new LivingDistrict("GG-R7",664,600,
                        new Damage(3,77)));


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