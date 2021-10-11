package at.ac.fhcampuswien.core.cards;

public class Jack extends Card{

    public Jack(String color){
        super(color);
    }

    @Override
    public String getName() {
        return NAME_JACK;
    }

    @Override
    public int getValue() {
        return VALUE_JACK;
    }
}
