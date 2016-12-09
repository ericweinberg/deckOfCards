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
  public void testDealOne() {
    Deck deck = new Deck();
    assertThat(deck.dealOneCard().isPresent(), is(true));
    assertThat(deck.getCards().size(), is(51));
  }

  @Test
  public void testDealAllCards() {
    Deck deck = new Deck();
    for (int i = 0; i < 52; i++) {
      deck.dealOneCard();
    }
    //assert that there are no cards left in the deck
    assertThat(deck.getCards().size(), is(0));
    assertThat(deck.dealOneCard().isPresent(), is(false));
  }

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
