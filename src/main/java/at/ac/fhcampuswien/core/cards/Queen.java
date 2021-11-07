package at.ac.fhcampuswien.core.cards;

public class Queen extends Card{

    public Queen(String color){
        super(color);
    }

    @Override
    public String getName() {
        return NAME_QUEEN;
    }

    @Override
    public int getValue() {
        return VALUE_QUEEN;
    }
}
