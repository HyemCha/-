import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyLinkedList<T>{

    Node header;

    static class Node<T>{
        T data;
        Node next = null;
    }

    MyLinkedList() {
        header = new Node<>();
    }

    void add(T data) {
        Node<T> end = new Node<>();
        end.data = data;
        Node<T> n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    // index로 삭제
    void delete(int index) {
        int cnt = 0;
        Node n = header;
        while (n.next != null) {
            if (cnt == index) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
            cnt++;
        }
    }

    // index로 검색
    T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> n = header.next;

        int cnt = 0;
        while (cnt != index){
            cnt++;
            n = n.next;
        }

        return (T) n.data;
    }

    void retrieve() {
        Node<T> n = header.next;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print(n.data);
        System.out.println();
    }

    public Iterator<T> iterator(){
        return new IteratorHelper();
    }

    class IteratorHelper implements Iterator<T> {

        Node<T> index;

        public IteratorHelper() {
            index = header;
        }

        @Override
        public boolean hasNext() {
            return (index.next != null);
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            T val = index.data;
            index = index.next;

            return val;
        }
    }
}

