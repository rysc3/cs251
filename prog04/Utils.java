/*
 * @author Ryan Scherbarth
 * cs251L
 * 4/13/23
 */
import java.util.ArrayList;
import java.util.List;

public final class Utils {
  public static <T> List<T> repeat(int n, T item) {
    List<T> ls = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      ls.add(item);
    }
    return ls;
  }
}
