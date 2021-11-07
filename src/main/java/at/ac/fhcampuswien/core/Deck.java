package at.ac.fhcampuswien.core;

import at.ac.fhcampuswien.core.cards.Card;
import at.ac.fhcampuswien.core.cards.CardFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Deck {

    public static final String SYMBOL_PIK = "♣";
    public static final String SYMBOL_TREFF = "♠";
    public static final String SYMBOL_KARO = "♦";
    public static final String SYMBOL_HERZ = "♥";


    protected static final List<String> COLOURS = Arrays.asList(SYMBOL_PIK, SYMBOL_TREFF, SYMBOL_KARO, SYMBOL_HERZ);

    public static final List<String> CARDS = Arrays.asList(Card.NAME_ASS, Card.NAME_KING, Card.NAME_QUEEN,Card.NAME_JACK,Card.NAME_TEN);


    private List<Card> cards = new ArrayList<>();

    public Deck() {
        super();
        cards = generateDeck();
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public int getLength() {
        return this.cards.size();
    }

    public List<Card> generateDeck(){
        List<Card> cards = new ArrayList<>();
        for (String color : COLOURS){
            for (String value : CARDS){
                cards.add(CardFactory.getCard(value, color));
            }
        }
        return cards;
    }

    public Card drawCard(int index){
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }
}
