package Sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] a=new int[]{49,38,65,97,76,13,27,49};
        int n=a.length;

        Quicksort0(a,0,n-1);

        for (int c=0;c<n;c++){
            System.out.print(a[c]+" ");
        }
        System.out.println();
    }
    static void Quicksort0(int[] a,int low,int high){
        if (low<high){//递归跳出条件
            //Partition()就是划分操作，将表a[low.....high]划分为满足上述条件的两个子表
            int pivotpos=Partition(a,low,high);  //划分
            Quicksort0(a,low,pivotpos-1);   //依次对两个子表进行递归排序，这是比枢轴元素小的一边
            Quicksort0(a,pivotpos+1,high);  //这是比枢轴元素大的一边
        }

    }

    //一趟划分
    static int Partition(int[] a, int low, int high) {
        int pivot=a[low];   //枢轴
        while(low<high){
            while (low<high&&a[high]>=pivot) --high;
            a[low]=a[high]; //将比枢轴小的元素移动到左端
            while (low<high&&a[low]<=pivot)  ++low;
            a[high]=a[low]; //将比枢轴大的元素移动到右端
        }
        a[low]=pivot;
        return low;
    }
}
