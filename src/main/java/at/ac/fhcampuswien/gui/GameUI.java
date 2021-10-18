package at.ac.fhcampuswien.gui;

import at.ac.fhcampuswien.core.cards.Card;

import java.util.List;

public class GameUI {

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

    public static void printPoints(String playerName, int points) {
        System.out.println(playerName + " gathered " + points + " points!");
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
}

