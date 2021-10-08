package at.fhcampuswien;

import java.util.*;

import static java.util.Map.entry;

public class Deck {

    public static final List<String> COLOURS =
            new ArrayList<>(Arrays.asList("Kreuz", "Pik", "Karo", "Herz"));
    public static final Map<String, Integer> VALUES =
            Map.ofEntries(
                    entry("Ass", 11),
                    entry("Zehner", 10),
                    entry("König", 4),
                    entry("Dame", 3),
                    entry("Bube", 2));

    private List<Card> cards;

    public Deck() {
        super();
        cards = new ArrayList<>();
        _generateDeck();
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public int getLength() {
        return this.cards.size();
    }

    private void _generateDeck(){
        for (String color : COLOURS){
            for (Map.Entry<String, Integer> value : VALUES.entrySet()){
                Card card = new Card(color, value);
                cards.add(card);
            }
        }
    }

    public Card drawCard(int index){
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }
    //public Card removeCard
}
