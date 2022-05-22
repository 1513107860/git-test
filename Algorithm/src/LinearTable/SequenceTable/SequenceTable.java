package LinearTable.SequenceTable;

public class SequenceTable {
    public static void main(String[] args) {
        SequenceImpl sequence=new SequenceImpl();
        sequence.Sequence();
        //你可以插入你想插入的数据
        for (int i = 0; i < 10; i++) {
            sequence.add(i,i);
        }
        System.out.println("在长度为10的数组范围内插入数据：");
        sequence.display();

        //扩容
        for (int i = 10; i < 20; i++) {
            sequence.add(i,i);
        }
        System.out.println("扩容：");
        sequence.display();

        //插入数据
        System.out.println("随机位置插入数据：");
        sequence.add(9,"list");
        sequence.display();

        //查找数据
        System.out.println("search查找一个数据："+sequence.search("list"));
        System.out.println("contains查找一个数据："+sequence.contains("list"));

        //查找某一个位置对应的值
        System.out.println("查找某一个位置对应的值："+sequence.getPos(9));

        //删除下标为key的一个数据
        System.out.println("删除下标为key的一个数据："+sequence.remove(8));
        sequence.display();

        //顺序表的长度
        System.out.println("得到顺序表的长度:"+sequence.size());
    }
}
