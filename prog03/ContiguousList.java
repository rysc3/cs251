import java.util.Arrays;
import java.util.Collection;

public class ContiguousList implements ListInterface<String> {
    // DO NOT EDIT CODE FROM HERE
    // Array backing the list
    private String[] elements;
    // Current number of elements in the array
    private int count;

    public ContiguousList() {
        elements = new String[10];
        count = 0;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
    // TO HERE

    // TODO: Implement ListInterface methods
    @Override
    public void prepend(String e) {

    }

    @Override
    public void append(String e) {

    }

    @Override
    public void insert(int index, String e) {

    }

    @Override
    public void empty() {

    }

    @Override
    public boolean has(String e) {
        return false;
    }

    @Override
    public String retrieve(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String delete(int index) {
        return null;
    }

    @Override
    public boolean delete(String e) {
        return false;
    }

    @Override
    public boolean deleteAll(Collection<?> c) {
        return false;
    }

    @Override
    public String mutate(int index, String e) {
        return null;
    }

    @Override
    public int length() {
        return 0;
    }

    // TODO: Implement toString and equals
}
