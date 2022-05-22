package LinearTable.Double;

public class DoubleList {
    public static void main(String[] args) {
        DoubleLinkedList list=new DoubleLinkedList();

        //创建链表
        list.createList();
        //打印链表
        list.display();
        //添加元素
        list.addIndex(3,8);
        //打印链表
        list.display();
        //移除元素
        list.remove(2);
        //打印链表
        list.display();
    }

}
