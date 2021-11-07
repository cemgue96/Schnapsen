package at.ac.fhcampuswien.core;

import at.ac.fhcampuswien.core.cards.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected List<Card> handCards;
    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }

    protected List<Card> stackCards;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    protected String playerName;
    private int scoredPoints = 0;

    public int getScoredPoints() {
        return scoredPoints;
    }

    public void setScoredPoints(int scoredPoints) {
        this.scoredPoints = scoredPoints;
    }



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
    public Card chooseCard(Card atout, Card firstPlayedCard) {
        return this.chooseCard();
    }

    public Player(String playerName) {
        this.playerName = playerName;
        handCards = new ArrayList<>();
        stackCards = new ArrayList<>();
    }
}
