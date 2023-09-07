import java.util.Collection;

public interface ListInterface<T> {
    // Adds the given element to front of the list
    void prepend(T e);

    // Adds the given element to the end of the list
    void append(T e);

    // Inserts the given element add the given index
    // Shifts all elements after the given index up by 1 index
    // If the index is larger than any index in the list then
    // the element should be inserted at the end of the list
    void insert(int index, T e);

    // Removes all elements from the list
    void empty();

    // Returns true if the given element exists in the list, false otherwise
    boolean has(T e);

    // Retrieves the element at the given index, if the index doesn't exist
    // then return null
    T retrieve(int index);

    // Returns true if the list is empty, false otherwise
    boolean isEmpty();

    // Deletes the element at the given index and returns it,
    // if the index doesn't exist then return null
    T delete(int index);

    // Deletes the first occurrence of an element from the list if it exists,
    // if an element is removed return true, false otherwise
    boolean delete(T e);

    // Deletes all elements within the given collection,
    // this includes duplicates. If it removes an element then return true,
    // otherwise false
    boolean deleteAll(Collection<?> c);

    // Sets the element at the given index to the given element and
    // returns the old element, return null if the index doesn't exist
    T mutate(int index, T e);

    // Returns the current length of the list
    int length();
}