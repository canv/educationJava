package course.lesson9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static packAlternative.AOutput.consoleOut;

class CityReader {
    private String cityFileAddress;

    private final String sectorPark = "Park";
    private final String sectorStreet = "Street";
    private final String sectorLD = "LivingDistrict";
    private final String sectorsDamage = "Damage";

    CityReader(String cityFileAddress) {
        this.cityFileAddress = cityFileAddress;
    }

    boolean cityLoading(City cityObj) {
        int readCondition;
        char readConditionChar;

        String foundSector;
        String foundName = "";
        String foundLength = "";
        String foundWidth = "";
        int intLength = 0;
        int intWidth = 0;


        try (BufferedReader cityReader = new BufferedReader
                (new FileReader(cityFileAddress))) {

            do {
                readCondition = cityReader.read();
                if (readCondition == '#') {
                    foundSector = cityReader.readLine();
                    consoleOut.println("\t\t~foundSector: " + foundSector);
                    //  if(foundSector != sectorPark || sectorStreet || sectorsDamage)
                    readCondition = cityReader.read();
                    while (readCondition != ' ') {
                        foundName += (char) readCondition;
                        readCondition = cityReader.read();
                    }
                    consoleOut.println("\t\t~foundName: " + foundName);
                    readCondition = cityReader.read();
                    while (readCondition != ' ') {
                        foundLength += (char) readCondition;
                        readCondition = cityReader.read();
                    }
                    consoleOut.println("\t\t~foundLength: " + foundLength);
                    intLength = Integer.parseInt(foundLength);
                    consoleOut.println("\t\t~intLength: " + intLength);
                    readCondition = cityReader.read();
                    while (readCondition != '.') {
                        foundWidth += (char) readCondition;
                        readCondition = cityReader.read();
                    }
                    consoleOut.println("\t\t~foundWidth: " + foundWidth);
                    intWidth = Integer.parseInt(foundWidth);
                    consoleOut.println("\t\t~intWidth: " + intWidth);
                    switch (foundSector) {
                        case "Park":
                            cityObj.addSector(new Park(foundName, intLength, intWidth));
                            consoleOut.println("\t\t~area: " + (intWidth * intLength));
                            foundName = "";
                            foundLength = "";
                            foundWidth = "";
                            intLength = 0;
                            intWidth = 0;
                            break;

                        case "Street":
                            cityObj.addSector(new Street(foundName, intLength, intWidth));
                            foundName = "";
                            foundLength = "";
                            foundWidth = "";
                            intLength = 0;
                            intWidth = 0;
                            break;

                        case "LivingDistrict":
                            cityObj.addSector(new LivingDistrict(foundName, intLength, intWidth));
                            foundName = "";
                            foundLength = "";
                            foundWidth = "";
                            intLength = 0;
                            intWidth = 0;
                            break;

                    }

                    foundSector = cityReader.readLine();

                    if (foundSector.equals(sectorsDamage)) {
                        while (readCondition != ' ') {
                            foundLength += (char) readCondition;
                            readCondition = cityReader.read();
                        }
                        consoleOut.println("\t\t~Damage foundLength: " + foundLength);
                        intLength = Integer.parseInt(foundLength);
                        consoleOut.println("\t\t~Damage intLength: " + intLength);
                        readCondition = cityReader.read();
                        while (readCondition != '.') {
                            foundWidth += (char) readCondition;
                            readCondition = cityReader.read();
                        }
                        consoleOut.println("\t\t~Damage foundWidth: " + foundWidth);
                        intWidth = Integer.parseInt(foundWidth);
                        consoleOut.println("\t\t~Damage intWidth: " + intWidth);

                        switch (foundSector) {
                            case "Park":
                                City.addDamage(cityObj.getParks(), foundName, intLength, intWidth);
                                foundName = "";
                                foundLength = "";
                                foundWidth = "";
                                intLength = 0;
                                intWidth = 0;
                                break;

                            case "Street":
                                City.addDamage(cityObj.getStreets(), foundName, intLength, intWidth);
                                foundName = "";
                                foundLength = "";
                                foundWidth = "";
                                intLength = 0;
                                intWidth = 0;
                                break;

                            case "LivingDistrict":
                                City.addDamage(cityObj.getLivingDistricts(), foundName, intLength, intWidth);
                                foundName = "";
                                foundLength = "";
                                foundWidth = "";
                                intLength = 0;
                                intWidth = 0;
                                break;
                        }



                    }
                }

                //to be continue...


            } while (readCondition != -1);

        } catch (IOException exc) {
            consoleOut.println("File access error!");
            return false;
        }
        return false;
    }


}

