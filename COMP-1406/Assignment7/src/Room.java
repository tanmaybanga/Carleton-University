import javafx.geometry.Point2D;

public class Room {
    private static final int    MAX_ROOM_TILES = 400;

    private int             numTiles;   // The number of tiles that make up a Room
    private Point2D[]       tiles;      // All the tiles that make up a Room
    private int             colorIndex; // The color index of the Room

    public Room() {
        tiles = new Point2D[MAX_ROOM_TILES];
        numTiles = 0;
        colorIndex = 0;
    }

    public int getColorIndex() { return colorIndex; }
    public int getNumberOfTiles() { return numTiles; }
    public void setColorIndex(int c) { colorIndex = c; }

    // Add a tile to the room (up until the maximum)
    public boolean addTile(int r, int c) {
        if (numTiles < MAX_ROOM_TILES) {
            tiles[numTiles++] = new Point2D(c,r);
            return true;
        }
        return false;
    }

    // Remove a tile from the room
    public void removeTile(int r, int c) {
        // Find the tile
        for (int i=0; i<numTiles; i++) {
            if ((tiles[i].getX() == c) && (tiles[i].getY() == r)) {
                tiles[i] = tiles[numTiles -1];
                numTiles--;
                return;
            }
        }
    }

    // Return whether or not the given location is part of the room
    public boolean contains(int r, int c) {
        for (int i=0; i<numTiles; i++)
            if ((tiles[i].getX() == c) && (tiles[i].getY() == r))
                return true;
        return false;
    }
}
