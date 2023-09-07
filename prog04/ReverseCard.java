/*
 * @author Ryan Scherbarth
 * cs251L
 * 4/13/23
 */
public class ReverseCard extends Card {

  public ReverseCard(Card.Color cardColor) {
    super(cardColor);
  }

  @Override
  public void doAction(Game game) {
    if (this.matchValue(game.getTopCard())) { // play the card if valid
      game.playCard(this);
    }
  }

  @Override
  public boolean matchValue(Card other) {
    /*
     * match if:
     * - another reverse card
     * - same color
     */
    if (this.getCardColor() == other.getCardColor()) { // color match
      return true;
    } else if (other instanceof ReverseCard) { // another reverse
      return true;
    }
    return false; // no match
  }

  @Override
  public String strRep() {
    return "Rev";
  }
}
