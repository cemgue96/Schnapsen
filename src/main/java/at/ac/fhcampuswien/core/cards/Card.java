package at.ac.fhcampuswien.core.cards;


public abstract class Card {

    public static final int CARDVALUE_ASS = 11;
    protected static final int CARDVALUE_KING = 4;
    protected static final int CARDVALUE_QUEEN = 3;
    protected static final int CARDVALUE_TEN = 10;
    protected static final int CARDVALUE_JACK = 2;

    public static final String CARDNAME_ASS = "Ass";
    public static final String CARDNAME_KING = "König";
    public static final String CARDNAME_QUEEN = "Dame";
    public static final String CARDNAME_TEN = "Zehner";
    public static final String CARDNAME_JACK = "Bube";

    private String color;

    public Card(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract String getName();

    public abstract int getValue();

    @Override
    public String toString() {
        return getName()+getColor();
    }
}
