package pl.edu.agh.dronka.shop.model;

public enum Genre {
    POP,
    ROCK,
    TECHNO,
    UNIDENTIFIED;

    public static Genre toGenre(String readGenre){
        switch (readGenre){
            case "POP":
                return POP;
            case "ROCK":
                return ROCK;
            case "TECHNO":
                return TECHNO;
            default:
                return UNIDENTIFIED;
        }
    }
}
