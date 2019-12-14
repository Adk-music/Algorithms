package geekbrains.lessons.homeworkalgorithmsThree;

import java.util.EmptyStackException;
import java.util.Objects;

public class MyStack<String> {
    private String[] list;
    private int size;
    private int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity){
        if (capacity <= 0){
            throw new  IllegalArgumentException("bad capacity" + capacity);
        }
        list = ((String[]) new Object[capacity]);
    }

    public void push(String  item){
        if (isFull()){
            throw new StackIsFullException();
        }
        list[size] = item;
        size++;
    }

    public String  pop(){
        String temp = peek();
        size--;
        list[size] = null;
        return temp;

    }


    public String  peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[size - 1];
    }


    public MyStack(){
        list = ((String[]) new Object[DEFAULT_CAPACITY]);
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
