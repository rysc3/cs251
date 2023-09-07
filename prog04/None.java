/*
 * @author Ryan Scherbarth
 * cs251L
 * 4/13/23
 */
public class None extends Card {

  public None() {
    super(Color.WILD);
  }

  @Override
  public void doAction(Game game) {
  }

  @Override
  public boolean matchValue(Card other) {
    return true;
  }

  @Override
  public String strRep() {
    return "";
  }
}
