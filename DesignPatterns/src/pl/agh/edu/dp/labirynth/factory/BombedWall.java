package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.Wall;

public class BombedWall extends Wall {
    public BombedWall(){
        System.out.println("Utworzono bombową ścianę.");
    }

    @Override
    public void Enter(){
        System.out.println("Ostrożnie! Ta ściana może wybuchnąć.");
    }
}
