package pl.agh.edu.dp.labirynth;

import java.util.ArrayList;
import java.util.Arrays;

public class StandardBuilderMaze implements MazeBuilder {
    private Maze currentMaze;

    public StandardBuilderMaze(){ }

    @Override
    public void maze() {
        this.currentMaze = new Maze();
    }

    @Override
    public Room room(int number) {
        Room room = new Room(number);
        this.currentMaze.addRoom(room);
        return room;
    }

    @Override
    public Door door(Room r1, Room r2, Direction d1, Direction d2) {
       Door door = new Door(r1, r2);
       r1.setSide(d1, door);
       r2.setSide(d2, door);
       return door;
    }

    @Override
    public void setSide(Direction side, Room room) {
        room.setSide(side, new Wall());
    }

    @Override
    public Maze toMaze() {
        return this.currentMaze;
    }

    public Direction commonWall(Room r1, Room r2){
        ArrayList<Direction> directions = new ArrayList<Direction>(Arrays.asList(
                Direction.North, Direction.South,
                Direction.East, Direction.West));
        for(Direction direction: directions){
            if(r1.getSide(direction) instanceof Door){
                Door door = (Door) r1.getSide(direction);
                if(door.getRoom1().equals(r1) && door.getRoom2().equals(r2) ||
                door.getRoom1().equals(r2) && door.getRoom1().equals(r1)) return direction;
            }
        }
        return null;
    }
}
