public class Game {
    public static final int     MAX_GAME_OBJECTS = 1000;

    Object[]        gameObjects;
    int             objectCount;

    public Game() {
        gameObjects = new Object[MAX_GAME_OBJECTS];
        objectCount = 0;
    }

    public void add(Object obj) {
        if (objectCount < MAX_GAME_OBJECTS)
            gameObjects[objectCount++] = obj;
    }

    // The get methods
    public Object[] getGameObjects() { return gameObjects; }
    public int getObjectCount() { return objectCount; }

    public String toString() {
        return "Game with " + objectCount + " objects";
    }

    public void displayObjects() {
        for (int i=0; i<objectCount; i++)
            System.out.println(gameObjects[i]);
    }
}