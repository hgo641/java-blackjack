package domain.deck;

import domain.Card;
import java.util.Stack;

public class Deck {
    private final Stack<Card> unusedCards;

    public Deck(Stack<Card> unusedCards) {
        this.unusedCards = unusedCards;
    }

    public Card pickCard() {
        return unusedCards.pop();
    }
}