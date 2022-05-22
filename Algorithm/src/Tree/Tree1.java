package Tree;
        /*
        先了解顺序存储二叉树的特点
        顺序二叉树的实现用完全二叉树的特性
        第n个元素的左子结点为2n+1
        第n个元素的右子结点为2n+2
        第n个元素的父结点为（n+1）/2
        n代表二叉树的第几个元素，从0开始（和数组一样）
        (index * 2 + 1) < arr.length 表示为左部分
        (index * 2 + 2) < arr.length表示为右部分
        */

public class Tree1 {
        public static void main(String[] args) {
            int[] array = {1, 2, 3, 4, 5, 6, 7};

            PreOrder pre=new PreOrder(array);
            InfixOrder infix=new InfixOrder(array);
            PostOrder post=new PostOrder(array);

            System.out.println("前序遍历");
            pre.preOrder();
            System.out.println();

            System.out.println("中序遍历");
            infix.infixOrder();
            System.out.println();

            System.out.println("后序遍历");
            post.postOrder();
            System.out.println();
        }

}
