/*
 * @author Ryan Scherbarth
 * cs251L
 * 4/13/23
 */
public class NumberCard extends Card {
  private int number;

  public NumberCard(Color cardColor, int number) {
    super(cardColor);
    this.number = number;
  }

  @Override
  public void doAction(Game game) {
    /*
     * should just need to check if matchValue is true
     */
    if (this.matchValue(game.getTopCard())) {
      game.playCard(this);
    }
  }

  @Override
  public boolean matchValue(Card other) {
    /*
     * cards match if they have:
     * - same color
     * - same number
     *
     * Start by returning true if any of the cards are wild.
     *
     * First check if colors match, if not we check if the instance of other is a
     * numberCard
     * if it isn't, we know that the numbers can't match, so its false. If it is,
     * then we
     * have to create a new NumberCard object so we can access .number, compare the
     * numbers
     * and check if they match in this way.
     */
    if (other instanceof WildCard || other instanceof WildDraw4Card) {
      return true;
    }

    if (this.getCardColor() == other.getCardColor()) { // Case: Colors match
      return true;
    } else if (other instanceof NumberCard) { // Check if 'other' is a number card
      NumberCard otherNumberCard = (NumberCard) other;
      if (this.number == otherNumberCard.number) { // Case: Colors don't match, numbers do match
        return true;
      }
    }
    return false; // Case: Nothing matches
  }

  @Override
  public String strRep() {
    return Integer.toString(number);
  }
}
