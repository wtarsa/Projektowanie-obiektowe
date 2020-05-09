package pl.edu.agh.to.lab4;

public class NameSearchStrategy implements SearchStrategy {

    private String name;

    public NameSearchStrategy(String name){
        this.name = name;
    }

    @Override
    public boolean filter(Suspect suspect) {
        if(suspect.getName().equals(this.name)) return true;
        return false;
    }
}
