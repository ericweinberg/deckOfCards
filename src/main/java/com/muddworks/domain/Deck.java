package com.muddworks.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A representation of a deck of cards.  A deck is composed of 52 cards, which breaks out to
 * 4 suits of 13 cards each numbered ace, 2...10, jack, queen, king.
 * <p>
 * Created by eweinberg
 */
public class Deck {

  private List<Card> cards = new ArrayList<>(52);

  public Deck() {
    for (Suit suit : Suit.values()) {
      for (int i = 1; i <= 13; i++) {
        cards.add(new Card(suit, i));
      }
    }
  }

  /**
   * Optionally returns a Card. If no cards are left in the deck, then no cards are returned.
   */
  public Optional<Card> dealOneCard() {
    if (cards.size() > 0) {
      return Optional.of(cards.remove(0));
    } else {
      return Optional.empty();
    }
  }

  /**
   * Get all of the Cards in this deck
   *
   * @return all of the cards
   */
  List<Card> getCards() {
    return cards;
  }
}
