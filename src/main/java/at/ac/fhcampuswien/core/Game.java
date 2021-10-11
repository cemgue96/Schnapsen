package at.ac.fhcampuswien.core;

import at.ac.fhcampuswien.core.cards.Card;
import at.ac.fhcampuswien.gui.GameUI;

import java.util.ArrayList;
import java.util.List;

public class Game {
    //This is the class for the game setup and logic.
    private Deck deck;
    private Player humanPlayer;
    private Player artificialPlayer;
    private Card atoutCard;
    public static final int NUMBER_OF_FIRST_DEAL_CARDS = 3;
    public static final int NUMBER_OF_SECOND_DEAL_CARDS = 2;
    public boolean humanPlayerIsDealer;
    public boolean humanPlayerHasTurn;
    public boolean cardsAvailable;
    public int humanPlayerPoints;
    public int artificialPlayerPoints;

    public static void printplayInstructions() {
        //TODO: print how this game works - like user intactions etc.
    }

    public Game() {
        super(); //call superclass constructor
    }

    public void run() {
        GameUI.printText("-----------------------------------------------------");
        GameUI.printText("♠♣♥♦       SCHNAPSEN - let's play a game!       ♠♣♥♦");
        GameUI.printText("-----------------------------------------------------");

        //Creates a new card deck and shuffles it
        deck = new Deck();
        deck.shuffle();

        //select human player as first dealer (can be improved later)
        humanPlayerIsDealer = true;
        humanPlayerHasTurn = true;
        cardsAvailable = true;

        //select 5 cards, create 2 players and set them as their handCards, while also removing this cards from the current deck. also chooses atout card.
        setupHandout();

        //print the atout card
        GameUI.printAtoutCard(this.atoutCard);

        startGame();

        humanPlayerPoints = calculatePoints(humanPlayer.stackCards);
        artificialPlayerPoints = calculatePoints(artificialPlayer.stackCards);

        GameUI.printPoints(humanPlayer.playerName, humanPlayerPoints);
        GameUI.printPoints(artificialPlayer.playerName, artificialPlayerPoints);

        if (humanPlayerPoints > artificialPlayerPoints) {
            GameUI.printWinnerText(humanPlayer.playerName);
        }
        else {
            GameUI.printWinnerText(artificialPlayer.playerName);
        }
    }

    private void startGame() {
        while(cardsAvailable) {
            GameUI.printHandCards(humanPlayer.handCards);

            playCards();

            if (humanPlayer.handCards.size() < 1) {
                cardsAvailable = false;
            }
        }
    }

    private void setupHandout() {

        List<Card> humanHandCards = new ArrayList<>(); //create new empty list of cards
        List<Card> artificialHandCards = new ArrayList<>(); //create new empty list of cards

        //handout first set of deal cards, opponent always gets the cards first
        if (humanPlayerIsDealer) {
            handoutCards(artificialHandCards, NUMBER_OF_FIRST_DEAL_CARDS);
            handoutCards(humanHandCards, NUMBER_OF_FIRST_DEAL_CARDS);
        }
        else {

            handoutCards(humanHandCards, NUMBER_OF_FIRST_DEAL_CARDS);
            handoutCards(artificialHandCards, NUMBER_OF_FIRST_DEAL_CARDS);
        }

        //choose atout card
        this.atoutCard = deck.drawCard(0);

        //handout second set of deal cards, opponent always gets the cards first
        if (humanPlayerIsDealer) {
            handoutCards(artificialHandCards, NUMBER_OF_SECOND_DEAL_CARDS);
            handoutCards(humanHandCards, NUMBER_OF_SECOND_DEAL_CARDS);
        }
        else {

            handoutCards(humanHandCards, NUMBER_OF_SECOND_DEAL_CARDS);
            handoutCards(artificialHandCards, NUMBER_OF_SECOND_DEAL_CARDS);
        }

        this.artificialPlayer = new ArtificialPlayer(artificialHandCards, "Computer");
        this.humanPlayer = new HumanPlayer(humanHandCards, "You");

    }

    private void handoutCards(List<Card> handCards, int numberOfCards) {

            for (int cardNumber = 0; cardNumber < numberOfCards; cardNumber++){

                handCards.add(deck.drawCard(0)); //always choose top card
            }
    }

    private void playCards() {
        Player firstPlayer;
        Player secondPlayer;

        if (humanPlayerHasTurn) {
            firstPlayer = humanPlayer;
            secondPlayer = artificialPlayer;
        }
        else {
            firstPlayer = artificialPlayer;
            secondPlayer = humanPlayer;
        }

        Card firstCard = firstPlayer.chooseCard();
        Card secondCard = secondPlayer.chooseCard();

        GameUI.printChosenCard(firstPlayer.playerName, firstCard);
        GameUI.printChosenCard(secondPlayer.playerName, secondCard);

        if (trumpChecker(firstCard, secondCard)) {
            secondPlayer.stackCards.add(firstCard);
            secondPlayer.stackCards.add(secondCard);

            GameUI.printTrumpText(secondPlayer.playerName);

            if (deck.getLength() > 1) {
                handoutCards(secondPlayer.handCards, 1);
                handoutCards(firstPlayer.handCards, 1);
            }
            else if (deck.getLength() == 1) {
                handoutCards(secondPlayer.handCards, 1);
                firstPlayer.handCards.add(this.atoutCard);
            }

            humanPlayerHasTurn = secondPlayer.equals(humanPlayer);
        }
        else {
            firstPlayer.stackCards.add(firstCard);
            firstPlayer.stackCards.add(secondCard);

            GameUI.printTrumpText(firstPlayer.playerName);

            if (deck.getLength() > 1) {
                handoutCards(firstPlayer.handCards, 1);
                handoutCards(secondPlayer.handCards, 1);
            }
            else if (deck.getLength() == 1) {
                handoutCards(firstPlayer.handCards, 1);
                secondPlayer.handCards.add(this.atoutCard);
            }

            humanPlayerHasTurn = !secondPlayer.equals(humanPlayer);
        }
    }

    private int calculatePoints(List<Card> stackCards) {
        int points = 0;

        for (Card card : stackCards){
            points += card.getValue();
        }

        return points;
    }
    //checks if second Card is a trump
    private boolean trumpChecker(Card firstCard, Card secondCard) {
        if (atoutCard.getColor().equals(firstCard.getColor()) &&  !atoutCard.getColor().equals(secondCard.getColor())) {
            return false;
        }
        else if ( !atoutCard.getColor().equals(firstCard.getColor()) && atoutCard.getColor().equals(secondCard.getColor())) {
            return true;
        }
        else return firstCard.getColor().equals(secondCard.getColor()) && firstCard.getValue() < secondCard.getValue();
    }
}
