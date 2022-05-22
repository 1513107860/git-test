package LinearTable.Single;

public class SingleListNode {
    public static void main(String[] args) {
    LinkedList list=new LinkedList();

    //创建链表
        list.createLinkedList();
        //任意位置插入值
        list.addIndex(2,6);
        //查看是否包含key
        list.contains(5);
        //删除2
        list.remove(2);
    //打印单链表
        list.show();
    //链表长度
        list.size();

    }

}
