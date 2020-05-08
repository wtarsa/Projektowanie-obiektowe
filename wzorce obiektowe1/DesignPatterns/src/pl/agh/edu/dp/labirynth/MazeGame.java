package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;

import java.util.ArrayList;

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

    public Maze createExampleGameplay(MazeFactory factory){
        ArrayList<Room> rooms = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            Room room = factory.createRoom(i);
            factory.createWall(Direction.North, room);
            factory.createWall(Direction.East, room);
            factory.createWall(Direction.South, room);
            factory.createWall(Direction.West, room);
            if(i == 7) room.end = true;
            rooms.add(room);
        }
        factory.createDoor(rooms.get(0), rooms.get(1), Direction.North, Direction.South);
        factory.createDoor(rooms.get(1), rooms.get(2), Direction.East, Direction.West);
        factory.createDoor(rooms.get(2), rooms.get(3), Direction.North, Direction.South);
        factory.createDoor(rooms.get(3), rooms.get(4), Direction.West, Direction.East);
        factory.createDoor(rooms.get(2), rooms.get(5), Direction.East, Direction.West);
        factory.createDoor(rooms.get(5), rooms.get(6), Direction.South, Direction.North);
        factory.createDoor(rooms.get(5), rooms.get(7), Direction.North, Direction.South);

        Maze maze = new Maze();
        for(Room room: rooms){
            maze.addRoom(room);
        }
        return maze;
    }

    public Maze createExampleGameplay1(MazeFactory factory){
        ArrayList<Room> rooms = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            Room room = factory.createRoom(i);
            factory.createWall(Direction.North, room);
            factory.createWall(Direction.East, room);
            factory.createWall(Direction.South, room);
            factory.createWall(Direction.West, room);
            if(i == 7) room.end = true;
            rooms.add(room);
        }

        BombedMazeFactory bombedFactory = new BombedMazeFactory();
        Room bombedRoom = bombedFactory.createRoom(2);
        bombedFactory.createWall(Direction.North, bombedRoom);
        bombedFactory.createWall(Direction.East, bombedRoom);
        bombedFactory.createWall(Direction.South, bombedRoom);
        bombedFactory.createWall(Direction.West, bombedRoom);
        rooms.set(2, bombedRoom);

        factory.createDoor(rooms.get(0), rooms.get(1), Direction.North, Direction.South);
        factory.createDoor(rooms.get(1), rooms.get(2), Direction.East, Direction.West);
        factory.createDoor(rooms.get(2), rooms.get(3), Direction.North, Direction.South);
        factory.createDoor(rooms.get(3), rooms.get(4), Direction.West, Direction.East);
        factory.createDoor(rooms.get(2), rooms.get(5), Direction.East, Direction.West);
        factory.createDoor(rooms.get(5), rooms.get(6), Direction.South, Direction.North);
        factory.createDoor(rooms.get(5), rooms.get(7), Direction.North, Direction.South);

        Maze maze = new Maze();
        for(Room room: rooms){
            maze.addRoom(room);
        }
        return maze;
    }
}
