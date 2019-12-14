package geekbrains.lessons.homeworkalgorithmsThree;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyDoubleQueue<T> {
    private T[] list;
    private int filledElementCount;
    private int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyDoubleQueue(int capacity){
        if (capacity <= 0){
            throw new  IllegalArgumentException("bad capacity" + capacity);
        }
        list = ((T[]) new Object[capacity]);
        end = capacity - 1;
    }

    public MyDoubleQueue(){
        list = ((T[]) new Object[DEFAULT_CAPACITY]);
        end = DEFAULT_CAPACITY - 1;
    }

    public void insert(T item){
        if (isFull()){
            throw new RuntimeException();
        }
        end = nextIndex(end);
        list[end] = item;
        filledElementCount++;
    }


    public T remove(){
        T value = peekBegin();
        list[begin] = null;
        begin = nextIndex(begin);
        filledElementCount--;
        return value;

    }

    public T peekBegin(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[begin];
    }

    public T peekEnd(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[end];
    }

    private int nextIndex(int index){
        return (index + 1) % list.length;
    }


    public boolean isFull(){
        return filledElementCount == list.length;
    }

    public boolean isEmpty(){
        return filledElementCount == 0;
    }


    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}

