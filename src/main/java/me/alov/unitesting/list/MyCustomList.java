package me.alov.unitesting.list;

public class MyCustomList<T> implements List<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public T get(int index) {
        Node<T> item = head;
        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }
        return item.getData();
    }

    @Override
    public void add(T data) {
        add(data, 0);
    }

    @Override
    public void add(T[] data) {
        for (T item: data) {
            add(item);
        }
    }


    @Override
    public void add(T data, int index) {
        Node<T> node = new Node<>(null, data, null);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            if (index == 0) {
                node.setPrev(tail);
                tail.setNext(node);
                tail = node;
            } else {
//                  |        |
                //null <-- test1 test2 test3
                Node<T> item = tail;
                for (int i = 0; i < index; i++) {
                    if (item.getPrev() != null)
                        item = item.getPrev();
                }
                if (item != head) {
                    Node<T> nextItem = item.getNext();
                    node.setPrev(item);
                    node.setNext(nextItem);

                    item.setNext(node);
                    nextItem.setPrev(node);
                } else {
                    node.setNext(head);
                    head.setPrev(node);
                    head = node;
                }
            }
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb =  new StringBuilder();
        if (head != null) {
            Node<T> item = head;
            while (item != null) {
                sb.append(item.getData().toString());
                sb.append(",");
                item = item.getNext();
            }
        }
        return sb.toString();
    }
}
