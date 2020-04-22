package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        //gameplay
        MazeGame mazeGame = new MazeGame();
        MazeFactory mazeFactory = new MazeFactory();
        Maze maze = mazeGame.createExampleGameplay1(mazeFactory);
        Player player = new Player();
        player.playGame(maze);

        //singleton
        /*
        MazeFactory mz1 = MazeFactory.getInstance();
        MazeFactory mz2 = MazeFactory.getInstance();
       // MazeFactory mz1 = new MazeFactory();
       // MazeFactory mz2 = new MazeFactory();
        System.out.println(mz2.equals(mz1));
    */

        //BombedMazeFactory
        /*
        MazeGame mazeGame = new MazeGame();
        MazeFactory mazeFactory = new BombedMazeFactory();
        Maze maze = mazeGame.createMaze(mazeFactory);
        System.out.println(maze.getRoomNumbers());
        Vector<Room> rooms = maze.getRooms();
        for(Room room: rooms) {
            Vector<Door> doors = room.getDoors();
            System.out.println(doors.size());
        }
        */

        //EnchantedMazeFactory
        /*
        MazeGame mazeGame = new MazeGame();
        MazeFactory mazeFactory = new EnchantedMazeFactory();
        Maze maze = mazeGame.createMaze(mazeFactory);
        System.out.println(maze.getRoomNumbers());
        Vector<Room> rooms = maze.getRooms();
        for(Room room: rooms) {
            Vector<Door> doors = room.getDoors();
            System.out.println(doors.size());
        }
        */

        //countingBuilder
        /*
        MazeGame mazeGame = new MazeGame();
        CountingMazeBuilder builder = new CountingMazeBuilder();
        Maze maze = mazeGame.createMaze(builder);
        builder.getCounts();
        */
        //builder
        /*
        MazeGame mazeGame = new MazeGame();
        MazeBuilder builder = new StandardBuilderMaze();

        System.out.println(maze.getRoomNumbers());
        Vector<Room> rooms = maze.getRooms();
        for(Room room: rooms){
            Vector<Door> doors = room.getDoors();
            System.out.println(doors.size());
        }*/
    }
}



