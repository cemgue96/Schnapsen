package at.ac.fhcampuswien.core.cards;

public class Ass extends Card{

    public Ass(String color){
        super(color);
    }

    @Override
    public String getName() {
        return CARDNAME_ASS;
    }

    @Override
    public int getValue() {
        return CARDVALUE_ASS;
    }
}
