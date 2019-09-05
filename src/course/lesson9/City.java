package course.lesson9;

import java.util.HashSet;
import java.util.Set;

class City{
    private Set<Park> parks;
    private Set<Street> streets;
    private Set<LivingDistrict> livingDistricts;

    City() {
        this.parks = new HashSet<>();
        this.streets = new HashSet<>();
        this.livingDistricts = new HashSet<>();
    }

    Set<Park> getParks() {
        return parks;
    }
    Set<Street> getStreets() {
        return streets;
    }
    Set<LivingDistrict> getLivingDistricts() {
        return livingDistricts;
    }

    void addSector(Park park){
        parks.add(park);
    }
    void addSector(Street street){
        streets.add(street);
    }
    void addSector(LivingDistrict livingDistrict){
        livingDistricts.add(livingDistrict);
    }
    static void addDamage(Set<? extends CitySet> points, String name, int length, int width){
        for (CitySet point : points) {
            if (name.equals(point.getName())) point.addDamage(length,width);
        }
    }
}