package com.muddworks.domain;

import com.muddworks.exception.DomainConstraintViolation;
import org.junit.Test;

import static com.muddworks.domain.Suit.CLUBS;
import static com.muddworks.domain.Suit.HEARTS;
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
}
