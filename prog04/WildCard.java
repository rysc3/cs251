/*
 * @author Ryan Scherbarth
 * cs251L
 * 4/13/23
 */
public class WildCard extends Card {

  public WildCard() {
    super(Card.Color.WILD);
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
     * if color matches
     * if another wild card
     *
     * this function should just always return true;
     */
    // wild always matches
    if (this instanceof WildCard || other instanceof WildCard || other instanceof WildDraw4Card) {
      return true;
    }
    return false;
  }

  @Override
  public String strRep() {
    return "W";
  }
}
