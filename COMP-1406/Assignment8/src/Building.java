public class Building {
    public static final int MAXIMUM_FLOORPLANS = 5;
    public static final int MAXIMUM_EXITS = 8;

    private FloorPlan[]   floors;           // The floorPlans of the building
    private int           numFloors;        // The number of floorPlans in the building
    private Exit[]        exits;            // The Exits of the building
    private int           numExits;         // The number of Exits in the building

    public Building(int fCount, int eCount) {
        floors = new FloorPlan[Math.max(MAXIMUM_FLOORPLANS, fCount)];
        numFloors = 0;
        exits = new Exit[Math.max(MAXIMUM_EXITS, eCount)];
        numExits = 0;
    }

    // Get/set methods
    /**
     * Created by Imran on 2017-03-20.
     */

    public Exit[] getExits() { return exits; }
    public Exit getExit(int i) { return exits[i]; }
    public FloorPlan[] getFloorPlans() { return floors; }
    public FloorPlan getFloorPlan(int i) { return floors[i]; }

    // Get the exit at this location
    public Exit exitAt(int r, int c) {
        for (int i=0; i<numExits; i++)
            if (exits[i].isAt(r,c))
                return exits[i];
        return null;
    }

    // Retirn whether or not there is an exit at this location
    public boolean hasExitAt(int r, int c) {
        return exitAt(r, c) != null;
    }

    // Add an exit to the floor plan (up until the maximum)
    public boolean addExit(int r, int c) {
        if (numExits < MAXIMUM_EXITS) {
            exits[numExits++] = new Exit(r,c);
            return true;
        }
        return false;
    }

    // Remove an exit from the floor plan
    public void removeExit(int r, int c) {
        // Find the exit
        for (int i=0; i<numExits; i++) {
            if (exits[i].isAt(r,c)) {
                exits[i] = exits[numExits -1];
                numExits--;
                return;
            }
        }
    }

    // Return an example of a building with 5 floors and 3 exits
    public static Building example() {
        Building b = new Building(5, 3);
        b.floors[0] = FloorPlan.floor1();
        b.floors[1] = FloorPlan.floor2();
        b.floors[2] = FloorPlan.floor3();
        b.floors[3] = FloorPlan.floor4();
        b.floors[4] = FloorPlan.floor5();
        b.numFloors = 5;
        b.addExit(19, 5);
        b.addExit(0, 8);
        b.addExit(9, 19);
        return b;
    }
}
