package com.muddworks.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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

  /**
   * Kind of hard to test the shuffle here. Just want to make sure that we're not in the same order as before, although
   * that's  technically  a possibility. Someone better at math can figure out the odds.
   */
  @Test
  public void testShuffle() {
    Deck deck = new Deck();
    List<Card> cards = deck.getCards();
    assertThat(cards.size(), is(52));
    deck.shuffle();
    List<Card> shuffledCards = deck.getCards();
    assertThat(shuffledCards.size(), is(52));
    assertFalse(Arrays.equals(cards.toArray(), shuffledCards.toArray()));
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
    boolean[] cardFound = new boolean[13];
    cards.forEach(card -> {
      cardFound[card.getValue()-1] = true;
    });
    for(boolean it : cardFound) {
      if(!it) {
        fail();
      }
    }
  }
}
