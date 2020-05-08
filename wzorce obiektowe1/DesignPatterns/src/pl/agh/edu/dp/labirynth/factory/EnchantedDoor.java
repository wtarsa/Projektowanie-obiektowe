package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Room;

public class EnchantedDoor extends Door {
    public EnchantedDoor(Room r1, Room r2) {
        super(r1, r2);
       // System.out.println("Utworzono magiczne drzwi");
    }

    @Override
    public void Enter(){
        System.out.println("Przeszedłeś przez magiczne drzwi :-).");
    }
}
