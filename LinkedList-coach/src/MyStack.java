import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyStack<T> extends MyLinkedList<T> {

    public void push(T data) {
        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            //
            node.setNext(this.head);
            this.head = node;
        }
    }

    public T pop() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        T data = (T) this.head.getData();
        this.head = this.head.getNext();
        return data;
    }

}
