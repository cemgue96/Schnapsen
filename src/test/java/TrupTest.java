import at.ac.fhcampuswien.core.Game;
import at.ac.fhcampuswien.core.cards.Ass;
import at.ac.fhcampuswien.core.cards.Card;
import at.ac.fhcampuswien.core.cards.King;
import at.ac.fhcampuswien.core.cards.Queen;

import static org.junit.jupiter.api.Assertions.*;

public class TrupTest {

    @org.junit.jupiter.api.Test
    void cardTrumped_sameColor() {
        Card firstHandHard = new Queen("♣");
        Card secondHandCard = new King("♣");
        Card atoutCard = new Ass("♦");

        boolean secondTrumped = Game.trumpChecker(firstHandHard, secondHandCard, atoutCard);

        assertTrue(secondTrumped);
    }

    @org.junit.jupiter.api.Test
    void cardTrumped_playedAtout() {
        Card firstHandHard = new King("♣");
        Card secondHandCard = new Queen("♦");
        Card atoutCard = new Ass("♦");

        boolean secondTrumped = Game.trumpChecker(firstHandHard, secondHandCard, atoutCard);

        assertTrue(secondTrumped);
    }

    @org.junit.jupiter.api.Test
    void cardeTrumped_differenColor() {
        Card firstHandHard = new King("♣");
        Card secondHandCard = new Queen("♠");
        Card atoutCard = new Ass("♦");

        boolean secondTrumped = Game.trumpChecker(firstHandHard, secondHandCard, atoutCard);

        assertFalse(secondTrumped);
    }
}
