package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Room;

public class EnchantedRoom extends Room {
    public EnchantedRoom(int number) {
        super(number);
        System.out.println("Utworzono magiczny pokój");
    }

    @Override
    public void Enter(){
        System.out.println("To magiczny pokój - uważaj!");
    }
}
