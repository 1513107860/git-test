package LinearTable.Stack;

import java.util.Arrays;
/**
 * 数组实现栈
 * @param <T>
 */
class Mystack1<T> {
    //实现栈的数组
    private Object[] stack;
    //数组大小
    private int size;
    //初始化数组
    Mystack1() {
        stack = new Object[10];//初始容量为10
    }

    //判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //返回栈顶元素
    public T peek() {
        T t = null;
        if (size > 0)
            t = (T) stack[size - 1];
        return t;
    }

    //入栈
    public void push(T t) {
        expandCapacity(size + 1);
        stack[size] = t;
        size++;
    }

    //出栈
    public T pop() {
        //移到栈顶，准备出栈
        T t = peek();
        if (size > 0) {
            stack[size - 1] = null;
            size--;
        }
        return t;
    }

    //如果栈满了就需要扩大容量
    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 2;//每次扩大一倍
            //Java里面数组扩大的方法Arrays.copyOf()
            stack = Arrays.copyOf(stack, size);
        }
    }
}

public class ArrayStack {
    public static void main(String[] args) {
        Mystack1<String> stack = new Mystack1<>();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push("java");
        stack.push("is");
        stack.push("beautiful");
        stack.push("language");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}
