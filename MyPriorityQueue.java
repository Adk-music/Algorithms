package geekbrains.lessons.homeworkalgorithmsThree;

import java.util.Comparator;
import java.util.EmptyStackException;

public class MyPriorityQueue<T extends Comparable> {
        private T[] list;
        private int size;
        private int DEFAULT_CAPACITY = 10;
        private Comparator<T> comparator = Comparator.naturalOrder();

    public MyPriorityQueue(int capacity, Comparator comparator){
        if (capacity <= 0){
            throw new  IllegalArgumentException("bad capacity" + capacity);
        }
        list = ((T[]) new Comparable[capacity]);
        this.comparator = comparator;
    }


//        public MyPriorityQueue(int capacity){
//            if (capacity <= 0){
//                throw new  IllegalArgumentException("bad capacity" + capacity);
//            }
//            list = ((T[]) new Comparable[capacity]);
//        }


        public MyPriorityQueue(){
            list = ((T[]) new Comparable[DEFAULT_CAPACITY]);
        }


    public void insert(T item){
        if (isFull()){
            throw new StackIsFullException();
        }
        list[size] = item;
        size++;

        int i = size - 1;
        while (i > 0 &&  comparator.compare(list[i], list[i-1]) > 0){
            swap(i,i-1);
            i--;
        }

    }



//        public void insert(T item){
//            if (isFull()){
//                throw new StackIsFullException();
//            }
//            list[size] = item;
//            size++;
//
//            int i = size - 1;
//            while (i > 0 &&  list[i].compareTo(list[i-1]) > 0){
//                swap(i,i-1);
//                i--;
//            }
//
//        }


    public T peek(){ // просмотр эл-та
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public T remove(){
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }


    private void swap(int index1, int index2){
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

        public boolean isFull(){
            return size == list.length;
        }

        public boolean isEmpty(){
            return size == 0;
        }


        public int size() {
            return size;
        }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list[i] + ", ");
        }
        return sb.toString();
    }
}



