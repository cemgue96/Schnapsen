package at.ac.fhcampuswien.core;

import at.ac.fhcampuswien.core.cards.Card;

import java.util.List;

public class HumanPlayer extends Player {

    public HumanPlayer(List<Card> handCards, String playerName) {
        super(handCards, playerName);
    }

    //TODO: override chooseCard function like printing playedCards, cards in hand and atout and let user select which card to chose
}
