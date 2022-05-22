class ListNode {
    //数据域
    public int val;
    //指针
    public ListNode next;
    //初始化值
    public ListNode(int val) {
        this.val = val;
    }
}

public class Deque {
    public ListNode head;//头结点
    public ListNode last;//尾节点

    //在双端队列头那边添加节点变成新的头结点
    //在第一个节点处添加一个节点
    public void addFirst(int val) {
        //创建对象初始化值建立新节点
        ListNode node = new ListNode(val);
        //判断尾节点是否为空
        if (this.last == null) {
            //若为空就是头结点尾节点都是这个新创建的节点
            this.head = node;
            this.last = node;
        }
        //node成为新的头节点
        node.next = this.head;
        this.head = node;
    }

    //在双端队列尾那边添加节点变成新的尾节点
    //在节点的最后添加一个节点
    public void addLast(int val) {
        //创建对象初始化值建立新节点
        ListNode node = new ListNode(val);
        //判断尾节点是否为空
        if (this.last == null) {
            //若为空就是头结点尾节点都是这个新创建的节点
            this.head = node;
            this.last = node;
        }
        //node成为新的尾节点
        this.last.next = node;
        this.last = node;
    }

    //从头结点那边拿出Deque的一个节点
    public int offerFirst() {
        //判断头节点是否为空，如果是就输出！
        if (this.head == null) {
            System.out.println("!");
            return -1;
        }
        //如果不为空，把头结点指向的值拿出来
        int oldValue = this.head.val;
        //判断头结点尾节点是否重合，如果重合就表明双端队列为空
        if (this.head == this.last) {
            this.head = null;
            this.last = null;
        } else {
            //没有重合就接着找下一个节点变成新的头结点
            this.head = this.head.next;
        }
        return oldValue;
    }

    //从尾结点那边拿出Deque的一个节点
    public int offerLast() {
        //判断尾节点是否为空，如果就输出！
        if (this.last == null) {
            System.out.println("!");
            return -1;
        }
        // //如果不为空，把尾结点指向的值拿出来
        int oldValue = this.last.val;
        //判断头结点尾节点是否重合，如果重合就表明双端队列为空
        if (this.head == this.last) {
            this.last = null;
            this.head = null;
        } else {
            //遍历找到新的尾节点
            ListNode cur = this.head;
            while (cur.next != last) {
                cur = cur.next;
            }
            //把找到的最后一个节点做为尾节点
            this.last = cur;
            //尾节点.next=null
            this.last.next = null;
        }
        return oldValue;
    }

    //获取Deque处第一个节点的值
    public int peekFirst() {
        //判断头结点是否为空，是就输出！
        if (this.head == null) {
            System.out.println("!");
            return -1;
        }
        //返回头结点值
        return this.head.val;
    }

    //获取Deque上最后一个节点的值
    public int peekLast() {
        //判断尾结点是否为空，是就输出！
        if (this.last == null) {
            System.out.println("!");
            return -1;
        }
        //返回尾结点值
        return this.last.val;
    }

    //Check whether the Deque is empty
    public boolean empty() {
        return this.head == null;
    }

    public void display(){
        ListNode cur =head;
        while (cur!=last) {
            System.out.println(cur.val);
            cur = cur.next;
        }
        System.out.println(cur.val);
    }
}
