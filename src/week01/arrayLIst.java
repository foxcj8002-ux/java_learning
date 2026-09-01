package week01;
import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class arrayLIst {
    public static void main(String[] args) {
        //创建ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<String> arrayList1 = new ArrayList<>();

        //添加元素
        arrayList.add(1);
        arrayList.add(1,2);
        System.out.println("ArraList:" + arrayList);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        //将arrayList元素全部添加到arrayList2
        arrayList2.addAll(arrayList);
        System.out.println("ArrayList2:" + arrayList2);

        //使用asList()初始化ArrayList
        ArrayList<Integer> arrayList3 = new ArrayList<>(Arrays.asList(3,17,3,5,6,8));
        System.out.println("ArrayList3:" + arrayList3);

        /*
        *访问ArrayList的元素
         */
        //1.使用get()方法
        arrayList1.add("cat");
        arrayList1.add("dog");
        arrayList1.add("pig");
        arrayList1.add("horse");
        System.out.println("animals:" + arrayList1);
        String a1 = arrayList1.get(1);

        System.out.println("a1:" + a1);

        //2.使用 iterator() 方法
        //创建一个Iterator对象
        Iterator<String> iterator = arrayList1.iterator();
        //使用Iterator的方法访问元素
        while(iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(",");

        }

        /*
        *更改ArrayList元素
         */
        //使用set()方法
        arrayList1.set(0,"tiger");
        System.out.println("修改后的animals:" + arrayList1);

        /*
        *删除ArrayList元素
         */
        //1.使用 remove() 方法
        String str = arrayList1.remove(0);
        System.out.println("删除动物：" + str);
        System.out.println("删除后的animals: " + arrayList1);

        //2.从数组列表中删除所有元素，使用removeAll()方法
        arrayList.removeAll(arrayList);
        System.out.println("最终ArrayList:" + arrayList);

        //3.使用clear()方法从数组列表中删除所有元素
        ArrayList<String> animals= new ArrayList<>();

        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");
        System.out.println("Initial ArrayList: " + animals);

        animals.clear();
        System.out.println("Final ArrayList: " + animals);

        /*
        *遍历 ArrayList
         */
        //1.使用 for 循环
        System.out.println("访问所有元素: ");

        for(int i = 0; i < animals.size(); i++) {
            System.out.print(animals.get(i));
            System.out.print(", ");
        }

        //2.使用 forEach 循环
        System.out.println("访问所有元素:  ");
        for(String animal : animals) {
            System.out.print(animal);
            System.out.print(", ");
        }

        /*
        *获取ArrayList的长度
         */
        //使用size()方法
        System.out.println("arrayList的大小: " + animals.size());

        /*
        *对ArrayList的元素进行排序
         */
        //使用Collections类的sort()方法
        System.out.println("未排序的ArrayList: " + arrayList3);

        //对数组列表进行排序
        Collections.sort(arrayList3);
        System.out.println("排序后的ArrayList: " + arrayList3);

        /*
        *Java ArrayList 转换为 数组
         */
        //使用toArray()方法将数组列表转换为数组
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");
        System.out.println("ArrayList: " + animals);

        //创建一个新的String类型数组
        String[] arr = new String[animals.size()];

        //将ArrayList转换成数组
        animals.toArray(arr);
        System.out.print("Array: ");
        for(String item:arr) {
            System.out.print(item+", ");
        }
        System.out.println();
        /*
        *Java Array 转换为 ArrayList
         */
        //使用asList()
        ArrayList<String> animals2 = new ArrayList<>(Arrays.asList(arr));
        System.out.println("animals2:" + animals2);
    }
}
