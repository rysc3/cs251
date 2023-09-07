import java.util.Objects;

// TODO: Implement ListInterface
public class ConnectedList<T> {
    // DO NOT EDIT CODE FROM HERE
    private ConnectedList.Node head;

    private class Node {
        private T value;
        private ConnectedList.Node next;

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, ConnectedList.Node next) {
            this.value = value;
            this.next = next;
        }

        public T value() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public ConnectedList.Node next() {
            return next;
        }

        public void setNext(ConnectedList.Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ConnectedList.Node node = (ConnectedList.Node) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
    // TO HERE

    // TODO: Implement ListInterface methods
    // TODO: Implement toString and equals
}
