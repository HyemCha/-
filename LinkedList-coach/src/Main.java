public class Main {
    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("1");

        System.out.println(myLinkedList.get(0));

        myLinkedList.delete(1);

        for (Object data :
                myLinkedList) {
            System.out.println(data);
        }
    }
}