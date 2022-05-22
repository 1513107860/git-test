package LoopTable;

public class LinkedList {
    private Node head;//头节点
    private Node tail;//尾节点
    int size;
    //构造器
    public LinkedList(){
        //初始化
        tail = head = null;
        size = 0;
    }

    //在链表头部增加节点
    public void addHead(Node hd){
        //因为是循环链表，如果使用该方法增加链表的第一个节点，则head=tail=hd，且next指向自身。
        if(size==0){//判断是否是空循环单链表
            //因为是循环单链表，所以就是本身指向本身
            hd.setNext(hd);
            //新增节点就是头尾节点
            tail = head = hd;
            //循环链表长度加1
            size++;
        }
        else{
            //尾节点指向新增的那个头节点
            tail.setNext(hd);
            //新增头节点
            hd.setNext(head);
            //把头节点给hd,在链表头部增加的这节点变成新头结点
            head = hd;
            //循环链表长度加1
            size++;
        }
    }

    //在链表尾部增加节点
    public void addTail(Node tl){
        //如果使用该方法增加链表的第一个节点，则tail=head= hd，且next指向自身。
        if(size==0){//判断是否是空循环单链表
            //因为是循环单链表，所以就是本身指向本身
            tl.setNext(tl);
            //新增节点就是头尾节点
            tail = head = tl;
            //循环链表长度加1
            size++;
        }
        else{
            //尾节点指向新增的那个节点，那个节点变成为尾节点
            tail.setNext(tl);
            //新增的那个尾节点指向头节点形成循环闭环
            tl.setNext(head);
            //尾节点给新增的节点tl
            tail = tl;
            //循环链表长度加1
            size++;
        }
    }

    //删除头部节点，被删掉的head将被自动回收
    public void delHead(){
        if(size>1){//判断循环单链表是否长度大于1
            //获取头结点的下一个指向的节点
            head = head.getNext();
            //尾节点指向删除的下一个代替的头结点
            tail.setNext(head);
            //循环链表长度减1
            size--;
        }
        else if(size==1){
            head = tail = null;
            size--;
        }
        else{//空循环链表，删除出错，无法删除
            System.out.println("There is no elements in the linked list.");
        }
    }

    //删除尾部节点
    public void delTail(){
        if(size>1){
            //创建空节点当中间值
            Node nd = new Node();
            //赋为头结点
            nd = head;
            //判断下一个必须是否有元素存在
            while(nd.getNext()!=tail){
                //因为是循环链表，尾节点就是头结点
                nd = nd.getNext();
            }
            //nd.next=head  删除尾节点把下一个节点当成新的头结点
            nd.setNext(head);
            size--;
        }
        else if(size==1){
            head = tail = null;
            size--;
        }
        else{
            System.out.println("There is no elements in the linked list.");
        }
    }

    //打印全部节点
    public void printList(){
        Node nd = new Node();
        nd = head;
        try{
            //判断头结点下一个必须是否有元素存在，不能再指向头结点了，不然死循环
            while(nd.getNext()!=head){
                System.out.print(nd.getData());
                System.out.print("->");
                nd = nd.getNext();
            }
            System.out.print(nd.getData());
            System.out.print("->");
            System.out.print(head.getData());
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}