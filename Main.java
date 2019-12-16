package geekbrains.lessons.homeworkfour;

import com.sun.xml.internal.rngom.util.Uri;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

//        MyLinkedList<String> mll = new MyLinkedList<>();
//
//        mll.insertFirst("Katya");
//        mll.insertFirst("Maria");
//        mll.insertFirst("Alex");
//
//        System.out.println(mll);
//
//        mll.insertLast("Fedor");
//
//        System.out.println(mll);

//        System.out.println(mll.removeLast());
//        System.out.println(mll);

//        System.out.println(mll.removeFirst());
//        System.out.println(mll);

//        mll.insert("Petya",3);
//        System.out.println(mll);
////
//        System.out.println(mll.remove("Fedor"));
//        System.out.println(mll);
//        System.out.println(mll.getFirst());

//        Iterator<String> iterator = mll.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

//        for (String s: mll) {
//            System.out.println(s);
//        }

        MyLinkedList<Integer> integers = new MyLinkedList<>();
        integers.insertFirst(1);
        integers.insertFirst(2);
        integers.insertFirst(3);
        ListIterator<Integer> iterator = integers.listIterator();
        if (iterator.hasNext()){
            iterator.next();
            iterator.next();
            iterator.next();
            iterator.set(8);
        }
        System.out.println(integers);
    }
}
