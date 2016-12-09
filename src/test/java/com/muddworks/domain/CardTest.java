package com.muddworks.domain;

import com.muddworks.exception.DomainConstraintViolation;
import org.junit.Test;

import static com.muddworks.domain.Suit.CLUBS;
import static com.muddworks.domain.Suit.HEARTS;
import static com.muddworks.domain.Suit.SPADES;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test suite for {@link Card}
 * Created by eweinberg
 */
public class CardTest {

  @Test
  public void testConstructor() {
    Card card = new Card(CLUBS, 4);
    assertThat(4, is(card.getValue()));
    assertThat(CLUBS, is(card.getSuit()));
  }

  @Test(expected = DomainConstraintViolation.class)
  public void testLowerValueBound() {
    new Card(HEARTS, -32);
  }

  @Test(expected = DomainConstraintViolation.class)
  public void testUpperValueBound() {
    new Card(HEARTS, 14);
  }

  @Test
  public void testFaceValues() {
    Card ace = new Card(SPADES, 1);
    assertThat(ace.getFaceValue(), is("Ace"));

    Card jack = new Card(SPADES, 11);
    assertThat(jack.getFaceValue(), is("Jack"));

    Card queen = new Card(SPADES, 12);
    assertThat(queen.getFaceValue(), is("Queen"));

    Card king = new Card(SPADES, 13);
    assertThat(king.getFaceValue(), is("King"));

  }
}
