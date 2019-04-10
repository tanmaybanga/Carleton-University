import java.lang.*;
import java.util.ArrayList;



public class Game {
    public static final int     MAX_GAME_OBJECTS = 1000;

    GameObject[]    gameObjects;
    int             objectCount;
    GameBoard       gameBoard;

    public Game() {
        gameObjects = new GameObject[MAX_GAME_OBJECTS];
        objectCount = 0;
        gameBoard = new GameBoard();
    }

    public void add(GameObject obj) {
        if (objectCount < MAX_GAME_OBJECTS)
            gameObjects[objectCount++] = obj;
    }

    public ArrayList<Player> getPlayers() {
        ArrayList<Player> result = new ArrayList<Player>();
        for (GameObject g: gameObjects) {
            if (g instanceof Player)
                result.add((Player)g);
        }
        return result;
    }

    public ArrayList<Wall> getWalls() {
        ArrayList<Wall> result = new ArrayList<Wall>();
        for (GameObject g: gameObjects) {
            if (g instanceof Wall)
                result.add((Wall)g);
        }
        return result;
    }

    // The get methods
    public GameObject[] getGameObjects() { return gameObjects; }
    public int getObjectCount() { return objectCount; }

    public String toString() {
        return "Game with " + objectCount + " objects";
    }

    public void displayObjects() {
        for (int i=0; i<objectCount; i++)
            System.out.println(gameObjects[i]);
    }
    public void updateObjects() {
        for (int i=0; i<objectCount; i++)
            gameObjects[i].update();
    }

    // Return an array of all Harmful objects in the game
    Harmful[] harmfulObjects() {
        // First find out how many objects are Harmful
        int count = 0;
        for (GameObject g:  gameObjects)
            if (g instanceof Harmful)
                count++;

        // Now create the array and fill it up
        Harmful[]    badGuys = new Harmful[count];
        count = 0;
        for (GameObject g:  gameObjects)
            if (g instanceof Harmful)
                badGuys[count++] = (Harmful)g;
        return badGuys;
    }

    public int assessDanger() {
        int harmOutThere = 0;
        Harmful[] dangerousStuff = harmfulObjects();
        for (Harmful d: dangerousStuff)
            harmOutThere += d.getDamageAmount();
        return harmOutThere;
    }



    public void displayBoard() {
        gameBoard.display(this);
    }
}