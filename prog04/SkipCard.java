/*
 * @author Ryan Scherbarth
 * cs251L
 * 4/13/23
 */
public class SkipCard extends Card {

  public SkipCard(Card.Color cardColor) {
    super(cardColor);
  }

  @Override
  public void doAction(Game game) {
    if (this.matchValue(game.getTopCard())) {
      game.playCard(this);
    }
  }

  @Override
  public boolean matchValue(Card other) {
    /*
     * matches if either:
     * - Color matches
     * - other card is also a skip
     */
    if (this.getCardColor() == other.getCardColor()) { // the correct color
      return true;
    } else if (other instanceof SkipCard) { // another skip
      return true;
    }
    return false; // doesn't match
  }

  @Override
  public String strRep() {
    return "S";
  }
}
