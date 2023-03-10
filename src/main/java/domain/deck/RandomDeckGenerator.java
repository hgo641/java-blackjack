package domain.deck;

import domain.card.Card;
import domain.card.Denomination;
import domain.card.Suits;
import java.util.ArrayDeque;
import java.util.Deque;

public class RandomDeckGenerator implements DeckGenerator {
    private static void addCard(final Deque<Card> cards, final Suits suits) {
        for (Denomination denomination : Denomination.values()) {
            cards.add(new Card(denomination, suits));
        }
    }

    @Override
    public Deck generateDeck() {
        Deque<Card> cards = new ArrayDeque<>();
        for (Suits suits : Suits.values()) {
            addCard(cards, suits);
        }
        return new Deck(cards);
    }
}
