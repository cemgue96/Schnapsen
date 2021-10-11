package at.ac.fhcampuswien.core.cards;

public class King extends Card{

    public King(String color){
        super(color);
    }

    @Override
    public String getName() {
        return NAME_KING;
    }

    @Override
    public int getValue() {
        return VALUE_KING;
    }
}
