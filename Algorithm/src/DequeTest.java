public class DequeTest {
    public static void main(String[] args) {
        Deque deque=new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.display();
        deque.offerFirst();
        System.out.println();
        deque.display();
    }
}
