package geekbrains.lessons.homeworkalgorithmsThree;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>(5);


//	 stack.push(1);
//	 stack.push(2);
//	 stack.push(3);
//	 stack.push(4);
//	 stack.push(5);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(stack.pop());
//        }

//		Expession e = new Expession("(4-6) + [ 34 + {2*5}]");
//		System.out.println(e.checkBracket());

//		MyQueue<Integer> queue = new MyQueue<>();
//
//		queue.insert(1);
//		queue.insert(2);
//		queue.insert(3);
//		queue.insert(4);

//		for (int i = 0; i < 4 ; i++) {
//			System.out.println(queue.remove());
//		}


//        MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>(10, Comparator.naturalOrder());
//
//        mpq.insert(6);
//        System.out.println(mpq);
//        mpq.insert(9);
//        System.out.println(mpq);
//        mpq.insert(3);
//        System.out.println(mpq);
//        mpq.insert(8);
//        System.out.println(mpq);
//        mpq.insert(4);
//        System.out.println(mpq);
//
//        System.out.println(mpq.remove());
//        System.out.println(mpq);


        stack.push("Cat");
        stack.push("walk");
        stack.push("on");
        stack.push("the");
        stack.push("street");

        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop() + " ");
        }

        MyDoubleQueue<Integer> mdq = new MyDoubleQueue<>();

        mdq.insertBegin(1);
        System.out.println(mdq);
        mdq.removeEnd();
        System.out.println(mdq);
        mdq.insertEnd(3);
        System.out.println(mdq);
        mdq.removeBegin();
        System.out.println(mdq);


    }
}
