
/*
 * @author Ryan Scherbarth
 * cs251
 * 3/29/23
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Card {
  /*
   * Draw2Card
   * NumberCard
   * ReverseCard
   * SkipCard
   * WildCard
   * WildDraw4Card
   */
  private final Color cardColor;

  public enum Color {
    RED("R"), YELLOW("Y"), BLUE("B"), GREEN("G"), WILD("W");

    private final String strRep;

    Color(String strRep) {
      this.strRep = strRep;
    }

    public boolean match(Color other) {
      return this == WILD || other == WILD || this == other;
    }

    @Override
    public String toString() {
      return strRep;
    }
  }

  public Card(Color cardColor) {
    this.cardColor = cardColor;
  }

  public Color getCardColor() {
    return cardColor;
  }

  public static class CannotPlayCardException extends Exception {
  }

  public abstract void doAction(Game game);

  public abstract boolean matchValue(Card other);

  public abstract String strRep();

  /**
   * Matches two cards according to Unus rules which state that two cards
   * match if they have the same color or the same symbol/numeric value
   *
   * @param other Card to match this card against
   * @return true if the two cards match and false otherwise
   *         (Done) Implement this
   */
  public boolean match(Card other) {
    if (this == other) { // exact match
      return true;
      // if either card is a wild card they can match
    } else if (this.cardColor == Card.Color.WILD || other.cardColor == Card.Color.WILD) {
      return true;
      // if card number matches
    } else if (this.cardColor == other.cardColor || this.strRep().equals(other.strRep())) {
      return true;
    }
    return false;
  }

  public void play(Game game) throws CannotPlayCardException {
    if (!match(game.getTopCard())) {
      throw new CannotPlayCardException();
    }

    doAction(game);
    game.playCard(this);
  }

  public int checkDraw() {
    int draw = 0;
    if (this.strRep().charAt(0) == 'D') {
      // this means it is a draw card
      draw = Integer.parseInt(this.strRep());
    } else {
      return 0;
    }
    return draw;
  }

  /**
   * This function does the following:
   * - Creates a List<String>
   * - Adds the top part of the card to this list which is the following string:
   * "/-------\\"
   * - Then constructs the middle of the card which depends on the length of the
   * strRep()
   * of the current card. If it is length 3 the following string should be
   * constructed and added to the list:
   * "| $getCardColor() |$strRep()|"
   * Otherwise if it is length 1 then the following string should be constructed
   * and added to the list:
   * "| $getCardColor() | $strRep() |"
   * - Then the bottom part of the card is added to the list which is given by the
   * following string:
   * "\\-------/"
   * - This list is then returned
   *
   * @return List of lines of this card
   *         (Done) Implement t his
   */
  public List<String> prettyPrint() {
    List<String> list = new ArrayList<String>();

    list.add("/-------\\");
    if (this.strRep().length() == 3) {
      list.add("| " + this.cardColor + " |" + this.strRep() + "|"); // Spaces with short strRep
    } else if (this.strRep().length() == 2) {
      list.add("| " + this.cardColor + " |" + this.strRep() + " |"); // No space with long strRap
    } else {
      list.add("| " + this.cardColor + " | " + this.strRep() + " |"); // No space with long strRap
    }
    list.add("\\-------/");
    return list;
  }

  @Override
  public final String toString() { // TODO Fix this somehow
    StringBuilder sb = new StringBuilder();

    for (String line : prettyPrint()) {
      sb.append(line).append("\n");
    }

    return sb.toString();
  }
}
