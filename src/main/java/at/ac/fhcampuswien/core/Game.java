package at.ac.fhcampuswien.core;

import at.ac.fhcampuswien.core.cards.Card;
import at.ac.fhcampuswien.gui.GameUI;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int POINTS_TO_FINISH_GAME = 66;
    public static final int GAME_SCORE_OPPONENT_NO_TRUMP = 3;
    public static final int MAX_POINTS_OPPONENT_DOUBLE_SCORE = 33;
    public static final int GAME_SCORE = 1;
    public static final int SCORE_TO_WIN = 7;
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
    public boolean forceColor;
    public int humanPlayerPoints;
    public int artificialPlayerPoints;

    public static void printplayInstructions() {
        //TODO: print how this game works - like user intactions etc.
    }

    public Game() {
        super(); //call superclass constructor
    }

    public void run() {
        GameUI.showWelcomeScreen();

        this.artificialPlayer = new ArtificialPlayer("Computer");
        this.humanPlayer = new HumanPlayer("You");
        do {
            setupGameRound();

            //print the atout card
            GameUI.printAtoutCard(this.atoutCard);

            mainGame();

            humanPlayerPoints = calculatePoints(humanPlayer.stackCards);
            artificialPlayerPoints = calculatePoints(artificialPlayer.stackCards);

            GameUI.printPointsFinished(humanPlayer.playerName, humanPlayerPoints);
            GameUI.printPointsFinished(artificialPlayer.playerName, artificialPlayerPoints);

            if (humanPlayerPoints > artificialPlayerPoints) {
                GameUI.printWinnerText(humanPlayer.playerName);
                humanPlayer.setScoredPoints(humanPlayer.getScoredPoints() + calculateGamePoints(artificialPlayer));
            } else {
                GameUI.printWinnerText(artificialPlayer.playerName);
                artificialPlayer.setScoredPoints(artificialPlayer.getScoredPoints() + calculateGamePoints(humanPlayer));
            }
            GameUI.printGamePointsOfPlayer(humanPlayer);
            GameUI.printGamePointsOfPlayer(artificialPlayer);
        }
        while (humanPlayer.getScoredPoints() < SCORE_TO_WIN && artificialPlayer.getScoredPoints() < SCORE_TO_WIN);
    }

    private void setupGameRound() {
        //Creates a new card deck and shuffles it
        deck = new Deck();
        deck.shuffle();

        //select human player as first dealer (can be improved later)
        humanPlayerIsDealer = true;
        humanPlayerHasTurn = true;
        cardsAvailable = true;
        forceColor = false;
        humanPlayer.stackCards = new ArrayList<>();
        artificialPlayer.stackCards = new ArrayList<>();

        //select 5 cards, create 2 players and set them as their handCards, while also removing this cards from the current deck. also chooses atout card.
        setupHandout();
    }

    private void mainGame() {

        while (cardsAvailable) {
            //GameUI.printHandCards(humanPlayer.handCards);
            playCards();
            if (humanPlayer.handCards.size() < 1) {
                cardsAvailable = false;
            }
            if (calculatePoints(humanPlayer.stackCards) >= POINTS_TO_FINISH_GAME ||
                    calculatePoints(artificialPlayer.stackCards) >= POINTS_TO_FINISH_GAME) {
                break;
            }
            GameUI.printCurrentPoints(artificialPlayer.playerName, calculatePoints(artificialPlayer.stackCards));
            GameUI.printCurrentPoints(humanPlayer.playerName, calculatePoints(humanPlayer.stackCards));
        }
    }

    private void setupHandout() {
        List<Card> humanHandCards = new ArrayList<>(); //create new empty list of cards
        List<Card> artificialHandCards = new ArrayList<>(); //create new empty list of cards

        //handout first set of deal cards, opponent always gets the cards first
        if (humanPlayerIsDealer) {
            handoutCards(artificialHandCards, NUMBER_OF_FIRST_DEAL_CARDS);
            handoutCards(humanHandCards, NUMBER_OF_FIRST_DEAL_CARDS);
        } else {
            handoutCards(humanHandCards, NUMBER_OF_FIRST_DEAL_CARDS);
            handoutCards(artificialHandCards, NUMBER_OF_FIRST_DEAL_CARDS);
        }

        //choose atout card
        this.atoutCard = deck.drawCard(0);

        //handout second set of deal cards, opponent always gets the cards first
        if (humanPlayerIsDealer) {
            handoutCards(artificialHandCards, NUMBER_OF_SECOND_DEAL_CARDS);
            handoutCards(humanHandCards, NUMBER_OF_SECOND_DEAL_CARDS);
        } else {
            handoutCards(humanHandCards, NUMBER_OF_SECOND_DEAL_CARDS);
            handoutCards(artificialHandCards, NUMBER_OF_SECOND_DEAL_CARDS);
        }
        this.artificialPlayer.setHandCards(artificialHandCards);
        this.humanPlayer.setHandCards(humanHandCards);
    }

    private void handoutCards(List<Card> handCards, int numberOfCards) {

        for (int cardNumber = 0; cardNumber < numberOfCards; cardNumber++) {

            handCards.add(deck.drawCard(0)); //always choose top card
        }
    }

    private void playCards() {
        Player firstPlayer;
        Player secondPlayer;

        if (humanPlayerHasTurn) {
            firstPlayer = humanPlayer;
            secondPlayer = artificialPlayer;
        } else {
            firstPlayer = artificialPlayer;
            secondPlayer = humanPlayer;
        }

        setCardsPlayableFlag(firstPlayer.handCards, true);
        Card firstCard = firstPlayer.chooseCard(atoutCard);
        GameUI.printChosenCard(firstPlayer.playerName, firstCard);

        if(forceColor) {
            secondPlayer.handCards = determinePlayableCards(secondPlayer.handCards, atoutCard, firstCard);
        }

        Card secondCard = secondPlayer.chooseCard(atoutCard, firstCard);
        GameUI.printChosenCard(secondPlayer.playerName, secondCard);

        if (trumpChecker(firstCard, secondCard, this.atoutCard)) {
            secondPlayer.stackCards.add(firstCard);
            secondPlayer.stackCards.add(secondCard);

            GameUI.printTrumpText(secondPlayer.playerName);

            if (deck.getLength() > 1) {
                handoutCards(secondPlayer.handCards, 1);
                handoutCards(firstPlayer.handCards, 1);
            } else if (deck.getLength() == 1) {
                handoutCards(secondPlayer.handCards, 1);
                firstPlayer.handCards.add(this.atoutCard);
            }

            humanPlayerHasTurn = secondPlayer.equals(humanPlayer);
        } else {
            firstPlayer.stackCards.add(firstCard);
            firstPlayer.stackCards.add(secondCard);

            GameUI.printTrumpText(firstPlayer.playerName);

            if (deck.getLength() > 1) {
                handoutCards(firstPlayer.handCards, 1);
                handoutCards(secondPlayer.handCards, 1);
            } else if (deck.getLength() == 1) {
                handoutCards(firstPlayer.handCards, 1);
                secondPlayer.handCards.add(this.atoutCard);
                forceColor = true;
            }

            humanPlayerHasTurn = !secondPlayer.equals(humanPlayer);
        }
    }

    public int calculatePoints(List<Card> stackCards) {
        int points = 0;

        for (Card card : stackCards) {
            points += card.getValue();
        }

        return points;
    }

    private int calculateGamePoints(Player loserPlayer) {
        int looserPoints = calculatePoints(loserPlayer.stackCards);
        if (looserPoints == 0) {
            return GAME_SCORE_OPPONENT_NO_TRUMP;
        } else if (looserPoints <= MAX_POINTS_OPPONENT_DOUBLE_SCORE) {
            return GAME_SCORE * 2;
        } else {
            return GAME_SCORE;
        }
    }

    //checks if second Card is a trump
    public static boolean trumpChecker(Card firstCard, Card secondCard, Card atoutCard) {
        if (atoutCard.getColor().equals(firstCard.getColor()) && !atoutCard.getColor().equals(secondCard.getColor())) {
            return false;
        } else if (!atoutCard.getColor().equals(firstCard.getColor()) && atoutCard.getColor().equals(secondCard.getColor())) {
            return true;
        } else
            return firstCard.getColor().equals(secondCard.getColor()) && firstCard.getValue() < secondCard.getValue();
    }

    public List<Card> determinePlayableCards(List<Card> handCards, Card atoutCard, Card playedCard) {

        setCardsPlayableFlag(handCards, false);
        boolean playableCardsAvailable = false;

        for (Card card : handCards) {
            if (atoutCard.getColor().equals(card.getColor()) && atoutCard.getColor().equals(playedCard.getColor())) {
                card.isPlayable = true;
            }
            if (playedCard.getColor().equals(card.getColor())) {
                card.isPlayable = true;
            }
        }

        for (Card card : handCards) {
            if (card.isPlayable) {
                playableCardsAvailable = true;
                break;
            }
        }

        if (!playableCardsAvailable) {
            setCardsPlayableFlag(handCards, true);
        }

        for (Card card : handCards) {
            if (atoutCard.getColor().equals(card.getColor())) {
                card.isPlayable = true;
            }
        }

        return handCards;
    }

    public static void setCardsPlayableFlag(List<Card> cards, boolean isPlayable) {
        for (Card card : cards) {
            card.isPlayable = isPlayable;
        }
    }

}
