package at.fhcampuswien;

public class GameUI {

    public static void printAtoutCard(Card atoutCard){
        System.out.println("The atout card is: " + atoutCard.getColor() + " " + atoutCard.getValue().getKey());
    }

    public static void printTrumpText(String playerName) {
        System.out.println(playerName + " trumped!");
        System.out.print(System.lineSeparator());
    }
}
