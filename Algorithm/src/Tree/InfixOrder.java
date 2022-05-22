package Tree;

public class InfixOrder {
        //存储数据节点的数组
        private int[] array;

        public InfixOrder(int[] array) {
            this.array = array;
        }
        //中序遍历入口
        public void infixOrder() {
            infixOrder(0);
        }

        /**
         * 中序遍历
         * @param index
         */
        private void infixOrder(int index) {
            //如果数组为空或数组.length==0
            if (array == null || array.length == 0) {
                System.out.println("数组为空，不能按照二叉树的中序遍历！");
            }
            //向左递归遍历
            if ((index * 2 + 1) < array.length) {
                infixOrder(2 * index + 1);
            }
            //输出当前这个元素
            System.out.print(array[index]+" ");
            //向右递归遍历
            if ((index * 2 + 2) < array.length) {
                infixOrder(2 * index + 2);
            }
        }

    }
