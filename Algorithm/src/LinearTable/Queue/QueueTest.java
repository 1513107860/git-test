package LinearTable.Queue;

public class QueueTest {
    public static void main(String[] args){

        //测试队列
        System.out.println("数组实现队列：");
        Queue queue = new Queue();
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

//使用数组定义一个队列
class Queue {

    int[] a = new int[5];
    int i = 0; //数组下标

    //入队
    public void in(int m){
        a[i++] = m;
    }

    //出队，先进先出
    public int out(){
        int index = 0;
        int temp = a[0];
        for(int j=1;j<i;j++){
            a[j-1] = a[j];
            index++;
        }
        i = index;
        return temp;
    }

}
