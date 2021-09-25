package at.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class Game {
    //This is the class for the game setup and logic.
    private Deck deck;
    private List<Player> players;
    private Card adoutCard;
    public static final int NUMBER_OF_PLAYERS = 2;
    public static final int NUMBER_OF_HAND_CARDS = 5;

    public static void printplayInstructions() {
        //TODO: print how this game works - like user intactions etc.
    }

    public Game() {
        super(); //call superclass constructor

        //Creates a new card deck
        deck = new Deck();

        //TODO: shuffle deck

        //select 5 cards, create 2 players and set them as their handCards, while also removing this cards from the current deck
        players = new ArrayList<>();
        handoutCards();


        //TODO: select atoutCard from Deck (eg the card on index 0)

        //TODO: print current adoutcard

        //TODO: randomPlayCards -> create Function for playing Cards

        //TODO: calculate game result & print
    }

    private void handoutCards() {
        //TODO: [not needed] implement alternating way of handing out cards
        Player player;
        for(int playerIndex = 0; playerIndex < NUMBER_OF_PLAYERS; playerIndex++){

            List<Card> handCards = new ArrayList<>(); //create new empty list of cards
            for (int cardNumber = 0; cardNumber < NUMBER_OF_HAND_CARDS; cardNumber++){
                handCards.add(deck.drawCard(0)); //always choose top card
            }
            if (playerIndex == 0){
                player = new ArtificialPlayer(handCards);
            } else {
                player = new HumanPlayer(handCards);
            }
            players.add(player);
        }
    }
}
