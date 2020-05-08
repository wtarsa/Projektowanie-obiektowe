package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public String toString(){
        switch (this){
            case North:
                return "N";
            case South:
                return "S";
            case East:
                return "E";
            case West:
                return "W";
            default:
                return "X";
        }
    }

    public static Direction toDirection(String direction){
        switch (direction){
            case "N":
                return North;
            case "S":
                return South;
            case "E":
                return East;
            case "W":
                return West;
            default:
                return null;
        }
    }
}