package at.ac.fhcampuswien.core.cards;

public class King extends Card{

    public King(String color){
        super(color);
    }

    @Override
    public String getName() {
        return CARDNAME_KING;
    }

    @Override
    public int getValue() {
        return CARDVALUE_KING;
    }
}
