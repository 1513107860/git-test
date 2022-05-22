package LinearTable.Queue;


import java.util.Stack;

/**
 * 3.两个堆栈实现一个队列
 *  1.原理分析：
 *  队列的主要操作有两个：入队操作和出队操作，出队时从队头出，入队是从队尾插入，
 *  入队的操作和入栈的操作类似，而最关键的问题是出队操作，要出队列的是队列的第一个元素，
 *  而出栈的是栈的栈顶元素，所以我们可以这样：
 *  假设两个栈A和栈B，A主要用来处理入队操作，B用于处理出队操作。入队操作和入栈操作类似，
 *  直接将元素压入栈即可。出队的时候，实现我们假设栈B为空，则要把栈A的第一个元素（即栈底元素）弹出，
 *  直接从A弹出这是不可能的，但如果我们把栈A里面的元素的顺序逆过来，这样直接用栈弹出栈顶元素即可，
 *  所以我们可以把栈A的元素全部弹出来，并俺顺序压入栈B中，这样每次栈B弹出的栈顶元素就是栈A相对应的栈底元素，就是出队操作。
 *  若B不为空，则代表之前从A复制过来的元素还没有完全弹出，要出栈的时候直接弹出即可。若栈B的元素都弹出来了，就需要从A中补充。
 *
 *  2.总结操作就是：
 *  入队：将元素进栈A
 *  出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；如果不为空，栈B直接出栈。
 *
 */

public class QueueTest3 {
    public static void main(String[] args) {

        System.out.println("3.两个堆栈实现一个队列：");
        Queue2 queue = new Queue2();
        queue.in(1);
        queue.in(2);
        queue.in(3);
        System.out.println(queue.out());
        System.out.println(queue.out());
        queue.in(4);
        System.out.println(queue.out());
        System.out.println(queue.out());
        queue.in(5);
        System.out.println(queue.out());

    }

}

//两个堆栈实现一个队列
class Queue2 {

    //创建栈的对象，一遍可以调用里面的方法
    Stack<Integer> stackA = new Stack<Integer>();
    Stack<Integer> stackB = new Stack<Integer>();

    //调用栈里面自身调用好的方法进行入队
    public void in(int n) {
        stackA.push(n);
    }

    //出队
    public int out() {
        if(stackB.isEmpty()){
            while (stackA.size() > 0) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

}