/**
 * Created by Imran on 2017-03-27.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DispatchCenter {
    public static String[] AREA_NAMES = {"Downtown", "Airport", "North", "South", "East", "West"};
    public HashMap<String, ArrayList> getAreas() {
        return areas;
    }
    private int[][]  stats;
    public int[][]   getStats() { return stats; }



    ArrayList<Taxi> listOfNorthUbers = new ArrayList<>();
    ArrayList<Taxi> listofEastUbers = new ArrayList<>();
    ArrayList<Taxi> listofSouthUbers = new ArrayList<>();
    ArrayList<Taxi> listofWestUbers = new ArrayList<>();
    ArrayList<Taxi> listofDowntownUbers = new ArrayList<>();
    ArrayList<Taxi> listOfAirportUbers = new ArrayList<>();

    HashMap<String, ArrayList> areas = new HashMap<>();
    {
        areas.put(AREA_NAMES[0], listofDowntownUbers);
        areas.put(AREA_NAMES[1], listOfAirportUbers);
        areas.put(AREA_NAMES[2], listOfNorthUbers);
        areas.put(AREA_NAMES[3], listofSouthUbers);
        areas.put(AREA_NAMES[4], listofEastUbers);
        areas.put(AREA_NAMES[5], listofWestUbers);
    }

    HashMap<Integer, Taxi> taxies = new HashMap<>();
    {
        for (int a = 0; a < 50; a++) {
            int randomValue = randomLicencePlateGenerator();
            Taxi currentUber = new Taxi(randomValue);
            int zoneNumber = randomZoneDistrictGenerator();
            String district = "";
            switch (zoneNumber) {
                case 1: district = AREA_NAMES[0];
                    break;
                case 2: district = AREA_NAMES[1];
                    break;
                case 3: district = AREA_NAMES[2];
                    break;
                case 4: district = AREA_NAMES[3];
                    break;
                case 5: district = AREA_NAMES[4];
                    break;
                case 6: district = AREA_NAMES[5];
                    break;
                default: break;
            }
            addTaxi(currentUber, district);
        }
    }

    // Constructor
    public DispatchCenter() {
        // You'll need this for the last part of the assignment
        stats = new int[AREA_NAMES.length][AREA_NAMES.length];
    }

    public int randomLicencePlateGenerator () {
        Random randomValue = new Random();
        int plateNumber = randomValue.nextInt(899) + 100;
        return plateNumber;
    }

    public int randomZoneDistrictGenerator() {
        Random randomValue = new Random();
        int zoneNumber = randomValue.nextInt(6) + 1;
        return zoneNumber;
    }

    // Find a taxi to satisfy the given request
    public Taxi sendTaxiForRequest(ClientRequest requestPickupDropOff) {
        String destinationRequest = requestPickupDropOff.getPickupLocation();
        String destinationDropPoint = requestPickupDropOff.getDropoffLocation();
        ArrayList<Taxi> ubersInLocation = (ArrayList<Taxi>) areas.get(requestPickupDropOff.getPickupLocation());
        if (ubersInLocation != null) {
            for (int a = 0; a < ubersInLocation.size(); a++) {
                if (ubersInLocation.get(a).getAvailable()) {
                    ubersInLocation.get(a).setAvailable(false);
                    ubersInLocation.get(a).setDestination(destinationDropPoint);
                    ubersInLocation.get(a).setEstimatedTimeToDest(computeTravelTimeFrom(destinationRequest, destinationDropPoint));
                    areas.get(destinationDropPoint).add(ubersInLocation.get(a));
                    areas.get(destinationRequest).remove(ubersInLocation.get(a));
                    return ubersInLocation.get(a);
                }
            }

            for (String d : AREA_NAMES) {
                if (availableTaxisInArea(d).size() > 0) {
                    for (Taxi primaryTaxi : availableTaxisInArea(d)) {
                        primaryTaxi.setDestination(destinationDropPoint);
                        primaryTaxi.setAvailable(false);
                        primaryTaxi.setEstimatedTimeToDest(computeTravelTimeFrom(destinationRequest, destinationDropPoint));
                        updateStats(destinationRequest, destinationDropPoint);
                        areas.get(destinationDropPoint).add(primaryTaxi);
                        areas.get(destinationRequest).remove(primaryTaxi);
                        return primaryTaxi;
                    }
                }
            }
        }
        return null;
    }

    // Determine the travel times from one area to another
    public static int computeTravelTimeFrom(String pickupLocation, String dropoffLocation) {
        String[][] distanceBetweenTrips = new String[][] {
            {"Downtown", "Downtown", "10"}, {"Downtown", "Airport", "40"},
            {"Downtown", "North", "20"}, {"Downtown", "South", "20"},
            {"Downtown", "East", "20"}, {"Downtown", "West", "20"},

            {"Airport", "Downtown", "40"}, {"Airport", "Airport", "10"},
            {"Airport", "North", "40"}, {"Airport", "South", "40"},
            {"Airport", "East", "20"}, {"Airport", "West", "60"},

            {"North", "Downtown", "20"}, {"North", "Airport", "40"},
            {"North", "North", "10"}, {"North", "South", "40"},
            {"North", "East", "20"}, {"North", "West", "20"},

            {"South", "Downtown", "20"}, {"South", "Airport", "40"},
            {"South", "North", "40"}, {"South", "South", "10"},
            {"South", "East", "20"}, {"South", "West", "20"},

            {"East", "Downtown", "20"}, {"East", "Airport", "20"},
            {"East", "North", "20"}, {"East", "South", "20"},
            {"East", "East", "10"}, {"East", "West", "40"},

            {"West", "Downtown", "20"}, {"West", "Airport", "60"},
            {"West", "North", "20"}, {"West", "South", "20"},
            {"West", "East", "40"}, {"West", "West", "10"}
        };


        for (int b = 0; b < distanceBetweenTrips.length; b++) {
            if (pickupLocation.equals(distanceBetweenTrips[b][0]) && dropoffLocation.equals(distanceBetweenTrips[b][1])) {
                return Integer.valueOf(distanceBetweenTrips[b][2]);
            }
        }
        return 0;
    }

    private ArrayList<Taxi> availableTaxisInArea (String avalibleUbers) {
        ArrayList<Taxi> options = new ArrayList<Taxi>();
        ArrayList<Taxi> currentUbers = areas.get(avalibleUbers);
        for (Taxi ubers: currentUbers) {
            if (ubers.getAvailable() == true) {
                options.add(ubers);
            }
        }
        return options;
    }

    public void addTaxi(Taxi currentUber, String zone) {
        taxies.put(currentUber.getPlateNumber(), currentUber);
        switch (zone) {
            case "Downtown": listofDowntownUbers.add(currentUber);
                break;

            case "Airport": listOfAirportUbers.add(currentUber);
                break;

            case "North": listOfNorthUbers.add(currentUber);
                break;

            case "South": listofSouthUbers.add(currentUber);
                break;

            case "East": listofEastUbers.add(currentUber);
                break;

            case "West": listofWestUbers.add(currentUber);
                break;

            default: break;
        }
    }

    // Return a list of all busy taxis
    public ArrayList<Taxi> getBusyTaxis() {
        ArrayList<Taxi> options = new ArrayList<Taxi>();
        for (int g = 0; g < areas.size(); g++) {
            for (int h = 0; h < areas.get(AREA_NAMES[g]).size(); h++) {
                Taxi ubers = (Taxi) areas.get(AREA_NAMES[g]).get(h);
                if(!ubers.getAvailable()) {
                    options.add((Taxi) areas.get(AREA_NAMES[g]).get(h));
                }
            }
        }
        return options;
    }

    // Update the statistics for a taxi going from the pickup location to the dropoff location
    public void updateStats(String pickupLocation, String dropoffLocation) {
        for (int k = 0; k < 6; k++) {
            for (int l = 0; l < 6; l++) {
                if (pickupLocation.equals(AREA_NAMES[k]) && dropoffLocation.equals(AREA_NAMES[l])) {
                    stats[k][l] += 1;
                }
            }
        }
    }
}
