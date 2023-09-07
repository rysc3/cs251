/*
 * @author Ryan Scherbarth
 * cs251L
 * 4/13/23
 */
public class WildDraw4Card extends Card {
  public WildDraw4Card() {
    super(Card.Color.WILD); // no card color // EVERY CARD COLOR
  }

  @Override
  public void doAction(Game game) {
    /*
     * should just always be matchable, always playable
     */
    if (this.matchValue(game.getTopCard())) {
      game.playCard(this); // playing his turn first should automatically skip him, then it will give the
                           // next player the cards
      game.getPlayers().current().drawCards(4);
    }
  }

  @Override
  public boolean matchValue(Card other) {
    // So long as it is currently your turn, which is checked elsewhere, you can
    // always play a wild card
    // this function also always returns true
    if (this instanceof WildDraw4Card || other instanceof WildCard || other instanceof WildDraw4Card) {
      return true;
    }
    return false;
  }

  @Override
  public String strRep() {
    // TODO Auto-generated method stub
    return "D+4";
  }
}
