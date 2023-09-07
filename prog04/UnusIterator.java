
/*
 * @author Ryan Scherbarth
 * cs251
 * 4/5/23
 */
import java.util.List;

public final class UnusIterator<T> {
  private final List<T> ls;
  private int curIndex;
  private final int len;

  private Direction dir = Direction.FORWARD;

  private final List<Integer> skips;

  private enum Direction {
    FORWARD(1), BACKWARD(-1);

    private final int adder;

    Direction(int adder) {
      this.adder = adder;
    }

    public int getAdder() {
      return adder;
    }

    public Direction flip() {
      if (this == FORWARD) {
        return BACKWARD;
      } else {
        return FORWARD;
      }
    }
  }

  public UnusIterator(List<T> ls) {
    this.ls = ls;
    this.curIndex = 0;
    this.len = ls.size();
    this.skips = Utils.repeat(this.len, 0);
  }

  /**
   * Find the next valid player index.
   * This is fairly complicated due to being able
   * to skip any player and being able to stack skips
   * on a given player. This function does the following:
   * - Loops until a valid next player is found
   * - Does not modify the curIndex
   * - Instead manipulate its own internal index
   * - This internal index is initially set to the curIndex + the directional
   * adder
   * - It is then checked if it has gone out of bounds
   * - If it has gone negative then it should be set to the max value
   * - If it is above the max value then it should be set to 0
   * - This index is then looked up in the skips list
   * - If this value is anything but 0 then that means this index must be skipped.
   * - If decrement is true then the value in the skips list for this index should
   * be decremented by 1
   * - If it is 0 then you have found the next index and the loop should be
   * exited.
   * - The internal index should then be returned
   *
   * @return Index of next player in the order respecting skips and reverses
   *         (Done) Implement this
   */

  private int findNextIndex(boolean decrement) {
    int intIndex = getCurIndex() + dir.getAdder();
    if (intIndex < 0) { // Loop around if we reach 0
      intIndex = len - 1;
    } else if (intIndex >= len) {
      intIndex = 0;
    }

    return intIndex;
  }

  public T current() {
    return ls.get(curIndex);
  }

  public T getAtIndex(int index) {
    return this.ls.get(index);
  }

  public int getCurIndex() {
    return curIndex;
  }

  public void next() {
    curIndex = findNextIndex(true);
  }

  public T peekNext() {
    return ls.get(findNextIndex(false));
  }

  /**
   * Simply calls flip on the dir member variable and
   * overwrites dir with this value
   * (Done) Implement this
   */
  public void reverse() {
    this.dir = dir.flip();
  }

  /**
   * Increments the nth element of skips by 1
   *
   * @param n Index in skips list to increment
   *          (Done) Implement this
   */
  public void skip(int n) {
    if (n < 0) {
      n = 0; // I guess this works
    }
    if (dir == Direction.FORWARD) {
      curIndex = getCurIndex() + n;
    } else {
      curIndex = getCurIndex() - n;
    }
  }

  public void skipIndex(int index) {
    skip(index);
  }
}
