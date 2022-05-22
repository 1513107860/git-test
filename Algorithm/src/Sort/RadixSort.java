package Sort;

public class RadixSort {
    private static void radixSort(int[] array,int d)
    {
        int n=1;//代表位数对应的数：个1,十10,百100...
        int k=0;//保存每一位排序后的结果用于下一位的排序输入
        int length=array.length;//获取形参传入数组的长度
        //这里用的二维数组
        int[][] bucket=new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] order=new int[length];//用于保存每个桶里有多少个数字
        while(n<d)
        {
            //这里面需要想象力想象存储过程，小伙伴们可以自己在草稿本上画一下
            for(int num:array) //将数组array里的每个数字放在相应的桶里
            {
                int digit=(num/n)%10; //第一轮获每个数的取个位，第二轮十位数字，第三轮千位数字.....
                bucket[digit][order[digit]]=num;  //digit:横排从左到右，从大到小第几个桶子  order[digit]:列，桶子里存储的数
                order[digit]++;//桶子移到下一个位置为存储下一个数字做准备
            }
            for(int i=0;i<length;i++)//从第一个桶子开始查找，将前一个循环生成的桶（就是二维数组内对应列里的值）里的数据覆盖到原数组中用于保存这一位的排序结果
            {
                if(order[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                {
                    for(int j=0;j<order[i];j++)
                    {
                        array[k]=bucket[i][j];//将二维数组里面存放的数值保存到原数组
                        k++;
                    }
                }
                order[i]=0;//将桶里计数器置0，用于下一次位排序
            }
            n*=10;
            k=0;//将k置0，用于下一轮保存位排序结果
        }

    }
    public static void main(String[] args)
    {
        int[] A=new int[]{73,22, 93, 43, 55, 14, 28, 65, 39, 81};
        radixSort(A, 100);
        for(int num:A)
        {
            System.out.print(num+" ");
        }
    }
}
