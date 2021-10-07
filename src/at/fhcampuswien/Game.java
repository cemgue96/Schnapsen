package at.fhcampuswien;

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

    public static void printplayInstructions() {
        //TODO: print how this game works - like user intactions etc.
    }

    public Game() {
        super(); //call superclass constructor

        //Creates a new card deck and shuffles it
        deck = new Deck();
        deck.shuffle();

        //select human player as first dealer (can be improved later)
        humanPlayerIsDealer = true;

        //select 5 cards, create 2 players and set them as their handCards, while also removing this cards from the current deck. also chooses atout card.
        setupHandout();

        //print the atout card
        GameUI.printAtoutCard(this.atoutCard);

        GameUI.printHumanPlayerCard(this.humanPlayer);

        //TODO: randomPlayCards -> create Function for playing Cards

        //TODO: calculate game result & print > print should be done in GameInterface
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

        this.artificialPlayer = new ArtificialPlayer(artificialHandCards);
        this.humanPlayer = new HumanPlayer(humanHandCards);

    }

    private void handoutCards(List<Card> handCards, int numberOfCards) {

            for (int cardNumber = 0; cardNumber < numberOfCards; cardNumber++){

                handCards.add(deck.drawCard(0)); //always choose top card
            }
    }

    private int calculatePoints(List<Card> stackCards) {
        return 0;
    }
}
