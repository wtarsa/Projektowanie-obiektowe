package pl.agh.edu.dp.labirynth;

public class CountingMazeBuilder implements MazeBuilder{
    int rooms;
    int doors;
    int walls;
    @Override
    public void maze() {
        this.rooms = 0;
        this.doors = 0;
        this.walls = 0;
    }

    @Override
    public Room room(int number) {
        this.rooms++;
        return new Room(number);
    }

    @Override
    public Door door(Room r1, Room r2, Direction d1, Direction d2) {
        this.doors++;
        return new Door(r1, r2);
    }

    @Override
    public void setSide(Direction side, Room room) { this.walls++; }

    @Override
    public Maze toMaze() { return null; }

    public void getCounts(){
        System.out.println("Liczba utworzonych \npokoi: " + this.rooms + "\ndrzwi: " + this.doors + "\nścian: " + this.walls);
    }

}
