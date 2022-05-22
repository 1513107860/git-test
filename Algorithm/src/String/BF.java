package String;

import java.util.Scanner;

public class BF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String t = sc.nextLine();
        int s=BFindex(string, t, 0);
        if (s!=-1){
            System.out.println("匹配成功");
        }else {
            System.out.println("匹配失败");
        }
    }
        public static int BFindex(String S, String T, int start){
            //start为匹配的起始位置
            int i = start, j = 0, v;
            //判断下标不越界
            while (i < S.length() && j < T.length()) {
                //如果相等
                if (S.charAt(i) == T.charAt(j)) {
                    i++;
                    j++;
                } else {
                    //如果不相等，回溯，重新比较，这里的逻辑是i回到的位置
                    i = i - j + 1; //i的下一个，已经比较了j次，所以是i-j+1
                    j = 0;
                }
            }
            //判断索引的长度最终是否等于子串的长度
            if (j == T.length()) { //匹配成功
                v = i - j;
            }
            else v = -1; //匹配失败
            return v;
        }
}
