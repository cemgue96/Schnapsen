import at.ac.fhcampuswien.core.ArtificialPlayer;
import at.ac.fhcampuswien.core.Player;
import at.ac.fhcampuswien.core.cards.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtifitialPlayerTest {

    @org.junit.jupiter.api.Test
    void chooseCard_sameColourAsAtout() {
        List<Card> handCards = new ArrayList<>();
        handCards.add(new Queen("♣"));
        handCards.add(new King("♦"));
        handCards.add(new Jack("♣"));
        handCards.add(new Ass("♦"));
        handCards.add(new Ten("♠"));

        Card atout = new Queen("♦");

        Player player = new ArtificialPlayer(handCards, "Computer");

        Card chosenCard = player.chooseCard(atout);
        assertEquals(4,chosenCard.getValue());
    }

    @org.junit.jupiter.api.Test
    void chooseCard_sameColourAsFirstCard() {
        List<Card> handCards = new ArrayList<>();
        handCards.add(new Queen("♣"));
        handCards.add(new King("♦"));
        handCards.add(new Jack("♣"));
        handCards.add(new Ass("♦"));
        handCards.add(new Ten("♠"));

        Card atout = new Queen("♦");
        Card firstPlayedCard = new Ten("♦");

        Player player = new ArtificialPlayer(handCards, "Computer");

        Card chosenCard = player.chooseCard(atout, firstPlayedCard);
        assertEquals(11,chosenCard.getValue());
    }

    @org.junit.jupiter.api.Test
    void chooseCard_chooseLowestCardWhenNoTrump() {
        List<Card> handCards = new ArrayList<>();

        handCards.add(new Queen("♣"));
        handCards.add(new King("♦"));
        handCards.add(new Jack("♣"));
        handCards.add(new Ass("♦"));
        handCards.add(new Ten("♦"));

        Card atout = new Queen("♠");
        Card firstPlayedCard = new Ten("♠");

        Player player = new ArtificialPlayer(handCards, "Computer");

        Card chosenCard = player.chooseCard(atout, firstPlayedCard);

        assertEquals(2,chosenCard.getValue());
    }
}
