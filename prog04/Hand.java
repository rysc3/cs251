
/*
 * @author Ryan Scherbarth
 * cs251L
 * 4/8/23
 */
import java.util.Arrays;
import java.util.List;

public final class Hand {
  private final List<Card> cards;

  public Hand(List<Card> cards) {
    this.cards = cards;
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public int numCardsRemaining() {
    return cards.size();
  }

  public Card getCard(int index) {
    return cards.get(index);
  }

  /**
   * This function does the following:
   * - Gets the current card using index
   * - Plays the current card
   * - Removes the current card from cards
   *
   * @param game  State of the game
   * @param index Index of desired card to play in cards
   * @throws Card.CannotPlayCardException
   *                                      (Done) Implement this
   */
  public void playCard(Game game, int index) throws Card.CannotPlayCardException {
    // Invalid input given
    if (index < 0 || index > numCardsRemaining()) {
      throw new Card.CannotPlayCardException();
    }
    Card playedCard = cards.get(index); // get current card
    if (playedCard.match(game.getTopCard())) { // if valid card is given
      game.playCard(playedCard); // play card
      /*
       * easier to handle this after the card has been played, since we can get the
       * top card
       * as many times as we want but its more work to get the card out of the users
       * hand.
       * need to then figure out if the card was a special card,
       * Draw 2, 4
       * Skip
       * Reverse
       *
       * and if so, pass the info to unusIterator
       */
      cards.remove(index); // remove from hand
    } else {
      throw new Card.CannotPlayCardException();
    }
  }

  /**
   * This function checks to see if your hand has any
   * matches to the given card
   *
   * @param topCard Card currently in play
   * @return true if match is found and false otherwise
   *         (Done) Implement this
   */
  public boolean noMatches(Card topCard) {
    for (Card c : cards) {
      /*
       * Actual card matching takes place in Card,
       * this just calls card.
       *
       * We loop through each card in our hand to check if one is
       * playable, if so return true
       */
      if (c.match(topCard)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Prints out your current hand's cards horizontally.
   * This is accomplished by calling the Card::prettyPrint
   * function on all cards in your hands. The prettyPrint function
   * transforms each card into a List<String> where each element of
   * the list represents a line of output for that card. You must then
   * Append all the first lines together seperated by a space
   * then all the second lines seperated by spaces
   * etc.
   * You must then put an index label under each card that
   * is centered between each card.
   * Then put a new line below
   * Then return the String you constructed
   * For example if your hand consisted of a red reverse and a blue skip
   * then your output would look like:
   * /-------\ /-------\
   * | R |Rev| | B | S |
   * \-------/ \-------/
   * 0 1
   *
   * @return
   *         (Done) Implement this
   */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();

    // Find the maximum number of lines in all the cards
    int maxLines = 0;
    for (Card c : this.cards) {
      int numLines = c.prettyPrint().size();
      if (numLines > maxLines) {
        maxLines = numLines;
      }
    }

    // Append each line of output for all cards, separated by spaces
    for (int i = 0; i < maxLines; i++) {
      for (Card c : this.cards) {
        List<String> prettyPrintedCard = c.prettyPrint();
        if (i < prettyPrintedCard.size()) {
          str.append(prettyPrintedCard.get(i));
        } else {
          str.append("      "); // Use spaces of equal width
        }
      }
      str.append("\n");
    }

    // Print index labels
    str.append("    " + "0");
    for (int i = 1; i < cards.size(); i++) {
      str.append("        " + i);
    }
    str.append("\n");

    return str.toString();
  }

  // lol didn't see this til now
  // Code you can use to test your implementation
  public static void main(String[] args) {
    Hand hand = new Hand(Arrays.asList(new Reverse(Card.Color.RED),
        new Skip(Card.Color.BLUE)));
    String handStr = hand.toString();
    System.out.println(handStr);
  }
}
