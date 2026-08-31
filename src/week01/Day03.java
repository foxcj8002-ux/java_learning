package week01;

public class Day03 {
    public static void main(String[] args) {
        //for循环
        int num = 100,sum = 0;
        for( int i = 0;i <= 100;i++) {
            sum += i;
        }
        System.out.println(sum);
        //while循环
        sum = 0;
        while(num != 0) {
            sum += num;
            num--;
        }
        System.out.println(sum);
        //dowhile循环
        sum = 0;
        num = 100;
        do{
            sum += num;
            num--;
        } while (num != 0);
        System.out.println(sum);
        //for-each循环
        int[] arr = {1,2,3,4,5};
        for(int i : arr) {
            System.out.println(i);
        }
        //带标签的break语句
        //for循环标记为first
        first:
        for( int i = 1; i < 5; i++) {

            //for循环标记为second
            second:
            for(int j = 1; j < 3; j ++ ) {
                System.out.println("i = " + i + "; j = " +j);

                //break语句终止第一个for循环
                if ( i == 2)
                    break first;
            }
        }

        //p1 计算1-100的总和
        int sum1 = 0;
        for (int i = 0; i <= 100; i++) {
            sum1 += i;
        }
        System.out.println(sum1);

        //p2 输出1-100所有偶数
        for (int i = 0; i <= 100; i++) {
            if(i%2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        //p3 计算1-100所有偶数的和
        int sum2 = 0;
        for (int i = 0; i <= 100; i++) {
            if(i%2 == 0) {
                sum2 += i;
            }
        }
        System.out.println(sum2);
    }
}
