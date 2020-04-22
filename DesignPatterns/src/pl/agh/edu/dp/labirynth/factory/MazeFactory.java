package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.*;

public class MazeFactory {

    public Room createRoom(int number) {
        return new Room(number);
    }

    public Door createDoor(Room r1, Room r2, Direction d1, Direction d2) {
        Door door = new Door(r1, r2);
        r1.setSide(d1, door);
        r2.setSide(d2, door);
        return door;
    }

    public void createWall(Direction direction, Room room) {
        room.setSide(direction, new Wall());
    }
}
