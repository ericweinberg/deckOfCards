package com.muddworks.domain;

import com.muddworks.exception.DomainConstraintViolation;

/**
 * Representation of a card. A card has a face value and a suit.
 * <p>
 * Created by eweinberg
 */
public class Card {
  private Suit suit;
  //values are 1 through 13 where 1, 11,12,13 are ace, jack, queen, king respectively
  private int value;

  public Card(Suit suit, int value) {
    if (value < 1 || value > 13) {
      throw new DomainConstraintViolation(String.format("Expecting value to be 1 through 13, but was %s", value));
    }
    this.value = value;
    this.suit = suit;
  }

  public Suit getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Card card = (Card) o;

    if (value != card.value) return false;
    return suit == card.suit;
  }

  @Override
  public int hashCode() {
    int result = suit.hashCode();
    result = 31 * result + value;
    return result;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Card{");
    sb.append("suit=").append(suit);
    sb.append(", value=").append(value);
    sb.append('}');
    return sb.toString();
  }
}
