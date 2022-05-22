package Sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] a=new int[]{49,38,65,97,76,13,27,49};
        int n=a.length;
        SelectSort1(a,n);
    }

    static void SelectSort1(int[] a,int n){
        //一共进行n-1趟排序
        int i,min,j;
        int temp;//中间变量
         for (i=0;i<n-1;i++){
             min=i;  //记录最小元素位置
             //在a[i...n-1]中选择最小的元素
             for (j=i+1;j<n;j++){
                 if (a[j]<a[min]){
                     min=j;
                 }
             }
             if(min!=i){
                 temp=a[i];
                 a[i]=a[min];
                 a[min]=temp;
             }

             System.out.print("第"+i+"排序:");
             for (int c=0;c<n;c++) {
                 System.out.print(a[c]+" ");
             }
             System.out.println();
         }
    }
}
