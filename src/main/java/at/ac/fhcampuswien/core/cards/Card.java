package at.ac.fhcampuswien.core.cards;


import java.util.Comparator;

public abstract class Card implements Comparable<Card>{

    protected static final int VALUE_ASS = 11;
    protected static final int VALUE_KING = 4;
    protected static final int VALUE_QUEEN = 3;
    protected static final int VALUE_TEN = 10;
    protected static final int VALUE_JACK = 2;

    public static final String NAME_ASS = "Ass";
    public static final String NAME_KING = "König";
    public static final String NAME_QUEEN = "Dame";
    public static final String NAME_TEN = "Zehner";
    public static final String NAME_JACK = "Bube";

    private final String color;

    protected Card(String color) {
        this.color = color;
        this.isPlayable = true;
    }

    public String getColor() {
        return color;
    }

    public abstract String getName();

    public abstract int getValue();

    public boolean isPlayable;

    @Override
    public String toString() {
        return getName()+getColor();
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getValue(), o.getValue());
    }
}
