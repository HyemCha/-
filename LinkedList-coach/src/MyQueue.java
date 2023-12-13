import java.util.NoSuchElementException;

public class MyQueue<T> extends MyLinkedList<T> {

    private Node<T> tail;


    public void enQueue(T data) {
        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.setNext(node);
        }
        this.tail = node;
        this.size++;
    }

    public T deQueue() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }

        T data = (T) this.head.getData();
        this.head = this.head.getNext();
        if (this.head == null) {
            this.tail = null;
        }

        this.size--;
        return data;
    }
}
