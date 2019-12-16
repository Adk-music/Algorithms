package geekbrains.lessons.homeworkfour;

public class MyOneLinkedList<Item> {
    private Node first;
    private int size; //кол-во элементов


    private class Node<Item>{
        Item value;
        Node next;

        public Node(Item value) {
            this.value = value;
        }
    }

    public void insertFirst(Item item){  //вставка первого эл-та
        Node newNode = new Node(item);
        newNode.next = first;
        first = newNode;
        size++;
    }

    public Item removeFirst(){
        if (isEmpty()){
            throw new StackIsEmptyException("List is empty");
        }
        Node oldFirst = first;
        first = first.next;
        size--;
        return (Item) oldFirst.value;
    }

    public Item getFirst () {
        if (isEmpty()){
            throw new StackIsEmptyException("List is empty");
        }
        return (Item)first.value;
    }

    public void insert(Item item, int link){ // вставляем эл-т первым в списке и переносим ссылку first на новый эл-т
         if (link <= 0){
             insertFirst(item);
             return;
         }

         Node current = first;
         int i = 0;
         while ( i < size-1 && i < link - 1){
             current = current.next;
             i++;
         }
         Node newNode = new Node(item);
         newNode.next = current.next;
         current.next = newNode;
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
        while (current.next != null && !current.next.value.equals(item) ){
            current = current.next;
        }
        if(current.next == null){
            return false;
        }

        current.next = current.next.next;
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
