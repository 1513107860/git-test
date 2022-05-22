package LinearTable.SequenceTable;

import java.util.Arrays;

public class SequenceImpl implements ISequence {
    //定义数组
    private Object[] elem;
    // 有效数据个数
    private int usedSize;
    //定义数组长度
    private static final int DEFAULT_SIZE = 10;

    //初始化数组
    //为什么都用this,因为this指向全局变量数组，不会出现数据混乱，你可以去理清一下什么是全局和局部变量
    public void Sequence() {
        this.elem = new Object[DEFAULT_SIZE];
        this.usedSize = 0;
    }

 /*   在 pos 位置插入 value(数值)
    @param pos:要插入的位置
    @param data:要插入的值
    插入成功返回true，否则返回false
 */

    @Override
    public boolean add(int pos, Object data) {
        //先判断是否满了再判断是否越界，这里面有一个逻辑问题，不能先判断是否越界
        // 1. 判断是否满了，如果满了进行扩容，每次扩容都是双倍增长
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }

        // 2. 判断pos位置的合法性,判断position位置是否越界
        if (pos < 0 || pos >this.elem.length-1) {
            return false;
        }

        // 3. 把pos位置以及之后的数全部向后挪一个位置
        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }

        // 4. 在 pos 位置插入 val
        this.elem[pos] = data;

        // 5. 更新长度
        this.usedSize++;

        return true;
    }

/*    查找关键字 key 找到返回 key 的下标，没有返回 -1
    @param key 关键字的值
    @return 查找成功返回true，失败返回false
*/
    @Override
    public int search(Object key) {
        // 1. 判断是否为空
        if (isEmpty()) {
            return -1;
        }

        // 2. 遍历查找
        for (int i = 0; i < this.elem.length; i++) {
            // 注意：判断条件不能写成：this.elem[i] == key
            if (this.elem[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

/*  查找是否包含相同关键字 key 是否在顺序表当中（这个和search有点冲突）
    @param key 关键字的值
    @return 查找成功返回true，失败返回false
*/
    @Override
    public boolean contains(Object key) {
        // 1. 判断是否为空
        if (isEmpty()) {
            return false;
        }

        // 2. 遍历查找
        for (int i = 0; i < this.elem.length; i++) {
            // 注意：判断条件不能写成：this.elem[i] == key
            if (this.elem[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

/*   得到 pos 位置的值
     @param pos 得到的值的位置
     @return 成功得到 pos位置的值返回true，否则返回false
*/
    @Override
    public Object getPos(int pos) {
        // 1. 判断位置是否合法
        if (pos<0 || pos>=this.elem.length) {
            return null;
        }

        // 2. 位置合法
        return this.elem[pos];
    }

/*   删除第一次出现的关键字 key
     @param key 关键字
     @return
*/
    @Override
    public Object remove(Object key) {
        // 1. 先查表看有没有这个关键字
        // index:关键字下标
        int index = search(key);

        // 2. 若表里没有这个关键字
        if (index == -1) {
            return null;
        }

        // 3. 表里有这个关键字
        Object data = this.elem[index];
        int i;
        // 删除第一次出现的关键字 key,把key后面的数全部向前挪一个位置
        for (i = index; i < this.usedSize; i++) {
            elem[i] = elem[i+1];
        }
        this.usedSize--;
        this.elem[i+1] = null;
        return data;
    }

/*    得到顺序表的长度
    @return 顺序表的长度
*/
    @Override
    public int size() {
        return this.usedSize;
    }

//    打印顺序表
    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

//  清空顺序表以防内存泄漏
    @Override
    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = null;
        }
    }

 /*   判断是否为满
    return 满了返回true,否则返回false
 */
    @Override
    public boolean isFull() {
        return this.elem.length == this.usedSize;
    }

   /* 判断是否为空
    表为空返回true，否则返回false
    */
    @Override
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

}
