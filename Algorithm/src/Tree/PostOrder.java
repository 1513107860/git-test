package Tree;

public class PostOrder {
        //存储数据节点的数组
        private int[] array;

        public PostOrder(int[] array) {
            this.array = array;
        }
        //后序遍历入口
        public void postOrder() {
            postOrder(0);
        }

        /**
         * 后序遍历
         * @param index
         */
        private void postOrder(int index) {
            //如果数组为空或数组.length==0
            if (array == null || array.length == 0) {
                System.out.println("数组为空，不能按照二叉树的前序遍历！");
            }
            //向左递归遍历
            if ((index * 2 + 1) < array.length) {
                postOrder(2 * index + 1);
            }

            //向右递归遍历
            if ((index * 2 + 2) < array.length) {
                postOrder(2 * index + 2);
            }

            //输出当前这个元素
            System.out.print(array[index]+" ");
        }

    }
