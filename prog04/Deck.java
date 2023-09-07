
/*
 * @author Ryan Scherbarth
 * cs251
 * 3/29/23
 */
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Deck {
  private final List<Card> cards;

  public Deck(List<Card> cards) {
    this.cards = cards;
    shuffleDeck();
  }

  public static class EmptyDeckException extends Exception {
  }

  /**
   * This function does the following:
   * - Checks if cards is empty
   * - If it is then throw a new EmptyDeckException
   * - If not then return and remove the first card in cards
   *
   * @return The top card from the deck
   * @throws EmptyDeckException
   *                            D_TODO: Implement this
   */
  public Card drawCard() throws EmptyDeckException {
    if (cards.size() == 0) { // If deck is empty
      throw new EmptyDeckException(); // Throw exception
    } else { // If deck is not empty
      /*
       * in order to print out a warning when there are only a few cards left,
       * we need to store the card in a variable and then check, rather than
       * just:
       * return cards.remove(0);
       */
      Card newCard = cards.remove(0); // Pos. 0 is top of deck
      if (cards.size() < 5) {
        System.out.println("Less than 5 cards remain in the deck.");
      }
      return newCard;
    }
  }

  public void shuffleDeck() {
    Collections.shuffle(this.cards);
  }

  public void addCards(Collection<Card> cards) {
    this.cards.addAll(cards);
    shuffleDeck();
  }
}
