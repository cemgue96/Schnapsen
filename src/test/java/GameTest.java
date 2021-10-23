import at.ac.fhcampuswien.core.Game;
import at.ac.fhcampuswien.core.cards.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @org.junit.jupiter.api.Test
    void determinePlayableCards_checkAtoutInHandAtoutPlayed() {
       Card atoutCard = new Ass("♦");
       Card playedCard = new Ten("♦");

       List<Card> handCards = new ArrayList<>();
       handCards.add(new Queen("♦"));
       handCards.add(new King("♥"));
       handCards.add(new Jack("♣"));
       handCards.add(new Ass("♦"));
       handCards.add(new Ten("♠"));

       Game game = new Game();
       handCards = game.determinePlayableCards(handCards, atoutCard, playedCard);

       assertEquals(true, handCards.get(0).isPlayable);
       assertEquals(false, handCards.get(1).isPlayable);
       assertEquals(false, handCards.get(2).isPlayable);
       assertEquals(true, handCards.get(3).isPlayable);
       assertEquals(false, handCards.get(4).isPlayable);
    }

    @org.junit.jupiter.api.Test
    void determinePlayableCards_checkNoAtoutInHandAtoutPlayed() {
        Card atoutCard = new Ass("♦");
        Card playedCard = new Ten("♦");

        List<Card> handCards = new ArrayList<>();
        handCards.add(new Queen("♥"));
        handCards.add(new King("♥"));
        handCards.add(new Jack("♣"));
        handCards.add(new Ass("♥"));
        handCards.add(new Ten("♠"));

        Game game = new Game();
        handCards = game.determinePlayableCards(handCards, atoutCard, playedCard);

        assertEquals(true, handCards.get(0).isPlayable);
        assertEquals(true, handCards.get(1).isPlayable);
        assertEquals(true, handCards.get(2).isPlayable);
        assertEquals(true, handCards.get(3).isPlayable);
        assertEquals(true, handCards.get(4).isPlayable);
    }

    @org.junit.jupiter.api.Test
    void determinePlayableCards_checkHeartInHandNoAtoutInHandHeartPlayed() {
        Card atoutCard = new Ass("♦");
        Card playedCard = new Ten("♥");

        List<Card> handCards = new ArrayList<>();
        handCards.add(new Queen("♥"));
        handCards.add(new King("♥"));
        handCards.add(new Jack("♣"));
        handCards.add(new Ass("♥"));
        handCards.add(new Ten("♠"));

        Game game = new Game();
        handCards = game.determinePlayableCards(handCards, atoutCard, playedCard);

        assertEquals(true, handCards.get(0).isPlayable);
        assertEquals(true, handCards.get(1).isPlayable);
        assertEquals(false, handCards.get(2).isPlayable);
        assertEquals(true, handCards.get(3).isPlayable);
        assertEquals(false, handCards.get(4).isPlayable);
    }

    @org.junit.jupiter.api.Test
    void determinePlayableCards_checkHeartInHandAtoutInHandHeartPlayed() {
        Card atoutCard = new Ass("♦");
        Card playedCard = new Ten("♥");

        List<Card> handCards = new ArrayList<>();
        handCards.add(new Queen("♥"));
        handCards.add(new King("♥"));
        handCards.add(new Jack("♣"));
        handCards.add(new Ass("♥"));
        handCards.add(new Ten("♦"));

        Game game = new Game();
        handCards = game.determinePlayableCards(handCards, atoutCard, playedCard);

        assertEquals(true, handCards.get(0).isPlayable);
        assertEquals(true, handCards.get(1).isPlayable);
        assertEquals(false, handCards.get(2).isPlayable);
        assertEquals(true, handCards.get(3).isPlayable);
        assertEquals(true, handCards.get(4).isPlayable);
    }

    @org.junit.jupiter.api.Test
    void determinePlayableCards_checkNoHeartInHandAtoutInHandHeartPlayed() {
        Card atoutCard = new Ass("♦");
        Card playedCard = new Ten("♥");

        List<Card> handCards = new ArrayList<>();
        handCards.add(new Queen("♣"));
        handCards.add(new King("♦"));
        handCards.add(new Jack("♣"));
        handCards.add(new Ass("♦"));
        handCards.add(new Ten("♠"));

        Game game = new Game();
        handCards = game.determinePlayableCards(handCards, atoutCard, playedCard);

        assertEquals(true, handCards.get(0).isPlayable);
        assertEquals(true, handCards.get(1).isPlayable);
        assertEquals(true, handCards.get(2).isPlayable);
        assertEquals(true, handCards.get(3).isPlayable);
        assertEquals(true, handCards.get(4).isPlayable);
    }

    @org.junit.jupiter.api.Test
    void determinePlayableCards_checkNoHeartInHandNoAtoutInHandHeartPlayed() {
        Card atoutCard = new Ass("♦");
        Card playedCard = new Ten("♥");

        List<Card> handCards = new ArrayList<>();
        handCards.add(new Queen("♣"));
        handCards.add(new King("♠"));
        handCards.add(new Jack("♣"));
        handCards.add(new Ass("♣"));
        handCards.add(new Ten("♠"));

        Game game = new Game();
        handCards = game.determinePlayableCards(handCards, atoutCard, playedCard);

        assertEquals(true, handCards.get(0).isPlayable);
        assertEquals(true, handCards.get(1).isPlayable);
        assertEquals(true, handCards.get(2).isPlayable);
        assertEquals(true, handCards.get(3).isPlayable);
        assertEquals(true, handCards.get(4).isPlayable);
    }
}



