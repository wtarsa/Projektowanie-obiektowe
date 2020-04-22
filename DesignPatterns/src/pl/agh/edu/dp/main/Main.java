package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        MazeGame mazeGame = new MazeGame();
        CountingMazeBuilder builder = new CountingMazeBuilder();
        Maze maze = mazeGame.createMaze(builder);
        builder.getCounts();
        /*
        System.out.println(maze.getRoomNumbers());
        Vector<Room> rooms = maze.getRooms();
        for(Room room: rooms){
            Vector<Door> doors = room.getDoors();
            System.out.println(doors.size());
        }*/
    }
}



