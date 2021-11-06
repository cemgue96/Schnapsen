package at.ac.fhcampuswien.gui;

import at.ac.fhcampuswien.core.Player;
import at.ac.fhcampuswien.core.cards.Card;

import java.util.List;
import java.util.Scanner;

public class GameUI {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void printAtoutCard(Card atoutCard){
        System.out.println("The atout card is: " + atoutCard.getColor() + " " + atoutCard.getName());
    }

    public static void printText(String text) {
        System.out.println(text);
    }
    
    public static void printHandCards(List<Card> handCards) {
        System.out.print("Your hand cards are: ");
        for (Card card : handCards) {
            System.out.print(card.getColor() + card.getName() + " ");
        }
        System.out.print(System.lineSeparator());
    }

    public static void printPointsFinished(String playerName, int points) {
        System.out.println(playerName + " gathered " + points + " points!");
    }

    public static void printCurrentPoints(String playerName, int points) {
        System.out.println("Current points " + playerName + ": " + points);
    }

    public static void printWinnerText(String playerName) {
        System.out.println(playerName + " won the game!");
    }

    public static void printChosenCard(String playerName, Card card) {
        System.out.println(playerName + " played the card: " + card.getColor() + card.getName());
    }

    public static void printTrumpText(String playerName) {
        System.out.println(playerName + " trumped!");
        System.out.print(System.lineSeparator());
    }

    public static Card selectCardToPlay(List<Card> handCards) {
        System.out.println("Choose next Card to play: ");
        int selectedCardIndex = -1;

        for(int i = 0; i < handCards.size(); i++) {
            Card card = handCards.get(i);
            if(card.isPlayable) {
                System.out.print(ANSI_CYAN + "[" + i + ": " + handCards.get(i) + "] " + ANSI_RESET);
            } else {
                System.out.print(ANSI_RED + handCards.get(i) + " " + ANSI_RESET);
            }
        }
        System.out.print("\n");

        //TODO: error could be that user does not select a right index
        boolean rightSelection = false;
        while (!rightSelection) {
            Scanner cardIndexScanner = new Scanner(System.in);
            selectedCardIndex = cardIndexScanner.nextInt();

            //TODO: check if card is actually playable
            if(selectedCardIndex >= 0 && selectedCardIndex < handCards.size() && handCards.get(selectedCardIndex).isPlayable) {
                rightSelection = true;
            } else {
                System.out.println("Please select allowed index!");
            }
        }

        return handCards.get(selectedCardIndex);
    }

    public static void showWelcomeScreen() {
        GameUI.printText("-----------------------------------------------------");
        GameUI.printText("♠♣♥♦       SCHNAPSEN - let's play a game!       ♠♣♥♦");
        GameUI.printText("-----------------------------------------------------");
    }

    public static void printGamePointsOfPlayer(Player player) {
        System.out.println(player.getPlayerName() + " scored " + player.getScoredPoints() + " points!");
    }
}

