package pl.agh.edu.dp.labirynth;

import java.util.*;

public class Room extends MapSite
{
    private int roomNumber;
    private Map<Direction, MapSite> sides;
    public boolean end;

    public Room(int number){
        this.end = false;
        this.sides = new EnumMap<>(Direction.class);
        this.roomNumber = number;
    }

    public MapSite getSide(Direction direction){
        return this.sides.get(direction);
    }

    public void setSide(Direction direction, MapSite ms){
        this.sides.put(direction, ms);
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    public Vector<Door> getDoors() {
        ArrayList<Direction> directions = new ArrayList<>(Arrays.asList(
                Direction.North, Direction.East,
                Direction.South, Direction.West
        ));
        Vector<Door> doors = new Vector<>();
        for(Direction direction: directions){
            if(this.getSide(direction) instanceof Door)
                doors.add((Door)this.getSide(direction));
        }
        return doors;
    }

    @Override
    public void Enter(){
        System.out.println("Normalny pokój");
    }
}
