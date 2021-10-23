package at.ac.fhcampuswien.core;

import at.ac.fhcampuswien.core.cards.Card;
import at.ac.fhcampuswien.gui.GameUI;

import java.util.List;

public class HumanPlayer extends Player {

    public HumanPlayer(String playerName) {
        super(playerName);
    }

    @Override
    public Card chooseCard(Card atoutCard) {
        return this.chooseCard();
    }

    @Override
    public Card chooseCard(Card atoutCard, Card firstPlayedCard) {
        return this.chooseCard();
    }

    @Override
    public Card chooseCard() {
        //TODO: get playableCards for PlayOut
        List<Card> playableCards = handCards;
        Card selectedCard = GameUI.selectCardToPlay(handCards);
        handCards.remove(selectedCard);
        return selectedCard;
    }
}

