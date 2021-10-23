package at.ac.fhcampuswien.core;

import at.ac.fhcampuswien.core.cards.Card;
import at.ac.fhcampuswien.gui.GameUI;

import java.util.List;

public class HumanPlayer extends Player {

    public HumanPlayer(List<Card> handCards, String playerName) {
        super(handCards, playerName);
    }

    //TODO: override chooseCard function like printing playedCards, cards in hand and atout and let user select which card to chose

    @Override
    public Card chooseCard() {
        //TODO: get playableCards for PlayOut
        List<Card> playableCards = handCards;
        Card selectedCard = GameUI.selectCardToPlay(handCards);
        handCards.remove(selectedCard);
        return selectedCard;
    }
}
