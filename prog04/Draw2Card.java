/*
 * @author Ryan Scherbarth
 * cs251L
 * 4/16/23
 */
public class Draw2Card extends Card {

  public Draw2Card(Card.Color cardColor) {
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
    if (other instanceof WildCard || other instanceof WildDraw4Card) {
      return true;
    }

    if (this.getCardColor() == other.getCardColor()) { // same color
      return true;
    } else if (other instanceof Draw2Card) { // also a match card
      return true;
    }
    return false;
  }

  @Override
  public String strRep() {
    return "D+2";
  }
}
