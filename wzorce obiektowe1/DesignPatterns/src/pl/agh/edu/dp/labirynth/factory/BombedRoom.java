package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Room;

public class BombedRoom extends Room {
    public BombedRoom(int number) {
        super(number);
       // System.out.println("Utworzono bombowy pokój.");
    }

    @Override
    public void Enter(){
        System.out.println("W tym pokoju jest bomba - uciekaj!");
    }
}
