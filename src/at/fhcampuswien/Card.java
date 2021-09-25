package at.fhcampuswien;

import java.util.Map;

public class Card {
    private String color;
    private Map.Entry<String, Integer> value;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Map.Entry<String, Integer> getValue() {
        return value;
    }

    public void setValue(Map.Entry<String, Integer> value) {
        this.value = value;
    }

    public Card(String color, Map.Entry<String, Integer> value) {
        this.color = color;
        this.value = value;
    }

    //TODO: create a function to print the card in a fancy way (even though we are a terminal application)
    /*public void print() {

    }*/
}
