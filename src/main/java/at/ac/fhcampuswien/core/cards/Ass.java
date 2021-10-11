package at.ac.fhcampuswien.core.cards;

public class Ass extends Card{

    public Ass(String color){
        super(color);
    }

    @Override
    public String getName() {
        return NAME_ASS;
    }

    @Override
    public int getValue() {
        return VALUE_ASS;
    }
}
