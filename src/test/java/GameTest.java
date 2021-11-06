import at.ac.fhcampuswien.core.Game;
import at.ac.fhcampuswien.core.HumanPlayer;
import at.ac.fhcampuswien.core.Player;
import at.ac.fhcampuswien.core.cards.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class GameTest {


    private HumanPlayer player;

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

        assertTrue(handCards.get(0).isPlayable);
        assertFalse(handCards.get(1).isPlayable);
        assertFalse(handCards.get(2).isPlayable);
        assertTrue(handCards.get(3).isPlayable);
        assertFalse(handCards.get(4).isPlayable);
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

        assertTrue(handCards.get(0).isPlayable);
        assertTrue(handCards.get(1).isPlayable);
        assertTrue(handCards.get(2).isPlayable);
        assertTrue(handCards.get(3).isPlayable);
        assertTrue(handCards.get(4).isPlayable);
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

        assertTrue(handCards.get(0).isPlayable);
        assertTrue(handCards.get(1).isPlayable);
        assertFalse(handCards.get(2).isPlayable);
        assertTrue(handCards.get(3).isPlayable);
        assertFalse(handCards.get(4).isPlayable);
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

        assertTrue(handCards.get(0).isPlayable);
        assertTrue(handCards.get(1).isPlayable);
        assertFalse(handCards.get(2).isPlayable);
        assertTrue(handCards.get(3).isPlayable);
        assertTrue(handCards.get(4).isPlayable);
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

        assertTrue(handCards.get(0).isPlayable);
        assertTrue(handCards.get(1).isPlayable);
        assertTrue(handCards.get(2).isPlayable);
        assertTrue(handCards.get(3).isPlayable);
        assertTrue(handCards.get(4).isPlayable);
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

        assertTrue(handCards.get(0).isPlayable);
        assertTrue(handCards.get(1).isPlayable);
        assertTrue(handCards.get(2).isPlayable);
        assertTrue(handCards.get(3).isPlayable);
        assertTrue(handCards.get(4).isPlayable);
    }

    @org.junit.jupiter.api.Test
    void calculatePoints_checkCalculation() {

        List<Card> stackCards = new ArrayList<>();
        stackCards.add(new Queen("♣"));
        stackCards.add(new King("♠"));
        stackCards.add(new Jack("♣"));
        stackCards.add(new Ass("♣"));
        stackCards.add(new Ten("♠"));
        stackCards.add(new Ten("♣"));

        Game game = new Game();

        assertEquals(40, game.calculatePoints(stackCards));
    }


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

    @org.junit.jupiter.api.Test
    void setCardsPlayableFlagTrueCheck() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Queen("♣"));
        cards.add(new King("♠"));
        cards.add(new Jack("♣"));

        Game.setCardsPlayableFlag(cards, true);

        assertTrue(cards.get(0).isPlayable);
        assertTrue(cards.get(1).isPlayable);
        assertTrue(cards.get(2).isPlayable);
    }

    @org.junit.jupiter.api.Test
    void setCardsPlayableFlagFalseCheck() {
        List<Card> cards = new ArrayList<>();

        cards.add(new Queen("♣"));
        cards.add(new King("♠"));
        cards.add(new Jack("♣"));

        Game.setCardsPlayableFlag(cards, false);

        assertFalse(cards.get(0).isPlayable);
        assertFalse(cards.get(1).isPlayable);
        assertFalse(cards.get(2).isPlayable);
    }
}



