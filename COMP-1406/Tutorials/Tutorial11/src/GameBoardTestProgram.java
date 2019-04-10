import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class GameBoardTestProgram {
    public static void main(String args[]) {
        Game  g = new Game();

        // Add some walls
        g.add(new Wall(new Point2D(0,0), 20, 1));
        g.add(new Wall(new Point2D(0,0), 1, 15));
        g.add(new Wall(new Point2D(19,0), 1, 15));
        g.add(new Wall(new Point2D(0,14), 20, 1));
        g.add(new Wall(new Point2D(1,6), 4, 1));
        g.add(new Wall(new Point2D(9,4), 10, 1));
        g.add(new Wall(new Point2D(12,7), 1, 4));

        // Add some prizes
        g.add(new Prize(new Point2D(17,1), 1000));
        g.add(new Prize(new Point2D(6,6), 500));
        g.add(new Prize(new Point2D(15,12), 750));

        // Add some traps
        g.add(new Trap(new Point2D(13,2)));
        g.add(new Trap(new Point2D(15,10)));

        // Add a Player
        Player player = new Player("Red Guy", Color.RED, new Point2D(3, 12), 0);
        player.speed = 1;
        player.direction = 90;
        g.add(player);

        // Add a Ball
        Ball ball = new Ball(new Point2D(3, 11));
        ball.speed = 5;
        ball.direction = 0;
        g.add(ball);

        // Make some updates, displaying the board each time ...
        for (int i=0; i<15; i++) {
            g.updateObjects();
            g.displayBoard();
            System.out.println("--------------------");
        }
    }
}
