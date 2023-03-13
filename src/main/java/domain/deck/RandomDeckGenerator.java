package domain.deck;

import domain.card.Card;
import domain.card.Denomination;
import domain.card.Suits;
import java.util.ArrayDeque;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
=======
import java.util.Deque;
>>>>>>> parent of 4eabeaf (fix: 덱의 카드가 랜덤으로 정렬되게 수정)

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
