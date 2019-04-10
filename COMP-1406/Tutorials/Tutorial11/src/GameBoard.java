public class GameBoard {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 25;

    private char[][]    grid;

    public GameBoard() {
        grid = new char[WIDTH][HEIGHT];
        for (int i=0; i<WIDTH; i++)
            for (int j=0; j<HEIGHT; j++)
                grid[i][j] = ' ';
    }

    //This method prints out the board
    public void display(Game  g) {
        // Erase the stuff at the old player and ball locations
        for(int go=0; go<g.getObjectCount(); go++) {
            if (g.getGameObjects()[go] instanceof MovableObject) {
                MovableObject m = (MovableObject)g.getGameObjects()[go];
                if ((m.getPreviousLocation().getX() < WIDTH) && (m.getPreviousLocation().getX() >= 0) &&
                        (m.getPreviousLocation().getY() < HEIGHT) && (m.getPreviousLocation().getY() >= 0))
                    grid[(int)m.getPreviousLocation().getX()][(int)m.getPreviousLocation().getY()] = ' ';
            }
        }
        // Draw the game objects on the board now
        for(int go=0; go<g.getObjectCount(); go++) {
            GameObject obj = g.getGameObjects()[go];
            if (g.getGameObjects()[go] instanceof Wall) {
                Wall w = (Wall)g.getGameObjects()[go];
                for (int i=0; i<w.getWidth(); i++)
                    for (int j=0; j<w.getHeight(); j++)
                        grid[(int)w.getLocation().getX()+i][(int)w.getLocation().getY()+j] = w.appearance();
            }
            else {
                if ((g.getGameObjects()[go].getLocation().getX() < WIDTH) && (obj.getLocation().getX() >= 0) &&
                        (obj.getLocation().getY() < HEIGHT) && (obj.getLocation().getY() >= 0))
                    grid[(int)obj.getLocation().getX()][(int)obj.getLocation().getY()] = obj.appearance();
            }
        }
        // Now display it
        for (int r=0; r<HEIGHT; r++) {
            for (int c=0; c<WIDTH; c++)
                System.out.print(grid[c][r]);
            System.out.println();
        }
    }

}
