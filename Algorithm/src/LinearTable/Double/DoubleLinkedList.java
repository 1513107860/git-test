package LinearTable.Double;

class Node2{
    public int value;//值
    public Node2 next;//后指针
    public Node2 prev;//前指针
    //提供构造方法，进行赋值操作
    public Node2(int value) {
        this.value = value;
    }

}
class DoubleLinkedList {
    public Node2 head;//在双向链表内定义一个表头head 谁的属性定义在谁的类中
    public Node2 last;//定义一个表尾last

    //1.生成一个双向链表
    public void createList(){
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        Node2 node4 = new Node2(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        this.last = node4;//表尾
        node4.prev = node3;
        node3.prev = node2;
        node2.prev = node1;
        this.head = node1;//表头
    }

    //2.打印链表
    public void display(){
        //从头节点开始遍历
        Node2 cur = this.head;
        while (cur != null){
            System.out.print(cur.value+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //3.得到链表长度
    public int size(){
        int count = 0;
        Node2 cur = this.head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        System.out.println("链表长度为："+count);
        return count;
    }

    //4.头插法
    public void addFirst(int data){
        Node2 node2 = new Node2(data);
        if (this.head == null){
            this.head = node2;
            this.last = node2;
        }
        else {
            node2.next = this.head;
            this.head.prev = node2;
            this.head = node2;
        }
    }

    //5.尾插法
    public void addLast(int data){
        Node2 node2 = new Node2(data);
        if (this.head == null){
            this.head = node2;
            this.last = node2;
        }else {
            this.last.next = node2;
            node2.prev = this.last;
            this.last = node2;
        }
    }

    //6.任意位置插入 第一个数据节点为0下标
    public boolean addIndex(int index,int data){
        if (index < 0 || index > size()){
            System.out.println("插入位置不合法！");
            return false;
        }
        if (index == 0){
            addFirst(data);
            return true;
        }
        if (index == size()){
            addLast(data);
            return true;
        }
        Node2 cur = this.head;
        Node2 node2 = new Node2(data);//定义应插入的新节点
        while (index != 0 ){
            cur = cur.next;
            index--;
        }
        //此时cur走到待插入位置 即插入点右侧
        node2.next = cur;
        cur.prev.next = node2;
        node2.prev = cur.prev;
        cur.prev = node2;
        return true;
    }

    //7.查找是否包含key是否在双链表中
    public boolean contains(int key){
        Node2 cur = this.head;
        while (cur != null){
            if (cur.value == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //8.删除第一次出现的key的节点
    public void remove(int key){
        Node2 cur = this.head;
        if (contains(key)){
            while (cur.value != key){
                cur = cur.next;
            }//找到所删除的节点 接下来判断节点位置
            //节点在头部同时也在尾部 即只有一个节点
            if (cur == this.head && cur.next ==null){
                clear();
                return;
            }
            if (cur == this.head){//节点在头部
                cur.next.prev = null;
                this.head = this.head.next;
                return;
            }
            if (cur.next ==null){//节点在尾部
                cur.prev.next = null;
                this.last = this.last.prev;
                return;
            }
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
        }else {
            System.out.println("不包含"+key+"  删除失败！");
        }
    }


    //9.删除所有值为key的节点
    public void removeAllKey(int key){
        int count = 0;
        while (contains(key)){
            remove(key);
            count++;
        }
        if (count != 0){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败！");
        }


    }

    //10.清空链表
    public void clear(){
        //this.head = null;不可以  因为是双向链表 它还被后面所指向
        while (this.head != null){//循环遍历 每一个节点的prev和next都要置为空
            Node2 cur = this.head.next;//循环内部定义 改变cur
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
        }
        this.last = null;//循环遍历完后 记住还有last也要置为空
        System.out.println("清空！");
    }

}