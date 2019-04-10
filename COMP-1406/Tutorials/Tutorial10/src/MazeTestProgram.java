public class MazeTestProgram {
    public static void main(String[] args) {
        Maze m = Maze.sampleMaze();
        Rat r = new Rat();
        r.moveTo(1,1);
        m.display(1,1);
        System.out.println("Can find cheese ... " + r.canFindCheeseIn(m));
        m = Maze.sampleMaze();
        m.placeCheeseAt(13,13);
        r.moveTo(1,1);
        m.display(1,1);
        System.out.println("Can find cheese ... " + r.canFindCheeseIn(m));
        m = Maze.sampleMaze();
        m.placeCheeseAt(6,12);
        r.moveTo(1,1);
        m.display(1,1);
        System.out.println("Can find cheese ... " + r.canFindCheeseIn(m));
        m = Maze.sampleMaze();
        m.placeCheeseAt(13,1);
        r.moveTo(1,1);
        m.display(1,1);
        System.out.println("Can find cheese ... " + r.canFindCheeseIn(m));
        m = Maze.sampleMaze();
        m.placeCheeseAt(13,3);
        r.moveTo(1,1);
        m.display(1,1);
        System.out.println("Can find cheese ... " + r.canFindCheeseIn(m));
    }
}
