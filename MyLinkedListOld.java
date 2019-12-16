package geekbrains.lessons.homeworkfour;

import java.util.Iterator;

public class MyLinkedListOld<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size; //кол-во элементов
     // двусторонний(двусвязный список)

    private class Node<Item>{
        Item value;
        Node next;
        Node previous;

        public Node(Item value) {
            this.value = value;
        }

        public Node(Item value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<Item>{
        Node current = new Node(null,first,null);


        @Override
        public boolean hasNext() { //всегда вызывается перед методом next()
            return current.next != null;
        }

        @Override
        public Item next() { // при достижении конца коллекции выбрасывает NoSuchElementException
            current = current.next;
            return (Item) current.value;
        }
    }

    public void insertFirst(Item item){  //вставка первого эл-та
        Node newNode = new Node(item);
        newNode.next = first;
        if(isEmpty()){
            last = newNode;
        } else{
            first.previous = newNode;
        }
        first = newNode;
        size++;
    }

    public void insertLast(Item item){  //вставка последнего эл-та
        Node newNode = new Node(item);
        if(isEmpty()){
            first = newNode;
        } else{
            newNode.previous = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public Item removeFirst(){  // удаление первого эл-та
        if (isEmpty()){
            throw new StackIsEmptyException("List is empty");
        }
        Node oldFirst = first;
        first = first.next;
        if(isEmpty()){
            last = null;
        } else {
            first.previous = null;
        }
        size--;
        return (Item) oldFirst.value;
    }

    public Item removeLast(){ //удаление последнего эл-та
        if (isEmpty()){
            throw new StackIsEmptyException("List is empty");
        }
        Node oldLast = last;
        if(last.previous != null){
            last.previous.next = null;
        } else {
            first = null;
        }
        last = last.previous;
        size--;
        return (Item) oldLast.value;
    }

    public Item getFirst () { // просмостр первого эл-та
        if (isEmpty()){
            throw new StackIsEmptyException("List is empty");
        }
        return (Item)first.value;
    }

    public Item getLast () { //просмотр последнего эл-та
        if (isEmpty()){
            throw new StackIsEmptyException("List is empty");
        }
        return (Item)last.value;
    }

    public void insert(Item item, int link){ // вставляем эл-т первым в списке и переносим ссылку first на новый эл-т
         if (link <= 0){
             insertFirst(item);
             return;
         }

         if(link >= size){
             insertLast(item);
             return;
         }



         Node current = first;
         int i = 0;
         while (i < link - 1){
             current = current.next;
             i++;
         }
         Node newNode = new Node(item);

         newNode.next = current.next;
         newNode.previous = current;
         current.next = newNode;
         newNode.next.previous = newNode;

         size++;
    }

    public boolean remove (Item item){
        if(isEmpty()){
            return false;
        }
        if(first.value.equals(item)){
            removeFirst();
            return true;
        }

        Node current = first;
        while (current != null && !current.value.equals(item) ){
            current = current.next;
        }
        if(current == null){
            return false;
        }
        if(current == last){
            removeLast();
            return true;
        }


        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
        return true;

    }




    public int linkOf(Item item){
        Node current = first;
        int link = 0;
        while (current != null){
            if(current.value.equals(item)){
                return link;
            }
            current = current.next;
            link++;
        }
        return -1;
    }

    public boolean contains(Item item){
        return linkOf(item) > -1;
    }


    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
       Node current = first;
       StringBuilder sb = new StringBuilder();
       while (current != null){
           sb.append(current.value.toString() + " ");
           current = current.next;
       }

        return sb.toString();
    }
}
