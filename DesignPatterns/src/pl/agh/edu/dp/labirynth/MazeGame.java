package pl.agh.edu.dp.labirynth;

public class MazeGame {
    public Maze createMaze(MazeBuilder builder){
        builder.maze();

        Room r1 = builder.room(1);
        Room r2 = builder.room(2);

        builder.setSide(Direction.North, r1);
        builder.setSide(Direction.East, r1);
        builder.setSide(Direction.South, r1);
        builder.setSide(Direction.West, r1);

        builder.setSide(Direction.North, r2);
        builder.setSide(Direction.East, r2);
        builder.setSide(Direction.South, r2);
        builder.setSide(Direction.West, r2);

        Door door = builder.door(r1, r2, Direction.South, Direction.North);

        return builder.toMaze();
    }
}
