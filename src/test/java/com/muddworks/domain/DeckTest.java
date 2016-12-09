package com.muddworks.domain;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Suite for the {@link Deck}
 * <p>
 * Created by eweinberg
 */
public class DeckTest {

  @Test
  public void testInitialization() {
    Deck deck = new Deck();
    assertThat(deck.getCards().size(), is(52));
  }

  @Test
  public void testHearts() {
    Deck deck = new Deck();
    verifySuit(deck, Suit.HEARTS);
  }

  @Test
  public void testClubs() {
    Deck deck = new Deck();
    verifySuit(deck, Suit.CLUBS);
  }

  @Test
  public void testSpades() {
    Deck deck = new Deck();
    verifySuit(deck, Suit.SPADES);
  }

  @Test
  public void testDiamonds() {
    Deck deck = new Deck();
    verifySuit(deck, Suit.DIAMONDS);
  }

  private void verifySuit(Deck deck, Suit suit) {
    List<Card> cards = deck.getCards().stream().filter(it -> it.getSuit() == suit).collect(Collectors.toList());
    for (int i = 1; i <= 13; i++) {
      assertThat(cards.get(i - 1).getValue(), is(i));
    }
  }
}
