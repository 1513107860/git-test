package Tree1;

public class Node {
    //节点值
    int data;
    Node leftChild;	//左孩子
    Node rightChild ;	//右孩子

    //初始化，无参构造器
    public Node() {
        data = 0;
        leftChild = rightChild  = null;
    }
    //初始化，一参构造函数
    public Node(int value) {
        this.data = value;
        leftChild = rightChild  = null;
    }
}
