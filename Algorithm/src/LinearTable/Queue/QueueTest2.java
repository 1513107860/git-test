package LinearTable.Queue;

import java.util.*;

/**
 * 2.使用集合实现队列功能，使用int数组保存数据特点：先进先出，后进后出
 */

public class QueueTest2 {
    public static void main(String[] args){

        //测试队列
        System.out.println("集合实现队列：");
        Queue1 queue = new Queue1();
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

//使用集合定义一个队列
class Queue1 {

    List<Integer> list = new ArrayList<Integer>();
    int index = 0;  //下标

    //入队
    public void in(int n){
        list.add(n);
        index++;
    }

    //出队
    public int out(){
        if(!list.isEmpty()){
            index--;
            return list.remove(0);
        }
        return -1;
    }

}