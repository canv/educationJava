package course.lesson9;

import java.util.Set;

final class CityCalculation{

    static int totalSectorArea(Set<? extends CitySet> points){
        int totalResult = 0;
        for (CitySet cityPoint : points)
            totalResult += (cityPoint.getLength()*cityPoint.getWidth());
        return totalResult;
    }
    static int streetsLength(Set<Street> streets) {
        int totalResult = 0;
        for (Street street : streets)
            totalResult += street.getLength();
        return totalResult;
    }
    static int totalSectorDamageArea(Set<? extends CitySet> points){
        int totalResult = 0;

        for (CitySet cityPoint : points) {
            Set<Damage> damages = cityPoint.getDamage();
            for (Damage damage : damages) {
                totalResult += damage.getLength() * damage.getWidth();
            }
        }
        return totalResult;
    }
    static int totalUsableArea(City city) {
        return (totalSectorArea(city.getParks()) - totalSectorDamageArea(city.getParks())) +
                (totalSectorArea(city.getStreets()) - totalSectorDamageArea(city.getStreets())) +
                (totalSectorArea(city.getLivingDistricts()) - totalSectorDamageArea(city.getLivingDistricts()));
    }
}