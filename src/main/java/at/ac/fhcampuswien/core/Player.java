package at.ac.fhcampuswien.core;

import at.ac.fhcampuswien.core.cards.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected List<Card> handCards;
    protected List<Card> stackCards;
    protected String playerName;

    public Card chooseCard() {
        //TODO: implement genious way on how to choose a card
        //now only choosing a random card out of hand
        //TODO: think about error handling aswell - throw error if no cards left? 🤔
        int index = (int)(Math.random() * handCards.size());
        Card chosenCard = handCards.get(index);
        handCards.remove(index);


        return chosenCard;
    }
    public Card chooseCard(Card atoutCard) {
        return this.chooseCard();
    }
    public Card chooseCard(Card atoutCard, Card firstPlayedCard) {
        return this.chooseCard(atoutCard);
    }

    public Player(List<Card> handCards, String playerName) {
        this.handCards = handCards;
        this.playerName = playerName;
        stackCards = new ArrayList<>();
    }
}
