package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.Wall;

public class BombedMazeFactory extends MazeFactory{
    @Override
    public Room createRoom(int number) {
        return new BombedRoom(number);
    }

    @Override
    public void createWall(Direction direction, Room room) {
        room.setSide(direction, new BombedWall());
    }
}
