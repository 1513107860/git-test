package LinearTable.Single;

class Node{//定义一个节点类
    public int value;//定义一个值域 整型
    public Node next;//定义一个next域 Node类型 因为next指向下一个节点的地址
    //构造方法 用于初始化对象
    public Node(int value){
        this.value = value;
    }
}

public class LinkedList {
    public Node head;//单链表头节点的引用 在链表内定义一个表头head

    //1.生成一个单链表
    public void createLinkedList(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        this.head = node1;
    }

    //2.打印链表
    public void show(){
        //cur当前节点
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.value+" ");
            //指针移到下一个位置
            cur= cur.next ;
        }
        System.out.println();
    }

    //3.得到链表长度
    public int size(){
        int count = 0;
        Node cur = this.head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        System.out.println("链表长度为："+count);
        return count;
    }

    //4.头插法 把新节点插入链表头部
    public void addFirst(int data){
        Node node = new Node(data);//定义一个插入的新节点
        node.next = this.head;//当前head地址赋值给新节点的next指向下一个位置
        this.head = node;//把head指针换给新节点
    }

    //5.尾插法 把新节点插入链表尾部
    public void addLast(int data){
        Node node = new Node(data);
        if (head == null){ //判断链表是否为空 如果为空下方cur.next会报错
            this.head = node;
            return;
        }
        Node cur = this.head;
        //把指针指到最后
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }

    //6.任意位置插入 第一个数据节点为0下标
    public boolean addIndex(int index,int data){
        if (index < 0 || index > size()){//先判断index位置合法性
            System.out.println("插入位置错误！");
            return false;
        }
        if (index == 0){//特殊位置 插入0位置 即头插法
            addFirst(data);
            return true;
        }
        if (index == size()){//特殊位置 插入末尾 即尾插法
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = findIndex(index);//找index-1位置的节点 即插入点左侧
        node.next = cur.next;//新节点next默认为null 给其赋值cur.next即所插入位置的右侧
        cur.next = node;//新节点node赋值给左侧的cur.next
        return true;
    }

    //为方便实现6. 写一个查找index-1位置的节点
    public Node findIndex(int index){
        Node cur = this.head;
        while (index-1 != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //7.查找是否包含key是否在单链表中
    public boolean contains(int key){
        Node cur = this.head;
        while (cur.next != null){
            if (cur.value == key){
                System.out.println("该链表包含"+key);
                return true;
            }
            cur = cur.next;
        }
        System.out.println("链表不包含"+key);
        return false;
    }

    //8.删除第一次出现的key的节点
    public void remove(int key){
        Node cur = this.head;
        if (contains(key)){
            if (this.head.value == key){//判断第一个值是否为key
                this.head = this.head.next;
                return;
            }
            while (cur.next != null){
                if (cur.next.value == key){
                    cur.next = cur.next.next;
                    System.out.println("删除成功");
                    return;
                }
            }
        }
        else {
            System.out.println("删除失败");
        }
    }

    //9.删除所有值为key的节点 只遍历链表一次
    public void removeAllKey(int key){
        if (this.head == null){
            System.out.println("链表为空！");
            return;
        }
        Node prev = this.head;//定义一个cur.value的前驱
        Node cur = this.head.next;//从第二个开始遍历
        while (cur != null){
            if (cur.value == key){
                prev.next = cur.next;
            } else{
                prev = cur;
            }
            cur = cur.next;
        }
        if (this.head.value == key)//第一个值就是key的情况
            this.head = this.head.next;
    }

    //10.清空链表
    public void clear(){
        this.head = null;//粗暴方法
    }

}