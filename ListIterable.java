package geekbrains.lessons.homeworkfour;

import java.util.ListIterator;

public interface ListIterable<Item> extends Iterable<Item> {

    ListIterator<Item> listIterator();
}
