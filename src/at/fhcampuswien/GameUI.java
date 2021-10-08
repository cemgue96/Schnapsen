package at.fhcampuswien;

public class GameUI {

    public static void printAtoutCard(Card atoutCard){
        System.out.println("The atout card is: " + atoutCard.getColor() + " " + atoutCard.getValue().getKey());
    }

    public static void printChosenCard(String playerName, Card card) {
        System.out.println(playerName + " played the card: " + card.getColor() + card.getValue().getKey());
    }

}
