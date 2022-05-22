package LinearTable.Stack;

/**
 * 链表实现栈
 *
 * @param <T>
 */
class Mystack2<T> {
    //定义链表
    class Node<T> {
        //定义数据类型泛型T
        private T t;
        //定义指针
        private Node next;
    }

    //定义头节点
    private Node<T> head;

    //构造函数初始化头指针
    Mystack2() {
        head = null;
    }

    //入栈
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException("参数不能为空");
        }
        if (head == null) {
            //创造的新节点
            head = new Node<T>();
            head.t = t;
            //next指针指向下一个位置
            head.next = null;
        } else {
            //头节点指向的位置
            Node<T> temp = head;
            //创建新节点
            head = new Node<>();
            head.t = t;
            head.next = temp;
        }
    }

    //出栈
    public T pop() {
        T t = head.t;
        head = head.next;
        return t;
    }

    //栈顶元素
    public T peek() {
        T t = head.t;
        return t;
    }

    //栈空
    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }
}

public class LinkStack {
    public static void main(String[] args) {
        Mystack2 stack = new Mystack2();
        System.out.println(stack.isEmpty());
        stack.push("Java");
        stack.push("is");
        stack.push("beautiful");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
