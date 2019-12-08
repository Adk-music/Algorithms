package geekbrains.lessons.homeworkalgorithmsTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> mal = new MyArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            mal.add(random.nextInt(100));
        }
        System.out.println(mal);

 //       mal.selectionSort();
 //       mal.insertionSort();
 //       mal.bubbleSort();
        System.out.println(mal);



//        mal.add(3, 99);
//
//        System.out.println(mal);
//
//        mal.remove(new Integer(6));
//        System.out.println(mal);
//
//        System.out.println(mal.indexOf(7));

//        MySortedArrayList<Integer> msal = new MySortedArrayList<>();
//        msal.add(5);
//        msal.add(1);
//        msal.add(9);
//        msal.add(2);
//        msal.add(3);
//
//        System.out.println(msal);

    }
}
