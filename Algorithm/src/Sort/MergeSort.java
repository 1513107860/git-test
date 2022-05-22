package Sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{49, 38, 65, 97, 76, 13, 27};
        int len = a.length;
        MergeSort(a,0,len-1);

    }

        static int[] b = new int[7];
        static void Merge(int a[], int low, int mid, int high){
            int k,i,j;

            for (k = low; k <= high; k++) {
                //将所有元素复制到b中
                b[k] = a[k];
            }

            for (i = low,j=mid+1,k=i;i<=mid&&j<=high;k++){
                //比较b中的左右两段中的元素
               if(b[i]<=b[j]){
                   //将较小的值复制到a中
                    a[k]=b[i++];
                }else {
                    a[k]=b[j++];
                }
            }
            //若第一个表未检测完，复制
            while (i<=mid) a[k++]=b[i++];
            //若第二个表未检测完，复制
            while (j<=high) a[k++]=b[j++];
        }

        static void MergeSort(int a[], int low, int high){
            if(low<high){
                //从中间划分两个子序列
                int mid=(low+high)/2;
                //对左侧子序列进行递归排序
                MergeSort(a,low,mid);
                //对右侧子序列进行递归排序
                MergeSort(a,mid+1,high);
                //归并
                Merge(a,low,mid,high);

                //输出每次归并排序
                //如果你对每次的排序输出不知道，仔细分析如何递归，代码先后
                //根据代码逻辑知，先输出左边的每次归并排序，在输出右边每次归并排序，最终进行最后一次归并排序
                for (int c=0;c<a.length;c++) {
                    System.out.print(a[c]+" ");
                }
                System.out.println();
            }
        }
}
