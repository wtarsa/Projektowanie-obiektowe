package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.factory.MazeFactory;

public class MazeGame {
    public Maze createMaze(MazeFactory factory){
        Room r1 = factory.createRoom(1);
        Room r2 = factory.createRoom(2);

        factory.createWall(Direction.North, r1);
        factory.createWall(Direction.East, r1);
        factory.createWall(Direction.South, r1);
        factory.createWall(Direction.West, r1);

        factory.createWall(Direction.North, r2);
        factory.createWall(Direction.East, r2);
        factory.createWall(Direction.South, r2);
        factory.createWall(Direction.West, r2);

        Door door = factory.createDoor(r1, r2, Direction.South, Direction.North);

        Maze maze = new Maze();
        maze.addRoom(r1);
        maze.addRoom(r2);
        return maze;
    }
}
