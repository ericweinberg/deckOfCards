package com.muddworks.service;

import com.muddworks.domain.Card;
import com.muddworks.domain.Deck;

import java.util.Optional;

/**
 * Service for interacting with a {@link Deck}
 * <p>
 * Created by eweinberg
 */
public class DeckService {
  private Deck deck;

  public DeckService() {
    deck = new Deck();
  }

  /**
   * Shuffle the deck.
   */
  public void shuffle() {
    deck.shuffle();
  }

  /**
   * Deal one card from the deck.
   *
   * @return a {@link Card}
   */
  public Optional<Card> dealOneCard() {
    return deck.dealOneCard();
  }

  /**
   * Reset to a full Deck.
   */
  public void resetDeck() {
    deck = new Deck();
  }
}
