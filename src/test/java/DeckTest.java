import at.ac.fhcampuswien.core.Deck;
import at.ac.fhcampuswien.core.cards.Card;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @org.junit.jupiter.api.Test
    void generateDeck_checksize() {
        Deck deck = new Deck();
        List<Card> cards = deck.generateDeck();
        assertEquals(20, cards.size());
    }

    @org.junit.jupiter.api.Test
    void getLength_checkLengthWithCards() {
        Deck deck = new Deck();
        List<Card> cards = deck.generateDeck();

        for (int i = 0; i < 3; i++){
            deck.drawCard(0);
        }

        assertEquals(17, deck.getLength());
    }

    @org.junit.jupiter.api.Test
    void getLength_checkLengthEmptyDeck() {
        Deck deck = new Deck();
        List<Card> cards = deck.generateDeck();

        for (int i = 0; i < 20; i++){
            deck.drawCard(0);
        }

        assertEquals(0, deck.getLength());
    }
}