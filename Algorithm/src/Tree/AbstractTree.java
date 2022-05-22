package Tree;

/**
 * 二叉树
 *
 * @author hh
 */

//抽象类
public abstract class AbstractTree {
    //节点个数
    public int count = 0;

    /**
     * 查询
     *
     * @return
     */
    public abstract Node find(int o);

    /**
     * 插入
     *
     * @param o
     */
    public abstract boolean insert(int o);

    /**
     * 删除
     *
     * @param o
     */
    public abstract boolean delete(int o);

    /**
     * 节点个数
     *
     * @return
     */
    public int count() {
        return this.count;
    }
}