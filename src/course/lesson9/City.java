package course.lesson9;

import java.util.HashSet;

class City{
    private HashSet<Park> parks;
    private HashSet<Street> streets;
    private HashSet<LivingDistrict> livingDistricts;

    City() {
        this.parks = new HashSet<>();
        this.streets = new HashSet<>();
        this.livingDistricts = new HashSet<>();
    }

    HashSet<Park> getParks() {
        return parks;
    }
    HashSet<Street> getStreets() {
        return streets;
    }
    HashSet<LivingDistrict> getLivingDistricts() {
        return livingDistricts;
    }

    void addPark(Park park) {
        parks.add(park);
    }
    void addStreet(Street street) {
        streets.add(street);
    }
    void addLivingDistrict(LivingDistrict livingDistrict) {
        livingDistricts.add(livingDistrict);
    }
}

final class CityCalculation{

    static int totalSectorArea(HashSet<? extends CitySet> points){
        int totalResult = 0;
        for (CitySet cityPoint : points)
            totalResult += (cityPoint.getLength()*cityPoint.getWidth());
        return totalResult;
    }
    static int streetsLength(HashSet<Street> streets) {
        int totalResult = 0;
        for (Street street : streets)
            totalResult += street.getLength();
        return totalResult;
    }
    static int totalSectorDamageArea(HashSet<? extends CitySet> points){
        int totalResult = 0;
        for (CitySet cityPoint : points)
            totalResult += (cityPoint.getDamage().getLength()*cityPoint.getDamage().getWidth());
        return totalResult;
    }
    static int totalUsableArea(City city) {
        return (totalSectorArea(city.getParks())-totalSectorDamageArea(city.getParks()))+
                (totalSectorArea(city.getStreets())-totalSectorDamageArea(city.getStreets()))+
                (totalSectorArea(city.getLivingDistricts())-totalSectorDamageArea(city.getLivingDistricts()));
    }
}