package week02;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        String[] words = {
                "apple",
                "banana",
                "apple",
                "orange",
                "banana",
                "apple"
        };
        Map<String,Integer> countMap = new HashMap<>();
        for(String word : words) {
            int count = countMap.getOrDefault(word,0);
            countMap.put(word,count+1);
        }
        for (Map.Entry<String,Integer> entry : countMap.entrySet()) {
            System.out.println("key->" + entry.getKey() + ",value->" + entry.getValue());
        }

        String maxWord = null;
        int maxCount = 0;

        for (Map.Entry<String,Integer> entry : countMap.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println("maxword->" + maxWord + ",maxCount->" + maxCount);

        for (Map.Entry<String,Integer> entry : countMap.entrySet()) {
            if(entry.getValue() >= 2 ) {
                System.out.println(entry.getKey());
            }
        }
    }
}
