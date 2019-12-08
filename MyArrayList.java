package geekbrains.lessons.homeworkalgorithmsTwo;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<Item extends Comparable> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0" + capacity);
        }
        list = (Item[]) new Comparable[capacity]; //превращаем массив в объекты и присваиваем им значение которое хотим.
    }

    public MyArrayList() {
        list = (Item[]) new Comparable[DEFAULT_CAPACITY]; //превращаем массив в объекты и присваиваем им значение которое хотим.
    }

    public void add(Item item) {//добавление эл-та в конец списка
        float loadFactor =  (float) size / list.length ;
        if(loadFactor > 0.75f ){
            reCapacity(list.length * 2);
        }
        list[size] = item;
        size++;
    }

    public void add(int index, Item item) {//добавление эл-та в произвольное место
        if (index < 0 || index > list.length) {
            throw new IndexOutOfBoundsException("index" + index);  //проверка
        }
        if (index > list.length * 0.75){
            reCapacity(list.length * 2);
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];

        }
        list[index] = item;
        size++;
    }

    public boolean remove(Item item){  //удаление элемента по значению
        int i = 0;
        while (i < size && !list[i].equals(item)){
            i++;
        }
        if (i == size){
            return false;
        }
        remove(i);
        return true;
    }

    public final boolean remove(int index){  //удаление элемента по индексу
        for (int i = index; i < size -1; i++) {
            list[i] = list[i + 1];
        }
        size--;
        list[size] = null;
        return true;
    }

    public Item get(int index){ // геттер по индексу
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index" + index);  //проверка
        }
        return list[index];
    }

    public void set(int index, Item item){ // сеттер
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index" + index);  //проверка
        }
        list[index] = item;
    }
    public int size(){
        return size;
    }

    private void reCapacity(int newCapacity){
      Item[] temp = ((Item[])new Comparable[newCapacity]);
      System.arraycopy(list,0,temp,0,size);
      list = temp;
    }

    private void trimToSize(){
        reCapacity(size);
        }

    private void ensureCapacity(int minCapacity){
        if (minCapacity > size){
            reCapacity(minCapacity);
        }
    }

    public int indexOf(Item item){ //линейный поиск
        for (int i = 0; i <  size; i++) {
            if (list[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

//Сортировка выбором, O(n^2), не устойчивая, используется для небольших массивов.

    private boolean less(int index1, int index2){
        return list[index1].compareTo(list[index2]) < 0;
    }

    private void swap(int index1, int index2){
        Item temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort(){
        long start = System.nanoTime();
        int indexMin;
        for (int i = 0; i < size - 1; i++) {
            indexMin = i;
            for (int j = i+1; j < size; j++) {
                if(less(j,indexMin)){
                    indexMin = j;
                }
            }
            swap(i,indexMin);
        }
        long end = System.nanoTime() - start;
        System.out.println(end);
    }


    // сортировка вставками, хорошо работает для почти отсортированных массивов, сортировка происходит с помощью сдвига.

    public void insertionSort(){
        long start = System.nanoTime();
        Item key;
        for (int i = 1; i < size ; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && key.compareTo(list[j-1]) < 0){
                list[j] = list[j-1];
                j--;
            }
            list[j] = key;
        }
        long end = System.nanoTime() - start;
        System.out.println(end);
    }

   //соритровка методом пузырька, сравниваем два элемента и меняем местами.

   public void bubbleSort(){
       long start = System.nanoTime();
       for (int i = size - 1; i > 0  ; i--) {
           for (int j = 0; j < i ; j++) {
               if (less(j+1,j)){
                   swap(j+1,j);
               }
           }
       }
       long end = System.nanoTime() - start;
       System.out.println(end);
   }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //переопределение метода toString
        for (int i = 0; i < size; i++) {
            sb.append(list[i] + " ");
        }
        sb.append("\n"); //добавление перевода курсора
        return sb.toString();
    }

}
