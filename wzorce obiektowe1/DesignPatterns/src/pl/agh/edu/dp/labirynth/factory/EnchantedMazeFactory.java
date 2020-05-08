package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public class EnchantedMazeFactory extends MazeFactory{
    @Override
    public Room createRoom(int number) {
        return new EnchantedRoom(number);
    }

    @Override
    public Door createDoor(Room r1, Room r2, Direction d1, Direction d2) {
        Door door = new EnchantedDoor(r1, r2);
        r1.setSide(d1, door);
        r2.setSide(d2, door);
        return door;
    }
}
