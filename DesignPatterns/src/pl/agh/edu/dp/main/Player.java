package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.Room;
import pl.agh.edu.dp.labirynth.factory.BombedRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {

    private static final ArrayList<Direction> directions =
            new ArrayList<>(Arrays.asList(
            Direction.North, Direction.East,
            Direction.South, Direction.West));

    private int healthPoints;

    public Player(){
        this.healthPoints = 10;
    }

    private void showRooms(Room room){
        System.out.println("Dostępne kierunki: ");
        for(Direction direction: directions){
            if(room.getSide(direction) instanceof Door){
                Door door = (Door) room.getSide(direction);
                System.out.println(direction.toString());
            }
        }
    }

    private Direction chooseDirection(){
        System.out.print("Wybierz kierunek: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        return Direction.toDirection(inputString);
    }

    private Room movePlayer(Direction moveDirection, Room room){
        Door door = (Door) room.getSide(moveDirection);
        if(door.getRoom1().equals(room)) return door.getRoom2();
        else return door.getRoom1();
    }

    public void playGame(Maze maze){
        Room currentRoom = maze.getRooms().elementAt(0);
        while(!currentRoom.end){
            if(this.healthPoints < 0){
                System.out.println("Przykro mi - umarłeś.");
                return;
            }
            System.out.println("Pozostałe punkty życia: " + this.healthPoints);
            currentRoom.Enter();
            if(currentRoom instanceof BombedRoom) {
                this.healthPoints -= 3;
            }
            showRooms(currentRoom);
            Direction moveDirection = chooseDirection();
            currentRoom = movePlayer(moveDirection, currentRoom);
            this.healthPoints--;
        }
        System.out.println("Znalazłeś koniec, gratuluję :-)");
    }
}
