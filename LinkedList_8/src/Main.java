public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> ml = new MyLinkedList<>();
        ml.add("hello");
        ml.add("hello1");
        ml.add("hello2");
        String a = ml.get(1);
        System.out.println("a = " + a);
        ml.retrieve();
        System.out.println("a = " + a);
        ml.retrieve();
    }
}