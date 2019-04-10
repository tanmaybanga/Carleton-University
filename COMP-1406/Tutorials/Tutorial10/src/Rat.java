public class Rat {
    private int	row, col;

    // Move the Rat to the given position
    public void moveTo(int r, int c) {
        row = r; col = c;
    }

    public boolean canFindCheeseIn(Maze m) {
        //m.display(row, col);
        // Return true if there is cheese at the rat's (row,col) in the maze
        if (m.cheeseAt(row, col))
            return true;

        // Return false if there is a wall at the rat's (row,col) in the maze
        if (m.wallAt(row, col) || m.hasBeenVisited(row, col))
            return false;

        // Mark this location as having been visited
        m.markVisited(row, col);

        // Move up in the maze and recursively check
        moveTo(row-1, col);
        if (canFindCheeseIn(m)) {
            moveTo(row+1, col);   // Move back down before marking
            m.markUnVisited(row, col); // Unmark the visited location
            return true;
        }
        moveTo(row+1, col);   // Move back down before marking

        // Move below in the maze and recursively check
        moveTo(row+1, col);
        if (canFindCheeseIn(m)) {
            moveTo(row-1, col);   // Move back up before marking
            m.markUnVisited(row, col); // Unmark the visited location
            return true;
        }
        moveTo(row-1, col);   // Move back up before marking

        // Move left in the maze and recursively check
        moveTo(row, col-1);
        if (canFindCheeseIn(m)) {
            moveTo(row, col+1);   // Move back right before marking
            m.markUnVisited(row, col); // Unmark the visited location
            return true;
        }
        moveTo(row, col+1);   // Move back right before marking

        // Move right in the maze and recursively check
        moveTo(row, col+1);
        if (canFindCheeseIn(m)) {
            moveTo(row, col-1);   // Move back left before marking
            m.markUnVisited(row, col); // Unmark the visited location
            return true;
        }
        moveTo(row, col-1);   // Move back left before marking

        // We tried all directions and did not find the cheese, so quit
        return false;
    }
}
