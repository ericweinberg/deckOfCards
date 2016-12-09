package com.muddworks;

import com.muddworks.domain.Card;
import com.muddworks.service.DeckService;

import java.util.Optional;

/**
 * Created by eweinberg
 */
public class Application {

  public static void main(String[] args) {
    DeckService deckService = new DeckService();

    int cardIndex = 0;
    boolean done = false;
    while (!done) {
      Optional<Card> card = deckService.dealOneCard();
      if (card.isPresent()) {
        cardIndex++;
        System.out.println(card.get());
      } else {
        done = true;
      }
    }
    System.out.println(String.format("Printed out %s cards", cardIndex));
  }
}
