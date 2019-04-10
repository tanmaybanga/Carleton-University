public class FloorPlan {
    private static final int    MAX_ROOMS= 12;

    private String          name;               // name of the floor plan
    private int             size;               // # of rows and columns in table
    private boolean[][]     walls;              // Grid indicating whether a wall is there or not
    private Room[]          rooms;              // Rooms defined in the floor plan
    private int             numRooms;           // Number of rooms defined in the floor plan

    // Yep, this is a constructor.  It assumes that floorplans are always square in shape
    public FloorPlan(int rw, String n) {
        name = n;
        size = rw;
        walls = new boolean[size][size];
        rooms = new Room[MAX_ROOMS];
        numRooms = 0;

        // Set the grid to have empty space inside, but walls around border
        for (int r=0; r<size; r++)
            for (int c=0; c<size; c++)
                if ((r==0)||(r==size-1)||(c==0)||(c==size-1))
                    walls[r][c] = true;
                else
                    walls[r][c] = false;
    }

    // Some get/set methods
    public int size() { return size; }
    public String getName() { return name; }
    public int getNumberOfRooms() { return numRooms; }

    public boolean wallAt(int r, int c) { return walls[r][c]; }
    public void setWallAt(int r, int c, boolean wall) { walls[r][c] = wall; }

    // Return the room at this position, if this tile position belongs to that room
    public Room roomAt(int r, int c) {
        for (int i=0; i<numRooms; i++) {
            if (rooms[i].contains(r, c))
                return rooms[i];
        }
        return null;
    }

    // Return the room with the given color index, if there is one
    public Room roomWithColor(int index) {
        for (int i=0; i<numRooms; i++) {
            if (rooms[i].getColorIndex() == index)
                return rooms[i];
        }
        return null;
    }

    // Start a new room at the given location
    public Room addRoomAt(int r, int c) {
        if (numRooms < MAX_ROOMS) {
            Room room = new Room();
            rooms[numRooms++] = room;
            room.addTile(r, c);
            return room;
        }
        return null;
    }

    // Remove a room from the floor plan (assumes the room index is valid)
    public void removeRoom(Room r) {
        // Find out which room it is first
        for (int i=0; i<numRooms; i++) {
            if (rooms[i] == r) {
                rooms[i] = rooms[numRooms - 1];
                numRooms--;
                return;
            }
        }
    }

    // Create and return an example of a FloorPlan object
    public static FloorPlan floor1() {
        FloorPlan fp = new FloorPlan(20, "Main Floor");

        int[][] tiles = {
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,1,0,0,0,1,1,1,1,0,1,1,1,1,1},
                {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
        for (int r=0; r<20; r++)
            for (int c=0; c<20; c++)
                fp.setWallAt(r,c,tiles[r][c]==1);

        return fp;
    }
}