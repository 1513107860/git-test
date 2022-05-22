package Sort;

public class HeapSort {

    public static void main(String[] args) {

        int[] a=new int[]{0,4,6,8 ,5,9};
        int len=a.length-1;

        Sort(a,len);

    }

    //建立大根堆
    static void BuildMaxHeap(int a[],int len){
        for (int i=len/2;i>0;i--){
            //从i=[n/2]~1,反复调整堆
            HeadAjust(a,i,len);
        }
    }

    static void HeadAjust(int a[],int k,int len){
        //a[0]不存放值，用来作为中间转换值，存放堆的值放a[1]至a[n]内
        a[0]=a[k];
        //函数HeadJust将元素k为根的子树进行调整
        for (int i=2*k;i<=len;i*=2){
            //沿着key较大的子节点向下筛选
            //比较左子节点与右节点大小
            if (i<len&&a[i]<a[i+1]){
                //取key较大的子节点的下标
                i++;
            }
            if (a[0]>=a[i]){
                break;
            }else {
                //将a[i]调整到双亲节点上
                a[k]=a[i];
                //修改k值，以便继续向下筛选
                k=i;
            }
        }
        a[k]=a[0];
    }

    static void Sort(int[] a,int len){
        int temp;
//        建立初始堆
        BuildMaxHeap(a,len);
        //n-1趟建堆和交换过程
        for (int i=len;i>1;i--){
            //堆顶与堆底元素进行交换
            temp=a[i];
            a[i]=a[1];
            a[1]=temp;
            //调整，把剩余的i-1个元素整理成堆
            HeadAjust(a,1,i-1);
            for(int j=1;j<=len;j++) {
                System.out.print(a[j]+" ");
            }
            System.out.println();
        }
    }
}
