public class Maze {
    public static byte EMPTY = 0;
    public static byte WALL = 1;
    public static byte CHEESE = 2;
    public static byte BREAD_CRUMB = -1;

    private int		rows, columns;
    private byte[][] 	grid;

    // A constructor that makes a maze of the given size
    public Maze(int r, int c) {
        rows = r;
        columns = c;
        grid = new byte[r][c];
    }
    // A constructor that makes a maze with the given byte array
    public Maze(byte[][] g) {
        rows = g.length;
        columns = g[0].length;
        grid = g;
    }

    // Return true if a wall is at the given location, otherwise false
    public boolean wallAt(int r, int c) {  return grid[r][c] == WALL;  }

    // Return true if a cheese is at the given location, otherwise false
    public boolean cheeseAt(int r, int c) {  return grid[r][c] == CHEESE;  }

    // Put a wall at the given location
    public void placeWallAt(int r, int c) {  grid[r][c] = WALL;  }

    // Remove a wall from the given location
    public void removeWallAt(int r, int c) {  grid[r][c] = EMPTY;  }

    // Put cheese at the given location
    public void placeCheeseAt(int r, int c) {  grid[r][c] = CHEESE;  }

    // Remove a cheese from the given location
    public void removeCheeseAt(int r, int c) {  grid[r][c] = EMPTY;  }

    // Mark the given location as visited
    public void markVisited(int r, int c) {
        grid[r][c] = BREAD_CRUMB;
    }

    // Mark the given location as not having been visited
    public void markUnVisited(int r, int c) {
        grid[r][c] = EMPTY;
    }

    // Return true of the location has been visited
    public boolean hasBeenVisited(int r, int c) {
        return grid[r][c] == BREAD_CRUMB;
    }

    // Display the maze
    public void display() {
        for(int r=0; r<rows; r++) {
            for (int c = 0; c<columns; c++) {
                if (grid[r][c] == WALL)
                    System.out.print("W");
                else if (grid[r][c] == CHEESE)
                    System.out.print("c");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Display the maze, the rat and the breadcrumbs
    public void display(int ratRow, int ratCol) {
        for(int r=0; r<rows; r++) {
            for (int c = 0; c<columns; c++) {
                if ((r == ratRow) && (c == ratCol))
                    System.out.print("r");
                else if (grid[r][c] == WALL)
                    System.out.print("W");
                else if (grid[r][c] == CHEESE)
                    System.out.print("c");
                else if (grid[r][c] == BREAD_CRUMB)
                    System.out.print(".");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Return a sample maze corresponding to the one in the notes
    public static Maze sampleMaze() {
        byte[][] grid = { {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                {1,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,1},
                {1,0,1,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,1},
                {1,0,1,0,0,0,1,1,1,0,0,1,0,0,0,1,0,0,1},
                {1,0,1,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,1},
                {1,0,1,0,1,0,1,1,1,0,0,0,0,0,0,0,0,0,1},
                {1,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1},
                {1,0,1,1,1,1,1,1,0,0,0,1,1,1,0,1,1,0,1},
                {1,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,0,1},
                {1,1,1,0,1,0,1,0,0,1,0,1,0,0,0,1,0,0,1},
                {1,0,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,1},
                {1,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
        Maze m = new Maze(grid);
        m.placeCheeseAt(3,12);
        return m;
    }
}
