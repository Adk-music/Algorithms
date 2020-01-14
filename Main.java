package geekbrains.lessons.homeworksix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//          MyTreeMap<Integer, String> map = new MyTreeMap<>();

//          map.put(5, "five");
//          map.put(1, "one");
//          map.put(3, "three");
//          map.put(2, "two");
//          map.put(4, "four");
////
//          System.out.println(map.height());
//
//          map.put(3, "thr");
//          System.out.println(map.get(3));
//          System.out.println(map.contains(44));
//          System.out.println(map.minKey());
//          System.out.println(map.maxKey());

        //  map.delete(3);
        //  System.out.println(map.get(3));

//          System.out.println(map);
//          System.out.println(map.size());
//          System.out.println(map.height());
//          System.out.println(map.isBalanced(map.root));

        Random random = new Random();
        int falseCount = 0;

        for (int i = 0; i < 20; i++) {

            MyTreeMap<Integer,Integer> map1 = new MyTreeMap<>();

            do {
                int randomValue = (int) (random.nextDouble() * 100);
                int signValue = random.nextInt(2);

                if (signValue == 0) {
                    randomValue *= -1;
                }
                map1.put(randomValue, randomValue);
            } while (map1.height() <= 6);
            System.out.println(map1);
            if ( !map1.isBalanced(map1.root)){
                falseCount++;
            }
            System.out.println(map1.isBalanced(map1.root));
        }
        System.out.println(falseCount/20 * 100);
    }
}
