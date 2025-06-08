package lab4_1;

import java.util.List;
import java.util.Scanner;

public class Search {
    public boolean SearchByTitle(Field field){
        return field==Field.TITLE;
    }
    public boolean SearchByAuthor(Field field){
        return field==Field.AUTHOR;
    }
    public boolean SearchByPublisher(Field field){
        return field==Field.PUBLISHER;
    }
    public boolean SearchByMode(Mode  mode,String condition,String book){
        switch (mode){
            case EXACT:
                return condition.equals(book);
            case FUZZY:
                return condition.contains(book);
            default:
                return false;
        }
    }
    public boolean SearchByRelation(Relation  relation,boolean first,boolean second){
        switch (relation){
            case AND:
                return first&&second;
            case OR:
                return first||second;
            case NOT:
                return !second;
            default:
                return false;
        }
    }

}