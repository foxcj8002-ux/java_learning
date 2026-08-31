package week01;

import java.util.Arrays;

public class Day04 {
    public static void main(String[] args) {
        //初始化数组
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int[] arr1 = {1,2,3,4,5};
        arr1[3] = 8;
        for(int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        /*
         * 复制数组
         */
        int[] n1 = {2,4,5,7,9,10};
        int[] n3 = new int[5];

        int[] n2 = new int[n1.length];
        //将整个n1数组复制到n2
        System.arraycopy(n1,0,n2,0,n1.length);
        System.out.println("n2 = " + Arrays.toString(n2));
        //从n1数组的索引2复制元素
        //将元素复制到n3数组的索引1
        //将复制2个元素
        System.arraycopy(n1,2,n3,1,2);
        System.out.println("n3 = " + Arrays.toString(n3));

        int[] source = {2, 3, 12, 4, 12, -2};
        int[] destination1 = Arrays.copyOfRange(source,0,source.length);
        System.out.println(Arrays.toString(destination1));

        int[] destination2 = Arrays.copyOfRange(source,2,5);
        System.out.println(Arrays.toString(destination2));
    }
}
