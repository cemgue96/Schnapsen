package at.fhcampuswien;

public class GameUI {

    public static void printAtoutCard(Card atoutCard){
        System.out.println("The atout card is: " + atoutCard.getColor() + " " + atoutCard.getValue().getKey());
    }

    public static void printHumanPlayerCard(Player humanPlayer) {
        for (Card card : humanPlayer.handCards) {
            System.out.println(card.getColor());
        }
    }
}
