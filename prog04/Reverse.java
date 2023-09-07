/*
 * @author Ryan Scherbarth
 * cs251L
 * 4/13/23
 */
public final class Reverse extends Card {
  public Reverse(Color cardColor) {
    super(cardColor);
  }

  /**
   * This function calls the reverse function
   * on the UnusIterator
   *
   * @param game
   *             TODO: Implement this
   */
  @Override
  public void doAction(Game game) {

  }

  @Override
  public boolean matchValue(Card other) {
    return other instanceof Reverse;
  }

  @Override
  public String strRep() {
    return "Rev";
  }
}
