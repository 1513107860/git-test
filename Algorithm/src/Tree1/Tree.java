package Tree1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    /**
     * 非递归实现树先序，中序，后序递归（栈）
     */
        public static void main(String[] args) {
            Node node4 = new Node(4);
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node5 = new Node(5);
            Node node6 = new Node(6);
            Node node7 = new Node(7);
            node4.leftChild = node2;
            node4.rightChild = node6;
            node2.leftChild = node1;
            node2.rightChild = node3;
            node6.leftChild = node5;
            node6.rightChild = node7;
            System.out.println("=====先序遍历=====");
            preOrder(node4);

            System.out.println("\n=====中序遍历=====");
            midOrder(node4);

            System.out.println("\n=====后序遍历=====");
            latOrder(node4);

            System.out.println("\n=====层序遍历=====");
            floOrder(node4);

        }


        /**
         * 先序遍历
         *     1.先将根节点入栈
         *     2.访问根节点
         *     3.如果根节点存在右孩子，则将右孩子入栈
         *     4.如果根节点存在左孩子，则将左孩子入栈（注意：一定是右孩子先入栈，然后左孩子入栈）
         *     5.重复2-4
         * @param root
         */
        //传入根节点
        public static void preOrder(Node root){
            if (root==null){
                System.out.println("空树");
            }
            //创建栈
            Stack<Node> stack = new Stack<>();
            //进栈
            stack.push(root);
            //判断是否栈是否为空
            while(!stack.isEmpty()){
                //栈顶元素节点赋给temp
                Node temp = stack.pop();
                //输出节点
                System.out.printf(temp.data+" ");
                //判断左孩子是否为空
                if (temp.rightChild!=null){
                    //不为空就进栈
                    stack.push(temp.rightChild);
                }
                ////判断右孩子是否为空
                if (temp.leftChild!=null){
                    //不为空就进栈
                    stack.push(temp.leftChild);
                }

            }
        }

        /**
         * 中序遍历
         *     1.先将根节点入栈
         *     2.将当前节点的所有左孩子入栈，直到左孩子为空
         *     3.访问栈顶元素，如果栈顶元素存在右孩子，则继续第2步
         *     4.重复第2、3步，直到栈为空并且所有的节点都被访问
         * @param root
         */
        public static void midOrder(Node root){
            if (root==null){
                System.out.println("空树");
            }
            Node temp = root;
            Stack<Node> stack = new Stack<>();
            while(temp!=null || !stack.isEmpty()){

                while(temp!=null){
                    stack.push(temp);
                    temp = temp.leftChild;

                }
                temp = stack.pop();
                System.out.printf(temp.data+" ");
                if(temp.rightChild!=null){
                    temp = temp.rightChild;
                }else {
                    temp = null;
                }
            }

        }

        /**
         * 后续遍历
         *     1.根节点入栈
         *     2.将根节点的左子树入栈，直到最左，没有左孩子为止
         *     3.得到栈顶元素的值，先不访问，判断栈顶元素是否存在右孩子，如果存在并且没有被访问，
         *       则将右孩子入栈，否则，
         *       就访问栈顶元素
         * @param root
         */
        public static void latOrder(Node root){
            if (root==null){
                System.out.println("空树");
            }
            Node temp = root;
            Node pre = null;
            Stack<Node> stack = new Stack<>();
            while(temp!=null || !stack.isEmpty()){
                while(temp!=null){
                    stack.push(temp);
                    temp = temp.leftChild;
                }
                if(!stack.isEmpty()){
                    temp = stack.peek();
                    if(temp != null){
                        if(temp.rightChild == null || temp.rightChild == pre){
                            temp = stack.pop();
                            System.out.printf(temp.data+" ");
                            pre = temp;
                            temp = null;
                        }else {
                            temp = temp.rightChild;
                        }
                    }
                }

            }
        }

        /**
         * 层序遍历
         * @param root
         */
        public static void floOrder(Node root){
            if (root==null){
                System.out.println("空树");
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                Node temp = queue.poll();
                System.out.printf(temp.data+" ");
                if (temp.leftChild!=null){
                    queue.offer(temp.leftChild);
                }
                if (temp.rightChild!=null){
                    queue.offer(temp.rightChild);
                }
            }
        }

}
