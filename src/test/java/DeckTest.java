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
        //cards.forEach(s -> System.out.println(s));
    }
}