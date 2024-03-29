package at.ac.fhcampuswien.core.cards;

public class CardFactory {

    public static Card getCard(String value, String color) {
        Card card = null;
        switch (value){
            case Card.NAME_ASS: card = new Ass(color); break;
            case Card.NAME_KING: card = new King(color); break;
            case Card.NAME_QUEEN: card = new Queen(color); break;
            case Card.NAME_JACK: card = new Jack(color); break;
            case Card.NAME_TEN: card = new Ten(color); break;
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
        return card;
    }
}
