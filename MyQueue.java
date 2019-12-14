package geekbrains.lessons.homeworkalgorithmsThree;

import java.util.EmptyStackException;

public class MyQueue<T>  {
    private T[] list;
    private int size;
    private int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    //0 1 2 3 4
    //b
    //      e
    //6 8 9

    public MyQueue(int capacity){
        if (capacity <= 0){
            throw new  IllegalArgumentException("bad capacity" + capacity);
        }
        list = ((T[]) new Object[capacity]);
    }

    public MyQueue(){
        list = ((T[]) new Object[DEFAULT_CAPACITY]);
    }

    public void insert(T item){
        if (isFull()){
            throw new StackIsFullException();
        }
        list[end] = item;
        size++;
        end = nextIndex(end);
    }

    public T remove(){
        T value = peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;

    }

    public T peek(){ // просмотр эл-та в стэк
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[begin];
    }

    private int nextIndex(int index){
        return (index + 1) % list.length;
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
}



