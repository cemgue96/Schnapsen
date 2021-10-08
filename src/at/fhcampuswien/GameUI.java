package at.fhcampuswien;

public class GameUI {

    public static void printAtoutCard(Card atoutCard){
        System.out.println("The atout card is: " + atoutCard.getColor() + " " + atoutCard.getValue().getKey());
    }


    public static void printPoints(String playerName, int points) {
        System.out.println(playerName + " gathered " + points + " points!");
    }

    public static void printWinnerText(String playerName) {
        System.out.println(playerName + " won the game!");
    }
}
