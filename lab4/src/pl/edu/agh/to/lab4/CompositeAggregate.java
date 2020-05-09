package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeAggregate implements SuspectAggregate{

    private ArrayList<SuspectAggregate> children;

    public CompositeAggregate(){
        this.children = new ArrayList<>();
    }

    public void addChild(SuspectAggregate child){

        this.children.add(child);
    }

    public void removeChild(SuspectAggregate child){
        for(SuspectAggregate suspectAggregate: children){
            if(suspectAggregate.equals(child))
                children.remove(child);
        }
    }

    @Override
    public Iterator<Suspect> iterator() {
        ArrayList<Suspect> suspects = new ArrayList<>();
        for(SuspectAggregate child: children){
            Iterator<Suspect> iterator = child.iterator();
            while(iterator.hasNext()){
                suspects.add(iterator.next());
            }
        }
        return suspects.iterator();
    }
}
