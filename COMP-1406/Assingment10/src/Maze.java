import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private static final byte  OPEN = 0;
    private static final byte  WALL = 1;
    private static final byte  VISITED = 2;
    
    private int         rows, columns;
    private byte[][]    grid;
    
    // A constructor that makes a maze of the given size
    public Maze(int r, int c) {
        rows = r;
        columns = c;
        grid = new byte[r][c];
        for(r=0; r<rows; r++) {
            for (c = 0; c<columns; c++) {
                grid[r][c] = WALL;
            }
        }
    }
    
    public int getRows() { return rows; }
    public int getColumns() { return columns; }
    
    // Return true if a wall is at the given location, otherwise false
    public boolean wallAt(int r, int c) {
        return grid[r][c] == WALL;
    }
    
    // Return true if this location has been visited, otherwise false
    public boolean visitedAt(int r, int c) {
        return grid[r][c] == VISITED;
    }
    
    // Put a visit marker at the given location
    public void placeVisitAt(int r, int c) {
        grid[r][c] = VISITED;
    }
    
    // Remove a visit marker from the given location
    public void removeVisitAt(int r, int c) {
        grid[r][c] = OPEN;
    }
    
    // Put a wall at the given location
    public void placeWallAt(int r, int c) {
        grid[r][c] = WALL;
    }
    
    // Remove a wall from the given location
    public void removeWallAt(int r, int c) {
        grid[r][c] = 0;
    }

    // Carve out a maze
    public void carve() {
        int startRow = (int)(Math.random()*(rows-2))+1;
        int startCol = (int)(Math.random()*(columns-2))+1;
        carve(startRow, startCol);
    }

    ArrayList<Integer> rowOffsets = new ArrayList<Integer>(Arrays.asList(-1, 1, 0, 0));
    ArrayList<Integer> colOffsets = new ArrayList<Integer>(Arrays.asList(0, 0, -1, 1));

    // Directly recursive method to carve out the maze
    public void carve(int r, int c) {

        // - If the piece is at current position, Make Red, Changes First Spot to Red
        if ((this.wallAt(r, c)) || (this.visitedAt(r,c))){
            placeVisitAt(r,c);
        }

        // - Removes The Piece if there is no wall, and not Visited
        else if ((!this.wallAt(r,c) || (!this.visitedAt(r,c)))){
            placeVisitAt(r,c);
            removeWallAt(r, c);
        }

        // - Carves the maze, current doesn't update so doesnt work.
        else{
             if (wallAt(r, c-1) && wallAt(r+1, c) && wallAt(r, c+1)){
                removeWallAt(r,c);
                placeVisitAt(r,c);
                carve(r-1, c);
            }
            else if(wallAt(r-1, c) && (wallAt(r,c-1)) && (wallAt(r+1, c))){
                removeWallAt(r,c);
                placeVisitAt(r,c);
                carve(r,c+1);
            }

            else if((wallAt(r, c+1) && wallAt(r-1, c) && wallAt(r, c-1))){
                removeWallAt(r,c);
                placeVisitAt(r,c);
                carve(r+1, c);
            }

            else if((wallAt(r+1, c) && wallAt(r, c+1) && wallAt(r-1, c))){
                removeWallAt(r,c);
                placeVisitAt(r,c);
                carve(r, c+1);
            }
        }
    }
    
    // Determine the longest path in the maze from the given start location
    public ArrayList<Point2D> longestPath() {
        return longestPathFrom(1,1); // Replace this with your code
    }
    
    // Determine the longest path in the maze from the given start location
    public ArrayList<Point2D> longestPathFrom(int r, int c) {
        ArrayList<Point2D> path = new ArrayList<Point2D>();
        
        // Write your code here
        
        return path;
    }
}

