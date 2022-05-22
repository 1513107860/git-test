package Sort;

public class InsertSort {

    public static void main(String[] arg) {
        int[] a=new int[] {49,38,65,97,76,13,27};
        int n=a.length;
        InsertSort2(a,n);
    }

    static void InsertSort(int a[],int n) {
        int i,j,temp;
        int h=1;
        // 第1个数只有一个数无法比较  肯定是有序的,所以从第二个数才开始遍历去比较
        for(i=1;i<n;i++) {
            // 取出第i个数，和前i-1个数比较后，插入合适位置
            if(a[i]<a[i-1]) {
                //取一个中间变量存值
                temp=a[i];
                for(j=i-1;j>=0&&a[j]>temp;--j) {
                    // 因为前i-1个数都是从小到大的有序序列，所以只要当前比较的数(list[j])比temp大，就把这个数后移一位
                    //例如：i=2,就是第二次排序，如果a[1]>temp=a[2] 则进入循环交换 a[2]=a[1],--j 后 如果a[0]>temp 则进入循环交换 a[1]=a[0]
                    a[j+1]=a[j];
                }
                //因为--j,所以得加回来
                // 例如：取i=1的时候  49 和 38 比较，循环下来就是 如果a[1]<a[0]  temp=a[1] a[1]=a[0] a[1]=temp
                a[j+1]=temp;
            }

            //遍历打印每一次插入排序的结果
            for(int c=0;c<n;c++) {
                System.out.print(a[c]+" ");
            }

            //第几次排序
            System.out.println("第"+ h++ +"次排序");

        }
    }

   static void InsertSort1(int a[],int n) {
        int i,j,low,high,mid,temp;
        int h=1;
        for (i=1;i<n;i++){
            //将a[i]暂存到中间变量，从第二个数开始与前面的数开始依次比较并排序
            temp=a[i];
            low=0;high=i-1;
            //判断low是否小于high,如果小于则执行while循环
            while(low<=high){
                mid=(low+high)/2;
                //取中间索引位置与temp比较,不断寻找它要插入的位置，知道不满足low<high退出循环
                if (a[mid]>temp) high=mid-1;
                else low=mid+1;
            }
            //位置寻找完毕，开始进行数据插入，然后进行到下一个最外层的for循环
            for (j=i-1;j>=high+1;--j){
                a[j+1]=a[j];
            }
            a[high+1]=temp;

            //遍历打印每一次插入排序的结果
            for(int c=0;c<n;c++) {
                System.out.print(a[c]+" ");
            }

            //第几次排序
            System.out.println("第"+ h++ +"次排序");
        }
   }

   static void InsertSort2(int a[],int n){
        //dk是步长
        int dk,i,j;
        //中间转换变量
        int temp;
        //获取步长，步长随着每次循环逐渐减小,n是数组的长度
        for (dk=n/2;dk>=1;dk=dk/2){
            //开始比较每个相隔步长dk的两个数
            for (i=dk;i<n;++i){
                //比较a[i]<a[i-dk]，例如步长为4的话第一次比较就是判断a[3]<a[0]
                if (a[i]<a[i-dk]){
                    //暂存在temp
                    temp=a[i];
                    //这里注意j>=0,和王道考研数据结构有差别，他总是a[0]不放值，作为中间变量
                     for (j=i-dk;j>=0&&temp<a[j];j-=dk){
                         //循环插入值，例如a[3]=a[0]
                         a[j+dk]=a[j];
                     }
                     //中间变量赋值插入刚才被覆盖的a[j+dk]
                     a[j+dk]=temp;
                }

            }
            //遍历打印每一次希尔排序的结果
            for(int c=0;c<n;c++) {
                System.out.print(a[c]+" ");
            }

            //第几次排序
            System.out.println("步长为："+dk);

        }
   }
}
