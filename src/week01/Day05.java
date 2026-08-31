package week01;

public class Day05 {
    //方法
    private static int getSquare(int x){
        return x * x;
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {

            //方法调用
            int result = getSquare(i);
            System.out.println("" + i + " 的平方是: " + result);
        }
    }
}
