package pl.agh.edu.dp.labirynth;

public interface MazeBuilder {

    public void maze();
    public Room room(int number);
    public Door door(Room r1, Room r2, Direction d1, Direction d2);

    public void setSide(Direction side, Room room);
    public Maze toMaze();
}
