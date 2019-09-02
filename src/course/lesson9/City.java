package course.lesson9;

class City {
    private final int recreationSetArea, roadsSetLength, residentialSetArea;

    private City(int residentialSetArea, int recreationSetArea, int roadsSetLength) {
        this.residentialSetArea = residentialSetArea;
        this.recreationSetArea = recreationSetArea;
        this.roadsSetLength = roadsSetLength;
    }

    int getResidentialSetArea() {
        return residentialSetArea;
    }
    int getRecreationSetArea() {
        return recreationSetArea;
    }
    int getRoadsSetLength() {
        return roadsSetLength;
    }

    @Override
    public String toString() {
        return "City{" +
                "residentialSetArea = " + residentialSetArea +
                ",\n\t recreationSetArea = " + recreationSetArea +
                ",\n\t roadsSetLength = " + roadsSetLength +
                '}';
    }

    static class CityBuilder{
        private int recreationSetArea, roadsSetLength,residentialSetArea;

        City build(){
            City city = new City(residentialSetArea,recreationSetArea,roadsSetLength);
            residentialSetArea = 0;
            recreationSetArea = 0;
            roadsSetLength = 0;
            return city;
        }
        CityBuilder withResidentialSetArea(int streetsSet) {
            this.residentialSetArea = streetsSet;
            return this;
        }
        CityBuilder withRecreationSetArea(int recreationAreasSet) {
            this.recreationSetArea = recreationAreasSet;
            return this;
        }
        CityBuilder withRoadsSetLength(int roadsSet) {
            this.roadsSetLength = roadsSet;
            return this;
        }
    }
}
