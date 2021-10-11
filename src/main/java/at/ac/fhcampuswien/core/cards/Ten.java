package at.ac.fhcampuswien.core.cards;

public class Ten extends Card{

    public Ten(String color){
        super(color);
    }

    @Override
    public String getName() {
        return CARDNAME_TEN;
    }

    @Override
    public int getValue() {
        return CARDVALUE_TEN;
    }
}
