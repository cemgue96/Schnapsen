package at.ac.fhcampuswien.core;

import at.ac.fhcampuswien.core.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArtificialPlayer extends Player {
    public ArtificialPlayer(List<Card> handCards, String playerName) {
        super(handCards, playerName);
    }

    //TODO: implement algorithm on which an artificalPlayer generates

    @Override
    public Card chooseCard(Card atout, Card firstPlayedCard) {
        //Ki spielt den niedrigst möglichen Stich
        //Wenn Atout wird atout gespielt
        //Sonst wird die niedrigste Karte gespielt

        List<Card> cardsWhichWouldTrump = new ArrayList<>();

        for(Card card : handCards) {
            if(firstPlayedCard.getColor().equals(card.getColor())) {
                if (firstPlayedCard.getValue() < card.getValue())
                    cardsWhichWouldTrump.add(card);
            }
        }

        if (cardsWhichWouldTrump.size() > 0) {
            Collections.sort(cardsWhichWouldTrump);

            handCards.remove(cardsWhichWouldTrump.get(0));
            return cardsWhichWouldTrump.get(0);

        } else {
            return chooseCard(atout);
        }
    }

    @Override
    public Card chooseCard(Card atoutCard) {
        List<Card> cardWithSameColorAsAtout = new ArrayList<>();

        for(Card card: handCards) {
            if(atoutCard.getColor().equals(card.getColor())) {
                cardWithSameColorAsAtout.add(card);
            }
        }

        if (cardWithSameColorAsAtout.size() > 0 ) {
            Collections.sort(cardWithSameColorAsAtout);

            handCards.remove(cardWithSameColorAsAtout.get(0));
            return cardWithSameColorAsAtout.get(0);
        } else {
            return chooseCard();
        }
    }

    @Override
    public Card chooseCard() {
        Collections.sort(handCards);

        Card chosenCard = handCards.get(0);
        handCards.remove(0);
        return chosenCard;
    }
}
