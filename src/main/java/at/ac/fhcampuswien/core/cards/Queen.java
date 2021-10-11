package at.ac.fhcampuswien.core.cards;

public class Queen extends Card{

    public Queen(String color){
        super(color);
    }

    @Override
    public String getName() {
        return CARDNAME_QUEEN;
    }

    @Override
    public int getValue() {
        return CARDVALUE_QUEEN;
    }
}
