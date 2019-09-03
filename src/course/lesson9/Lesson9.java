package course.lesson9;

import java.util.*;

import static packAlternative.AOutput.consoleOut;

public class Lesson9 {
    public static void main(String[] args) {
// 1) Сделать HashSet Городов (с сэтами: жилых районов, дорог, зон отдыха)
//      Создать методы к нему, которые:
//          - подсчитывает общую площадь всех покрытий;
//          - подсчитывает общую площадь всех дамагов;
//          - подсчитывает общую длинну всех дорог.

        City cityFirst = new City.CityBuilder()
                .withRecreationSetArea(12345)
                .withResidentialSetArea(5255)
                .withRoadsSetLength(55321).build();
        City citySecond = new City.CityBuilder()
                .withRecreationSetArea(55101)
                .withResidentialSetArea(1200)
                .withRoadsSetLength(101001).build();
        City cityThird = new City.CityBuilder()
                .withRecreationSetArea(23311)
                .withResidentialSetArea(123452)
                .withRoadsSetLength(627331).build();

        HashSet<City> cities = new HashSet<>();
        cities.add(cityFirst);
        cities.add(citySecond);
        cities.add(cityThird);

        consoleOut.println("Total Cover area: " +
                totalCover(cities));
        consoleOut.println("Total Recreation area: " +
                totalCalculate(cities, "Recreation"));
        consoleOut.println("Total Roads length: " +
                totalCalculate(cities, "Roads"));

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

    private static int totalCalculate(HashSet<City> cities, String who) {
        int totalResult = 0;
        switch (who) {
            case "Recreation":
                for (City city : cities)
                    totalResult += city.getRecreationSetArea();
                return totalResult;
            case "Residential":
                for (City city : cities)
                    totalResult += city.getResidentialSetArea();
                return totalResult;
            case "Roads":
                for (City city : cities)
                    totalResult += city.getRoadsSetLength();
                return totalResult;
        }
        return -1;
    }
    private static int totalCover(HashSet<City> cities) {
        return totalCalculate(cities, "Recreation") +
                totalCalculate(cities, "Residential");
    }

    private static ArrayList<Person> sortByRank(ArrayList<Person> persons){

        Person[] personsArr = new Person[persons.size()];
        for (int i = 0; i < personsArr.length; i++) {
            personsArr[i] = persons.get(i);
        }

        int actualIndex, sortIndex;
        Person tempVal;
        int collectionSize = persons.size();
        for(actualIndex = 1; actualIndex < collectionSize; actualIndex++){
            for (sortIndex = collectionSize-1; sortIndex >= actualIndex; sortIndex--){
                if(personsArr[sortIndex-1].getMilitary().getRank()
                        > personsArr[sortIndex].getMilitary().getRank()){
                    tempVal = personsArr[sortIndex-1];
                    personsArr[sortIndex-1]=personsArr[sortIndex];
                    personsArr[sortIndex] = tempVal;
                }
            }
        }

        ArrayList<Person> sortedPersons = new ArrayList<>();
        Collections.addAll(sortedPersons, personsArr);

        return sortedPersons;
    }
}