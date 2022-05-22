package Tree;

public class PreOrder {
        //存储数据节点的数组
        private int[] array;

        public PreOrder(int[] array) {
            this.array = array;
        }
        //前序遍历入口
        public void preOrder() {
            //调用preOrder(int index);
            preOrder(0);
        }
        /**
         * 前序遍历
         * @param index
         */
        public void preOrder(int index) {
            //如果数组为空或数组.length==0
            if (array == null || array.length == 0) {
                System.out.println("数组为空，不能按照二叉树的前序遍历！");
            }
            //输出当前元素
            System.out.print(array[index]+" ");
            //前序遍历特点：从上至下，从左至右

            //向左递归遍历，左子树
            if ((index * 2 + 1) < array.length) {
                preOrder(2 * index + 1);
            }
            //向右递归遍历，右子树
            if ((index * 2 + 2) < array.length) {
                preOrder(2 * index + 2);
            }
        }

    }
