/*
 * @author Ryan Scherbarth
 * cs251
 * 3/29/23
 */
public class DrawN extends Card {
  private final int n;

  public DrawN(Color cardColor, int n) {
    super(cardColor);
    this.n = n;
  }

  public int getN() {
    return n;
  }

  /**
   * Makes the next player draw n cards
   *
   * @param game Current game state
   */
  @Override
  public void doAction(Game game) {
    Player currentPlayer = game.getPlayers().current();
    Deck deck = game.getDeck();
    try {
      if (this.getN() == 4) {
        for (int i = 0; i < 4; i++) {
          Card card = deck.drawCard();
          currentPlayer.hand.addCard(card);
        }
        game.getPlayers().next();
      } else {
        game.getPlayers().next();
        Player nextPlayer = game.getPlayers().current();
        for (int i = 0; i < this.getN(); i++) {
          Card card = deck.drawCard();
          nextPlayer.hand.addCard(card);
        }
      }
    } catch (Deck.EmptyDeckException e) {
      // Do something when the deck is empty
    }
  }

  /**
   * Checks if other has the same value as this
   *
   * @param other Other card to match against
   * @return true if other is an instanceof DrawN and our n equals their n, false
   *         otherwise
   */
  @Override
  public boolean matchValue(Card other) {
    // Check card color and card value
    return (other instanceof DrawN) && (this.getN() == ((DrawN) other).getN())
        && (this.getCardColor() == other.getCardColor());
  }

  @Override
  public String strRep() {
    return "D+" + n;
  }
}
