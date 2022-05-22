package Sort;

public class ExchangeSort {
    public static void main(String[] args) {
        int[] a=new int[]{49,38,65,97,76,13,27,49};
        int n=a.length;
        BubbleSort(a,n);
    }
    static void BubbleSort(int a[],int n){
        int i,j;
        int temp;
        boolean flag;
        //进行n-1趟排序，例如  5个数只要循环比较4趟
        for (i=0;i<n-1;i++){
            //这里是从后往前进行比较,比较n-1趟
            for(j=0;j<n-i-1;j++){
                //从前往后循环比较，先找出最大值放后面
                if (a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }

            for (int c=0;c<n;c++){
                System.out.print(a[c]+" ");
            }
            System.out.println("第"+ i +"排序");

        }
    }
}
